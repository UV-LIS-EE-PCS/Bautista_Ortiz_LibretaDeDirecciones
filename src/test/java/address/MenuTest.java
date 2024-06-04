package address;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import address.data.*;
import address.Menu;


public class MenuTest {
    private AddressBook begin;
    private Menu menu;

    @BeforeEach
    public void setUp() {
        begin = AddressBook.getInstance();
        menu = new Menu(begin);
    }

    /**
     * Test to validate the empty input
     */
    @Test
    public void testValidateNonEmptyInput() {
        String nonEmptyInput = "Ejemplo";
        assertEquals("Ejemplo", Menu.validateNonEmptyInput(nonEmptyInput));

    }
}
