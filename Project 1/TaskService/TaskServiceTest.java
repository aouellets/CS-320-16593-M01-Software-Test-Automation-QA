package TaskService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the TaskService class.
 */
public class TaskServiceTest {
    private TaskService taskService;
    private Task task;

    @BeforeEach
    public void setUp() {
        taskService = new TaskService();
        task = new Task("001", "Coding", "Finish coding assignment");
    }

    @Test
    public void testAddTask() {
        assertTrue(taskService.addTask(task));
        assertFalse(taskService.addTask(task)); // Duplicate task ID
    }

    @Test
    public void testDeleteTask() {
        taskService.addTask(task);
        assertTrue(taskService.deleteTask("001"));
        assertFalse(taskService.deleteTask("001")); // Deleting already deleted task
        assertFalse(taskService.deleteTask("NonExistentID")); // Non-existent task ID
    }

    @Test
    public void testUpdateTask() {
        taskService.addTask(task);
        assertTrue(taskService.updateTask("001", "Debugging", "Debug the program"));
        Task updatedTask = taskService.getTask("001");
        assertEquals("Debugging", updatedTask.getName());
        assertEquals("Debug the program", updatedTask.getDescription());
    }

    @Test
    public void testUpdateNonExistentTask() {
        assertFalse(taskService.updateTask("NonExistentID", "Debugging", "Debug the program"));
    }

    @Test
    public void testAddNullTask() {
        assertFalse(taskService.addTask(null));
    }
}
