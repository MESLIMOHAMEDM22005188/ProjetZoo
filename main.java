import src.GestionZoo.Assistant;
import src.GestionZoo.ControleZoo;
import src.GestionZoo.Validateur;
import src.GestionZoo.Zoo;

import java.util.Scanner;

public class main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nom;
        String prenom;
        int age = 0;
        Zoo zoo = null;

        char choix = ' ';
        do {
            System.out.print("Appuyez sur 's' pour commencer une partie : ");
            choix = scanner.next().charAt(0);

            if (!(choix == 's' || choix == 'S')) {
                System.out.println("Veuillez appuyer sur 's' pour continuer.");
            } else {
                Assistant.afficherLigneSuivante("\nBonjour ! Bienvenue dans votre ZOO !", scanner);
                Assistant.afficherLigneSuivante("\nJ'ai appris pour vos parents... ", scanner);
                Assistant.afficherLigneSuivante("\nToutes mes condoléances...  ", scanner);
                Assistant.afficherLigneSuivante("\nJe les connaissais, ils avaient beaucoup d'espoir en votre avenir.", scanner);
                Assistant.afficherLigneSuivante("\nVous héritez maintenant du plus grand zoo au monde construit par vos parents.", scanner);
                Assistant.afficherLigneSuivante("\nAvant de vous donner les clés, vous devez remplir ce formulaire :", scanner);

                nom = Validateur.saisirInfoValide("Entrez votre nom: ", "Erreur : Veuillez entrer un nom valable", "Erreur : Pas de caractère spécial dans le nom.", scanner, Assistant.estNomValide());

                prenom = Validateur.saisirInfoValide("Entrez un prénom :  ", "Erreur : Veuillez entrer un prénom de plus de 3 caractères.", "Erreur : Pas de caractère spécial dans le prénom.", scanner, Assistant.estPrenomValide());

                age = Validateur.saisirAge(scanner);
                Assistant.afficherMenu(scanner, zoo);
                Zoo.afficherJeu(nom, age, scanner, zoo);

            }
        } while (!(choix == 's' || choix == 'S'));
    }
    public static void afficherMenuPrincipal(String nom, int age, Scanner scanner, Zoo zoo) {
        char choix = ' ';
        do {
            System.out.println("\nFélicitations " + nom + "! Vous êtes officiellement propriétaire de ce zoo.");
            // Afficher les options du menu principal
            System.out.println("1. Voir ensemble du zoo");
            System.out.println("2. Voir les enclos");
            // ... (autres options)

            System.out.print("\nChoisissez une option : ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    choix = ControleZoo.afficherInformationsZoo(nom, age, scanner);
                    break;
                case 2:
                    ControleZoo.afficherDetailEnclos(scanner, choix);
                    break;
                // ... (autres cas pour les différentes options du menu)
                default:
                    System.out.println("Option invalide.");
                    break;
            }
        } while (choix == 'o' || choix == 'O');
    }
}