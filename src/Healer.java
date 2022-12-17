public class Healer extends SpellCaster {

    public Healer(String name){
        this.name = name;


        this.HP = 10;
        this.armor = 1;
        this.mana = 20;
        this.manaspent = 3;
        this.weapon = new Weapon("rayon guérisseur", 3);
        this.getConsumables().add(new Food());
        this.getConsumables().add(new Potion());

    }

    @Override
    public void attack(Combatant cible, Game game) {
        cible.setHP(cible.getHP()+this.weapon.getDegats());
    }
}