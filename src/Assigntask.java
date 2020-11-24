import java.time.LocalDateTime;

public class Assigntask extends Task {
    private String assignedTo;

    public Assigntask(int id, String name, String status, LocalDateTime dueDate,String assignedTo) {
        super(id, name, status, dueDate);
        this.assignedTo=assignedTo;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    @Override
    public String type() {
        return "Assigned task";
    }

    @Override
    public String toString() {
        return "Assigntask{" +
                "id"+ super.getId()+" "+
                "name  "+ super.getName()+" "+
                "status"+ super.getStatus()+ " "+
                "dueDate"+ super.getDueDate()+ " "+
                "assignedTo='" + assignedTo + '\'' +
                '}';
    }
}
