package address.data;

import java.io.*;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;

public class AddressBook {
    Scanner input = new Scanner(System.in);

    //Singleton pattern and declaration of the array list
    private static AddressBook instance = null;
    ArrayList <AddressEntry> addressEntriesList;

    //Array List initialization
    private AddressBook(){
        addressEntriesList = new ArrayList<>();
    }

    //Method to return the single instance
    public static AddressBook getInstance(){
        if(instance == null){
            instance = new AddressBook();
        }
        return instance;
    }




    //Method for add new records through user data insertion
    public void add () {
        AddressEntry dataEntry = new AddressEntry();
        System.out.println("Name");
        dataEntry.setName(input.nextLine());
        System.out.println("Last Name");
        dataEntry.setLastName(input.nextLine());
        System.out.println("Street");
        dataEntry.setStreet(input.nextLine());
        System.out.println("City");
        dataEntry.setCity(input.nextLine());
        System.out.println("State");
        dataEntry.setState(input.nextLine());
        System.out.println("Zip");
        dataEntry.setZip(input.nextInt());
        input.nextLine();
        System.out.println("Email");
        dataEntry.setEmail(input.nextLine());
        System.out.println("Phone Number");
        dataEntry.setPhoneNumber(input.nextInt());
        input.nextLine();
        addressEntriesList.add(dataEntry);
    }

    //Method to remove records from the directory
    public void remove(String lastName){
        addressEntriesList.removeIf(entry -> entry.getLastName().equals(lastName));
        System.out.println(lastName + "Removed successfully");
    }

    //Method to saving an entry to a file
    public void saveToFile(AddressEntry dataEntry ){
        try (FileWriter file = new FileWriter(dataEntry.getLastName() + "_"
        + dataEntry.getName() + ".txt")){
            file.write(dataEntry.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Method to create and return an instance from a String array
    private AddressEntry createAddressEntry(String [] addressElements){
        AddressEntry dataEntry = new AddressEntry();
        dataEntry.setName(addressElements[0]);
        dataEntry.setLastName(addressElements[1]);
        dataEntry.setStreet(addressElements[2]);
        dataEntry.setCity(addressElements[3]);
        dataEntry.setState(addressElements[4]);
        dataEntry.setZip(Integer.parseInt(addressElements[5]));
        dataEntry.setEmail(addressElements[6]);
        dataEntry.setPhoneNumber(Integer.parseInt(addressElements[7]));
        return dataEntry;
    }

    //Method to  read an entry from a file
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
            addressEntriesList.add(dataEntry);
            System.out.println("File: " + fileName + "load successfully");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //Method to search for a record in the directory by the last name
    public void find(String lastName){
        ArrayList <AddressEntry> addressEntriesFound = new ArrayList<>();

        for (int i = 0; i< addressEntriesList.size(); i++){
            AddressEntry temporalEntry = addressEntriesList.get(i);
            if (temporalEntry.getName().toUpperCase().contains(lastName.toUpperCase())){
                System.out.println(addressEntriesList.toString());
                addressEntriesFound.add(temporalEntry);
            }
        }
        if (addressEntriesFound.isEmpty()) {
            System.out.println("No address entry found");
        }
        else {
            for (int i = 0; i < addressEntriesFound.size(); i++){
                System.out.println(addressEntriesFound.get(i).toString());
            }
        }
    }

    //Method to display all entries contained in the ArrayList
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






}
