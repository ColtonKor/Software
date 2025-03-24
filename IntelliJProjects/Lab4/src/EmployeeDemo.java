import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeDemo {
    public static void main(String[] args) {
        ArrayList<Employee> toDoList = new ArrayList<Employee>(20);
        boolean done = false;
        String answer;
        Scanner keyboard = new Scanner(System.in);
        while (! done) {
            Employee input = new Employee();
            System.out.print("Input an ID number: ");
            input.setID(keyboard.nextLine());
            System.out.print("Input a name: ");
            input.setName(keyboard.nextLine());
            toDoList.add(input);
            System.out.print("More People? (y/n) ");
            answer = keyboard.nextLine();
            if (!(answer.equalsIgnoreCase("y"))) {
                done = true;
            }
        }
        System.out.println("The employee list contains:");
        for (Employee entry : toDoList) {
            System.out.println(entry);
        }
        while(done){
            Employee search = new Employee();
            System.out.println("Type the employee ID number and name to search");
            System.out.print("ID number: ");
            search.setID(keyboard.nextLine());
            System.out.print("Name: ");
            search.setName(keyboard.nextLine());
            if(toDoList.contains(search)){
                System.out.printf("%s is an employee.\n", search);
            } else {
                System.out.printf("%s is not an employee.\n", search);
            }
            System.out.print("Another search? (y/n)");
            answer = keyboard.nextLine();
            if(!(answer.equalsIgnoreCase("y"))){
                done = false;
            }
        }
        while(!done){
            Employee fire = new Employee();
            System.out.println("Type the employee ID number and name to fire");
            System.out.print("ID number: ");
            fire.setID(keyboard.nextLine());
            System.out.print("Name: ");
            fire.setName(keyboard.nextLine());
            if (toDoList.remove(fire)) {
                System.out.printf("%s has been fired. (Bye!)%n", fire);
            } else {
                System.out.printf("%s was not an Employee.%n", fire);
            }
            System.out.println("The employee list contains:");
            for (Employee entry : toDoList) {
                System.out.println(entry);
            }
            System.out.print("Fire another? (y/n) ");
            answer = keyboard.nextLine();
            if(!(answer.equalsIgnoreCase("y"))){
                done = true;
            }
        }
    }
}
