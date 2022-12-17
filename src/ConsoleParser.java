import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleParser implements InputParser{

    private Scanner sc = new Scanner(System.in);
    private Game game;

    public ConsoleParser(Game game){
        this.game = game;
    }

    @Override
    public void KOKOText(String string) {
        System.out.println(string);
    }

    @Override
    public int getInt() {
        int input = 0;
        while (input==0){
            String str = this.sc.nextLine();
            try {
                input = Integer.parseInt(str);
            }catch (Exception e){
                System.out.println("Veuillez entrer un entier");
            }

        }
        return input;

    }

    @Override
    public int getIntRange(int start, int end){
        int input;
        input = getInt();
        while(input<start || input>end){
            System.out.println("entrez une valeur entre "+start+" et "+end);
            input = getInt();
        }
        return input;
    }

    @Override
    public void asknombrehero(){
        System.out.println("Combien voulez vous de heros dans votre equipe ?");
        int nombreHero = getIntRange(1,10);
        this.game.setHeronumber(nombreHero);
        asktypehero(1);


    }

    @Override
    public void askAction() {
        System.out.println("Voulez vous attaquer ou prendre un objet ?");
        System.out.println("(1) Attaque");
        System.out.println("(2) Objets");
        int input = getIntRange(1,2);
        if(input==1){
            this.chosecible();
        }else {
            this.choseobject();
        }
    }

    @Override
    public void chosecible() {
        ArrayList<Combatant> list = new ArrayList<Combatant>();
        if(this.game.getActualcombatant() instanceof Healer){
            for(Hero hero : this.game.getTeamhero()){
                list.add(hero);
            }
        }else{
            for(Enemy ennemy : this.game.getTeamenemy()) {
                list.add(ennemy);
            }
        }
        for(int i = 0; i<list.size();i++){
            Combatant c = list.get(i);
            System.out.println("("+(i+1)+") "+c.getName()+" | Hp : "+c.getHP());
        }

        int input = getIntRange(1,list.size());

        Combatant cible = list.get(input-1);
        this.game.executeattack(cible);


    }

    @Override
    public void choseobject() {
        System.out.println("Choisissez un objet");
        Hero hero = (Hero) this.game.getActualcombatant();
        for(Consumable c : hero.getConsumables()){
            if(c instanceof Food){
                System.out.println("("+(hero.getConsumables().indexOf(c)+1)+") Food");
            }else {
                System.out.println("("+(hero.getConsumables().indexOf(c)+1)+") Potion");
            }

        }
        int input = getIntRange(1,hero.getConsumables().size());
        this.game.consumeObject(hero.getConsumables().get(input-1));


    }

    @Override
    public void showdegats() {
        System.out.println("\n"+"-".repeat(30));
        Combatant c = this.game.getActualcombatant();
        System.out.println(c.getName()+ " Vient d'infliger "+c.getWeapon().getDegats());
    }

    @Override
    public void showsoin() {
        System.out.println("\n"+"-".repeat(30));
        Combatant c = this.game.getActualcombatant();
        System.out.println(c.getName()+ " s'est soigné grace a un objet ");
    }

    @Override
    public void levelUp() {
        System.out.println("\n"+"-".repeat(30));
        System.out.println("Bravo, vous avez terminé le niveau ! "+(this.game.getLevel()-1));

        System.out.println("Vous passez maintenant au niveau "+this.game.getLevel());
    }


    @Override
    public void asktypehero(int numeroHero){
        System.out.println("Quel type de heros voulez vous pour le heros numero "+numeroHero+" ?");
        System.out.println("(1) Warrior");
        System.out.println("(2) Hunter");
        System.out.println("(3) Mage");
        System.out.println("(4) Healer");
        int nombre = getIntRange(1,4);
        this.demandeNom(nombre);

    }

    public void demandeNom(int nombre){
        System.out.println("Choisissez un nom pour votre heros ");
        String nom = this.sc.nextLine();
        this.game.createhero(nombre,nom);
    }
    @Override
    public void win() {
        System.out.println("-".repeat(30));
        System.out.println("Bravo vous avez gagné !");
    }
    @Override
    public void lose() {
        System.out.println("-".repeat(30));
        System.out.println("Dommage, vous avez perdu");

    }

}