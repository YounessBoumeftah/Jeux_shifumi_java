package jeux_shifumi;

import java.util.Random;
import java.util.Scanner;

public class shifumi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Bienvenue dans le jeu Shifumi!");
        System.out.println("1. Pierre\n2. Papier\n3. Ciseaux");

        int userChoice = getUserChoice(scanner);
        int computerChoice = random.nextInt(3) + 1;

        System.out.println("L'ordinateur a choisi : " + getChoiceName(computerChoice));
        System.out.println("Vous avez choisi : " + getChoiceName(userChoice));

        int result = determineWinner(userChoice, computerChoice);
        displayResult(result);
        
        scanner.close();
    }

    private static int getUserChoice(Scanner scanner) {
        System.out.print("Veuillez entrer votre choix (1, 2, ou 3) : ");
        int choice = scanner.nextInt();

        while (choice < 1 || choice > 3) {
            System.out.println("Choix invalide. Veuillez entrer 1, 2 ou 3.");
            choice = scanner.nextInt();
        }

        return choice;
    }

    private static String getChoiceName(int choice) {
        switch (choice) {
            case 1:
                return "Pierre";
            case 2:
                return "Papier";
            case 3:
                return "Ciseaux";
            default:
                return "Inconnu";
        }
    }

    private static int determineWinner(int userChoice, int computerChoice) {
        if (userChoice == computerChoice) {
            return 0; // Égalité
        } else if ((userChoice == 1 && computerChoice == 3) ||
                   (userChoice == 2 && computerChoice == 1) ||
                   (userChoice == 3 && computerChoice == 2)) {
            return 1; // Utilisateur gagne
        } else {
            return -1; // Ordinateur gagne
        }
    }

    private static void displayResult(int result) {
        if (result == 0) {
            System.out.println("Égalité !");
        } else if (result == 1) {
            System.out.println("Félicitations, vous avez gagné !");
        } else {
            System.out.println("Désolé, l'ordinateur a gagné. Essayez encore !");
        }
    }
}
