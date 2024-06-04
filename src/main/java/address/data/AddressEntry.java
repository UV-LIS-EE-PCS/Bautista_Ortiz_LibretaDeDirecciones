package address.data;

/**
 * Represents an entry in an address book.
 */
public class AddressEntry {
    private String name;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private int zip;
    private String email;
    private String phoneNumber;

    /**
     * Constructs an empty AddressEntry.
     */
    public AddressEntry(){

    }

    /**
     * Constructs an AddressEntry with the specified details.
     * @param name The name of the person.
     * @param lastName The last name of the person.
     * @param street The street address.
     * @param city The city name.
     * @param state The state name.
     * @param zip The ZIP code.
     * @param email The email address.
     * @param phoneNumber The phone number.
     */
    public AddressEntry(String name, String lastName, String street, String city, String state, int zip,
                        String email, String phoneNumber){

    }

    /**
     * Returns the name of the person.
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the last name of the person.
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the person.
     * @param lastName The last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the street address.
     * @return The street address.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the street address.
     * @param street The street address to set.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Returns the city name.
     * @return The city name.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city name.
     * @param city The city name to set.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Returns the state name.
     * @return The state name.
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state name.
     * @param state The state name to set.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Returns the ZIP code.
     * @return The ZIP code.
     */
    public int getZip() {
        return zip;
    }

    /**
     * Sets the ZIP code.
     * @param zip The ZIP code to set.
     */
    public void setZip(int zip) {
        this.zip = zip;
    }

    /**
     * Returns the email address.
     * @return The email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address.
     * @param email The email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the phone number.
     * @return The phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number.
     * @param phoneNumber The phone number to set.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns a string representation of the AddressEntry.
     * @return A string representation containing the details of the AddressEntry.
     */
    @Override
    public String toString() {
        return "Name: " + getName() + "\n"+ "Last Name: " + getLastName() + "\n"+
                "Street: " + getStreet() + "\n"+ "City: " + getCity() + "\n"+
                "State: " + getState() + "\n"+ "Zip: " + getZip() + "\n"+
                "Email: " + getEmail() + "\n"+ "PhoneNumber: " + getPhoneNumber() + "\n";

    }

}
