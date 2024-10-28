package ContactService;

import java.util.HashMap;
import java.util.Map;

/**
 * ContactService class manages a collection of contacts and provides operations
 * to add, update, and delete contacts.
 */
public class ContactService {
    // Using a HashMap to store contacts with contactID as the key for fast lookup
    private Map<String, Contact> contacts;

    // Constructor to initialize the contact list
    public ContactService() {
        contacts = new HashMap<>();
    }

    /**
     * Adds a contact to the service.
     * @param contact The contact to be added.
     * @return true if the contact was added, false if a contact with the same ID already exists.
     */
    public boolean addContact(Contact contact) {
        if (contact == null || contacts.containsKey(contact.getContactID())) {
            return false; // Prevent adding if contactID already exists or contact is null
        }
        contacts.put(contact.getContactID(), contact);
        return true;
    }

    /**
     * Deletes a contact by its contactID.
     * @param contactID The unique ID of the contact to be deleted.
     * @return true if the contact was deleted, false if no such contact exists.
     */
    public boolean deleteContact(String contactID) {
        if (contactID == null || !contacts.containsKey(contactID)) {
            return false; // Prevent deletion if contactID doesn't exist or is null
        }
        contacts.remove(contactID);
        return true;
    }

    /**
     * Updates the contact fields (firstName, lastName, phone, and address) of an existing contact.
     * @param contactID The unique ID of the contact to be updated.
     * @param firstName The new first name.
     * @param lastName The new last name.
     * @param phone The new phone number.
     * @param address The new address.
     * @return true if the contact was successfully updated, false if no such contact exists.
     */
    public boolean updateContact(String contactID, String firstName, String lastName, String phone, String address) {
        if (!contacts.containsKey(contactID)) {
            return false; // Contact not found
        }
        Contact contact = contacts.get(contactID);
        if (firstName != null) {
            contact.setFirstName(firstName);
        }
        if (lastName != null) {
            contact.setLastName(lastName);
        }
        if (phone != null) {
            contact.setPhone(phone);
        }
        if (address != null) {
            contact.setAddress(address);
        }
        return true;
    }

    /**
     * Retrieve a contact by its contactID.
     * @param contactID The unique ID of the contact to be retrieved.
     * @return The contact if found, null if no such contact exists.
     */
    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}
