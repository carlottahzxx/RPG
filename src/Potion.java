public class Potion extends Consumable {
    @Override
    public void use(Combatant c) {
        c.setMana(c.getMana() + this.heal);

    }
}
