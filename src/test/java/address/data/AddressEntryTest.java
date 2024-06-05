package address.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import address.data.AddressEntry;

public class AddressEntryTest {

    /**
     * Test to validate the constructor and getters of the AddressEntry class
     */
    @Test
    void testConstructorAndGetters() {
        AddressEntry entry = new AddressEntry("Alejandra", "Ortiz", "Tulipanes", "Minatitlán",
                "Veracruz", 96870, "bautista@gmail.com", "9221859943");
        assertEquals("Alejandra", entry.getName());
        assertEquals("Ortiz", entry.getLastName());
        assertEquals("Tulipanes", entry.getStreet());
        assertEquals("Minatitlán", entry.getCity());
        assertEquals("Veracruz", entry.getState());
        assertEquals(96870, entry.getZip());
        assertEquals("bautista@gmail.com", entry.getEmail());
        assertEquals("9221859943", entry.getPhoneNumber());
    }

    /**
     * Test to validate the setters of the AddressEntry class
     */
    @Test
    void testSettersAndGetters() {
        AddressEntry entry = new AddressEntry();
        entry.setName("Alejandra");
        entry.setLastName("Ortiz");
        entry.setStreet("Tulipanes");
        entry.setCity("Minatitlán");
        entry.setState("Veracruz");
        entry.setZip(96870);
        entry.setEmail("bautista@gmail.com");
        entry.setPhoneNumber("9221859943");
        assertEquals("Alejandra", entry.getName());
        assertEquals("Ortiz", entry.getLastName());
        assertEquals("Tulipanes", entry.getStreet());
        assertEquals("Minatitlán", entry.getCity());
        assertEquals("Veracruz", entry.getState());
        assertEquals(96870, entry.getZip());
        assertEquals("bautista@gmail.com", entry.getEmail());
        assertEquals("9221859943", entry.getPhoneNumber());
    }


    /**
     * Test to validate the toString method of the AddressEntry class
     */
    @Test
    void testToString(){
        AddressEntry entry = new AddressEntry("Alejandra", "Ortiz", "Tulipanes", "Minatitlán",
                "Veracruz", 96870, "bautista@gmail.com", "9221859943");
        assertEquals("Name: Alejandra\nLast Name: Ortiz\nStreet: Tulipanes\nCity: Minatitlán\nState: Veracruz" +
                "\nZip: 96870\nEmail: bautista@gmail.com\nPhoneNumber: 9221859943\n", entry.toString());


    }

}

