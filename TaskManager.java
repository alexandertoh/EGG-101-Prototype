import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<Task>();

    public TaskManager() {
        System.out.println("Task Manager Running...\n");
    }

    public void createTask(Task newTask) {
        tasks.add(newTask);
    }
    public void createTask(Task[] newTasks) {
        for (Task task : newTasks) {
            tasks.add(task);
        }
    }
    public void listTasks() {
        if (tasks.size() == 0) {
            System.out.println("No tasks have been created yet.");
        } else {
            for (Task task : tasks) {
                System.out.println("\n" + task.returnInfo());
            }
        }
        
    }
}
