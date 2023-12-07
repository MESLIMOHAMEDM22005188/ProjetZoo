package src.GestionZoo;

import src.Enclos.EnclosAquarium;
import java.util.Scanner;

public class Creation {
    public static void creerEnclosSimple(){
        System.out.println("cc");

    }
    public static void creerEnclosVoltigeur(){
    }
    public static void creerEnclosAquarium() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Création d'un nouvel enclos aquarium :");
        System.out.println("Entrez le nom de l'enclos :");
        String nomEnclos = scanner.nextLine();

        System.out.println("Entrez la capacité maximale de l'enclos :");
        int capaciteMax = scanner.nextInt();

        EnclosAquarium nouvelEnclosAquarium = new EnclosAquarium(nomEnclos, capaciteMax);

        System.out.println("L'enclos aquarium '" + nomEnclos + "' a été créé avec succès !");

        retourCreerEnclos(scanner);
    }
    public static char retourCreerEnclos(Scanner scanner) {
        System.out.println("\nRetourner à l'interface precedente ?");
        char choixRetour = scanner.next().charAt(0);
        if (choixRetour == 'o' || choixRetour == 'O') {
            ControleZoo.creerEnclos();
        }
        return choixRetour;
    }
}
