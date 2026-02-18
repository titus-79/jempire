public class Player {

    private int wood;
    private int stone;
    private int gold;
    private int food;
    private int citizens;
    private boolean mine = false;
    private int round = 0;
    private boolean victory = false;

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

    public boolean getVictory() {
        return victory;
    }

    public int setRound() {
        return this.round += 1;
    }

    public void explore() {
        int woodUpdate = (5 * citizens);
        int foodUpdate = (3 * citizens);
        this.wood += woodUpdate;
        this.food += foodUpdate;
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
        if (this.stone >= 5) {
            this.gold += 10;
            this.stone -= 5;
            System.out.println("Vous avez échangé 5 pierres contre 10 d'or.\n");
            tour();
        } else {
            System.out.println("Vous n'avez pas assez de pierres.\n");
        }
    }

    public void buildCastle() {
        if (this.wood >= 100 && this.stone >= 100 && this.gold >= 200 && this.citizens >= 40) {
            this.victory = true;
            tour();

        } else {
            System.out.println("Vous n'avez pas les ressources nécéssaires.\n");
        }
        ;
    }

    public boolean hunger(int nbFood) {
        boolean lose = nbFood <= 0 ? true : false;
        if (lose) {
            citizens = 0;
        }
        return lose;
    }

    public void tour() {
        this.round++;
        if (this.citizens > this.food) {
            int dead = this.citizens - this.food;
            this.citizens = this.food;
            System.out.println(dead + " Habitants sont morts.\n");
        } else {
            this.food -= citizens;
        }
        if (hunger(this.food)) {
            System.out.println("Les habitants sont morts de faim. Vous avez perdu !\n");
        }
        System.out.println("=".repeat(100) + "\n");
    }
}
