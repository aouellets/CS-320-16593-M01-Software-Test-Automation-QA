package AppointmentService;

import java.util.Date;

/**
 * Appointment class representing the Appointment object.
 * This class enforces strict constraints on appointment information.
 */
public class Appointment {
    private final String appointmentID;      // Unique appointment ID that cannot be changed
    private final Date appointmentDate;      // Appointment date, must not be in the past
    private String description;              // Description of the appointment, limited to 50 characters

    // Constructor to initialize the appointment object with necessary fields
    public Appointment(String appointmentID, Date appointmentDate, String description) {
        if (appointmentID == null || appointmentID.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid appointment description");
        }

        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    // Getters for appointment fields
    public String getAppointmentID() {
        return appointmentID;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid appointment description");
        }
        this.description = description;
    }
}
