package src.GestionZoo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Zoo {
    private String nom;
    private int age;
    private String prenom;

    public Zoo(String nom, String prenom, int age) {
        this.nom = nom;
    }

    public static void afficherOption() {
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

        Scanner scanner = new Scanner(System.in);
        Zoo zoo = new Zoo("Nom par défaut", "Prénom par défaut", 0);
        afficherJeu(zoo, scanner);
    }

    public static void afficherJeu( Zoo zoo, Scanner scanner) {
        zoo = new Zoo("Nom par défaut", "Prénom par défaut", 0);
        int option = 0;
        boolean isInvalidInput = true;

        while (isInvalidInput) {
            try {
                System.out.print("Entrez votre choix (de 1 à 9) : ");
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        ControleZoo.afficherInformationsZoo(scanner);
                        isInvalidInput = false;
                        break;
                    case 2:
                        ControleZoo.afficherDetailEnclos(scanner);
                        isInvalidInput = false;
                        break;
                    case 3:
                        // La variable "choix" n'est pas définie ici
                        ControleZoo.ExaminerEnclos(scanner, 'c'); // Remplacer 'c' par la valeur souhaitée pour "choix"
                        isInvalidInput = false;
                        break;
                    case 4:
                        ControleZoo.NettoyerEnclos(scanner);
                        isInvalidInput = false;
                        break;
                    case 5:
                        ControleZoo.NourrirCreature(scanner);
                        isInvalidInput = false;
                        break;
                    case 6:
                        ControleZoo.transfererCreature(scanner);
                        isInvalidInput = false;
                        break;
                    case 7:
                        ControleZoo.creerEnclos();
                        isInvalidInput = false;
                        break;
                    case 8:
                        ControleZoo.supprimerEnclos();
                        isInvalidInput = false;
                        break;
                    case 9:
                        ControleZoo.creerCreature(ControleZoo.EspeceCreatureEnum.class);
                        isInvalidInput = false;
                        break;
                    default:
                        System.err.println("ENTREZ UNE VALEUR CORRECT (de 1 à 9)");
                        break;
                }
            } catch (InputMismatchException e) {
                System.err.println("ENTREZ UN CHIFFRE VALIDE (de 1 à 9)");
                System.err.println("Entrez votre choix:");

                scanner.next();
            }
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
