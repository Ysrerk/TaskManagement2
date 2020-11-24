import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Timedtask extends Task{
    //public static ArrayList<Object> listofaddedtimedtasklist;


    private LocalDateTime startDate;
    private LocalDateTime endDate;
    public Timedtask(int id, String name, String status, LocalDateTime dueDate,LocalDateTime startDate,LocalDateTime endDate) {
        super(id, name, status, dueDate);
        this.startDate=startDate;
        this.endDate=endDate;
    }



    @Override
    public String type() {
        return "Timedtask";
    }

    @Override
    public String toString() {
        return "Timedtask{" +
                "id=" + super.getId()+" "+
                "name  " + super.getName()+" "+
                "status" + super.getStatus()+" "+
                "dueDate" + super.getDueDate()+" "+

                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
