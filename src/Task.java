import java.time.LocalDateTime;

public class Task {

    public enum Status{
        ADDED,
        ASSIGNED,
        SCHEDULED,
        SCHEDULEDASSIGNED
    }



    private int id;
    private String name;
    private String status;
    private LocalDateTime dueDate;

    public Task(int id, String name, String status, LocalDateTime dueDate) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.dueDate = dueDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public  static void addtask(Task task){
        Database.listofaddedtasklist.add(task);

    }

    @Override
    public String toString() {
        return "[" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", dueDate=" + dueDate +
                ']';
    }


}
