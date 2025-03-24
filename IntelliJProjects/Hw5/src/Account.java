public class Account implements Depositable, Withdrawable, Balanceable{
    private double Balance;


    @Override
    public double getBalance() {
        return Balance;
    }

    @Override
    public void setBalance(double balance) {
        Balance = balance;
    }

    @Override
    public void deposit(double amount) {

    }

    @Override
    public void withdraw(double amount) {

    }
}
