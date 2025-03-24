public class CheckingAccount extends Account{
    private double fee;

    public CheckingAccount(){}

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getFee() {
        return fee;
    }


    @Override
    public void setBalance(double balance) {
        super.setBalance(balance);
    }

    @Override
    public double getBalance() {
        return super.getBalance();
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
