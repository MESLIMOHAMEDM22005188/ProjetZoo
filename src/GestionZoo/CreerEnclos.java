package src.GestionZoo;

import src.Enclos.Enclos;
import src.Enclos.EnclosAquarium;
import src.Enclos.EnclosVoltigeur;

import java.util.Scanner;

public class CreerEnclos {

    public static void creerEnclosSimple() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Création d'un nouvel enclos simple:");
        System.out.println("Entrez le nom de l'enclos :");
        String nomEnclos = scanner.nextLine();

        int capaciteMax = obtenirCapaciteMaximale(scanner);

        EnclosVoltigeur nouvelEnclosSimple = new EnclosVoltigeur(nomEnclos, capaciteMax);

        System.out.println("L'enclos voltigeur '" + nomEnclos + "' a été créé avec succès !");
        Enclos.EnclosList.add(nouvelEnclosSimple);

        retourCreerEnclos(scanner);
    }

    public static void creerEnclosVoltigeur() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Création d'un nouvel enclos voltigeur :");
        System.out.println("Entrez le nom de l'enclos :");
        String nomEnclos = scanner.nextLine();

        int capaciteMax = obtenirCapaciteMaximale(scanner);

        EnclosVoltigeur nouvelEnclosVoltigeur = new EnclosVoltigeur(nomEnclos, capaciteMax);

        System.out.println("L'enclos voltigeur '" + nomEnclos + "' a été créé avec succès !");
        Enclos.EnclosList.add(nouvelEnclosVoltigeur); // Ajout à la liste EnclosList

        retourCreerEnclos(scanner);
    }

    public static void creerEnclosAquarium() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Création d'un nouvel enclos aquarium :");
            System.out.println("Entrez le nom de l'enclos :");
            String nomEnclos = scanner.nextLine();

            int capaciteMax = obtenirCapaciteMaximale(scanner);

            EnclosAquarium nouvelEnclosAquarium = new EnclosAquarium(nomEnclos, capaciteMax);
            System.out.println("L'enclos aquarium '" + nomEnclos + "' a été créé avec succès !");
            Enclos.EnclosList.add(nouvelEnclosAquarium); // Ajout à la liste EnclosList
        } while (retourCreerEnclos(scanner) == 'o');
    }

    public static int obtenirCapaciteMaximale(Scanner scanner) {
        int capaciteMax = 0;
        boolean capaciteValide = false;

        do {
            System.out.println("Entrez la capacité maximale de l'enclos (un chiffre entre 1 et 15) :");

            if (scanner.hasNextInt()) {
                capaciteMax = scanner.nextInt();
                scanner.nextLine(); // Consommer le retour à la ligne

                if (capaciteMax >= 1 && capaciteMax <= 15) {
                    capaciteValide = true;
                } else {
                    System.err.println("La capacité maximale doit être entre 1 et 15. Veuillez réessayer.");
                }
            } else {
                System.out.println("Veuillez entrer un nombre valide pour la capacité maximale.");
                scanner.next(); // Pour consommer la saisie incorrecte
            }
        } while (!capaciteValide);

        return capaciteMax;
    }


    public static char retourCreerEnclos(Scanner scanner) {
        System.out.println("\nVoulez-vous créer un autre enclos (o/O pour Oui, n'importe quoi d'autre pour Non) ?");
        char choixRetour = scanner.nextLine().charAt(0);
        return choixRetour;
    }
}