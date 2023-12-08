package src.GestionZoo;

import java.util.Scanner;

public class Assistant {
    public static void afficherLigneSuivante(String ligne, Scanner scanner) {
        System.out.println(ligne);
        System.out.println("(S)");

        char choix = scanner.next().charAt(0);

        if (!(choix == 'S' || choix == 's')) {
            System.out.println("(Appuyez sur s pour poursuivre");
        }
    }

    public static boolean estNomValide(String nom) {
        // Vérification de la longueur du nom
        if (nom.length() <= 3) {
            return false;
        }

        // Vérification des caractères spéciaux, chiffres et espaces
        for (char c : nom.toCharArray()) {
            if (!Character.isLetter(c)) {
                System.out.println("Pas de caractère spécial.");
                return false;
            }
        }

        // Si toutes les conditions sont remplies, le nom est valide
        return true;
    }

    public static boolean estPrenomValide(String prenom) {
        // Vérification de la longueur du prénom
        if (prenom.length() <= 3) {
            return false;
        }

        // Vérification des caractères spéciaux, chiffres et espaces
        for (char c : prenom.toCharArray()) {
            if (!Character.isLetter(c)) {
                System.out.println("Pas de caractère spécial.");
                return false;
            }
        }

        // Si toutes les conditions sont remplies, le prénom est valide
        return true;
    }

    public void afficherFormulaire(Scanner scanner, Zoo zoo) {
        System.out.println("Voici le formulaire");
        System.out.println("Entrez Votre nom: ");


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
            System.out.println("Maintenant vous pouvez acceder au menu principale du Jeu (Q)");

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
                    System.out.println("Bien j'ai enregistrer vos informations !");
                    Zoo.afficherOption();

                    break;
                default:
                    System.out.println("Choix invalide.");
                    break;
            }
        } while (choixMenu != 'Q' && choixMenu != 'q');
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
}

