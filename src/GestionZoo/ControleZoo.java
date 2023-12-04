package src.GestionZoo;

import src.Creatures.CreatureFantastique;
import src.Enclos.Enclos;

public class ControleZoo {
    public static void afficherInformationsZoo() {
        char choix = ' ';
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
        System.out.println("\nRetourner à l'accueil ?");
        System.out.println("\nVeuillez cliquer sur O");
        if (!(choix == 'O' || choix == 'o')) {
            System.out.println("\nVeuillez cliquer sur O");
        }

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
    public static void afficherDetailEnclos() {
        System.out.println("\nDétails des enclos :");
        if (!Enclos.EnclosList.isEmpty()) {
            for (Enclos enclos : Enclos.EnclosList) {
                enclos.afficherCaracteristiques();
            }
        } else {
            System.out.println("Vous n'avez aucun enclos.");
        }

    }

}
