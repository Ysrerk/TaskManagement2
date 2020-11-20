import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Console {



        public  static void interactionwithuser() {

            while (true) {
                Scanner read = new Scanner(System.in);
                System.out.println("please chooese  from menu which  type process do you want \n" +
                        "0-exit\n" +
                        "1-Add new Task\n" +
                        "2-Add a task to Timed Task List\n" +
                        "3-To list Tasks\n" +
                        "4-To list Timed Tasks\n" +
                        "5-To Assign task\n" +
                        "6-To list  assigned task\n" +
                        "7-Assigned timed task\n" +
                        "8- To list assigned timed task\n" +
                        "9-Sort Task according to Name\n" +
                        "10-Sort Task according to Date\n" +
                        "11-Delete Task\n" +
                        "12-Update task name\n" +
                        "13-Update Duedate\n" +
                        "14-Export Tasks by JSON.file\n" +
                        "15-To read Tasks from JSON file");
                int processid = read.nextInt();
                if (processid == 0) {

                    break;
                } else if (processid == 1 ||processid==2||processid==5) {
                    read.nextLine();
                    System.out.println("please enter task id");
                    int id = Integer.valueOf(read.nextLine());
                    System.out.println("please add task name");
                    String name = read.nextLine();

                    System.out.println("please add task due date like this format  (yyyy-MM-dd)");
                    String duedate = read.next();
                    duedate += "T12:00:00";

                    //LocalDateTime aLD = LocalDateTime.parse(duedate);
                    //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    LocalDateTime dueDate = LocalDateTime.parse(duedate);


                    switch(processid){
                        case 1:
                            Database.listofaddedtasklist.add(new Task(id,name,String.valueOf(Task.Status.ADDED),dueDate));
                            break;
                        case 2:
                            System.out.println("please add task startdate like this format  (yyyy-MM-dd)");
                            String startdate = read.next();
                            startdate += "T12:00:00";

                            LocalDateTime starDate = LocalDateTime.parse(startdate);
                            System.out.println("please add task finishdate like this format  (yyyy-MM-dd)");
                            String finishdate = read.next();
                            finishdate += "T12:00:00";

                            LocalDateTime endDate = LocalDateTime.parse(finishdate);
                            Database.listofaddedtimedtasklist.add(new Timedtask(id, name, String.valueOf(Task.Status.SCHEDULED), dueDate, starDate, endDate));
                            break;
                        case 5:

                            System.out.println("Who do you want to assign?");
                            String assignedTo = read.next();
                            Database.listofassignedtasklist.add(new Assigntask(id,name,String.valueOf(Task.Status.ASSIGNED),dueDate,assignedTo));

                    }

                }


                else if (processid == 3) {

                    for (Object tlist : Database.listofaddedtasklist) {


                        System.out.println(tlist);
                    }

                }
                else if (processid == 4) {
                    //ttlist is meaning timed task
                    for (Object ttlist : Database.listofaddedtimedtasklist) {

                        System.out.println(ttlist);

                    }
                }

                else if(processid==6) {
                    for(Object assigntask:Database.listofassignedtasklist){
                        System.out.println(assigntask);
                    }

                }

                /*
                else if (processid == 2) {
                    System.out.println("which task do you want to timed task  please enter id");
                    int timedtaskid = read.nextInt();

                    System.out.println("please add task startdate like this format  (yyyy-MM-dd)");
                    String startdate = read.next();
                    startdate += "T12:00:00";

                    LocalDateTime starDate = LocalDateTime.parse(startdate);
                    System.out.println("please add task finishdate like this format  (yyyy-MM-dd)");
                    String finishdate = read.next();
                    finishdate += "T12:00:00";

                    LocalDateTime endDate = LocalDateTime.parse(finishdate);
                    // id that is  was got from user  is  searching  in the list of task
                    for (List<Object> timedtask : Database.listofaddedtasklist) {
                        ArrayList<Object> timedtaskc = (ArrayList<Object>) timedtask;

                        if (timedtaskc.contains(timedtaskid)) {
                            int ind = Database.listofaddedtasklist.indexOf(timedtaskc);
                            Timedtask.addtimedtasklist(timedtaskc, starDate, endDate);

                            //************************Buna bir bakmam lazim **********************************************
                            //listofaddedtasklist.remove(ind);


                        }
                    }
                } else if (processid == 3) {

                    for (List<Object> tlist : Database.listofaddedtasklist) {


                        System.out.println("Task id:" + tlist.get(0) + "Task  details:" + tlist.get(1) + "Task Due Date:"
                                + tlist.get(2) + "Task Status:" + tlist.get(3));
                    }

                } else if (processid == 4) {
                    //ttlist is meaning timed task
                    for (List<Object> ttlist : Database.listofaddedtimedtasklist) {

                        System.out.println("Task id:" + ttlist.get(0) + "Task  details:" + ttlist.get(1) + "Task Due Date:"
                                + ttlist.get(2) + "Task Status:" + ttlist.get(3) + "Task start date:" + ttlist.get(4) + "Task end date:"
                                + ttlist.get(5));

                    }
                } else if (processid == 5) {

                    System.out.println("which task do you want to assigned to task  please enter id");

                    int assignedid = read.nextInt();

                    System.out.println("Who do you want to assign?");
                    String assignto = read.next();

                    for (List<Object> astask : Database.listofaddedtasklist) {

                        if (astask.contains(assignedid)) {

                            Assignedtask.assignedtotask(astask, assignto);
                        }
                    }

                } else if (processid == 6) {

                    for (List<Object> aslist : Database.listofassignedtasklist) {

                        System.out.println(" ASSIGNED TASK LIST " + "TASK ID:" + aslist.get(0) + "  TASK DETAILS:" + aslist.get(1) +
                                "  TASK DUE DATE:" + aslist.get(2) + "TASK STATUS:" +
                                aslist.get(3) + "   TASK ASSIGNED TO:" + aslist.get(4));
                    }
                } else if (processid == 7) {

                    System.out.println("which task do you want to  bugget task");
                    int id = read.nextInt();
                    System.out.println("please add task startdate like this format  (yyyy-MM-dd)");
                    String startdate = read.next();
                    startdate += "T12:00:00";

                    LocalDateTime starDate = LocalDateTime.parse(startdate);
                    System.out.println("please add task finishdate like this format  (yyyy-MM-dd)");
                    String finishdate = read.next();
                    finishdate += "T12:00:00";

                    LocalDateTime endDate = LocalDateTime.parse(finishdate);

                    System.out.println("what isthe budget of  project");
                    int budget = read.nextInt();

                    for (List<Object> blist : Database.listofassignedtasklist) {
                        if (blist.contains(id)) {
                            AssignedTimedTask.tobudgetthetask(blist, starDate, endDate, budget);
                        }

                    }
                } else if (processid == 8) {

                    for (List<Object> bdlist : Database.listofbudgettasklist) {

                        System.out.println(bdlist);

                        System.out.println("Budget list" + "task id" + bdlist.get(0) + "task details:" + bdlist.get(1) +
                                "task due date" + bdlist.get(2) + "task status" + bdlist.get(3) + "task assigned to" + bdlist.get(4) +
                                "start date" + bdlist.get(5) + "end date" + bdlist.get(6) + "budget" + bdlist.get(7));
                    }

                } else if (processid == 9) {

                    List<Object> result = Database.listofaddedtasklist.stream().sorted((o1, o2) -> o1.get(1).toString().compareTo(o2.get(1).toString())).collect(Collectors.toList());
                    System.out.println("Tasks sorted  according to name :");

                    for (Object task : result) {
                        System.out.println(task);
                    }

                } else if (processid == 10) {

                    System.out.println("Tasks sorted according to date");

                    List<Object> result = Database.listofaddedtasklist.stream().sorted((o1, o2) -> o1.get(2).toString().compareTo(o2.get(2).toString())).collect(Collectors.toList());

                    System.out.println(result);
                } else if (processid == 11) {
                    System.out.println("which task do you want to delete ");
                    int id = read.nextInt();


                    for (List<Object> task : Database.listofaddedtasklist) {

                        if (task.contains(id)) {

                            Database.listofaddedtasklist.remove(task);
                        }
                    }


                } else if (processid == 12) {


                    System.out.println("which task's name do you want to update");
                    read.nextLine();
                    int id = Integer.valueOf(read.nextLine());
                    System.out.println("Please write what do you want to update");
                    String newname = read.nextLine();

                    for (List<Object> task : Database.listofaddedtasklist) {
                        if (task.contains(id)) {
                            task.set(task.indexOf(task.get(1)), newname);
                            System.out.println(id + " Task is updated.");
                            System.out.println(task);
                        }
                    }
                } else if (processid == 13) {

                    System.out.println("which task do you want to update due date  enter task id");
                    int id = read.nextInt();
                    System.out.println("please write new due date like this format  (yyyy-MM-dd)");
                    String newduedate = read.next();
                    newduedate += "T12:00:00";

                    LocalDateTime newduedaten = LocalDateTime.parse(newduedate);

                    for (List<Object> task : Database.listofaddedtasklist) {
                        if (task.contains(id)) {

                            task.set(2, newduedaten);//task.indexOf(task.get(2))
                            System.out.println("Last value of Duedate" + task);

                        }
                    }
                } else if (processid == 14) {

                    Jsonmake js = new Jsonmake();

                    js.jsonmake(Database.listofaddedtasklist);
                } else if (processid == 15) {
                    try {
                        Jsonread.readjson();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }*/


            }
        }



    }

