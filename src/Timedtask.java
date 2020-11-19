import java.time.LocalDate;
import java.time.LocalDateTime;



public class Timedtask  extends Task{

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    public Timedtask(int id, String name, String status, LocalDateTime dueDate,LocalDateTime startDate,LocalDateTime endDate) {
        super(id, name, status, dueDate);
        this.startDate=startDate;
        this.endDate=endDate;
    }
}
