import java.util.Scanner;

public class Bank2 {
    private Account2[] accounts = new Account2[3];
    private String bankName;
    private int numOfAccounts = 0;



    public Bank2(){}

    public void setBankName(String test){
        bankName = test;
    }
    public boolean openAccount(){
        Scanner kb = new Scanner(System.in);
        if(numOfAccounts == 3){
            System.out.println("Bank is full!");
            return false;
        }
        accounts[numOfAccounts] = new Account2();
        System.out.print("Enter an Account Name: ");
        accounts[numOfAccounts].setName(kb.nextLine());
        System.out.print("Enter an Account Number: ");
        accounts[numOfAccounts].setNumber(kb.nextInt());
        System.out.print("Enter an Account Type: ");
        accounts[numOfAccounts].setType(kb.nextInt());
        System.out.print("Enter an Account Balance: ");
        accounts[numOfAccounts].setBalance(kb.nextDouble());
        for (int i = 0; i <numOfAccounts ; i++) {
            if(accounts[i].getNumber() == accounts[numOfAccounts].getNumber()){
                return false;
            }
        }
        numOfAccounts++;
        return true;
    }

    public boolean closeAccount(int close){
        for (int i = 0; i < numOfAccounts; i++) {
            if(accounts[i].getNumber() == close){
                accounts[i] = null;
                return true;
            }
        }
        return false;
    }

    public void printAllAccounts(){
        int temp = 0;
        for (int i = 0; i < 3; i++) {
            if(accounts[i] != null){
                System.out.println("Account: " + bankName + "\n" + accounts[i]);
            } else {
                temp++;
            }
        }
        if(temp == 3){
            System.out.println("Bank Is Empty!");
        }
    }
}
