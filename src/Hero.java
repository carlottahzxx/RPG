import java.util.ArrayList;

public abstract class Hero extends Combatant {

    private ArrayList<Consumable> consumables = new ArrayList<Consumable>();

    public ArrayList<Consumable> getConsumables() {
        return consumables;
    }
}