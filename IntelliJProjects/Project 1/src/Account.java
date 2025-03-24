//Account Class
//This class makes the actual account It holds the number, the type of the account, its balance
//The SSN number. Deposit and Withdraw change the balance in the account
//Colton Korhummel. September 29, 2023
public class Account {
    private int accNr;
    private int type;
    private double balance;
    private String SSN;
    public void setAccNr(int accNr) {
        this.accNr = accNr;
    }

    public int getAccNr() {
        return accNr;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getSSN() {
        return SSN;
    }

    public void Accdeposit(double money){
        balance += money;
    }
    public void Accwithdraw(double money){
        balance -= money;
    }
}
