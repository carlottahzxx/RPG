public class Weapon extends Item {

        private int degats;

        public Weapon(String name, int degats){
            this.name = name;
            this.degats = degats;
    }
    public int getDegats(){return degats;}
}
