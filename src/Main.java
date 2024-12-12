import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quel est votre nom joueur 1 ?");
        String joueur1 = scanner.nextLine();

        System.out.println("Quel est votre nom joueur 2 ?");
        String joueur2 = scanner.nextLine();

        System.out.println("Bonjour " + joueur1 + "et " + joueur2 + ", bon jeu a vous ;)");
    }
    public static void initialiserPlateau(char[][] plateau) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                plateau[i][j] = ' ';
            }
        }
    }
    public static void afficherPlateau(char[][] plateau) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(plateau[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("-----");
        }
    }
}
