public class Food extends Consumable {
    @Override
    public void use(Combatant c) {
        c.setHP(c.getHP() + this.heal);
    }

}
