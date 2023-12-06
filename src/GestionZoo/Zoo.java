package src.GestionZoo;

import java.util.Scanner;

import static src.GestionZoo.ControleZoo.choix;

public class Zoo {
    private static String nom;
    private static int age;
    private String prenom;
    private static Zoo zoo;
    public Zoo(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }


    public static void afficherOption(){
        System.out.println("Choisissez une option : ");
        System.out.println("1. Voir ensemble du zoo");
        System.out.println("2. Voir les enclos");
        System.out.println("3. Examiner un enclos");
        System.out.println("4. Nettoyer un enclos");
        System.out.println("5. Nourrir les créatures");
        System.out.println("6. Transférer une créature d’un enclos à un autre");
        System.out.println("7. Créer un enclos");
        System.out.println("8. Fermer un enclos");
        System.out.println("9. Acheter une créature");

        Scanner scanner = null;
        Zoo zoo = null;
        afficherJeu(nom, age, zoo);
    }
    public static void afficherJeu(String nom, int age, Zoo zoo) {
        Scanner scanner = new Scanner(System.in);
            Zoo.zoo = new Zoo("Nom par défaut", "Prénom par défaut", 0);
            Zoo.nom = Zoo.zoo.getNom();
            Zoo.age = Zoo.zoo.age;
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    ControleZoo.afficherInformationsZoo(Zoo.nom, Zoo.age, scanner); // Appel corrigé avec les arguments nécessaires
                    break;
                case 2:
                    ControleZoo.afficherDetailEnclos(scanner); // Appel corrigé avec les arguments nécessaires
                    break;
                case 3:
                    ControleZoo.ExaminerEnclos(scanner, choix);
                    break;
                case 4:
                    ControleZoo.NettoyerEnclos(scanner);
                    break;
                case 5:
                    ControleZoo.NourrirCreature(scanner);
                    break;
                case 6:
                    ControleZoo.transfererCreature(scanner);
                    break;
                case 7:
                    ControleZoo.creerEnclos();
                    break;
                case 8:
                    ControleZoo.supprimerEnclos();
                case 9:
                    ControleZoo.acheterCreature();
                    break;
            }
            if ((choix == 'o' || choix == 'O')) {
                afficherOption();
            }
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


    public String getNom() {
        return nom;
    }
}
