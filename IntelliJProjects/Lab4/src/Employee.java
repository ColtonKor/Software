import java.util.ArrayList;
import java.util.Scanner;

public class Employee {
    private String myID;
    private String myName;

    public Employee(){}

    public Employee(String Name, String ID){
        myName = Name;
        myID = ID;
    }
    public void setID(String ID){
        myID = ID;
    }

    public void setName(String Name){
        myName = Name;
    }

    public String getName(){
        return myName;
    }

    public String getMyID(){
        return myID;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Employee) {
            Employee other = (Employee) obj;
            return ((this.myID.equals(other.myID)) &&
                    (this.myName.equals(other.myName)));
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return myID + " " + myName;
    }
}
