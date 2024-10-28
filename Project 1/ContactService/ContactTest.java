package ContactService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Contact class.
 */
public class ContactTest {

    @Test
    public void testValidContact() {
        Contact contact = new Contact("001", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("001", contact.getContactID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testInvalidContactID() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    public void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("001", null, "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("001", "LongerThanTen", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    public void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("001", "John", null, "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("001", "John", "LongerThanTen", "1234567890", "123 Main St"));
    }

    @Test
    public void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("001", "John", "Doe", null, "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("001", "John", "Doe", "123456789", "123 Main St")); // Less than 10 digits
        assertThrows(IllegalArgumentException.class, () -> new Contact("001", "John", "Doe", "12345678901", "123 Main St")); // More than 10 digits
    }

    @Test
    public void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("001", "John", "Doe", "1234567890", null));
        assertThrows(IllegalArgumentException.class, () -> new Contact("001", "John", "Doe", "1234567890", "This address is longer than 30 characters and should throw an exception"));
    }
}
