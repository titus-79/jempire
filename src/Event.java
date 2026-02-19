public class Event {

    public static void randomEvent() {
        if (Player.getRound() > 3) {
            attack();
            pest();
            migrant();

        }
    }

    public static void attack() {
        double chance = Math.random();
        double difficult = 0.02;
        if (chance < 0.1) {
            int attaquants = (int) Math.exp(Math.random() * Player.getRound() * difficult);
            int deadCitizens = (int) Math.round(attaquants * Math.random());
            if (deadCitizens > Player.getCitizens()) {
                deadCitizens = Player.getCitizens();
            }
            int newCitizens = Player.getCitizens() - deadCitizens;
            Player.setCitizens(newCitizens);
            System.out.println(attaquants + " barbare(s) attaque(nt) : Moins " + deadCitizens + " habitant(s)\n");
        }
        if (Player.getCitizens() < 0) {
            Player.setCitizens(0);
        }
    }

    public static void pest() {
        double chance = 2 * Math.random() * Math.random();
        if (chance < 0.01) {
            int deadCitizens = rangeRandom(Player.getCitizens() / 3, Player.getCitizens() - 1);
            int newCitizens = Player.getCitizens() - deadCitizens;
            Player.setCitizens(newCitizens);
            System.out.println("La peste noire : Moins " + deadCitizens + " habitant(s)\n");
        }
    }

    public static void migrant() {
        double chance = Math.random() * Math.random();
        if (chance < 0.015) {
            int migrant = rangeRandom(1, Player.getCitizens() / 2);
            int newCitizens = Player.getCitizens() + migrant;
            Player.setCitizens(newCitizens);
            System.out.println("Des migrants vous ont rejoint : Plus " + migrant + " habitant(s)\n");
        }
    }

    public static int rangeRandom(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

}
