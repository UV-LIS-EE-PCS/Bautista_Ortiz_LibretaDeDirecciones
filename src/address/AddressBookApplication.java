package address;

import address.data.*;

import javax.xml.namespace.QName;
import java.nio.channels.SelectableChannel;
import java.util.Scanner;

public class AddressBookApplication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AddressBook addressEntriesList = AddressBook.getInstance();
        Menu begin = new Menu(addressEntriesList);
        boolean running = true;
        while (running) {
            begin.displayMenu();
            char answer = input.next().toLowerCase().charAt(0);
            input.nextLine();
            switch (answer) {
                case 'a': //Add
                    boolean validEntry = true;
                    while (validEntry) {
                        try {
                            System.out.println("Name");
                            String name = validateNonEmptyInput(input.nextLine());
                            System.out.println("Last Name");
                            String lastName = validateNonEmptyInput(input.nextLine());
                            System.out.println("Street");
                            String street = validateNonEmptyInput(input.nextLine());
                            System.out.println("City");
                            String city = validateNonEmptyInput(input.nextLine());
                            System.out.println("State");
                            String state = validateNonEmptyInput(input.nextLine());
                            System.out.println("Zip");
                            while (!input.hasNextInt()) {
                                System.out.println("Invalid input \nEnter a nex zip");
                                input.next();
                            }
                            int zip = input.nextInt();
                            input.nextLine();
                            System.out.println("Email");
                            String email = validateNonEmptyInput(input.nextLine());
                            System.out.println("Phone Number");
                            String phoneNumber = validateNonEmptyInput(input.nextLine());

                            if (!begin.isContactExists(name, lastName)) {
                                begin.CheckToAdd(name, lastName, street, city, state, zip, email, phoneNumber);
                                AddressEntry dataEntry = new AddressEntry(name, lastName, street, city, state, zip,
                                        email, phoneNumber);
                                validEntry = false;
                            } else {
                                System.out.println("Contact already exists");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Please enter a valid information");
                        }
                    }
                    break;

                case 'b': //Remove
                    System.out.println("Enter the name of the contact of you want to remove");
                    String nameContact = validateNonEmptyInput(input.nextLine());
                    System.out.println("Enter the last name of the contact of you want to remove");
                    String lastNameContact = validateNonEmptyInput(input.nextLine());
                    addressEntriesList.find(lastNameContact);

                    System.out.println("Are you sure to remove this contact? (y/n)");
                    char answerToCase = input.nextLine().toLowerCase().charAt(0);
                    if (answerToCase == 'y'){
                        addressEntriesList.remove(nameContact, lastNameContact);
                    } else if (answerToCase == 'n') {
                        System.out.println("Operation canceled");

                    }
                    break;

                case 'c': // File
                    System.out.println("Please enter the file name ");
                    String filename = input.nextLine();
                    addressEntriesList.readFromFile(filename);
                    break;

                case 'd' : //Show the contacts
                    addressEntriesList.displayEntries();
                    break;

                case 'e': //Find a contact
                    System.out.println("Enter the last name ");
                    String findLastName = input.nextLine();
                    addressEntriesList.find(findLastName);
                    break;

                case 'f': //Exit
                    System.out.println("Thank you for use the directory");
                    running = false;
                    return;

                default:
                    System.out.println("Invalid entry, must be a letter from a - f");
                    break;




            }

        }
    }

    //Method to validate if a user input is empty
    private static String validateNonEmptyInput(String input) {
        if (input == null || input.trim().equals("")) {
            throw new IllegalArgumentException("This field cannot be empty");
        }
        return input.trim();
    }
}
