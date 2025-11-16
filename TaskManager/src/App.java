import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        TaskManage taskM = new TaskManage();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("======Task Manager ======");
            System.out.println("1. Add task");
            System.out.println("2. Remove task");
            System.out.println("3. Edit task");
            System.out.println("4. Display all tasks");
            System.out.println("5. Exit program");
            System.out.println("Enter your choice (1-5): ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter task name: ");
                    String taskName = sc.nextLine();
                    System.out.println("Enter description: ");
                    String description = sc.nextLine();
                    System.out.println("Enter date it should be completed on (YYYY-MM-DD): ");
                    String dateInput = sc.nextLine();
                    LocalDate completionDate = LocalDate.parse(dateInput, DateTimeFormatter.ISO_LOCAL_DATE);

                    taskM.addTask(new Task(taskName, description, completionDate, false));
                    break;
                
                case 2:
                    System.out.println("Enter task name to be removed: ");
                    String taskN = sc.nextLine();
                    Task taskToRemove = taskM.searchByName(taskN);
                    if (taskToRemove != null) {
                        taskM.removeTask(taskN);
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;

                case 3:
                    System.out.println("Enter task name to edit: ");
                    String taskNa = sc.nextLine();
                    Task taskToEdit = taskM.searchByName(taskNa);
                    if (taskToEdit != null) {
                        System.out.println("Enter new task name: ");
                        String newTaskName = sc.nextLine();
                        System.out.println("Enter new description: ");
                        String newDescription = sc.nextLine();
                        System.out.println("Enter new completion date (YYY-MM-DD):");
                        String newDateInput = sc.nextLine();
                        LocalDate newCompletionDate = LocalDate.parse(newDateInput, DateTimeFormatter.ISO_LOCAL_DATE);
                        System.out.println("Is the task completed? (Yes/No)");
                        String isCompleted = sc.nextLine();
                        boolean newIsCompleted = isCompleted.equalsIgnoreCase(isCompleted);
                        taskM.editTask(taskNa, newTaskName, newDescription, newCompletionDate, newIsCompleted);
                        break;
                    }
                    else {
                        System.out.println("Task not found");
                        break;
                    }

                case 4:
                    taskM.displaytasks();
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;
            }
        } while (choice != 5);
        sc.close();
    }
}
