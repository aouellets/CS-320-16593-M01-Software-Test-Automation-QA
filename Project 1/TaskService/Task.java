package TaskService;

/**
 * Task class representing the Task object.
 * This class enforces strict constraints on task information.
 */
public class Task {
    private final String taskID;      // Unique task ID that cannot be changed
    private String name;              // Name of the task, limited to 20 characters
    private String description;       // Description of the task, limited to 50 characters

    // Constructor to initialize the task object with necessary fields
    public Task(String taskID, String name, String description) {
        if (taskID == null || taskID.length() > 10) {
            throw new IllegalArgumentException("Invalid task ID");
        }
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid task name");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid task description");
        }

        this.taskID = taskID;
        this.name = name;
        this.description = description;
    }

    // Getters for task fields
    public String getTaskID() {
        return taskID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid task name");
        }
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid task description");
        }
        this.description = description;
    }
}
