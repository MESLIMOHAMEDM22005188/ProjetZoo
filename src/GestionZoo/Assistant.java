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

    public static void afficherFormulaire(Scanner scanner, Zoo zoo) {
        System.out.println("Voici le formulaire");

        Validateur validateur = new Validateur();
        String nom;
        String prenom;
        int age = 0;

        // Saisie du nom avec validation
        do {
            System.out.println("Entrez votre nom : ");
            nom = scanner.nextLine();

            if (nom.length() < 3) {
                System.out.println("Le nom doit avoir au moins 3 caractères. Veuillez réessayer.");
            } else if (!validateur.estUniquementAlphabetique(nom)) {
                System.out.println("Le nom ne doit contenir que des lettres. Veuillez réessayer.");
            } else {
                break; // Sortir de la boucle si le nom est valide
            }
        } while (true);

        // Saisie du prénom avec validation
        do {
            System.out.println("Entrez votre prénom : ");
            prenom = scanner.nextLine();

            if (prenom.length() < 3) {
                System.out.println("Le prénom doit avoir au moins 3 caractères. Veuillez réessayer.");
            } else if (!validateur.estUniquementAlphabetique(prenom)) {
                System.out.println("Le prénom ne doit contenir que des lettres. Veuillez réessayer.");
            } else {
                break; // Sortir de la boucle si le prénom est valide
            }
        } while (true);

        // Saisie de l'âge avec validation
        do {
            System.out.println("Entrez votre âge : ");
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                scanner.nextLine(); // Pour consommer le saut de ligne

                if (age < 18 || age > 120) {
                    System.out.println("L'âge doit être entre 18 et 120 ans. Veuillez réessayer.");
                } else {
                    break; // Sortir de la boucle si l'âge est valide
                }
            } else {
                System.out.println("Veuillez entrer un nombre valide pour l'âge.");
                scanner.nextLine(); // Pour consommer la saisie invalide
            }
        } while (true);
        afficherMenu(scanner, zoo);
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

