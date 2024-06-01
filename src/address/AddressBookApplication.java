package address;

import address.data.*;

import javax.xml.namespace.QName;
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
                    System.out.println("Name");
                    String name = input.nextLine();
                    System.out.println("Last Name");
                    String lastName = input.nextLine();
                    System.out.println("Street");
                    String street = input.nextLine();
                    System.out.println("City");
                    String city = input.nextLine();
                    System.out.println("State");
                    String state = input.nextLine();
                    System.out.println("Zip");
                    while (!input.hasNextInt()) {
                        System.out.println("Invalid input \nEnter a nex zip");
                        input.next();
                    }
                    int zip = input.nextInt();
                    input.nextLine();
                    System.out.println("Email");
                    String email = input.nextLine();
                    System.out.println("Phone Number");
                    String phoneNumber = input.nextLine();

                    if (!begin.isContactExists(name,lastName)){
                        begin.CheckToAdd(name,lastName, street, city, state, zip, email, phoneNumber);
                        AddressEntry dataEntry = new AddressEntry(name,lastName, street, city, state, zip,
                                email, phoneNumber);
                    }
                    else{
                        System.out.println("Contact already exists");
                    }

                    break;

                case 'b': //Remove
                    System.out.println("Enter the name of the contact of you want to remove");
                    String nameContact = input.nextLine();
                    System.out.println("Are you sure to remove this contact? ");
                    char answerToCase = input.nextLine().toLowerCase().charAt(0);
                    if (answerToCase == 'y'){
                        addressEntriesList.remove(nameContact);
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

                case 'f': //Exit
                    System.out.println("Thank you for use the directory");
                    running = false;
                    return;

                default:
                    System.out.println("Invalid entry, must be a letter from a - e");




            }

        }
    }


}
