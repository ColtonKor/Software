public class Bank2Test_2 {
    public static void main(String[] args) {
        //Tests the full bank account
        Bank2 test = new Bank2();
        test.setBankName("Glank");

        //Barth, 3672, 1, 3000.21
        test.openAccount();

        //Iris, 1234, 2, 250
        test.openAccount();

        //Gnart, 5768, 1, 365.25
        test.openAccount();

        //Trane, 2438, 1, 2342.2
        test.openAccount();

        //
        test.printAllAccounts();
    }
}
