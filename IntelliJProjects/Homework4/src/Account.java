//Account Class
//This program has account numbers, types, balances, and the personal information
//of the customer. It uses getters and setters along with find functions
//which search into customer class to return to the bank class
//Colton Korhummel. September 22, 2023

public class Account {
    private int accNr;
    private int accType;
    private Customer accHolder = new Customer();
    private double balance;

    //returns the Account number to Bank.java
    public int getAccNr(){
        return accNr;
    }
    //returns the Account Type to Bank.java
    public int getAccType(){
        return accType;
    }
    //returns the Account Balance to Bank.java
    public double getBalance(){
        return balance;
    }
    //overrides the current Account number and sets a new one
    public void setAccNr(int accNr){
        this.accNr = accNr;
    }
    //overrides the current Account Type and sets a new one
    public void setAccType(int accType){
        this.accType = accType;
    }
    //overrides the current Account Balance and sets a new one
    public void setBalance(double balance){
        this.balance = balance;
    }
    //Searches for the SSN from the Customer.java then sends it Bank.java
    public int findSsn(){
        return accHolder.getSsn();
    }
    //Searches for the Customer name from the Customer.java then sends it Bank.java
    public String findcustName(){
        return accHolder.getCustName();
    }
    //Searches for the Address from the Customer.java then sends it Bank.java
    public String findaddr(){
        return accHolder.getAddr();
    }
    //takes address from bank than pushes it into the customer class
    public void passAddr(String addr){
        accHolder.setAddr(addr);
    }
    //takes SSN from bank than pushes it into the customer class
    public void passSsn(int ssn){
        accHolder.setSsn(ssn);
    }
    //takes Customer Name from bank than pushes it into the customer class
    public void passCustName(String custName){
        accHolder.setCustName(custName);
    }
}
