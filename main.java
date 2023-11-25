import Creatures.CreatureFantastique;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Création d'une nouvelle créature fantastique...");
        System.out.println("Choisissez le type de créature parmi les options suivantes :");
        System.out.println("DRAGONS, KRAKENS, LICORNES, LYCANTHROPES, MEGALODONS, NYMPHES, PHENIX, SIRENES");
        System.out.print("Entrez le type de créature : ");
        String typeCreature = scanner.nextLine();

        nom nom;
        try {
            nom = noom.valueOf(typeCreature.toUpperCase());
            Creature creature = CreatureFactory.createCreature(nomEspece);
            System.out.println("Créature fantastique créée : " + creature.getNom());
        } catch (IllegalArgumentException e) {
            System.err.println("Type de créature incorrect !");
        }

        scanner.close();
    }
}
