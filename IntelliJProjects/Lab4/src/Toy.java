public class Toy {

    private int number;

    private String name;



    public Toy(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        // checks if the passed object is of type Toy
        if (obj instanceof Toy) {
            // (casts the passed in object as Toy)
            Toy other = (Toy) obj;
            // compares the two Toy objects
            return ((this.number == other.number) &&
                    (this.name.equals(other.name)));
        } else {
            return false;
        }
    }

}