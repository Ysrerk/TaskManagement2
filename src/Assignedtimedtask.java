import java.time.LocalDateTime;

public class Assignedtimedtask  extends  Assigntask{

    private int budget;

    public Assignedtimedtask(int id, String name, String status, LocalDateTime dueDate, String assignedTo,int budget) {
        super(id, name, status, dueDate, assignedTo);
        this.budget=budget;
    }

    public  static void addtask(Assignedtimedtask assignedtimedtask){

        Database.listofassignedtimedtasklist.add(assignedtimedtask);
    }

    @Override
    public String toString() {
        return "Assignedtimedtask{" +
                "id"+ super.getId()+ " "+
                "name"+ super.getName()+ " "+
                "status"+ super.getStatus() + " "+
                "dueDate"+ super.getDueDate()+ " "+
                "assignedTo"+ super.getAssignedTo()+ " "+
                "budget=" + budget +
                '}';
    }
}
