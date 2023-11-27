import src.Creatures.Licorne;
import src.Enclos.Enclos;
import src.GestionZoo.Assistant;
import src.GestionZoo.Zoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Zoo zoo = null;
        List<Enclos> enclosList = new ArrayList<>();

        System.out.println("Appuyez sur 's' pour commencer une partie");
        char choix = scanner.next().charAt(0);

        if (Character.toLowerCase(choix) == 's') {
            Assistant.afficherLigneSuivante("\nBonjour ! Bienvenue dans votre ZOO !", scanner);
            Assistant.afficherLigneSuivante("\nJ'ai appris pour vos parents... ", scanner);
            Assistant.afficherLigneSuivante("\nToutes mes condoléances...  ", scanner);
            Assistant.afficherLigneSuivante("\nJe les connaissaient ils avaient beaucoup d'espoir en votre avenir", scanner);
            Assistant.afficherLigneSuivante("\nVous heritez maintenant du plus grand zoo au monde construit par vos parents", scanner);
            Assistant.afficherLigneSuivante("\nAvons de vous donnez les clées vous devez remplire çe formulaire :", scanner);

            System.out.println("\n Formulaire");
            System.out.print("Entrez votre nom : ");
            scanner.nextLine(); // consommer la nouvelle ligne après le nextInt()
            String nom = scanner.nextLine();

            System.out.print("Entrez votre prénom : ");
            String prenom = scanner.nextLine();

            System.out.print("Entrez votre âge : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre valide pour l'âge.");
                scanner.next(); // Consommer la mauvaise entrée
            }
            int age = scanner.nextInt();
            zoo = new Zoo(nom, prenom, age);
            Assistant.afficherMenu(scanner, zoo);

            System.out.println("\nFélicitations " + nom + "! Vous êtes officiellement propriétaire de ce zoo.");
            System.out.println("\nVous pouvez maintenant accéder à certaines informations du Zoo :");
            System.out.println("1. Voir ensemble du zoo");
            System.out.println("2. Voir les enclos");
            System.out.println("3. Voir la localisation");
            System.out.println("4. Examiner un enclos");
            System.out.println("5. Nettoyer un enclos");
            System.out.println("6. Nourrir les créatures");
            System.out.println("7. Transférer une créature d’un enclos à un autre");
            System.out.println("8. Créer un enclos");
            System.out.println("9. Fermer un enclos");
            System.out.println("10. Acheter une créature");

            System.out.print("\nChoisissez une option : ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("\nInformations sur le zoo :");
                    if (enclosList.isEmpty()) {
                        System.out.println("Vous ne disposez d'aucun enclos.");
                    } else {
                        afficherEnclosDansZoo(enclosList);
                    }
                    break;
                case 2:
                    // Logique pour voir les enclos
                    break;
                case 3:
                    // Logique pour voir la localisation
                    break;
                case 4:
                    // Logique pour examiner un enclos
                    examinerEnclos(scanner);
                    break;
                case 5:
                    // Logique pour nettoyer un enclos
                    nettoyerEnclos(scanner);
                    break;
                case 6:
                    // Logique pour nourrir les créatures
                    nourrirCreatures(scanner);
                    break;
                case 7:
                    // Logique pour transférer une créature d’un enclos à un autre
                    transfererCreature(scanner);
                    break;
                case 8:
                    // Créer un nouvel enclos
                    creerEnclos(scanner, enclosList);
                    break;
                case 9:
                    // Supprimer un enclos
                    fermerEnclos(scanner, enclosList);
                    break;
                case 10:
                    // Acheter une créature
                    acheterCreature(scanner, enclosList);
                    break;
                default:
                    System.out.println("Option invalide.");
                    break;
            }
        }
    }

    private static void examinerEnclos(Scanner scanner) {
        // Logique pour examiner un enclos
    }

    private static void nettoyerEnclos(Scanner scanner) {
        // Logique pour nettoyer un enclos
    }

    private static void nourrirCreatures(Scanner scanner) {
        // Logique pour nourrir les créatures
    }

    private static void transfererCreature(Scanner scanner) {
        // Logique pour transférer une créature d’un enclos à un autre
    }

    private static void creerEnclos(Scanner scanner, List<Enclos> enclosList) {
        System.out.print("Entrez le nom de l'enclos à créer : ");
        String nomEnclos = scanner.next();
        Enclos enclos = new Enclos();
        enclos.setNomEnclos(nomEnclos);
        enclosList.add(enclos);
        System.out.println("L'enclos " + nomEnclos + " a été créé avec succès !");
    }
    private static void afficherEnclosDansZoo(List<Enclos> enclosList) {
        if (enclosList.isEmpty()) {
            System.out.println("Il n'y a aucun enclos dans le zoo pour le moment.");
        } else {
            System.out.println("Liste des enclos dans le zoo :");
            for (Enclos enclos : enclosList) {
                System.out.println("- " + enclos.getNom());
            }
        }
    }

    private static void fermerEnclos(Scanner scanner, List<Enclos> enclosList) {
        System.out.print("Entrez le nom de l'enclos à fermer : ");
        String nomEnclos = scanner.next();
        Enclos enclos = trouverEnclos(nomEnclos, enclosList);
        if (enclos != null) {
            enclosList.remove(enclos);
            System.out.println("L'enclos " + nomEnclos + " a été fermé et supprimé avec succès !");
        } else {
            System.out.println("L'enclos " + nomEnclos + " n'a pas été trouvé.");
        }
    }

    private static Enclos trouverEnclos(String nomEnclos, List<Enclos> enclosList) {
        for (Enclos enclos : enclosList) {
            if (enclos.getNom().equals(nomEnclos)) {
                return enclos;
            }
        }
        return null;
    }

    private static void acheterCreature(Scanner scanner, List<Enclos> enclosList) {
        afficherCreaturesDisponibles();
        System.out.print("Choisissez le numéro de la créature à acheter : ");
        int choixCreature = scanner.nextInt();

        switch (choixCreature) {
            case 1:
                Licorne nouvelleLicorne = creerLicorne(scanner);
                placerCreatureDansEnclos(scanner, enclosList, nouvelleLicorne);
                break;
            // Ajoutez d'autres cas pour les autres créatures ici
            default:
                System.out.println("Choix de créature invalide.");
                break;
        }
    }

    private static void afficherCreaturesDisponibles() {
        System.out.println("Liste des créatures disponibles à l'achat :");
        System.out.println("1. Licorne");
        System.out.println("2. Dragon");
        System.out.println("3. Kraken");
        System.out.println("4. Lycanthrope");
        System.out.println("5. Megalodon");
        System.out.println("6. Nymphe");
        System.out.println("7. Phénix");
        System.out.println("8. Sirène");
        // Ajoutez d'autres créatures disponibles ici
    }

    private static Licorne creerLicorne(Scanner scanner) {
        System.out.print("Entrez le nom de la licorne : ");
        String nomLicorne = scanner.next();
        return Licorne.creerLicorne(nomLicorne, 'F', 70, 1.8, 4);
    }

    private static void placerCreatureDansEnclos(Scanner scanner, List<Enclos> enclosList, Licorne creature) {
        System.out.println("Liste des enclos disponibles :");
        afficherListeEnclos(enclosList);

        System.out.print("Entrez le nom de l'enclos où vous souhaitez placer la créature : ");
        String nomEnclos = scanner.next();

        System.out.print("Entrez le type d'enclos (Simple, ...): "); // Ajoutez cette ligne pour que l'utilisateur puisse choisir le type d'enclos
        String typeEnclos = scanner.next();

        Enclos enclos = trouverEnclos(nomEnclos, enclosList);

        if (enclos != null && enclos.getType().equalsIgnoreCase(typeEnclos)) {
            enclos.ajouterCreature(creature);
            System.out.println("La créature a été placée dans l'enclos " + nomEnclos + " avec succès !");
        } else {
            System.out.println("L'enclos " + nomEnclos + " n'a pas été trouvé ou n'est pas du type spécifié.");
        }
    }

    private static void afficherListeEnclos(List<Enclos> enclosList) {
        System.out.println("Liste des enclos :");
        for (Enclos enclos : enclosList) {
            System.out.println(enclos.getNom());
        }
    }

}
