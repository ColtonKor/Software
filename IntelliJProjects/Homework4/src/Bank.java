//Bank Class
//This class opens accounts in a bank. It won't go over 5 accounts. It connects to Account.java
//which will connect to Customer.java It will print bank details, account details.
//You can also delete accounts from the bank. Can update the values for all of the variables for the
//Colton Korhummel. September 22, 2023

public class Bank {
    private String bankName;
    private Account[] accounts = new Account[5];
    private int numAccounts;


    //overrides the current number of accounts and sets a new one
    public void setNumAccounts(int number){
        numAccounts = number;
    }
    //overrides the current Bank name and sets a new one
    public void setBankName(String Name){
        bankName = Name;
    }
    //returns number of accounts to main test
    public int getNumAccounts(){
        return numAccounts;
    }
    //returns bank name to main test
    public String getBankName(){
        return bankName;
    }

    //overrides bankName and replaces it
    public Bank(String bankName){
        this.bankName = bankName;
    }

    //This takes in details for a new account. Their name, address, SSN, account Number, Account Type, and Balance
    //It checks if the amount of accounts is 5 which is max; Then checks if ssn or account number are already in use
    //if all is good it will add the balance number, type, ssn, name, address into this account.
    // Then increments number of accounts
    public boolean openAcc(String custName, String addr, int ssn, int accNr, int accType, double balance){
        if(numAccounts == 5){
            return false;
        }
        accounts[numAccounts] = new Account();
        for (int i = 0; i < numAccounts; i++) {
            if(accNr == accounts[i].getAccNr()){
                return false;
            }
            if(ssn == accounts[i].findSsn()){
                return false;
            }
        }
        accounts[numAccounts].setBalance(balance);
        accounts[numAccounts].setAccNr(accNr);
        accounts[numAccounts].setAccType(accType);
        accounts[numAccounts].passAddr(addr);
        accounts[numAccounts].passSsn(ssn);
        accounts[numAccounts].passCustName(custName);
        numAccounts++;
        return true;
    }
    //It searches through all of the accounts to find the number if there is none it returns false
    //If the number is there it will remove that account from this bank
    public boolean closeAcc(int accNr){
        for (int i = 0; i < numAccounts; i++) {
            if(accNr == accounts[i].getAccNr()){
                for (int j = i; j < numAccounts; j++) {
                    accounts[j] = accounts[j+1];
                }
                numAccounts--;
                return true;
            }
        }
        return false;
    }
    //This will search for the account number and if it finds it it will return the balance of that account
    public double getAccBal(int accNr){
        for (int i = 0; i < numAccounts; i++) {
            if(accounts[i].getAccNr() == accNr){
                return accounts[i].getBalance();
            }
        }
        return 0;
    }
    //This will go through all of the accounts and add all of the balances and return it
    public double sumAccBals(){
        double sum = 0;
        for (int i = 0; i < numAccounts; i++) {
            sum += accounts[i].getBalance();
        }
        return sum;
    }
    //It will search through the accounts to find a number and if it finds it, it will return the address
    public String getAccAddr(int accNr){
        for (int i = 0; i < numAccounts; i++) {
            if(accNr == accounts[i].getAccNr()){
                return accounts[i].findaddr();
            }
        }
        return "Not there!";
    }
    //This will search through accounts and if it finds the number it will replace the balance
    public void updateBal(int acctNr, double amount){
        for (int i = 0; i < numAccounts; i++) {
            if(accounts[i].getAccNr() == acctNr){
                accounts[i].setBalance(amount);
            }
        }
    }

    public void updateAddr(int acctNr, String Addr){
        for (int i = 0; i < numAccounts; i++) {
            if(accounts[i].getAccNr() == acctNr){
                accounts[i].passAddr(Addr);
            }
        }
    }
    //This prints all of the info of the account Name, Address, SSN Account number, type, balance,
    public boolean accInfo(int accNr){
        for (int i = 0; i < numAccounts; i++) {
            if(accNr == accounts[i].getAccNr()){
                System.out.printf("Account Number: %d\n", accNr);
                if(accounts[i].getAccType() == 1){
                    System.out.println("Checking account");
                } else if (accounts[i].getAccType() == 2){
                    System.out.println("Savings account");
                }
                System.out.printf("Balance: %.2f\n\n", accounts[i].getBalance());
                System.out.printf("Customer: %s\n", accounts[i].findcustName());
                System.out.println(accounts[i].findaddr());
                System.out.printf("SSN: %d\n\n", accounts[i].findSsn());
                return true;
            }
        }
        return false;
    }
    //this prints the details of the whole bank, Account number, balance, name, SSN of all accounts
    public void bankInfo(){
        System.out.printf("Bank Name: %s\n", bankName);
        System.out.printf("Number of Accounts: %d\n", numAccounts);
        double sum = 0;
        for (int i = 0; i < numAccounts; i++) {
            sum += accounts[i].getBalance();
            System.out.printf("  %d: $%.2f ", accounts[i].getAccNr(), accounts[i].getBalance());
            System.out.printf("- %s: %d\n", accounts[i].findcustName(), accounts[i].findSsn());
        }
        System.out.printf("Bank Total Balance: $%.2f\n", sum);
    }
}
