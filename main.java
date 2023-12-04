import src.GestionZoo.Assistant;
import src.GestionZoo.Zoo;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nom;
        String prenom;
        int age;
        Zoo zoo = null;

        char choix = ' ';
        while (!(choix == 's' || choix == 'S')) {
            System.out.print("Appuyez sur 's' pour commencer une partie : ");
            choix = scanner.next().charAt(0);

            if (!(choix == 's' || choix == 'S')) {
                System.out.println("Veuillez appuyer sur 's' pour continuer.");
            }
            Assistant.afficherLigneSuivante("\nBonjour ! Bienvenue dans votre ZOO !", scanner);
            Assistant.afficherLigneSuivante("\nJ'ai appris pour vos parents... ", scanner);
            Assistant.afficherLigneSuivante("\nToutes mes condoléances...  ", scanner);
            Assistant.afficherLigneSuivante("\nJe les connaissaient, ils avaient beaucoup d'espoir en votre avenir.", scanner);
            Assistant.afficherLigneSuivante("\nVous héritez maintenant du plus grand zoo au monde construit par vos parents.", scanner);
            Assistant.afficherLigneSuivante("\nAvant de vous donner les clés, vous devez remplir ce formulaire :", scanner);
        }

        do {
            System.out.print("Entrez un nom : ");
            nom = scanner.nextLine();

            if (!Assistant.estNomValide(nom)) {
                if (nom.length() <= 3) {
                    System.out.println("Erreur : Veuillez entrer un nom de plus de 3 caractères.");
                } else {
                    System.out.println("Erreur : Pas de caractère spécial dans le nom.");
                }
            }
        } while (!Assistant.estNomValide(nom));

        do {
            System.out.print("Entrez un prénom : ");
            prenom = scanner.nextLine();

            if (!Assistant.estPrenomValide(prenom)) {
                if (prenom.length() <= 3) {
                    System.out.println("Erreur : Veuillez entrer un prénom de plus de 3 caractères.");
                } else {
                    System.out.println("Erreur : Pas de caractère spécial dans le prénom.");
                }
            }
        } while (!Assistant.estPrenomValide(prenom));
        System.out.print("Entrez votre âge : ");
        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un nombre valide pour l'âge.");
            scanner.next(
        }
            Assistant.afficherMenu(scanner, zoo);
            Zoo.afficherJeu(nom, scanner, zoo);
        }
    }


