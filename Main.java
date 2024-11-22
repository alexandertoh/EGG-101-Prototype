import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Welcome Message
        System.out.println("Team Track Prototype\nFrontend Developers: Choushi I., Cody L., Matt K.\nBackend Developer: Alexander O.\n\n---\n");

        while (running) {
            System.out.println("\n\nMain Menu\n[1] Make New Task\n[2] View Tasks\n[3] Test Task\n[4] ... \n[5] Exit");

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

            } else if(menuSelection == 3) { // Test Task 
                System.out.println("\n\nTest Case: User Jane Doe has to complete the updated Bill of Materials in her EGG 101 class, due at 11:59 PM on 11/14/24. Please note that this is an overview of the information, as the functionality hasn't been tested yet.\nInputting the following information:\n\nTask Name: Update Bill of Materials\nDescription: Annotate over last week's assignment and update the tech stack for the assignment.\nDue Date: 11:59:00 PM on 11/14/24\nUsers: Jane Doe, John Doe, Joe Rogan\nID: 1");
        
                // Test Case Variables
                String testName = "Update Bill of Materials";
                String testDescription = "Annotate over last week's assignment and update the tech stack for the assignment.";
                String[] testUsers = {"Jane Doe", "John Doe", "Joe Rogan"};
                String testDate = "11:59:00 PM on 11/21/24";
                int testID = 1;
                Task testTask = new Task(testName, testDescription, testDate, testUsers, testID);
                System.out.println("\nMethod Output: \n" + testTask.returnInfo());
                System.out.println("Press Enter to continue...");
                scanner.nextLine();
            }
            else if (menuSelection == 5) { // Closes software
                running = false;
            } else { // Invalid Selection
                System.out.println("Invalid Selection. Please try again.");
            }
        }

        scanner.close();
    }
}