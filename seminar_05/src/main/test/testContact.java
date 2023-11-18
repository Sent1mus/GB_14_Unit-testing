import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class testContact {
    private ContactOperations ContactOperations;

    @Test
    public void testAddContact() {
        ContactOperations ContactOperations = new ContactOperations();
        Contact Contact = new Contact("John", "1234567890");
        ContactOperations.addContact(Contact);
        assertNotNull(ContactOperations.data.get(0));
        assertEquals("John", ContactOperations.data.get(0).getName());
        assertEquals("1234567890", ContactOperations.data.get(0).getPhone());
    }

    @Test
    public void testPrintContact() {
        ContactOperations ContactOperations = new ContactOperations();
        Contact Contact1 = new Contact("John", "1234567890");
        Contact Contact2 = new Contact("Jane", "0987654321");

        ContactOperations.addContact(Contact1);
        ContactOperations.addContact(Contact2);

        String expected = "John: 1234567890\nJane: 0987654321\n";
        assertEquals(expected, ContactOperations.toString());
    }

    @Test
    public void testEditPhone() {
        ContactOperations ContactOperations = new ContactOperations();
        ContactOperations.addContact(new Contact("John", "1234567890"));
        assertTrue(ContactOperations.editPhone("John", "0987654321"));
    }

    @Test
    void testEditName() {
        ContactOperations ContactOperations = new ContactOperations();
        ContactOperations.addContact(new Contact("John", "1234567890"));
        assertTrue(ContactOperations.editName("Jane", "1234567890"));
    }

    @Test
    void testAllOperations() {
        ContactOperations ContactOperations = new ContactOperations();
        Contact contact1 = new Contact("John", "1234567890");
        Contact contact2 = new Contact("Jane", "0987654321");
        Contact contact3 = new Contact("Bob", "1111111111");
        ContactOperations.addContact(contact1);
        ContactOperations.addContact(contact2);
        ContactOperations.addContact(contact3);
        assertThat(ContactOperations.toString()).contains("Jane: 0987654321");
        ContactOperations.editPhone("Jane", "1231231231");
        ContactOperations.editName("Max", "1111111111");
        assertThat(ContactOperations.toString()).contains("Jane: 1231231231");
        ContactOperations.delContact("Jane");
        assertThat(ContactOperations.toString()).doesNotContain("Jane: 1231231231");
        assertThat(ContactOperations.toString()).contains("John: 1234567890");
        assertThat(ContactOperations.toString()).contains("Max: 1111111111");
    }

}
