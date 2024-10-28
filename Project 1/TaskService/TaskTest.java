package TaskService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Task class.
 */
public class TaskTest {

    @Test
    public void testValidTask() {
        Task task = new Task("001", "Coding", "Finish coding assignment");
        assertEquals("001", task.getTaskID());
        assertEquals("Coding", task.getName());
        assertEquals("Finish coding assignment", task.getDescription());
    }

    @Test
    public void testInvalidTaskID() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Coding", "Finish coding assignment"));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "Coding", "Finish coding assignment"));
    }

    @Test
    public void testInvalidTaskName() {
        assertThrows(IllegalArgumentException.class, () -> new Task("001", null, "Finish coding assignment"));
        assertThrows(IllegalArgumentException.class, () -> new Task("001", "LongerThanTwentyCharactersName", "Finish coding assignment"));
    }

    @Test
    public void testInvalidTaskDescription() {
        assertThrows(IllegalArgumentException.class, () -> new Task("001", "Coding", null));
        assertThrows(IllegalArgumentException.class, () -> new Task("001", "Coding", "This description is longer than fifty characters, and it should throw an exception"));
    }
}
