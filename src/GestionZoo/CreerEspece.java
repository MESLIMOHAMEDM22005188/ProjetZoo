package src.GestionZoo;

import src.Creatures.CreatureFantastique;

import java.util.Scanner;

import static src.Enclos.Enclos.EnclosList;

public class CreerEspece {
    public static <EspeceCreature extends Enum<EspeceCreature>> void creerCreature(Class<EspeceCreature> enumType) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vous pouvez avoir des créatures fantastiques :");
        System.out.println("1. Licorne");
        System.out.println("2. Megalodon");
        System.out.println("3. Lycanthrope");
        System.out.println("4. Dragon");
        System.out.println("5. Sirène");
        System.out.println("6. Kraken");
        System.out.println("7. Nymphes");

        if (!EnclosList.isEmpty()) {
            System.out.println("Liste des enclos disponibles :");
            for (int i = 0; i < EnclosList.size(); i++) {
                System.out.println((i + 1) + ". " + EnclosList.get(i).getNom());
            }

            System.out.println("Entrez le numéro de l'enclos dans lequel vous souhaitez ajouter une créature :");
            int choixEnclosAjoutCreature = scanner.nextInt(); // Demander à l'utilisateur de choisir l'enclos

            if (choixEnclosAjoutCreature > 0 && choixEnclosAjoutCreature <= EnclosList.size()) {
                scanner.nextLine(); // Consommer la fin de la ligne après la saisie précédente

                EspeceCreature[] especes = enumType.getEnumConstants();

                System.out.println("Liste des espèces disponibles :");
                for (int i = 0; i < especes.length; i++) {
                    System.out.println((i + 1) + ". " + especes[i].name());
                }

                System.out.println("Entrez le numéro de l'espèce de la nouvelle créature :");
                int choixEspeceCreature = scanner.nextInt(); // Demander à l'utilisateur de choisir l'espèce de la créature

                if (choixEspeceCreature > 0 && choixEspeceCreature <= especes.length) {
                    EspeceCreature especeCreature = especes[choixEspeceCreature - 1];

                    System.out.println("Entrez le nom de la nouvelle créature :");
                    scanner.nextLine(); // Consommer la fin de la ligne après la saisie précédente
                    String nomCreature = scanner.nextLine(); // Saisir le nom de la créature

                    // Créer une nouvelle créature avec le nom, l'espèce et un sexe aléatoire
                    CreatureFantastique nouvelleCreature = CreatureFantastique.creerNouvelleCreature(especeCreature, nomCreature);

                    // Ajouter la nouvelle créature à l'enclos sélectionné
                    EnclosList.get(choixEnclosAjoutCreature - 1).ajouterCreature(nouvelleCreature);
                    System.out.println("La créature a été ajoutée avec succès à l'enclos "
                            + EnclosList.get(choixEnclosAjoutCreature - 1).getNom() + ".");
                } else {
                    System.out.println("Numéro d'espèce invalide.");
                }
            } else {
                System.out.println("Numéro d'enclos invalide.");
            }
        } else {
            System.out.println("Aucun enclos n'est disponible pour ajouter une créature.");
            System.out.println("Voulez-vous créer un enclos ? (Tapez 'z' pour oui, 'o' pour retourner à l'accueil)");

            scanner.nextLine(); // Consommer la fin de la ligne précédente
            char choix = scanner.nextLine().toLowerCase().charAt(0); // Lire et convertir en minuscule le premier caractère de l'entrée de l'utilisateur

            if (choix == 'z') {
                ControleZoo.creerEnclos();
            } else if (choix == 'o') {
                ControleZoo.retourAccueil(scanner);
            } else {
                System.err.println("faites un choix !");
            }
        }}
}