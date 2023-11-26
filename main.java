import Creatures.CreatureFantastique;
import Enclos.Enclos;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Création d'une créature fantastique (exemple : dragon)
        CreatureFantastique creature = new CreatureFantastique("Dragon", 'M', 150, 5, 10, 10, 500, 20, 50) {
            @Override
            public void setIndicateurProprete(int i) {

            }

            @Override
            public void emettreSon() {

            }

            @Override
            public void soigner() {

            }
        };

        // Création de l'enclos
        Enclos enclos = new Enclos();
        enclos.definirNomEnclos("Enclos des Dragons");

        boolean continuer = true;

        while (continuer) {
            System.out.println("\nQue souhaitez-vous faire ?");
            System.out.println("1. Afficher les caractéristiques de la créature");
            System.out.println("2. Afficher les caractéristiques de l'enclos");
            System.out.println("3. Ajouter une créature à l'enclos");
            System.out.println("4. Nourrir les créatures dans l'enclos");
            System.out.println("5. Quitter");

            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.println("\nCaractéristiques de la créature :");
                    System.out.println("Nom : " + creature.getNom());
                    System.out.println("Sexe : " + creature.getSexe());
                    System.out.println("Poids : " + creature.getPoids());
                    // Afficher d'autres caractéristiques si nécessaire
                    break;
                case 2:
                    System.out.println("\nCaractéristiques de l'enclos :");
                    enclos.afficherCaracteristiques();
                    break;
                case 3:
                    enclos.ajouterCreature();
                    break;
                case 4:
                    enclos.nourrirCreatures();
                    break;
                case 5:
                    continuer = false;
                    System.out.println("Fin du programme.");
                    break;
                default:
                    System.out.println("Choix invalide.");
                    break;
            }
        }

        scanner.close();
    }
}
