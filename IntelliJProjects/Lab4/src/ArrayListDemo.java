import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo {
    public static void main(String[] args) {

        ArrayList<String> toDoList = new ArrayList<String>(20);
        System.out.println("Enter list entries, when prompted.");
        boolean done = false;
        String next = null;
        String answer;
        Scanner keyboard = new Scanner(System.in);
        while (! done) {
            System.out.print("Input an entry: ");
            next = keyboard.nextLine();
            toDoList.add(next);
            System.out.print("More items? (y/n) ");
            answer = keyboard.nextLine();
            if (!(answer.equalsIgnoreCase("y"))) {
                done = true;
            }
        }
        System.out.println("The list contains:");
        for (String entry : toDoList) {
            System.out.println(entry);
        }
        String search;
        System.out.print("An item to search: ");
        search = keyboard.nextLine();
        if(toDoList.contains(search)){
            System.out.printf("%s is in the list", search);
        } else {
            System.out.printf("%s is not in the list.\n", search);
        }
        System.out.print("An item to remove: ");
        search = keyboard.nextLine();
        if (toDoList.remove(search)) {
            System.out.printf("%s is removed from the list.%n", search);
        } else {
            System.out.printf("%s was not in the list.%n", search);
        }
        System.out.println("The list contains:");
        for (String entry : toDoList) {
            System.out.println(entry);
        }

    }
}