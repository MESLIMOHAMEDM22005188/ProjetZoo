package src.GestionZoo;

import src.Creatures.Licorne;
import src.Enclos.Enclos;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Assistant {
    public static void afficherLigneSuivante(String ligne, Scanner scanner) {
        System.out.println(ligne);
        System.out.println("(S)");

        char choix = scanner.next().charAt(0);

        if (!(choix == 'S' || choix == 's')) {
            System.out.println("(Appuyez s pour poursuivre");
        }
    }

    public static boolean gestionPrenomNom(String nom){
        return nom.matches("[a-zA-Z]+");
    }
    public static boolean verifierAge(int age) {
        boolean ageValide = false;
        if (age < 18) {
            System.out.println("Désolé, revenez quand vous serez majeur.");
        } else if (age == 89) {
            System.out.println("Vous êtes trop vieux pour gérer un si grand zoo.");
        } else if (age > 89) {
            System.out.println("Vous êtes vraiment très vieux pour gérer un zoo !");
        } else {
            ageValide = true;
            System.out.println("Bienvenue ! Vous avez l'âge requis pour gérer ce zoo.");
        }
        return ageValide;
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
