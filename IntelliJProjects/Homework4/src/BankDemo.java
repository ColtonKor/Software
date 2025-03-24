public class BankDemo {
    public static void main(String[] args) {
        Bank csumbBank = new Bank("CSUMB");
        System.out.println("\n========== Three New Accounts ==========");
        csumbBank.openAcc("Tom Smith", "123 University Center 93955",
                77777, 1000, 1, 10.0);
        csumbBank.openAcc("Alice Smith", "123 University Center 93955",
                88888, 2000, 1, 50.25);
        csumbBank.openAcc("Joe Otter", "2440 Ocean Avenue 93900",
                99999, 3000, 2, 100.25);
        System.out.println("\n========== Bank Info ==========");
        csumbBank.bankInfo();
        System.out.println("\n========== Close Account ==========");
        System.out.println(csumbBank.closeAcc(1000));
        System.out.println(csumbBank.closeAcc(7000));
        System.out.println("\n========== Account Info ==========");
        csumbBank.accInfo(2000);
        System.out.println(csumbBank.accInfo(7000));
    }
}