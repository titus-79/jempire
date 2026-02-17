import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        boolean victoire = false;
        int round = 0;
        while (habitant > 0 && victoire == false) {

            Scanner scanner = new Scanner(System.in);
            menu(scanner);
            scanner.close();
        }
    }

}