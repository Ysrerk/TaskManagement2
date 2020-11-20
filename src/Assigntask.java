import java.time.LocalDateTime;

public class Assigntask extends Task {
    private String assignedTo;
    public Assigntask(int id, String name, String status, LocalDateTime dueDate,String assignedTo) {
        super(id, name, status, dueDate);
        this.assignedTo=assignedTo;
    }
}
