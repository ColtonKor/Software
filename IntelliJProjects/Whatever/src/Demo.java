import java.util.ArrayList;
import java.util.Scanner;
public class Demo {
    public static void main(String[] args) {

        ArrayList<String> listOne = new ArrayList<>();
        ArrayList<String> listTwo;

        listOne.add("asafoetida");

        A aObj = new A(listOne);

        listTwo = aObj.getList();
        listTwo.add("galangal");

        System.out.println(listOne);
    }

}