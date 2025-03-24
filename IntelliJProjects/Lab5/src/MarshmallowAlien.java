public class MarshmallowAlien extends Alien{
    public int damage  = 1;
    public MarshmallowAlien(int health, String name){
        super(health, name);
    }

    @Override
    public int getDamage() {
        return damage;
    }
}
