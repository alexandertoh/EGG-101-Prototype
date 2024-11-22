import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Welcome Message
        System.out.println("Time Manager v0.1\nFrontend Developers: Choushi I., Cody L., Matt K.\nBackend Developer: Alexander O.\n\n---\n");

        while (running) {
            System.out.println("Main Menu\n[1] Make New Task\n[2] View Tasks\n[3] Exit");

            int menuSelection = scanner.nextInt();
            scanner.nextLine(); 

            if (menuSelection == 1) { // Creates a new Tasks
                System.out.println("Task name: ");
                String taskName = scanner.nextLine();
                System.out.println("Task description: ");
                String taskDescription = scanner.nextLine();
                System.out.println("Due Date (MM/DD/YYYY): ");
                String taskDueDate = scanner.nextLine();
                System.out.println("Please enter the users (separated by commas): ");
                String taskUsers = scanner.nextLine();
                System.out.println("Please enter the task ID: ");
                int taskID = scanner.nextInt();
                scanner.nextLine(); 
                String[] taskUsersArray = taskUsers.split(",");
                Task newTask = new Task(taskName, taskDescription, taskDueDate, taskUsersArray, taskID);
                taskManager.createTask(newTask);
            } else if (menuSelection == 2) { // Lists all created Tasks
                taskManager.listTasks();
                System.out.println("Press Enter to continue...");
                scanner.nextLine();

            } else if (menuSelection == 3) { // Closes software
                running = false;
            } else { // Invalid Selection
                System.out.println("Invalid Selection. Please try again.");
            }
        }

        scanner.close();
    }
}