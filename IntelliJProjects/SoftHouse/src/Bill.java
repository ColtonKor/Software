import java.util.Scanner;
public class Bill {
    private int Hours;
    private int Minutes;
    private double Rate = 150.00;
    private double Price;
    private int Coupon;



    public void inputTimeWorked(){
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter number of full hours worked\nfollowed by number of minutes:");
        Hours = kb.nextInt();
        Minutes = kb.nextInt();
        System.out.printf("%d hours and %d minutes\n",Hours, Minutes);
    }
    public void updateFee(){
        Scanner kb = new Scanner(System.in);
        System.out.printf("Rate: $%.2f per quarter hour\n", Rate);
        System.out.println("Enter a coupon number:");
        Coupon = kb.nextInt();
        if(Coupon == 1234){
            Rate = Rate-(Rate/10);
            System.out.println("Your coupon is valid. (10% discount)");
        } else {
            System.out.println("Your coupon is invalid");
        }
        Price = ((Rate*4)*Hours)+(Minutes/15)*Rate;
    }
    public void outputBill(){
        System.out.printf("Amount due: $%.2f\n", Price);
    }
}
