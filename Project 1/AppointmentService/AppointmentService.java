package AppointmentService;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;

/**
 * AppointmentService class manages a collection of appointments and provides operations
 * to add, delete and update appointments.
 */
public class AppointmentService {
    // Using a HashMap to store appointments with appointmentID as the key for fast lookup
    private Map<String, Appointment> appointments;

    // Constructor to initialize the appointment list
    public AppointmentService() {
        appointments = new HashMap<>();
    }

    /**
     * Adds an appointment to the service.
     * @param appointment The appointment to be added.
     * @return true if the appointment was added, false if an appointment with the same ID already exists.
     */
    public boolean addAppointment(Appointment appointment) {
        if (appointment == null || appointments.containsKey(appointment.getAppointmentID())) {
            return false; // Prevent adding if appointmentID already exists or appointment is null
        }
        appointments.put(appointment.getAppointmentID(), appointment);
        return true;
    }

    /**
     * Deletes an appointment by its appointmentID.
     * @param appointmentID The unique ID of the appointment to be deleted.
     * @return true if the appointment was deleted, false if no such appointment exists.
     */
    public boolean deleteAppointment(String appointmentID) {
        if (appointmentID == null || !appointments.containsKey(appointmentID)) {
            return false; // Prevent deletion if appointmentID doesn't exist or is null
        }
        appointments.remove(appointmentID);
        return true;
    }

    /**
     * Retrieve an appointment by its appointmentID.
     * @param appointmentID The unique ID of the appointment to be retrieved.
     * @return The appointment if found, null if no such appointment exists.
     */
    public Appointment getAppointment(String appointmentID) {
        return appointments.get(appointmentID);
    }

    /**
     * Updates the appointment fields (date and description) of an existing appointment.
     * @param appointmentID The unique ID of the appointment to be updated.
     * @param newDate The new date of the appointment.
     * @param newDescription The new description of the appointment.
     * @return true if the appointment was successfully updated, false if no such appointment exists.
     */
    public boolean updateAppointment(String appointmentID, Date newDate, String newDescription) {
        if (!appointments.containsKey(appointmentID)) {
            return false; // Appointment not found
        }
        Appointment appointment = appointments.get(appointmentID);
        if (newDate != null && !newDate.before(new Date())) {
            appointment.setAppointmentDate(newDate); // Changed back to setAppointmentDate
        }
        if (newDescription != null && newDescription.length() <= 50) {
            appointment.setDescription(newDescription);
        }
        return true;
    }
}
