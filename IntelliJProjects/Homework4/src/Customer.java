//Customer class
//This program is just basic setters and getters to help the other classes for more information on a
//bank account with the Name, SSN, Address it feeds into the Account class
//Colton Korhummel. September 22, 2023

public class Customer {
    private String custName;
    private int ssn;
    private String addr;

    //returns the customer name to Account.java
    public String getCustName(){
        return custName;
    }
    //returns the customer SSN to Account.java
    public int getSsn(){
        return ssn;
    }
    //returns the Address name to Account.java
    public String getAddr(){
        return addr;
    }
    //overrides the current customer name and sets a new one
    public void setCustName(String custName){
        this.custName = custName;
    }
    //overrides the current customer SSN and sets a new one
    public void setSsn(int ssn){
        this.ssn = ssn;
    }
    //overrides the current customer Addr and sets a new one
    public void setAddr(String addr){
        this.addr = addr;
    }
}
