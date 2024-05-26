package address.data;

import java.util.Scanner;
import java.util.ArrayList;

public class AddressBook {
    Scanner input = new Scanner(System.in);
    ArrayList <AddressEntry> AddressEntryRegister = new ArrayList<>();

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

    public void print(){

    }


}
