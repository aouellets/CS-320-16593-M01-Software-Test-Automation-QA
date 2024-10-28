package TaskService;

import java.util.HashMap;
import java.util.Map;

/**
 * TaskService class manages a collection of tasks and provides operations
 * to add, update, and delete tasks.
 */
public class TaskService {
    // Using a HashMap to store tasks with taskID as the key for fast lookup
    private Map<String, Task> tasks;

    // Constructor to initialize the task list
    public TaskService() {
        tasks = new HashMap<>();
    }

    /**
     * Adds a task to the service.
     * @param task The task to be added.
     * @return true if the task was added, false if a task with the same ID already exists.
     */
    public boolean addTask(Task task) {
        if (task == null || tasks.containsKey(task.getTaskID())) {
            return false; // Prevent adding if taskID already exists or task is null
        }
        tasks.put(task.getTaskID(), task);
        return true;
    }

    /**
     * Deletes a task by its taskID.
     * @param taskID The unique ID of the task to be deleted.
     * @return true if the task was deleted, false if no such task exists.
     */
    public boolean deleteTask(String taskID) {
        if (taskID == null || !tasks.containsKey(taskID)) {
            return false; // Prevent deletion if taskID doesn't exist or is null
        }
        tasks.remove(taskID);
        return true;
    }

    /**
     * Updates the task fields (name and description) of an existing task.
     * @param taskID The unique ID of the task to be updated.
     * @param name The new name of the task.
     * @param description The new description of the task.
     * @return true if the task was successfully updated, false if no such task exists.
     */
    public boolean updateTask(String taskID, String name, String description) {
        if (!tasks.containsKey(taskID)) {
            return false; // Task not found
        }
        Task task = tasks.get(taskID);
        if (name != null && name.length() <= 20) {
            task.setName(name);
        }
        if (description != null && description.length() <= 50) {
            task.setDescription(description);
        }
        return true;
    }

    /**
     * Retrieve a task by its taskID.
     * @param taskID The unique ID of the task to be retrieved.
     * @return The task if found, null if no such task exists.
     */
    public Task getTask(String taskID) {
        return tasks.get(taskID);
    }
}
