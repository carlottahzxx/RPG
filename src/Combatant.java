abstract public class Combatant {
    protected String name;
    protected int HP;
    protected String Description;
    protected int armor;

    private int mana = 20;

    protected Weapon weapon;

    public int getHP() {
        return HP;
    }

    public abstract void attack(Combatant cible,Game game);

    public String getName() {
        return name;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public Weapon getWeapon() {
        return weapon;
    }
}