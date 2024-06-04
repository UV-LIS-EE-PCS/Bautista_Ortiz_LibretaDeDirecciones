package address;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import address.data.*;
import address.Menu;


public class MenuTest {
    @Test
    public void testValidateNonEmptyInput() {
        String nonEmptyInput = "Ejemplo";
        assertEquals("Ejemplo", Menu.validateNonEmptyInput(nonEmptyInput));

        String emptyInput = "";
        try{
            Menu.validateNonEmptyInput(emptyInput);
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e){
            assertEquals("This field is required", e.getMessage());
        }
    }
}
