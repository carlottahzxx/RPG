public class Enemy extends Combatant {
    public Enemy(String name, int HP){
        this.name = name;
        this.HP = HP;
        this.armor = 3;
        this.weapon = new Weapon("Epée", 5);
    }

    @Override
    public void attack(Combatant cible, Game game) {
        cible.setHP(cible.getHP()-this.weapon.getDegats());
        if(cible.getHP()<=0){
            game.getTeamhero().remove(cible);
            game.getOrdreTour().remove(cible);
            game.setHeronumber(game.getHeronumber()-1);
        }
    }
}