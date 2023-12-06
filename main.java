import src.GestionZoo.Assistant;
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
                Zoo.afficherJeu(nom, age, zoo);

            }
        } while (!(choix == 's' || choix == 'S'));
    }
}