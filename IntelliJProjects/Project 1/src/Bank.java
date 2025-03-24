//Bank Class
//This class simulates a bank. There is a bank name, The number of customers and accounts in this bank.
//There is an arrayList for every other class in this program. We read in data from a file which has the
//amount of customers and accounts. A function to print the info of the bank and a certain account. There are
//functions to deposit, withdraw, or close an account. There is also a function that prints out all
//transactions that are connected to an account. You can add new customers and account into the bank.
//You can remove a customer which in turns removes all his accounts. Finally, there is a function
//that can take the last 4 digits of a social security number and prints all accounts associated with the SSN
//Colton Korhummel. September 29, 2023
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Bank {
    private String bankName;
    private ArrayList<Customer> toDoList = new ArrayList<Customer>();
    private ArrayList<Transaction> AccountUpdates = new ArrayList<Transaction>();
    private ArrayList<Account> personalAcc = new ArrayList<Account>();
    private int Peoplenum;
    private int Accountnum;

    public Bank(String name){
        bankName = name;
    }
    public void readData(String filename){
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new FileInputStream(filename)).useDelimiter(",|\\r\\n");
        } catch (FileNotFoundException e) {
            System.out.println("File not found or could not be opened.");
            System.exit(0);
        }
        Peoplenum = inputStream.nextInt();
        inputStream.nextLine();
        for (int i = 0; i < Peoplenum; i++) {
            Customer listTemp = new Customer();
            listTemp.setName(inputStream.next());
            listTemp.setAddress(inputStream.next());
            listTemp.setZipCode(inputStream.nextInt());
            listTemp.setSSN(inputStream.next());
            toDoList.add(listTemp);
        }
        Accountnum = inputStream.nextInt();
        inputStream.nextLine();
        for (int i = 0; i < Accountnum; i++) {
            Account accountTemp = new Account();
            String SSN = inputStream.next();
            accountTemp.setSSN(SSN);
            int accNr = inputStream.nextInt();
            accountTemp.setAccNr(accNr);
            int type = inputStream.nextInt();
            accountTemp.setType(type);
            double balance = inputStream.nextDouble();
            accountTemp.setBalance(balance);
            for (int j = 0; j < Peoplenum; j++) {
                if(toDoList.get(j).getSSN().equals(SSN)){
                    if(type == 1){
                        if(toDoList.get(j).Check() == 0){
                            personalAcc.add(accountTemp);
                            toDoList.get(j).setChecking(1);
                        } else {
                            System.out.println("Already a Checking Account");
                        }
                    } else {
                        if(toDoList.get(j).Save() == 0){
                            personalAcc.add(accountTemp);
                            toDoList.get(j).setSaving(1);
                        } else {
                            System.out.println("Already a Saving Account");
                        }
                    }
                }
            }
        }
    }

    public void bankInfo() {
        System.out.printf("Bank Name: %s\n", bankName);
        System.out.printf("Number of Customers: %d\n", Peoplenum);
        for (int i = 0; i < Peoplenum; i++) {
            System.out.printf("  %s: %s\n", toDoList.get(i).getName(), toDoList.get(i).getSSN());
        }
        System.out.printf("Number of Accounts: %d\n", Accountnum);
        for (int i = 0; i < Accountnum; i++) {
            System.out.printf("  %s: $%.2f\n", personalAcc.get(i).getAccNr(), personalAcc.get(i).getBalance());
        }
        double sum = 0;
        for (int i = 0; i < Accountnum; i++) {
            sum += personalAcc.get(i).getBalance();
        }
        System.out.printf("Total Balance: $%.2f\n", sum);
    }

    public void accountInfo(int accountNr) {
        int index = 0;
        String SSN = "";
        for (int i = 0; i < Accountnum; i++) {
            if(accountNr == personalAcc.get(i).getAccNr()){
                index++;
                SSN = personalAcc.get(i).getSSN();
                System.out.printf(" -Number: %d\n", personalAcc.get(i).getAccNr());
                if(personalAcc.get(i).getType() == 1) {
                    System.out.println(" -Checking");
                } else if (personalAcc.get(i).getType() == 2){
                    System.out.println(" -Savings");
                }
                System.out.printf(" -Balance: $%.2f\n", personalAcc.get(i).getBalance());
            }
        }
        for (int i = 0; i < Peoplenum; i++) {
            if(SSN.equals(toDoList.get(i).getSSN())){
                System.out.printf(" -Name: %s\n", toDoList.get(i).getName());
            }
        }
        if(index == 0) {
            System.out.printf("Account (%d) does not exist.\n", accountNr);
        }
    }

    public void deposit(int Number, double money) {
        for (int i = 0; i < Accountnum; i++) {
            if(Number == personalAcc.get(i).getAccNr()){
                Transaction temporary = new Transaction();
                temporary.setDeposit(money);
                temporary.setAccNumber(Number);
                temporary.setTime();
                temporary.setAccTr("Deposit");
                AccountUpdates.add(temporary);
                personalAcc.get(i).Accdeposit(money);
                return;
            }
        }
    }

    public void withdraw(int Number, double money) {
        for (int i = 0; i < Accountnum; i++) {
            if(Number == personalAcc.get(i).getAccNr()){
                Transaction temporary = new Transaction();
                temporary.setWithdraw(money);
                temporary.setAccNumber(Number);
                temporary.setTime();
                temporary.setAccTr("Withdraw");
                AccountUpdates.add(temporary);
                personalAcc.get(i).Accwithdraw(money);
                return;
            }
        }
    }

    public boolean closeAccount(int Number) {
        for (int i = 0; i < Accountnum; i++) {
            if(Number == personalAcc.get(i).getAccNr()){
                Transaction temporary = new Transaction();
                temporary.setTime();
                temporary.setAccNumber(Number);
                temporary.setAccTr("Account Closed");
                temporary.setAccNumber(Number);
                AccountUpdates.add(temporary);
                personalAcc.remove(i);
                Accountnum--;
                return true;
            }
        }
        return false;
    }

    public void transaction(int number) {
        int index = 0;
        for (int i = 0; i < AccountUpdates.size(); i++) {
            if(number == AccountUpdates.get(i).getAccNumber()){
                index++;
                System.out.printf("  -Account Number: %s, ", AccountUpdates.get(i).getAccNumber());
                System.out.printf("%s", AccountUpdates.get(i).getAccTr());
                if(AccountUpdates.get(i).getAccTr().equals("Account Closed")){
                    System.out.print(", ");
                } else {
                    if(AccountUpdates.get(i).getAccTr().equals("Deposit")){
                            System.out.printf(" ($%.2f), ", AccountUpdates.get(i).getDeposit());
                    }
                    if (AccountUpdates.get(i).getAccTr().equals("Withdraw")) {
                        System.out.printf(" ($%.2f), ", AccountUpdates.get(i).getWithdraw());
                    }
                }
                System.out.printf("%s\n", AccountUpdates.get(i).getTime());
            }
        }
        if(index == 0){
            System.out.printf("No transaction for account %d", number);
        }
    }

    public void newCustomer(String Name, String Address, int ZipCode, String SSN) {
        Customer temp = new Customer();
        temp.setName(Name);
        temp.setAddress(Address);
        temp.setZipCode(ZipCode);
        temp.setSSN(SSN);
        for (int i = 0; i < Peoplenum; i++) {
            if(temp.getSSN().equals(toDoList.get(i).getSSN())){
                System.out.printf("%s is not added - Existing customer with matching SSN in system.\n", temp.getName());
                return;
            }
        }
        System.out.printf("%s is added\n", temp.getName());
        toDoList.add(temp);
        Peoplenum++;
    }

    public void newAccount(String SSN, int Number, int Type, double Balance) {
        int test = 0;
        for (int i = 0; i < Accountnum; i++) {
            if(Number == personalAcc.get(i).getAccNr()){
                System.out.printf("Account creation failed - Account %d already exists\n", Number);
                return;
            }
        }
        for (int i = 0; i < Peoplenum; i++) {
            if(SSN.equals(toDoList.get(i).getSSN())){
                test++;
            }
        }
        if(test == 0){
            System.out.printf("Account creation failed - No Customers with %s SSN\n", SSN);
            return;
        }
        for (int i = 0; i < Peoplenum; i++) {
            if(SSN.equals(toDoList.get(i).getSSN())){
                if(Type == 1){
                    if(toDoList.get(i).Check() == 1){
                        System.out.println("Account creation failed - This Customer already has a Checking Account");
                        return;
                    }
                } else {
                    if(toDoList.get(i).Save() == 1){
                        System.out.println("Account creation failed - This Customer already has a Saving Account");
                        return;
                    }
                }
            }
        }
        for (int i = 0; i < Peoplenum; i++) {
            if(SSN.equals(toDoList.get(i).getSSN())){
                System.out.printf("Account creation - Number: %d, Customer: %s\n", Number, toDoList.get(i).getName());
            }
        }
        for (int i = 0; i < Peoplenum; i++) {
            if(SSN.equals(toDoList.get(i).getSSN())){
                if(Type == 1){
                    toDoList.get(i).setChecking(1);
                } else {
                    toDoList.get(i).setSaving(1);
                }
            }
        }

        Account temp = new Account();
        temp.setSSN(SSN);
        temp.setAccNr(Number);
        temp.setType(Type);
        temp.setBalance(Balance);
        personalAcc.add(temp);
        Accountnum++;
    }

    public void removeCustomer(String SSN) {
        for (int i = 0; i < Accountnum; i++) {
            if(SSN.equals(personalAcc.get(i).getSSN())){
                System.out.printf("Account removed - Number: %d $%.2f\n", personalAcc.get(i).getAccNr(), personalAcc.get(i).getBalance());
                closeAccount(personalAcc.get(i).getAccNr());
            }
            if(i == 1){
                if(SSN.equals(personalAcc.get(i-1).getSSN())){
                    System.out.printf("Account removed - Number: %d $%.2f\n", personalAcc.get(i-1).getAccNr(), personalAcc.get(i-1).getBalance());
                    closeAccount(personalAcc.get(i-1).getAccNr());
                }
            }
        }
        for (int i = 0; i < Peoplenum; i++) {
            if(SSN.equals(toDoList.get(i).getSSN())){
                System.out.printf("Customer removed - SSN: %s. Customer: %s\n", toDoList.get(i).getSSN(), toDoList.get(i).getName());
                toDoList.remove(i);
                Peoplenum--;
                return;
            }
        }

        System.out.println("Customer remove failed. SSN does not exist.");
    }

    public void customerInfoWithSSN(int SSN) {
        int index = 0;
        for (int i = 0; i < Peoplenum; i++) {
            if(Integer.parseInt(toDoList.get(i).getSSN().substring(7, 11)) == SSN){
                System.out.printf("Name: %s\n", toDoList.get(i).getName());
                System.out.println(toDoList.get(i).getAddress());
                System.out.printf("SSN: %s\n", toDoList.get(i).getSSN());
                index++;
                for (int j = 0; j < Accountnum; j++) {
                    if(Integer.parseInt(personalAcc.get(j).getSSN().substring(7, 11)) == SSN && personalAcc.get(j).getSSN().equals(toDoList.get(i).getSSN())){
                        if(personalAcc.get(j).getType() == 1){
                            System.out.printf("Checking (%d), $%.2f\n\n", personalAcc.get(j).getAccNr(), personalAcc.get(j).getBalance());
                        } else {
                            System.out.printf("Saving (%d), $%.2f\n\n", personalAcc.get(j).getAccNr(), personalAcc.get(j).getBalance());
                        }
                    }
                }
            }
        }
        if(index == 0){
            System.out.printf("No customer with %d\n", SSN);
        }
    }
}
