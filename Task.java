public class Task {
    // Instance Variables
    private String name;
    private String description; 
    private String dueDate;
    private String[] users;
    private int ID;


    // Constructor
    public Task (String name, String description, String dueDate, String[] users, int ID) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.users = users;
        this.ID = ID;
    }

    // Accessor Methods
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getDueDate() { return dueDate; }
    public String[] getUsers() { return users; }
    public int getID() { return ID; }

    // Mutator Methods
    public void setName(String name) { this.name = name;}
    public void setDescription(String description) { this.description = description;}
    public void setDueDate(String dueDate) { this.dueDate = dueDate;}
    public void setUsers(String[] users) { this.users = users;}
    public void setID(int ID) { this.ID = ID;}
    
    public String returnInfo() {
        String info = "ID #" + ID + "\nTask Name: " + name + "\nDescription: " + description + "\nDue Date: " + dueDate + "\nUsers: ";
        for (String user : users) {
            info += user + ", ";
        }
        return info;
    }
}