import GestionZoo.Assistant;
import GestionZoo.Zoo;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Appuyez sur 's' pour commencer une partie");
        char choix = scanner.next().charAt(0);

        if (choix == 'S' || choix == 's') {
            Assistant.afficherLigneSuivante("\nBonjour Bienvenue dans votre ZOO!", scanner);
            // Ajoutez d'autres messages ici avec Assistant.afficherLigneSuivante() si nécessaire

            System.out.println("\nVeuillez remplir le formulaire :");
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
            Zoo zoo = new Zoo(nom, prenom, age);
            Assistant.afficherMenu(scanner, zoo);

            System.out.println("\nFélicitations " + nom + "! Vous êtes officiellement propriétaire de ce zoo.");
            System.out.println("\nVous pouvez maintenant accéder à certaines informations du Zoo :");
            System.out.println("\nVoir ensemble zoo");
            System.out.println("\nVoir enclos");
            System.out.println("\nLocalisation");
        }
    }
}
