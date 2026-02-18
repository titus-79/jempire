import java.util.Scanner;

class Main {
    static Scanner scanner = new Scanner(System.in);

    public static int readInt(String prompt) throws NumberFormatException {
        System.out.print(prompt);
        String input = scanner.nextLine();
        int result = Integer.parseInt(input);
        return result;
    }

    public static void main(String[] args) {

        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║           WELCOME TO JEMPIRE           ║");
        System.out.println("╚════════════════════════════════════════╝\n");
        while (Player.getCitizens() > 0 && Player.getVictory() == false) {
            statusGame();
            Event.randomEvent();
            statusGame();
            menu(scanner);
            statusGame();
        }
        scanner.close();

    }

    public static void menu(Scanner scanner) {
        System.out.println("|| Tours : " + Player.getRound() + " ||");
        System.out.print("| Bois : " + Player.getWood());
        System.out.print(" || Pierre : " + Player.getStone());
        System.out.print(" || Or : " + Player.getGold());
        System.out.print(" || Nourriture : " + Player.getFood());
        System.out.println(" || Citizens : " + Player.getCitizens() + " |\n");
        System.out.println("Choisissez une action parmi les suivantes :");
        System.out.println("| Choix | Action | Coût / Risque | Gain |\n");
        System.out.println("| 1 | Explorer la forêt | Aucun | +5 Bois, +3 Nourriture |");
        System.out
                .println("| 2 | Créer une mine | -10 Bois | (Débloque l'accès à la pierre pour les tours suivants) |");
        System.out.println(
                "| 3 | Travailler à la mine | -5 Nourriture | +5 Pierre, +2 Or (Seulement si mine construite !) |");
        System.out.println("| 4 | Recruter un soldat | -30 Or | +1 Habitant |");
        System.out.println("| 5 | Commercer | -5 Pierre | +10 Or |");
        System.out.println(
                "| 6 | CONSTRUIRE LE CHÂTEAU | -100 Bois, -100 Pierre, -200 Or, -40 Habitants | VICTOIRE IMMÉDIATE ! |\n");

        try {
            int userChoice = readInt("Votre choix :");
            switch (userChoice) {
                case 1:
                    System.out.println("Explorer la forêt\n");
                    Player.explore();
                    break;
                case 2:
                    System.out.println("Créer une mine\n");
                    Player.createMine();
                    break;
                case 3:
                    System.out.println("Travailler à la mine\n");
                    Player.workMine();
                    break;
                case 4:
                    System.out.println("Recruter un soldat\n");
                    Player.engage();
                    break;
                case 5:
                    System.out.println("Commercer\n");
                    Player.business();
                    break;
                case 6:
                    System.out.println("CONSTRUIRE LE CHÂTEAU\n");
                    Player.buildCastle();
                    break;
                default:
                    System.err.println("Veuillez choisir une option valide\n");
            }

        } catch (NumberFormatException e) {
            System.err.println("Erreur de saisie\n");
        }
    }

    public static void statusGame() {
        if (Player.getCitizens() == 0) {
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║              GAME OVER !!!             ║");
            System.out.println("╚════════════════════════════════════════╝\n");
        } else if (Player.getVictory() == true) {
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║                YOU WIN !!!             ║");
            System.out.println("╚════════════════════════════════════════╝\n");
            System.out.println("Score : " + Player.getRound() + "\n");
        }
    }

}
