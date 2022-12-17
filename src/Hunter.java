public class Hunter extends Hero {
    int nb_Fleche;

    public Hunter(String name){
        this.name = name;
        this.HP = 15;
        this.armor = 2;
        this.nb_Fleche = 30;
        this.weapon = new Weapon("flèche de la mort",5);
        this.getConsumables().add(new Food());
        this.getConsumables().add(new Potion());

    }


    @Override
    public void attack(Combatant cible, Game game) {
        cible.setHP(cible.getHP()-this.weapon.getDegats());
        if(cible.getHP()<=0){
            game.getTeamenemy().remove(cible);
            game.getOrdreTour().remove(cible);
        }

    }
}