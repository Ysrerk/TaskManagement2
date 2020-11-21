import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Console {
    List<Object> listofaddedtimedtasklist;



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
                } else if (processid == 1 ||processid==2||processid==5||processid==7) {
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
                            Task.addtask((new Task(id,name,String.valueOf(Task.Status.ADDED),dueDate)));
                            //Database.listofaddedtasklist.add(new Task(id,name,String.valueOf(Task.Status.ADDED),dueDate));
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
                            Timedtask.addtask((new Timedtask(id, name, String.valueOf(Task.Status.SCHEDULED), dueDate, starDate, endDate)));
                            //listofaddedtimedtasklist.add(new Timedtask(id, name, String.valueOf(Task.Status.SCHEDULED), dueDate, starDate, endDate));
                            break;
                        case 5:
                            System.out.println("Who do you want to assign?");
                            String assignedTo = read.next();
                            Assigntask.addtask((new Assigntask(id,name,String.valueOf(Task.Status.ASSIGNED),dueDate,assignedTo)));
                        case 7:
                            System.out.println("Who do you want to assign?");
                            String assignedT = read.next();
                            System.out.println("what isthe budget of  project");
                            int budget = read.nextInt();
                            Assignedtimedtask.addtask((new Assignedtimedtask(id,name,String.valueOf(Task.Status.SCHEDULEDASSIGNED),dueDate,assignedT,budget)));
                    }
                }
                else if (processid == 3) {
                    System.out.println(Database.listofaddedtasklist);
                }
                else if (processid == 4) {
                    //ttlist is meaning timed task
                    for (Object ttlist :Database.listofaddedtimedtasklist) {
                        System.out.println(ttlist);
                    }
                }
                else if(processid==6) {
                    for(Object assigntask:Database.listofassignedtasklist){
                        System.out.println(assigntask);
                    }
                }
                else if(processid==8){
                    for (Object assignedtimedtask:Database.listofassignedtimedtasklist){
                        System.out.println(assignedtimedtask);
                    }
                }
                else if (processid == 9) {
                    List<Task> sortedTasks = Database.listofaddedtasklist.stream()
                            .sorted(Comparator.comparing(Task::getName))
                            .collect(Collectors.toList());

                    /*List<Task> sortedUsers = Database.listofaddedtasklist.stream()
                            .sorted(Comparator.comparing(Task::getName).reversed())
                            .collect(Collectors.toList());*/
                    System.out.println(sortedTasks);

                }
                else if (processid == 10) {
                    List<Task> sortedTasks = Database.listofaddedtasklist.stream()
                            .sorted(Comparator.comparing(Task::getDueDate))
                            .collect(Collectors.toList());
                    System.out.println(sortedTasks);

                }
                else if (processid == 11) {
                    System.out.println("which task do you want to delete ");
                    int id = read.nextInt();
                    for (Task task : Database.listofaddedtasklist) {
                        if (task.getId()==id) {
                            Database.listofaddedtasklist.remove(task);
                            break;
                        }
                    }
                }
                else if (processid == 12) {
                    System.out.println("which task's name do you want to update");
                    read.nextLine();
                    int id = Integer.valueOf(read.nextLine());
                    System.out.println("Please write what do you want to update");
                    String newname = read.nextLine();
                    for (Task task : Database.listofaddedtasklist) {
                        if (task.getId()==id) {
                            task.setName(newname);
                            System.out.println(id + " Task is updated.");
                            System.out.println(task);
                            break;
                        }
                    }
                }
                else if (processid == 13) {

                    System.out.println("which task do you want to update due date  enter task id");
                    int id = read.nextInt();
                    System.out.println("please write new due date like this format  (yyyy-MM-dd)");
                    String newduedate = read.next();
                    newduedate += "T12:00:00";

                    LocalDateTime newduedaten = LocalDateTime.parse(newduedate);

                    for (Task task : Database.listofaddedtasklist) {
                        if (task.getId()==id) {

                            task.setDueDate(newduedaten);
                            System.out.println("Last value of Duedate" + task);
                            break;

                        }
                    }
                }

                /*
                 else if (processid == 14) {

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

