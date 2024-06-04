package address.data;

import address.Menu;
import java.io.*;
import java.util.Comparator;
import java.util.ArrayList;

public class AddressBook {

    /**
     * List to store address entries.
     */
    private ArrayList <AddressEntry> addressEntriesList = new ArrayList<>();

    /**
     * Singleton instance of the AddressBook.
     */
    private static AddressBook instance = null;


    /**
     * Constructor
     */
    private AddressBook(){
    }

    /**
     * Returns the singleton instance of the AddressBook class.
     * If no instance exists, a new instance is created.
     * @return The singleton instance of the AddressBook class.
     */
    public static AddressBook getInstance(){
        if(instance == null){
            instance = new AddressBook();
        }
        return instance;
    }


    /**
     * Returns the list of address entries stored in the AddressBook.
     * @return The list of address entries.
     */
    public ArrayList <AddressEntry> getEntries(){
        return addressEntriesList;
    }

    /**
     * Adds a new AddressEntry to the address book.
     *
     * @param name        the first name of the contact
     * @param lastName    the last name of the contact
     * @param street      the street address of the contact
     * @param city        the city where the contact lives
     * @param state       the state where the contact lives
     * @param zip         the ZIP code of the contact's address
     * @param email       the email address of the contact
     * @param phoneNumber the phone number of the contact
     */
    public void add (String name, String lastName, String street, String city,
                     String state, int zip, String email, String phoneNumber) {
        AddressEntry dataEntry = new AddressEntry();
        dataEntry.setName(name);
        dataEntry.setLastName(lastName);
        dataEntry.setStreet(street);
        dataEntry.setCity(city);
        dataEntry.setState(state);
        dataEntry.setZip(zip);
        dataEntry.setEmail(email);
        dataEntry.setPhoneNumber(phoneNumber);
        addressEntriesList.add(dataEntry);
    }

    /**
     * Removes an AddressEntry from the address book that matches the given first name and last name.
     *
     * @param lastName the last name of the contact to be removed
     */
    public void remove(String lastName ){
        addressEntriesList.removeIf(entry -> entry.getLastName().equalsIgnoreCase(lastName));
        System.out.println(lastName + " Removed successfully");
    }

    /**
     * Creates an AddressEntry object from an array of address elements.
     *
     * @param addressElements an array of Strings containing the address elements
     *                        in the following order: name, last name, street, city,
     *                        state, zip, email, and phone number.
     * @return an AddressEntry object populated with the provided address elements.
     * @throws NumberFormatException if the zip code element cannot be parsed as an integer.
     */
    private AddressEntry createAddressEntry(String [] addressElements){
        AddressEntry dataEntry = new AddressEntry();
        dataEntry.setName(addressElements[0]);
        dataEntry.setLastName(addressElements[1]);
        dataEntry.setStreet(addressElements[2]);
        dataEntry.setCity(addressElements[3]);
        dataEntry.setState(addressElements[4]);
        dataEntry.setZip(Integer.parseInt(addressElements[5]));
        dataEntry.setEmail(addressElements[6]);
        dataEntry.setPhoneNumber(addressElements[7]);
        return dataEntry;
    }

    /**
     * Reads address entries from a file and adds them to the address book.
     * If a duplicate entry is found, it will not be added.
     *
     * @param fileName the name of the file to read from.
     */
    public void readFromFile(String fileName){
        try(BufferedReader entry = new BufferedReader(new FileReader(fileName))){
            String [] addressElements = new String[8];
            int index = 0;
            String currentLine;
            while ((currentLine = entry.readLine()) != null){
                String [] position = currentLine.split("\n");
                addressElements[index] = position[0];
                index++;
            }
            AddressEntry dataEntry = createAddressEntry(addressElements);
            if (!isContactExists(dataEntry.getName(), dataEntry.getLastName())){
                addressEntriesList.add(dataEntry);
                System.out.println("File: " + fileName + " load successfully");
            }
            else {
                System.out.println("Duplicate entry found in file " + fileName);
            }
        } catch (FileNotFoundException e){
            System.out.println("File: " + fileName + " not found");
        }
        catch (IOException e){
            System.out.println("Error reading file: " + fileName);
            e.printStackTrace();
        }
    }

    /**
     * Finds and prints address entries that contain the given last name.
     *
     * @param lastName the last name to search for in the address entries.
     */
    public void find(String lastName){
        ArrayList <AddressEntry> addressEntriesFound = new ArrayList<>();

        for (int i = 0; i< addressEntriesList.size(); i++){
            AddressEntry temporalEntry;
            temporalEntry = addressEntriesList.get(i);
            if (temporalEntry.getLastName().toLowerCase().contains(lastName.toLowerCase())){
                addressEntriesFound.add(temporalEntry);
            }
        }
        if (addressEntriesFound.isEmpty()) {
            System.out.println("No address entry found");
            return;
        }
        else {
            for (int i = 0; i < addressEntriesFound.size(); i++) {
                 System.out.println("Found address entry no.: " + (i + 1));
                 System.out.println(addressEntriesFound.get(i).toString());
            }
        }
    }

    /**
     * Displays all address entries in the address book.
     * If the address book is empty, it prints a message indicating that.
     * Otherwise, it sorts the entries by last name and prints each entry.
     */
    public void displayEntries(){
        if (addressEntriesList.isEmpty()){
            System.out.println("The directory is empty,please add a new record an try again");
        }
        else {
            Comparator <AddressEntry> comparator = Comparator.comparing(AddressEntry::getLastName);
            addressEntriesList.sort(comparator);
            for(AddressEntry temporalEntry : addressEntriesList){
                System.out.println(temporalEntry.toString());
            }
        }
    }

    /**
     * Checks if a contact with the given name and last name exists in the address entries list.
     * @param name The name of the contact to search for.
     * @param lastName The last name of the contact to search for.
     * @return {@code true} if a contact with the specified name and last name exists in the list, {@code false} otherwise.
     */
    public boolean isContactExists(String name, String lastName){
        for (AddressEntry dataEntry : addressEntriesList){
            if (dataEntry.getName().equalsIgnoreCase(name) &&
                    dataEntry.getLastName().equalsIgnoreCase(lastName)){
                return true;
            }
        }
        return false;
    }

}
