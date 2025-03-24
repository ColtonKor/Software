//Customer Class
//This class has the information of the customer. Their name, address, Zipcode, and checking and saving ints
//which tell you if the customer already has a checking or a saving account.
//Colton Korhummel. September 29, 2023

public class Customer {
    private String Name;
    private String Address;
    private int ZipCode;
    private String SSN;
    private int checking = 0;
    private int saving = 0;
    public int Check(){
       return checking;
    }
    public void setChecking(int checking) {
        this.checking = checking;
    }
    public int Save(){
        return saving;
    }
    public void setSaving(int saving) {
        this.saving = saving;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public String getAddress() {
        return Address;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getName() {
        return Name;
    }
    public void setSSN(String SSN) {
        this.SSN = SSN;
    }
    public String getSSN() {
        return SSN;
    }
    public void setZipCode(int zipCode) {
        ZipCode = zipCode;
    }
    public int getZipCode() {
        return ZipCode;
    }
}
