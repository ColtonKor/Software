import java.util.Scanner;
public class AccountApp{
    public static void main(String[] args) {
        CheckingAccount Go = new CheckingAccount();
        SavingsAccount Follow = new SavingsAccount();
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter the initial Checking amount: ");
        Go.setBalance(kb.nextDouble());
        System.out.print("Enter initial Savings amount: ");
        Follow.setBalance(kb.nextDouble());
        System.out.print("Enter Checking fee: ");
        Go.setFee(kb.nextDouble());
        System.out.print("Enter Savings interest rate: ");
        Follow.setRate(kb.nextDouble());
        System.out.println("\nOK! This is your information");
        System.out.printf("Checking Amount: $%.2f\n", Go.getBalance());
        System.out.printf("Savings Amount: $%.2f\n", Follow.getBalance());
        System.out.printf("Checking Fee: $%.2f\n", Go.getFee());
        System.out.printf("Interest Rate: %.1f%%\n", Follow.getRate()*100);
        System.out.println("\nEnter transactions for the month.\n");
        String loop = "y";
        String type;
        String Acc;
        double update;
        int index = 0;
        int Saver = 0;
        while(loop.equals("y")){
            System.out.print("Withdrawal or deposit? (w/d): ");
            type = kb.next();
            System.out.print("Checking or Savings? (c/s): ");
            Acc = kb.next();
            System.out.print("Amount? $");
            update = kb.nextDouble();
            if(Acc.equals("c")){
                index++;
                if(type.equals("w")){
                    Go.withdraw(update);
                } else if(type.equals("d")){
                    Go.deposit(update);
                }
            } else if(Acc.equals("s")){
                Saver++;
                if(type.equals("w")){
                    Follow.withdraw(update);
                    Follow.setPayment();
                } else if(type.equals("d")){
                    Follow.deposit(update);
                    Follow.setPayment();
                }
            }
            System.out.print("\nContinue? (y/n): ");
            loop = kb.next();
            System.out.println();
        }
        if(Saver == 0){
            Follow.setPayment();
        }
        Follow.setBalance(Follow.getBalance() + Follow.getPayment());
        Go.setFee(Go.getFee()*index);
        Go.setBalance(Go.getBalance()- Go.getFee());
        System.out.println("Monthly Payments and Fees");
        System.out.printf("Checking fee: $%.2f\n", Go.getFee());
        System.out.printf("Savings interest payment: $%.2f\n", Follow.getPayment());
        System.out.println("\nFinal Balances");
        System.out.printf("Checking: $%.2f\n", Go.getBalance());
        System.out.printf("Savings: $%.2f", Follow.getBalance());
    }
}