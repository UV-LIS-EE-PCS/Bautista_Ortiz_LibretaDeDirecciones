package address;
import address.data.*;

public class Menu {

    private AddressBook menu;

    public Menu (AddressBook menu) {
        this.menu = menu;
    }

    //Method that displays the available options for manipulating the records
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

    //Method to validate if a contact exists
    public boolean isContactExists(String name, String lastName){
        for (AddressEntry dataEntry : menu.getEntries()){
            if (dataEntry.getName().equalsIgnoreCase(name) &&
                    dataEntry.getLastName().equalsIgnoreCase(lastName)){
                return true;
            }
        }
        return false;
    }

    public void CheckToAdd (String name, String lastName, String street, String city, String state, int zip, String email, String phoneNumber) {
        try {
            if (!isContactExists(name, lastName)) {
                menu.add(name, lastName, street, city, state, zip, email, phoneNumber);
                System.out.println("Contact added successfully!");
            } else {
                System.out.println("This contact already exists");
            }
        } catch (Exception e) {
            System.out.println("An error occurred when adding the contact: " + e.getMessage());
        }
    }




}

