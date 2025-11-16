import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class TaskManage {
    private List<Task> tasks;

    public TaskManage() {
        tasks = new ArrayList<>();
    }

    public void addTask (Task task) {
        tasks.add(task);
    }

    public Task searchByName (String taskName) {
        for (Task task : tasks) {
            if (task != null && task.getTaskName() != null && task.getTaskName().equals(taskName)) {
                return task;
            }
        }
        return null;
    }

    public boolean editTask(String taskName, String newName, String newDescription, LocalDate newCompletionDate, Boolean newIsCompleted) {
        Task task = searchByName(taskName);
        if (task == null) {
            return false;
        }

        if (newName != null && !newName.isEmpty()) {
            task.setTaskName(newName);
        }
        if (newDescription != null) {
            task.setDescription(newDescription);
        }
        if (newCompletionDate != null) {
            task.setCompletionDate(newCompletionDate);
        }
        if (newIsCompleted != null) {
            task.setCompleted(newIsCompleted);
        }

        return true;
    }

    public boolean removeTask (String taskName) {
        Task taskF = searchByName(taskName);
        if (taskF != null) {
            return tasks.remove(taskF);
        }
        return false;
    }

    public void displaytasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks are available");
        }
        else {
            for (Task availTasks : tasks) {
                System.out.println(availTasks);
            }
        }
    }
}
