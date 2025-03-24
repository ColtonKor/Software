public class OgreAlien extends Alien{
    public int damage  = 6;
    public OgreAlien(int health, String name){
        super(health, name);
    }

    @Override
    public int getDamage() {
        return damage;
    }
}
