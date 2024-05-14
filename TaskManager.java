import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String description;

    public Task(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

public class TaskManager {
    private ArrayList<Task> tasks;
    private Scanner scanner;

    public TaskManager() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void createTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        Task task = new Task(description);
        tasks.add(task);
        System.out.println("Task created successfully!");
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i).getDescription());
            }
        }
    }

    public void updateTask() {
        displayTasks();
        if (!tasks.isEmpty()) {
            System.out.print("Enter task number to update: ");
            int taskNumber = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            if (taskNumber >= 1 && taskNumber <= tasks.size()) {
                System.out.print("Enter new task description: ");
                String newDescription = scanner.nextLine();
                tasks.get(taskNumber - 1).setDescription(newDescription);
                System.out.println("Task updated successfully!");
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }

    public void deleteTask() {
        displayTasks();
        if (!tasks.isEmpty()) {
            System.out.print("Enter task number to delete: ");
            int taskNumber = scanner.nextInt();
            if (taskNumber >= 1 && taskNumber <= tasks.size()) {
                tasks.remove(taskNumber - 1);
                System.out.println("Task deleted successfully!");
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create Task");
            System.out.println("2. Display Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Please enter your choice (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    taskManager.createTask();
                    break;
                case 2:
                    taskManager.displayTasks();
                    break;
                case 3:
                    taskManager.updateTask();
                    break;
                case 4:
                    taskManager.deleteTask();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}
