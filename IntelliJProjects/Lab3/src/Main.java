// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        char[] myArray = {'H', 'u', 'm', 'm', 'u', 's', '!'};
        char lastChar;

        try {
            lastChar = myArray[myArray.length];
            System.out.print("Processing data...");
            System.out.println(myArray[1]);
        } catch (Exception e) {
            System.out.println("That's an error!");
        }
    }
}