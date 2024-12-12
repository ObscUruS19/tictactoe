import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quel est votre nom joueur 1 ?");
        String joueur1 = scanner.nextLine();

        System.out.println("Quel est votre nom joueur 2 ?");
        String joueur2 = scanner.nextLine();

        System.out.println("Bonjour " + joueur1 + "et " + joueur2 + ", bon jeu a vous ;)");

        initialiserJeu(joueur1, joueur2, scanner);
    }
    public static void initialiserJeu(String joueur1, String joueur2, Scanner scanner) {
        boolean rejouer = true;

        while (rejouer) {
            char[][] tableau = new char[3][3];
            initialiserTableau(tableau);

            boolean joueur1Tour = true;
            boolean jeuEnCours = true;

            while (jeuEnCours) {
                afficherTableau(tableau);
                if (joueur1Tour) {
                    System.out.println(joueur1 + ", c'est votre tour. Entrez la ligne et la colonne (0, 1 ou 2) séparées par un espace :");
                } else {
                    System.out.println(joueur2 + ", c'est votre tour. Entrez la ligne et la colonne (0, 1 ou 2) séparées par un espace :");
                }

                int ligne = scanner.nextInt();
                int colonne = scanner.nextInt();

                if (ligne >= 0 && ligne < 3 && colonne >= 0 && colonne < 3 && tableau[ligne][colonne] == ' ') {
                    tableau[ligne][colonne] = joueur1Tour ? 'X' : 'O';
                    joueur1Tour = !joueur1Tour;
                } else {
                    System.out.println("Cette case est déjà occupée ou invalide. Retentez :)");
                }

                if (verifierGagnant(tableau)) { jeuEnCours = false; afficherTableau(tableau);
                    if (joueur1Tour) {
                        System.out.println("Félicitations " + joueur2 + ", vous avez gagné !"); }
                    else {
                        System.out.println("Félicitations " + joueur1 + ", vous avez gagné !"); }
                } else if (tableauPlein(tableau)) {
                    jeuEnCours = false;
                    afficherTableau(tableau);
                    System.out.println("Match nul !"); }
            }

            System.out.println("Voulez-vous rejouer ? (oui/non)");
            String reponse = scanner.next();

            if (!reponse.equalsIgnoreCase("oui")) {
                rejouer = false;
            }
        }

        System.out.println("Merci d'avoir joué ! Au revoir.");
        scanner.close();
    }


    public static void initialiserTableau(char[][] tableau) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tableau[i][j] = ' ';
            }
        }
    }

    public static void afficherTableau(char[][] tableau) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tableau[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("-----");
        }
    }

    public static boolean tableauPlein(char[][] tableau) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tableau[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean verifierGagnant(char[][] tlateau) {
        for (int i = 0; i < 3; i++) {
            if (tlateau[i][0] == tlateau[i][1] && tlateau[i][1] == tlateau[i][2] && tlateau[i][0] != ' ') {
                return true;
            }
            if (tlateau[0][i] == tlateau[1][i] && tlateau[1][i] == tlateau[2][i] && tlateau[0][i] != ' ') {
                return true;
            }
        }
        if (tlateau[0][0] == tlateau[1][1] && tlateau[1][1] == tlateau[2][2] && tlateau[0][0] != ' ') {
            return true;
        }
        if (tlateau[0][2] == tlateau[1][1] && tlateau[1][1] == tlateau[2][0] && tlateau[0][2] != ' ') {
            return true;
        }
        return false;
    }
}
