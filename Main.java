import java.util.Scanner;

public class Main {
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Welcome Message
        System.out.println("Team Track Prototype\nFrontend Developers: Choushi I., Cody L., Matt K.\nBackend Developer: Alexander O.\n---\n\nPress enter to continue...");
        scanner.nextLine();

        while (running) {
            clearConsole();
            System.out.println("<=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=> Main Menu <=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>\n[1] Make New Task\n[2] View Tasks\n[3] Test Task\n[4] Messaging Demonstration \n[5] Generative AI Suggestions\n[6] Exit\n\nPlease select an option: ");

            int menuSelection = scanner.nextInt();
            scanner.nextLine(); 

            if (menuSelection == 1) { // Creates a new Tasks
                clearConsole();
                System.out.println("<=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=> Task Creation <=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
                System.out.println("Task name: ");
                String taskName = scanner.nextLine();
                System.out.println("Task description: ");
                String taskDescription = scanner.nextLine();
                System.out.println("Due Date (HH:MM MM/DD/YYYY): ");
                String taskDueDate = scanner.nextLine();
                System.out.println("Please enter the users (separated by commas): ");
                String taskUsers = scanner.nextLine();
                System.out.println("Please enter the task ID: ");
                int taskID = scanner.nextInt();
                scanner.nextLine();
                String[] taskUsersArray = taskUsers.split(",");
                Task newTask = new Task(taskName, taskDescription, taskDueDate, taskUsersArray, taskID);
                taskManager.createTask(newTask);
                System.out.println("Task " + taskName + " created Successfully!\n\n" + newTask.returnInfo() + "\n\nPress Enter to continue...");
                scanner.nextLine();
            } else if (menuSelection == 2) { // Lists all created Tasks
                clearConsole();
                System.out.println("<=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=> Task List <=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
                taskManager.listTasks();
                System.out.println("\n\nPress Enter to continue...");
                scanner.nextLine();

            } else if(menuSelection == 3) { // Test Task 
                clearConsole();
                System.out.println("<=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=> Test Case <=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
                System.out.println("\n\nTest Case: User Jane Doe has to complete the updated Bill of Materials in her EGG 101 class, due at 11:59 PM on 11/14/24. \nPlease note that this is an overview of the information, as the functionality hasn't been tested yet.\nInputting the following information:\n\nTask Name: Update Bill of Materials\nDescription: Annotate over last week's assignment and update the tech stack for the assignment.\nDue Date: 11:59:00 PM on 11/14/24\nUsers: Jane Doe, John Doe, Joe Rogan\nID: 1\n\nPress Enter to continue...");
                scanner.nextLine();

                // Test Case Variables
                String testName = "Update Bill of Materials";
                String testDescription = "Annotate over last week's assignment and update the tech stack for the assignment.";
                String[] testUsers = {"Jane Doe", "John Doe", "Joe Rogan"};
                String testDate = "11:59:00 PM on 11/21/24";
                int testID = 1;
                Task testTask = new Task(testName, testDescription, testDate, testUsers, testID);
                System.out.println("\n== Method Output ==\n" + testTask.returnInfo() + "\n== Method Output ==");
                System.out.println("\nPrinted above is the output of testTask.returnInfo(), a method in the task class that returns the info about a task. \nThese instances of tasks are then managed by the Task Manager class. \n\nPress Enter to continue...");
                scanner.nextLine();
            } else if (menuSelection == 4) { // Messaging demonstratioin
                // Clear Console
                clearConsole();
                String message = "\nMessaging System is currently under development. Here's what it would look like:\n\n <=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=> Messaging <=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=> \n\nUsers in Chat:\n - Alex\n - Matt\n - Cody\n - Choushi\n\nGroup Chat 1:\nAlex: Testing out the Messaging Functionality!\nMatt: Hello, World!\n\n|=-=-= Message Box =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-|";
                System.out.println(message);
                String response = scanner.nextLine();
                message = "\nMessaging System is currently under development. Here's what it would look like:\n\n <=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=> Messaging <=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=> \n\nUsers in Chat:\n - Alex\n - Matt\n - Cody\n - Choushi\n - Test User\n\nGroup Chat 1:\nAlex: Testing out the Messaging Functionality!\nMatt: Hello, World!\nTest User: " + response +"\n\n|=-=-= Message Box =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-|";
                clearConsole();
                System.out.println(message + "\n\nIn the future, we will have functionality to have groupchats, private messages, video conferencing.\nThis has been a simulated demonstration of what the final product could look like.\n\nPress Enter to continue...");
                scanner.nextLine();
            } else if (menuSelection == 5) { // Generative AI Suggestions
                clearConsole();
                System.out.println("<=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=> Generative AI Suggestions <=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>\n\nDue to the scope of the prototype, we have not implemented this feature yet.\nAn example of a prompt used to generate suggestions could be:\n\"How can I manage my cooking classes better?\"\n\n--- PROMPT SENT TO LLM ---\n\"Act as a Personal Assistant. Whenever you produce an output, produce the outputs that a Personal Assistant would produce.\nYour boss has the following tasks: \n[Task List]\n\nThis is your boss's request: \"[User Prompt]\"Your Task is to follow your bosses orders and respond with a list of tasks with the timing optimized. \nYou must follow the formatting that was given.\"\n --- PROMPT SENT TO LLM ---\n\nThis prompt is an example of using a Persona Pattern, a way to prompt engineer generative ai.\n\nPress Enter to continue...");
                scanner.nextLine();
            }
            else if (menuSelection == 6) { // Closes software
                running = false;
            } else if (menuSelection == 1337){
                String[] users = {"Alex", "Matt", "Cody", "Choushi"};
                Task task1 = new Task("Begin Demonstration", "Introduce our product and begin live demonstration", "2:00 PM 11/22/2024", users, 1);
                Task task2 = new Task("Upload Code to Github", "Upload final code to github, check for bugs.", "11:59 PM 11/21/2024", users, 2);
                Task task3 = new Task("Update Documentation", "Update the documentation for the project and add code comments", "11:59 PM 11/21/2024", users, 3);
                Task[] tasks = {task1, task2, task3};
                taskManager.createTask(tasks);
                System.out.println("\nDEMONSTRATION MODE ON");
                scanner.nextLine();
            } else { // Invalid Selection
                System.out.println("Invalid Selection. Please try again.");
            }
        }
        scanner.close();
    }
}