package src.GestionZoo;


import java.util.Scanner;

public class Zoo {
    private String nom;
    private String prenom;
    private int age;

    public Zoo(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public void afficherRecapitulatif() {
        System.out.println("\nRécapitulatif des informations :");
        System.out.println("Nom : " + nom);
        System.out.println("Prénom : " + prenom);
        System.out.println("Âge : " + age);
    }

    public void modifierChamp(Scanner scanner) {
        System.out.print("Choisissez le champ à modifier (1-Nom, 2-Prénom, 3-Âge) : ");
        int choix = scanner.nextInt();
        scanner.nextLine(); // consommer la nouvelle ligne après le nextInt()
        switch (choix) {
            case 1:
                System.out.print("Entrez le nouveau nom : ");
                nom = scanner.nextLine();
                break;
            case 2:
                System.out.print("Entrez le nouveau prénom : ");
                prenom = scanner.nextLine();
                break;
            case 3:
                System.out.print("Entrez le nouvel âge : ");
                age = scanner.nextInt();
                scanner.nextLine(); // consommer la nouvelle ligne après le nextInt()
                break;
            default:
                System.out.println("Choix invalide.");
                break;
        }
    }
}
