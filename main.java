import src.Creatures.CreatureFantastique;
import src.Enclos.Enclos;
import src.GestionZoo.Assistant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static src.GestionZoo.Assistant.*;

public class main {

    static int age;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nom = "";
        String prenom = "";


        System.out.println("Appuyez sur 's' pour commencer une partie");
        char choix = scanner.next().charAt(0);

        if (Character.toLowerCase(choix) == 's') {
            afficherLigneSuivante("\nBonjour ! Bienvenue dans votre ZOO !", scanner);
            afficherLigneSuivante("\nJ'ai appris pour vos parents... ", scanner);
            afficherLigneSuivante("\nToutes mes condoléances...  ", scanner);
            afficherLigneSuivante("\nJe les connaissaient ils avaient beaucoup d'espoir en votre avenir", scanner);
            afficherLigneSuivante("\nVous heritez maintenant du plus grand zoo au monde construit par vos parents", scanner);
            afficherLigneSuivante("\nAvons de vous donnez les clées vous devez remplire çe formulaire :", scanner);

            System.out.println("\n Formulaire");
            while (true) {
                System.out.print("Entrez votre nom : ");
                nom = scanner.nextLine();
                if (gestionPrenomNom(nom) && nom.length() >= 4 && Character.isUpperCase(nom.charAt(0))) {
                    System.out.println("Nom valide !");
                    break;
                } else {
                    System.out.println("Le nom saisi n'est pas valide.");
                }
            }
            while (true) {

                System.out.print("Entrez votre prenom: ");
                prenom = scanner.nextLine();
                if (gestionPrenomNom(prenom) && prenom.length() >= 6 && Character.isUpperCase(prenom.charAt(0))) {
                    System.out.println("prenom valide !");
                    break;
                } else {
                    System.out.println("Le prénom saisi n'est pas valide.");
                }
            }

            System.out.print("Entrez votre âge : ");
            age = scanner.nextInt();
            verifierAge(age);
        }
        if (verifierAge(age)) {
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
            boolean jouer = true;
            while (jouer) {
                System.out.print("\nChoisissez une option  ");
                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("\nInformations sur le zoo :");
                        if (!Enclos.enclosList.isEmpty()) {
                            encn
                            if(Creatures.) {
                                afficherEnclosDansZoo(enclosList);
                                showOption();
                            }
                        } else {
                            System.out.println("Vous ne disposez d'aucun enclos.");
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
    }
    private static void showOption(){
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
    }



}
