import java.time.LocalDateTime;

public class Assignedtimedtask  extends  Task{

    public Assignedtimedtask(int id, String name, String status, LocalDateTime dueDate,int budget) {
        super(id, name, status, dueDate);
        this.budget=budget;
    }

    public String type() {
        return "AssignedTimedtask";
    }

    private int budget;


    @Override
    public String toString() {
        return "Assignedtimedtask{" +
                "id"+ super.getId()+ " "+
                "name"+ super.getName()+ " "+
                "status"+ super.getStatus() + " "+
                "dueDate"+ super.getDueDate()+ " "+
                "budget=" + budget +
                '}';
    }
}
