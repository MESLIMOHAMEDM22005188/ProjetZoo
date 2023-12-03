import src.GestionZoo.Assistant;
import src.GestionZoo.Zoo;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nom;
        String prenom;
        int age;
        Zoo zoo;

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

        System.out.println("\nFormulaire");
        System.out.print("Entrez votre nom : ");
        scanner.nextLine(); // consommer la nouvelle ligne après le nextInt()
        nom = scanner.nextLine();

        System.out.print("Entrez votre prénom : ");
        prenom = scanner.nextLine();

        System.out.print("Entrez votre âge : ");
        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un nombre valide pour l'âge.");
            scanner.next(); // Consommer la mauvaise entrée
        }
        age = scanner.nextInt();

        zoo = new Zoo(nom, prenom, age);

        Assistant.afficherMenu(scanner, zoo);
        Zoo.afficherJeu(nom, scanner, zoo);

    }
}
