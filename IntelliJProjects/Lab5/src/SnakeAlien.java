public class SnakeAlien extends Alien{
    public int damage  = 10;
    public SnakeAlien(int health, String name){
        super(health, name);
    }

    @Override
    public int getDamage() {
        return damage;
    }
}
