public class Player {

    private int wood;
    private int stone;
    private int gold;
    private int food;
    private int citizens;

    public Player(int wood, int stone, int gold, int food, int citizens) {
        this.wood = wood;
        this.stone = stone;
        this.gold = gold;
        this.food = food;
        this.citizens = citizens;
    }

    public int getWood() {return wood;}
    public int getStone() {return stone;}
    public int getGold() {return gold;}
    public int getFood() {return food;}
    public int getCitizens() {return citizens;}


    public void explore() {
        // System.out.println("Confirmez ? O/N");
        // String confirm = scanner.nextLine();
            int woodUpdate = 5 * citizens;
            int foodUpdate = 3 * citizens;
            this.wood += woodUpdate;
            this.food += foodUpdate;
            System.out.println("Vous avez obtenu " +  woodUpdate + " bois et " + foodUpdate + " nourritures\n") ;
         

    }

    public boolean createMine() {
        int woodUpdate = -10;
        this.wood -= woodUpdate;
        return false;
    }

    public void workMine() {
        
    }

    public void engage() {

    }

    public void business() {

    }

    public boolean buildCaslte() {
        return false;
    }
    
}
