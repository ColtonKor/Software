//Transaction Class
//This class is the transactions a customer does on his account. It tracks withdraws,
//deposits, and if the account was closed. It also measures the time each was done
//Colton Korhummel. September 29, 2023
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Transaction {
    private String Time;
    private String AccTr;
    private int AccNumber;
    private double deposit;
    private double withdraw;

    //This function sets the current time that it is called
    public void setTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm:ss");
        Time = now.format(formatter);
    }

    public String getTime() {
        return Time;
    }

    public void setAccTr(String accTr) {
        AccTr = accTr;
    }

    public String getAccTr() {
        return AccTr;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public void setWithdraw(double withdraw) {
        this.withdraw = withdraw;
    }

    public double getDeposit() {
        return deposit;
    }

    public double getWithdraw() {
        return withdraw;
    }

    public void setAccNumber(int accNumber) {
        AccNumber = accNumber;
    }

    public int getAccNumber() {
        return AccNumber;
    }
}
