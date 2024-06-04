package address.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddressBookTest {
    private AddressBook addressBook;

    @BeforeEach
    public void setUp() {
        addressBook = AddressBook.getInstance();
    }

    /**
     * test to validate the correct operation of the add method of the AddressBook class
     */

    @Test
    public void testAdd() {
        addressBook.add("Emilio", "Jasso", "Los Naranjos", "Las Choapas"
        , "Veracruz", 96779, "jasso@gmail.com", "9213456998");

        addressBook.add("Alejandra", "Ortiz", "Tulipanes", "Minatitlán"
        , "Veracruz", 96870, "bauti@gmail.com", "9221859943");
        assertEquals(2, addressBook.getEntries().size());
    }

    /**
     * test to validate the correct operation of the remove method of the AddressBook class
     */
    @Test
    public void testRemove() {
        addressBook.add("Emilio", "Jasso", "Los Naranjos", "Las Choapas"
                , "Veracruz", 96779, "jasso@gmail.com", "9213456998");

        addressBook.remove( "Jasso");
        assertEquals(0, addressBook.getEntries().size());
    }

    /**
     * test to validate the correct operation of the createAddressEntry method of the AddressBook class
     */
    @Test
    public void testReadFromFile(){

        if (!addressBook.isContactExists("Alejandra", "Bautista")){
            addressBook.readFromFile("Bautista.txt");
            assertEquals(1, addressBook.getEntries().size());
        }
        else {
            addressBook.readFromFile("Bautista.txt");
            assertEquals(0, addressBook.getEntries().size());
        }

    }

    /**
     * test to validate the correct operation of the find method of the AddressBook class
     */
    @Test
    public void testFind() {
        addressBook.add("Emilio", "Jasso", "Los Naranjos", "Las Choapas"
                , "Veracruz", 96779, "jasso@gmail.com", "9213456998");

        addressBook.add("Antonieta", "jaramillo", "Los Naranjos", "Las Choapas"
                , "Veracruz", 96779, "jasso@gmail.com", "9213456998");

        addressBook.add("Alejandra", "Ortiz", "Tulipanes", "Minatitlán"
                , "Veracruz", 96870, "bauti@gmail.com", "9221859943");

        addressBook.find("Ja");
        assertEquals(2, addressBook.getEntries().size()-1);
    }

    /**
     * test to validate the correct operation of the displayEntries method of the AddressBook class
     */
    @Test
    public void TestDisplayEntries(){
        addressBook.add("Emilio", "Jasso", "Los Naranjos", "Las Choapas"
                , "Veracruz", 96779, "jasso@gmail.com", "9213456998");

        addressBook.add("Antonieta", "jaramillo", "Los Naranjos", "Las Choapas"
                , "Veracruz", 96779, "jasso@gmail.com", "9213456998");

        addressBook.displayEntries();
        assertEquals(2, addressBook.getEntries().size());
    }

    /**
     * test to validate the correct operation of the isContactExist method of the AddressBook class
     */
    @Test
    public void TestIsContactExists() {
        addressBook.add("Emilio", "Jasso", "Los Naranjos", "Las Choapas"
                , "Veracruz", 96779, "jasso@gmail.com", "9213456998");

        addressBook.isContactExists("Emilio", "Jaso");
        assertTrue(addressBook.getEntries().size()==1);
    }
}
