import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private ArrayList<Hero> teamhero = new ArrayList<Hero>();

    private ArrayList<Enemy> teamenemy = new ArrayList<Enemy>();

    private ArrayList<Combatant> ordreTour = new ArrayList<Combatant>();

    private InputParser inputParser;

    private int heronumber;

    private int level = 1;

    private Combatant actualcombatant;

    public void startbattle(){


    }


    public void start2(){
        Scanner sc = new Scanner(System.in);
        this.inputParser= new ConsoleParser(this);
        inputParser.KOKOText("Bienvenue dans mon RPG, venez vaincre les ennemis");

        inputParser.asknombrehero();


    }

    public void createhero(int typeHero, String name){
        if(typeHero==1){
            teamhero.add(new Warrior(name));
        }else if(typeHero==2){
            teamhero.add(new Hunter(name));
        }else if(typeHero==3){
            teamhero.add(new Mage(name));
        }else if(typeHero==4){
            teamhero.add(new Healer(name));
        }

        if(teamhero.size()<this.heronumber){
            //on genere un nouveau heros
            this.inputParser.asktypehero(teamhero.size()+1);

        }else {
            //On passe a la suite du jeu
            this.genererEnnemy();
        }


    }

    public ArrayList<Hero> getTeamhero() {
        return teamhero;
    }

    public void setHeronumber(int heronumber) {
        this.heronumber = heronumber;
    }

    public void genererEnnemy(){
        String[] nom = {"Max Vachette", "Daisy Dan", "Antoine","Happy Léa","Guyguane"};
        int[] hp = {10,12,15,17,25};
        for(int i = 0; i<this.heronumber; i++){
            teamenemy.add(new Enemy(nom[level-1],hp[level-1]));
        }
        this.choixOrdre();
        choseaction();
    }

    public void choixOrdre(){
        for(int i = 0; i<this.heronumber; i++){
            ordreTour.add(teamhero.get(i));
            ordreTour.add(teamenemy.get(i));
        }
        this.actualcombatant = this.ordreTour.get(0);

    }

    public void nextcombatant(){
        int indice = this.ordreTour.indexOf(this.actualcombatant);

        if(indice==this.ordreTour.size()-1){
            this.actualcombatant = this.ordreTour.get(0);


        }else{
            this.actualcombatant = this.ordreTour.get(indice+1);
        }


    }

    public void choseaction(){
        if(this.actualcombatant instanceof Hero){
            this.inputParser.askAction();
        }else{
            int indice = (int)Math.random()*(teamhero.size()-1);
            this.executeattack(teamhero.get(indice));
        }
    }

    public void executeattack(Combatant cible){
        actualcombatant.attack(cible,this);
        this.inputParser.showdegats();
        finTour();

    }

    public void finTour(){
        if(teamhero.size()==0){
            this.inputParser.lose();
        }else if(teamenemy.size()==0){
            level++;
            levelup();
        }else {
            nextcombatant();
            choseaction();

        }


    }

    private void levelup() {

        ordreTour = new ArrayList<Combatant>();

        for(Hero h : teamhero){
            h.setHP(30);
        }
        if(level<6){
            this.inputParser.levelUp();
            genererEnnemy();
        }else {
            this.inputParser.win();
        }


    }




    public Combatant getActualcombatant() {
        return actualcombatant;
    }

    public ArrayList<Enemy> getTeamenemy() {
        return teamenemy;
    }

    public void consumeObject(Consumable c){
        c.use(actualcombatant);
        this.inputParser.showsoin();
        finTour();
    }


    public int getLevel() {
        return level;
    }

    public int getHeronumber() {
        return heronumber;
    }

    public ArrayList<Combatant> getOrdreTour() {
        return ordreTour;
    }
}