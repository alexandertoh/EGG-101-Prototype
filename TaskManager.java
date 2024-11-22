import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<Task>();

    public TaskManager() {
        System.out.println("Task Manager Running");
    }

    public void createTask(Task newTask) {
        tasks.add(newTask);
    }
    public void listTasks() {
        for (Task task : tasks) {
            System.out.println("\n" + task.returnInfo());
        }
    }
}
