/**
 * Title: Bank2Test_0.java
 * Abstract: This test case is designed to verify if the Bank2
 * class can handle only one account at openAccount()
 * and closeAccount().
 * Author: XXXX
 * ID: XXXX
 * Date: MM/DD/YY
 */

public class Bank2Test_0 {
    public static void main(String[] args) {
        Bank2 testBank = new Bank2();
        testBank.setBankName("CSUMB");

        // Input: Name: "Alice", Number: 1234,
        // Type: 1, Balance: 1000.50
        testBank.openAccount();

        // Output: The program should display the one account
        // information properly on the screen.
        testBank.printAllAccounts();

        // Output: The program should display "true" because
        // the bank has an account of 1234.
        System.out.println(testBank.closeAccount(1234));

        // Output: The program shouldn’t display anything
        // because there’s no account in the bank.
        testBank.printAllAccounts();
    }
}