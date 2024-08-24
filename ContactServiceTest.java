//cs320
//projectdone
//GakuKikuchi

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("67890", "Alice", "Smith", "0987654321", "456 Elm St");
        service.addContact(contact);
        assertEquals(contact, service.getContact("67890"));
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("67890", "Alice", "Smith", "0987654321", "456 Elm St");
        service.addContact(contact);
        service.deleteContact("67890");
        assertNull(service.getContact("67890"));
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("67890", "Alice", "Smith", "0987654321", "456 Elm St");
        service.addContact(contact);
        service.updateContact("67890", "Bob", "Johnson", "1122334455", "789 Oak St");
        Contact updatedContact = service.getContact("67890");
        assertEquals("Bob", updatedContact.getFirstName());
        assertEquals("Johnson", updatedContact.getLastName());
        assertEquals("1122334455", updatedContact.getPhone());
        assertEquals("789 Oak St", updatedContact.getAddress());
    }

    @Test
    public void testAddDuplicateContact() {
        Contact contact = new Contact("67890", "Alice", "Smith", "0987654321", "456 Elm St");
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact);
        });
    }
}
