public class Player {

    private static int wood = 0;
    private static int stone = 0;
    private static int gold = 50;
    private static int food = 100;
    private static int citizens = 1;
    private static boolean mine = false;
    private static int round = 0;
    private static boolean victory = false;


    public static int getWood() {
        return wood;
    }

    public static int getStone() {
        return stone;
    }

    public static int getGold() {
        return gold;
    }

    public static int getFood() {
        return food;
    }

    public static int getCitizens() {
        return citizens;
    }

    public static boolean getMine() {
        return mine;
    }

    public static int getRound() {
        return round;
    }

    public static boolean getVictory() {
        return victory;
    }

    public static int setRound() {
        return round += 1;
    }

    public static void explore() {
        int woodUpdate = (5 * citizens);
        int foodUpdate = (3 * citizens);
        wood += woodUpdate;
        food += foodUpdate;
        tour();
        System.out.println("Vous avez obtenu " + woodUpdate + " bois et " + foodUpdate + " nourritures\n");

    }

    public static void createMine() {
        if (wood >= 10 && mine == false) {
            wood -= 10;
            mine = true;
            tour();
            System.out.println("Mine créée !! Vous pouvez extraire de la pierre et de l'or !\n");
        } else if (wood < 10 && mine == false) {
            System.out.println("Vous n'avez pas assez de bois.\n");
        } else {
            System.out.println("Vous avez déja une mine.\n");
        }
    }

    public static void workMine() {
        if (mine == true && food >= (5 + citizens)) {
            int stoneUpdate = (5 * citizens);
            int goldUpdate = (2 * citizens);
            food -= 5;
            stone += stoneUpdate;
            gold += goldUpdate;
            System.out.println("Vous avez extrait " + stoneUpdate + " Pierres et " + goldUpdate + " d'Or.\n");
            tour();
        } else if (mine == true && food < (5 + citizens)) {
            System.out.println("Les habitants sont morts de faim dans la mine. Vous avez perdu !\n");
            citizens = 0;
        } else {
            System.out.println("Vous n'avez pas de mine.\n");
        }

    }

    public static void engage() {
        if (gold >= 30) {
            gold -= 30;
            citizens++;
            System.out.println("Vous avez recruté un soldat.\n");
            tour();
        } else {
            System.out.println("Vous n'avez pas assez d'or ...\n");
        }

    }

    public static void business() {
        if (stone >= 5) {
            gold += 10;
            stone -= 5;
            System.out.println("Vous avez échangé 5 pierres contre 10 d'or.\n");
            tour();
        } else {
            System.out.println("Vous n'avez pas assez de pierres.\n");
        }
    }

    public static void buildCastle() {
        if (wood >= 100 && stone >= 100 && gold >= 200 && citizens >= 40) {
            victory = true;
            tour();

        } else {
            System.out.println("Vous n'avez pas les ressources nécéssaires.\n");
        }
        ;
    }

    public static boolean hunger(int nbFood) {
        boolean lose = nbFood <= 0 ? true : false;
        if (lose) {
            citizens = 0;
        }
        return lose;
    }

    public static void tour() {
        round++;
        if (citizens > food) {
            int dead = citizens - food;
            citizens = food;
            System.out.println(dead + " Habitants sont morts.\n");
        } else {
            food -= citizens;
        }
        if (hunger(food)) {
            System.out.println("Les habitants sont morts de faim. Vous avez perdu !\n");
        }
        System.out.println("=".repeat(100) + "\n");
    }
}
