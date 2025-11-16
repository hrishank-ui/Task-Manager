import java.time.LocalDate;

public class Task {
    private String taskName;
    private String description;
    private LocalDate completionDate;
    private boolean isCompleted;

    public Task (String taskName, String description, LocalDate completionDate, boolean isCompleted) {
        this.taskName = taskName;
        this.description = description;
        this.completionDate = completionDate;
        this.isCompleted = false;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    @Override
    public String toString() {
        return "Task: " + taskName + "\n" +
               "Description: " + description + "\n" +
               "Completion Date: " + completionDate + "\n" +
               "Completed: " + (isCompleted ? "Yes" : "No");
    }
}
