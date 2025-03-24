import java.util.ArrayList;
import java.util.Scanner;

public class ToyDemo {
    public static void main(String[] args) {
        ArrayList<Toy> list = new ArrayList<Toy>();

        Toy tom100 = new Toy(100, "Tom");
        Toy tom200 = new Toy(200, "Tom");

        list.add(tom100);
        list.add(tom200);

        Toy tom100_2 = new Toy(100, "Tom");
        if (list.contains(tom100_2)){
            System.out.println("Found");
        } else {
            System.out.println("Not found");
        }

    }
}
