package address.data;

import java.util.Scanner;
import java.util.ArrayList;

public class AddressBook {
    Scanner input = new Scanner(System.in);

    ArrayList <AddressEntry> AddressEntryRegister = new ArrayList<>();

    //Method for add new records through user data insertion
    public void add () {
        AddressEntry temporalAddressEntry = new AddressEntry();
        System.out.println("Name");
        temporalAddressEntry.setName(input.nextLine());
        System.out.println("Last Name");
        temporalAddressEntry.setLastName(input.nextLine());
        System.out.println("Street");
        temporalAddressEntry.setStreet(input.nextLine());
        System.out.println("City");
        temporalAddressEntry.setCity(input.nextLine());
        System.out.println("State");
        temporalAddressEntry.setState(input.nextLine());
        System.out.println("Zip");
        temporalAddressEntry.setZip(input.nextInt());
        input.nextLine();
        System.out.println("Email");
        temporalAddressEntry.setEmail(input.nextLine());
        System.out.println("Phone Number");
        temporalAddressEntry.setPhoneNumber(input.nextInt());
        input.nextLine();
        AddressEntryRegister.add(temporalAddressEntry);
    }

    //Method to remove records from the directory
    public void remove(String lastName){
        AddressEntryRegister.removeIf(entry -> entry.getLastName().equals(lastName));
    }

    //Method to reading records through a text file
    public void readFromFile(String fileName){


    }


    //Method to search for a record in the directory by the last name
    public void find(String lastName){

    }




}
