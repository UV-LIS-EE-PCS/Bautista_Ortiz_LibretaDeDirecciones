package address.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import address.data.AddressEntry;

public class AddressEntryTest {

    @Test
    void testConstructorAndGetters() {
        AddressEntry entry = new AddressEntry("Alejandra", "Ortiz", "Tulipanes", "");
        /*AddressEntry entry = new AddressEntry("John", "Doe", "123 Main St", "Anytown", "NY", 12345, "john@example.com", "1234567890");
        assertEquals("John", entry.getName());
        assertEquals("Doe", entry.getLastName());
        assertEquals("123 Main St", entry.getStreet());
        assertEquals("Anytown", entry.getCity());
        assertEquals("NY", entry.getState());
        assertEquals(12345, entry.getZip());
        assertEquals("john@example.com", entry.getEmail());
        assertEquals("1234567890", entry.getPhoneNumber());*/
    }
}
