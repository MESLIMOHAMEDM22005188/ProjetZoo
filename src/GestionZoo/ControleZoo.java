package src.GestionZoo;

import src.Creatures.CreatureFantastique;
import src.Enclos.Enclos;

import java.util.Scanner;

public class ControleZoo {
    static char choix = ' '; // Déclarer la variable choix comme statique

    public static char afficherInformationsZoo(String nom, int age, Scanner scanner) {
        Zoo zoo = new Zoo("", "", 0); // Création d'une instance de Zoo

        System.out.println("\nInformations sur le zoo :");
        if (!Enclos.EnclosList.isEmpty()) {
            for (Enclos enclos : Enclos.EnclosList) {
                System.out.println("- Nom de l'enclos : " + enclos.getNom());
                System.out.println("  Nombre de créatures : " + enclos.getNombreCreaturesPresentes());
            }
        } else {
            System.out.println("Vous ne disposez d'aucun enclos.");
        }



        System.out.println("\nInformations sur les créatures fantastiques :");
        if (!CreatureFantastique.Creature.isEmpty()) {
            for (CreatureFantastique creature : CreatureFantastique.Creature) {
                System.out.println("- Nom de la créature : " + creature.getNom());
                // Ajoutez d'autres informations de la créature fantastique si nécessaire
            }
        } else {
            System.out.println("Aucune créature fantastique n'est présente.");
        }

        char choixRetour = retourAccueil(scanner);

        return choixRetour;
    }

    public static void afficherDetailEnclos(Scanner scanner, char choix) { // Ajout de l'argument choix
        System.out.println("\nDétails des enclos :");

    }
    public static void ExaminerEnclos(Scanner scanner, char choix){

    }
    public static char retourAccueil(Scanner scanner) {
        System.out.println("\nRetourner à l'accueil ? (Appuyez sur 'o' pour oui) : ");
        char choix = scanner.next().charAt(0);
        scanner.nextLine(); // Consommer la nouvelle ligne

        char choixRetour = retourAccueil(scanner);

        return choixRetour;
    }

}
