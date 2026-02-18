public class Player {

    private int wood;
    private int stone;
    private int gold;
    private int food;
    private int citizens;
    private boolean mine = false;
    private int round = 0;

    public Player(int wood, int stone, int gold, int food, int citizens) {
        this.wood = wood;
        this.stone = stone;
        this.gold = gold;
        this.food = food;
        this.citizens = citizens;
    }

    public int getWood() {
        return wood;
    }

    public int getStone() {
        return stone;
    }

    public int getGold() {
        return gold;
    }

    public int getFood() {
        return food;
    }

    public int getCitizens() {
        return citizens;
    }

    public boolean getMine() {
        return mine;
    }

    public int getRound() {
        return round;
    }

    public int setRound() {
        return this.round += 1;
    }

    public void explore() {
        int woodUpdate = (5 * citizens);
        int foodUpdate = (3 * citizens);
        this.wood += woodUpdate;
        this.food += foodUpdate ;
        tour();
        System.out.println("Vous avez obtenu " + woodUpdate + " bois et " + foodUpdate + " nourritures\n");

    }

    public void createMine() {
        if (this.wood >= 10 && this.mine == false) {
            this.wood -= 10;
            this.mine = true;
            tour();
            System.out.println("Mine créée !! Vous pouvez extraire de la pierre et de l'or !\n");
        } else if (this.wood < 10 && this.mine == false) {
            System.out.println("Vous n'avez pas assez de bois.\n");
        } else {
            System.out.println("Vous avez déja une mine.\n");
        }
    }

    public void workMine() {
        if (this.mine == true && this.food >= (5 + citizens)) {
            int stoneUpdate = (5 * citizens);
            int goldUpdate = (2 * citizens);
            this.food -= 5;
            this.stone += stoneUpdate;
            this.gold += goldUpdate;
            System.out.println("Vous avez extrait " + stoneUpdate + " Pierres et " + goldUpdate + " d'Or.\n");
            tour();
        } else if (this.mine == true && this.food < (5 + citizens)) {
            System.out.println("Les habitants sont morts de faim dans la mine. Vous avez perdu !\n");
            citizens = 0;
        } else {
            System.out.println("Vous n'avez pas de mine.\n");
        }

    }

    public void engage() {
        if (this.gold >= 30) {
            this.gold -= 30;
            this.citizens++;
            System.out.println("Vous avez recruté un soldat.\n");
            tour();
        } else {
            System.out.println("Vous n'avez pas assez d'or ...\n");
        }

    }

    public void business() {

    }

    public boolean buildCaslte() {
        return false;
    }

    public boolean hunger(int nbCitizen, int nbFood) {
        boolean lose = nbCitizen > nbFood ? true : false;
        if (lose) {
            citizens = 0;
        }
        return lose;
    }

    public void tour() {
        this.round++;
        this.food -= citizens;
        if (hunger(citizens, food)) {
            System.out.println("Les habitants sont morts de faim. Vous avez perdu !\n");
        }
    }
}
