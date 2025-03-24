public class SavingsAccount extends Account{
    private double rate;
    private double payment;

    public SavingsAccount(){

    }

    public void setPayment() {
        this.payment = (getBalance()*this.rate);
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getPayment() {
        return payment;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public void deposit(double amount) {
        setBalance(amount+getBalance());
    }

    @Override
    public void withdraw(double amount) {
        setBalance(getBalance() - amount);
    }
}
