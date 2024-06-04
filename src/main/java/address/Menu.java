package address;
import address.data.*;

public class Menu {

    private AddressBook menu;

    public Menu (AddressBook menu) {
        this.menu = menu;
    }

    /**
     * Displays the menu options for interacting with the address book.
     */
    public void displayMenu(){
        System.out.println("------------------------------------");
        System.out.println("Welcome to the Menu \n" +
                "Please choose one of the following options:");
        System.out.println("a) Add a new address");
        System.out.println("b) Remove an address");
        System.out.println("c) Read from file");
        System.out.println("d) Show all the address");
        System.out.println("e) Find an address by last name");
        System.out.println("f) Exit");
        System.out.println("------------------------------------");
    }

    /**
     * Validates a non-empty input string.
     * Throws an IllegalArgumentException if the input is null or empty after trimming.
     * @param input The input string to validate.
     * @return The trimmed input string if it is not empty.
     * @throws IllegalArgumentException If the input string is null or empty after trimming.
     */
    static String validateNonEmptyInput(String input) {
        if (input == null || input.trim().equals("")) {
            throw new IllegalArgumentException("This field cannot be empty");
        }
        return input.trim();
    }
}

