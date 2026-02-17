import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        boolean victoire = false;
        int round = 0;
        Assets player = new Assets(0,0, 50, 100, 1);
        while (player.citizens > 0 && victoire == false) {

            Scanner scanner = new Scanner(System.in);
            menu(scanner);
            scanner.close();
        }
    }

}