package AppointmentService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

/**
 * Unit tests for the AppointmentService class.
 */
public class AppointmentServiceTest {
    private AppointmentService appointmentService;
    private Appointment appointment;

    @BeforeEach
    public void setUp() {
        appointmentService = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 100000); // Create a future date
        appointment = new Appointment("001", futureDate, "Doctor's appointment");
    }

    @Test
    public void testAddAppointment() {
        assertTrue(appointmentService.addAppointment(appointment));
        assertFalse(appointmentService.addAppointment(appointment)); // Duplicate appointment ID
    }

    @Test
    public void testDeleteAppointment() {
        appointmentService.addAppointment(appointment);
        assertTrue(appointmentService.deleteAppointment("001"));
        assertFalse(appointmentService.deleteAppointment("001")); // Deleting already deleted appointment
        assertFalse(appointmentService.deleteAppointment("NonExistentID")); // Non-existent appointment ID
    }

    @Test
    public void testAddNullAppointment() {
        assertFalse(appointmentService.addAppointment(null));
    }

    @Test
    public void testUpdateAppointment() {
        appointmentService.addAppointment(appointment);
        Date newDate = new Date(System.currentTimeMillis() + 200000);
        assertTrue(appointmentService.updateAppointment("001", newDate, "Updated appointment"));
        Appointment updatedAppointment = appointmentService.getAppointment("001");
        assertEquals(newDate, updatedAppointment.getAppointmentDate());
        assertEquals("Updated appointment", updatedAppointment.getDescription());
    }

    @Test
    public void testAddAppointmentWithPastDate() {
        Date pastDate = new Date(System.currentTimeMillis() - 100000);
        Appointment pastAppointment = new Appointment("002", pastDate, "Past appointment");
        assertFalse(appointmentService.addAppointment(pastAppointment));
    }

    @Test
    public void testAddAppointmentWithInvalidDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment invalidAppointment = new Appointment("003", futureDate, "This description is longer than fifty characters and should not be allowed");
        assertFalse(appointmentService.addAppointment(invalidAppointment));
    }
}
