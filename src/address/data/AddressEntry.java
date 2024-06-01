package address.data;

public class AddressEntry {
    private String name;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private int zip;
    private String email;
    private String phoneNumber;

    public AddressEntry(){

    }
    public AddressEntry(String name, String lastName, String street, String city, String state, int zip,
                        String email, String phoneNumber){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\n"+ "Last Name: " + getLastName() + "\n"+
                "Street: " + getStreet() + "\n"+ "City: " + getCity() + "\n"+
                "State: " + getState() + "\n"+ "Zip: " + getZip() + "\n"+
                "Email: " + getEmail() + "\n"+ "PhoneNumber: " + getPhoneNumber() + "\n";

    }

}
