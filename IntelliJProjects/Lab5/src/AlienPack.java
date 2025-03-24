import java.util.ArrayList;

public class AlienPack {
    private ArrayList<Alien> toDoList = new ArrayList<Alien>();

    public AlienPack (int numAliens) {}

    public void addAlien(Alien newAlien) {
        toDoList.add(newAlien);
    }

    public int calculateDamage() {
        int damage = 0;
        for (int i=0; i < toDoList.size(); i++) {
            damage += toDoList.get(i).getDamage();
        }
        return damage;
    }
}