package address;

import address.data.*;

import java.util.Scanner;

public class AddressBookApplication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AddressBook addressEntriesList = AddressBook.getInstance();
        Menu begin = new Menu(addressEntriesList);
        boolean running = true;
        do {
            begin.displayMenu();
            char answer = input.next().toLowerCase().charAt(0);
            input.nextLine();
            switch (answer) {
                case 'a': //Add
                    boolean validEntry = true;
                    while (validEntry) {
                        try {
                            System.out.println("Name");
                            String name = begin.validateNonEmptyInput(input.nextLine());
                            System.out.println("Last Name");
                            String lastName = begin.validateNonEmptyInput(input.nextLine());
                            System.out.println("Street");
                            String street = begin.validateNonEmptyInput(input.nextLine());
                            System.out.println("City");
                            String city = begin.validateNonEmptyInput(input.nextLine());
                            System.out.println("State");
                            String state = begin.validateNonEmptyInput(input.nextLine());
                            System.out.println("Zip");
                            while (!input.hasNextInt()) {
                                System.out.println("Invalid input \nEnter a nex zip");
                                input.next();
                            }
                            int zip = input.nextInt();
                            input.nextLine();
                            System.out.println("Email");
                            String email = begin.validateNonEmptyInput(input.nextLine());
                            System.out.println("Phone Number");
                            String phoneNumber = begin.validateNonEmptyInput(input.nextLine());

                            if (!addressEntriesList.isContactExists(name, lastName)) {
                                addressEntriesList.add(name, lastName, street, city, state, zip, email, phoneNumber);
                                AddressEntry dataEntry = new AddressEntry(name, lastName, street, city, state, zip,
                                        email, phoneNumber);
                            } else {
                                System.out.println("Contact already exists");
                            }
                            validEntry = false;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Please enter a valid information");
                        } catch (Exception e){
                            System.out.println("An error occurred when adding the contact: ");
                        }
                    }
                    break;

                case 'b': //Remove
                    System.out.println("Enter the name of the contact of you want to remove");
                    String nameContact = begin.validateNonEmptyInput(input.nextLine());
                    System.out.println("Enter the last name of the contact of you want to remove");
                    String lastNameContact = begin.validateNonEmptyInput(input.nextLine());
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
        }while (running);
    }


}
