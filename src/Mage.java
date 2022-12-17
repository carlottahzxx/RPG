public class Mage extends SpellCaster {

    public Mage(String name) {

        this.name = name;
        this.HP = 10;
        this.armor = 1;
        this.mana = 20;
        this.manaspent = 3;
        this.weapon = new Weapon("Sceptre",5);
        this.getConsumables().add(new Food());
        this.getConsumables().add(new Potion());
    }

    @Override
    public void attack(Combatant cible,  Game game) {
        if(this.getMana()>=this.manaspent){
            cible.setHP(cible.getHP()-this.weapon.getDegats());
            if(cible.getHP()<=0){
                game.getTeamenemy().remove(cible);
            }
            cible.setMana(cible.getMana()-this.manaspent);
            game.getOrdreTour().remove(cible);
        }

    }
}