package ContactService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the ContactService class.
 */
public class ContactServiceTest {
    private ContactService contactService;
    private Contact contact;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
        contact = new Contact("001", "John", "Doe", "1234567890", "123 Main St");
    }

    @Test
    public void testAddContact() {
        assertTrue(contactService.addContact(contact));
        assertFalse(contactService.addContact(contact)); // Duplicate contact ID
    }

    @Test
    public void testDeleteContact() {
        contactService.addContact(contact);
        assertTrue(contactService.deleteContact("001"));
        assertFalse(contactService.deleteContact("001")); // Deleting already deleted contact
        assertFalse(contactService.deleteContact("NonExistentID")); // Non-existent contact ID
    }

    @Test
    public void testUpdateContact() {
        contactService.addContact(contact);
        assertTrue(contactService.updateContact("001", "Jane", "Smith", "0987654321", "456 Oak St"));
        Contact updatedContact = contactService.getContact("001");
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("456 Oak St", updatedContact.getAddress());
    }

    @Test
    public void testUpdateNonExistentContact() {
        assertFalse(contactService.updateContact("NonExistentID", "Jane", "Smith", "0987654321", "456 Oak St"));
    }

    @Test
    public void testAddNullContact() {
        assertFalse(contactService.addContact(null));
    }
}
