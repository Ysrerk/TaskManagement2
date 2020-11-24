import java.util.List;

public class Dao {
    //data access object
    Database db;


    public Dao(Database db) {
        this.db = db;
    }

    public void addtask(Task  task){

        db.listofaddedtasklist.add(task);



    }
    public void listtask(){
        for(Task task:db.listofaddedtasklist){
            System.out.println(task);
        }
    }
    public void listtask(String type){
        for(Task task:db.listofaddedtasklist){

            if(task.type().equals(type))
            System.out.println(task);
        }
    }

    public List<Task> ltask(){

        return db.getListofaddedtasklist();
    }
}
