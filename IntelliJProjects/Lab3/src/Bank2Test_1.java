public class Bank2Test_1 {
    public static void main(String[] args) {
        //Tests the account number duplication
        Bank2 test = new Bank2();
        test.setBankName("Bargle");

        //Frank, 1234, 1, 3000.21
        test.openAccount();

        //Sally, 1234, 2, 250
        test.openAccount();

        //Charles, 5768, 1, 365.25
        test.openAccount();


        test.printAllAccounts();
    }
}
