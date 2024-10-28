package AppointmentService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

/**
 * Unit tests for the Appointment class.
 */
public class AppointmentTest {

    @Test
    public void testValidAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000); // Create a future date
        Appointment appointment = new Appointment("001", futureDate, "Doctor's appointment");
        assertEquals("001", appointment.getAppointmentID());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Doctor's appointment", appointment.getDescription());
    }

    @Test
    public void testInvalidAppointmentID() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        assertThrows(IllegalArgumentException.class, () -> new Appointment(null, futureDate, "Doctor's appointment"));
        assertThrows(IllegalArgumentException.class, () -> new Appointment("12345678901", futureDate, "Doctor's appointment")); // ID too long
    }

    @Test
    public void testInvalidAppointmentDate() {
        Date pastDate = new Date(System.currentTimeMillis() - 100000); // Create a past date
        assertThrows(IllegalArgumentException.class, () -> new Appointment("001", pastDate, "Doctor's appointment"));
    }

    @Test
    public void testInvalidDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        assertThrows(IllegalArgumentException.class, () -> new Appointment("001", futureDate, null)); // Null description
        assertThrows(IllegalArgumentException.class, () -> new Appointment("001", futureDate, "This description is longer than fifty characters, and it should throw an exception."));
    }
}
