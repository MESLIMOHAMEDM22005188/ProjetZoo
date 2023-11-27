package src.GestionZoo;

import src.Creatures.Licorne;

import java.util.Scanner;

public class Assistant {
    public static void afficherLigneSuivante(String ligne, Scanner scanner) {
        System.out.println(ligne);
        System.out.println("(S)");

        char choix = scanner.next().charAt(0);

        if (!(choix == 'S' || choix == 's')) {
            System.out.println("Fin du programme.");
            System.exit(0);
        }
    }

    public static void afficherMenu(Scanner scanner, Zoo zoo) {
        char choixMenu;
        do {
            System.out.println("\nMenu :");
            System.out.println("V - Voir le récapitulatif");
            System.out.println("M1 - Modifier le nom");
            System.out.println("M2 - Modifier le prénom");
            System.out.println("M3 - Modifier l'âge");
            System.out.println("Q - Quitter");

            System.out.print("Votre choix : ");
            choixMenu = scanner.next().charAt(0);

            switch (choixMenu) {
                case 'V':
                case 'v':
                    zoo.afficherRecapitulatif();
                    break;
                case 'M':
                case 'm':
                    zoo.modifierChamp(scanner);
                    break;
                case 'Q':
                case 'q':
                    System.out.println("Fin du programme.");
                    break;
                default:
                    System.out.println("Choix invalide.");
                    break;
            }
        } while (choixMenu != 'Q' && choixMenu != 'q');
    }
}
