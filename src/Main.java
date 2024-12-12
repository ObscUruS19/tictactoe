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
}
