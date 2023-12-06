package src.GestionZoo;

import src.Creatures.CreatureFantastique;
import src.Creatures.NomEspece;
import src.Enclos.Enclos;

import java.util.List;
import java.util.Scanner;

import static src.Enclos.Enclos.EnclosList;
import static src.Enclos.Enclos.trouverEnclosParNom;

public class ControleZoo {

    static char choix = ' '; // Déclarer la variable choix comme statique

    public static void afficherInformationsZoo(String nom, int age, Scanner scanner) {

        System.out.println("\nInformations sur le zoo :");
        if (!EnclosList.isEmpty()) {
            for (Enclos enclos : EnclosList) {
                System.out.println("- Nom de l'enclos : " + enclos.getNom());
                System.out.println("  Nombre de créatures : " + enclos.getNombreCreaturesPresentes());
            }
        } else {
            System.out.println("Vous ne disposez d'aucun enclos.");
        }

        System.out.println("\nInformations sur les créatures fantastiques :");
        if (!CreatureFantastique.Creature.isEmpty()) {
            for (CreatureFantastique creature : CreatureFantastique.Creature) {
                System.out.println("- Nom de la créature : " + creature.getNom());
                // Ajoutez d'autres informations de la créature fantastique si nécessaire
            }
        } else {
            System.out.println("Aucune créature fantastique n'est présente.");
        }

        retourAccueil(scanner);
    }


    public static void afficherDetailEnclos(Scanner scanner) {
        System.out.println("\nDétails des enclos :");
        for (Enclos enclos : EnclosList) {
            System.out.println("- " + enclos.getNom());
        }
        System.out.println("\nSélectionner un enclos :");
        String choix = scanner.nextLine();
        Enclos enclosSelectionne = trouverEnclosParNom(choix);
        if (enclosSelectionne != null) {
            enclosSelectionne.afficherCaracteristiques();
            // Vous pouvez ajouter d'autres informations spécifiques à l'enclos ici si nécessaire
        } else {
            System.out.println("L'enclos spécifié n'a pas été trouvé.");
        }
        retourAccueil(scanner);

    }

    public static void ExaminerEnclos(Scanner scanner, char choix) {
        System.out.println("Examiner un enclos :");
        if (!Enclos.EnclosList.isEmpty()) {
            System.out.println("Liste des enclos disponibles :");
            for (Enclos enclos : Enclos.EnclosList) {
                System.out.println("- " + enclos.getNom());
            }

            System.out.println("Entrez le nom de l'enclos que vous souhaitez examiner :");
            String nomEnclos = scanner.nextLine(); // Demander à l'utilisateur de saisir le nom de l'enclos

            Enclos enclosExamine = trouverEnclosParNom(nomEnclos);

            if (enclosExamine != null) {
                enclosExamine.afficherCaracteristiques();
                // Vous pouvez ajouter d'autres actions pour examiner cet enclos, selon vos besoins.
            } else {
                System.out.println("L'enclos avec le nom spécifié n'existe pas.");
            }
        } else {
            System.out.println("Aucun enclos n'est disponible.");
        }
        retourAccueil(scanner);

    }
    public static void NourrirCreature(Scanner scanner) {
        System.out.println("Nourrir les créatures :");
        if (!Enclos.EnclosList.isEmpty()) {
            System.out.println("Liste des enclos disponibles :");
            for (int i = 0; i < Enclos.EnclosList.size(); i++) {
                System.out.println((i + 1) + ". " + Enclos.EnclosList.get(i).getNom());
            }

            System.out.println("Entrez le numéro de l'enclos dont vous voulez nourrir les créatures :");
            int choixEnclos = scanner.nextInt(); // Demander à l'utilisateur de choisir l'enclos

            if (choixEnclos > 0 && choixEnclos <= Enclos.EnclosList.size()) {
                Enclos enclosANourrir = Enclos.EnclosList.get(choixEnclos - 1);

                System.out.println("Choisissez l'espèce à nourrir dans l'enclos " + enclosANourrir.getNom() + ":");
                List<String> especes = enclosANourrir.getEspecesPresentes();
                for (int i = 0; i < especes.size(); i++) {
                    System.out.println((i + 1) + ". " + especes.get(i));
                }

                int choixEspece = scanner.nextInt(); // Demander à l'utilisateur de choisir l'espèce à nourrir

                if (choixEspece > 0 && choixEspece <= especes.size()) {
                    String especeNourrie = especes.get(choixEspece - 1);
                    enclosANourrir.nourrirCreatureParEspece(especeNourrie);
                    System.out.println("Les créatures de l'espèce " + especeNourrie + " dans l'enclos " + enclosANourrir.getNom() + " ont été nourries.");
                } else {
                    System.out.println("Numéro d'espèce invalide.");
                }
            } else {
                System.out.println("Numéro d'enclos invalide.");
            }
        } else {
            System.out.println("Aucun enclos n'est disponible pour nourrir les créatures.");
        }
        retourAccueil(scanner);

    }


    public static void NettoyerEnclos(Scanner scanner) {
        System.out.println("Nettoyer un enclos :");

        if (!Enclos.getEnclosList().isEmpty()) {
            System.out.println("Liste des enclos disponibles :");
            for (int i = 0; i < Enclos.getEnclosList().size(); i++) {
                System.out.println((i + 1) + ". " + Enclos.getEnclosList().get(i).getNom());
            }

            System.out.println("Entrez le numéro de l'enclos que vous souhaitez nettoyer :");
            int choixEnclos = scanner.nextInt(); // Demander à l'utilisateur de choisir l'enclos
            scanner.nextLine(); // Consommer la nouvelle ligne

            if (choixEnclos > 0 && choixEnclos <= Enclos.getEnclosList().size()) {
                Enclos enclosANettoyer = Enclos.getEnclosList().get(choixEnclos - 1);

                if (enclosANettoyer.getProprete().equalsIgnoreCase("Propre")) {
                    System.out.println("L'enclos " + enclosANettoyer.getNom() + " est déjà propre.");
                } else {
                    enclosANettoyer.setProprete("Propre");
                    System.out.println("L'enclos " + enclosANettoyer.getNom() + " a été nettoyé.");
                }
            } else {
                System.out.println("Numéro d'enclos invalide.");
            }
        } else {
            System.out.println("Aucun enclos n'est disponible.");
        }
        retourAccueil(scanner);

    }
    public static void transfererCreature(Scanner scanner) {
        System.out.println("Transférer une créature d’un enclos à un autre :");
        if (!Enclos.EnclosList.isEmpty()) {
            System.out.println("Liste des enclos disponibles :");
            for (int i = 0; i < Enclos.EnclosList.size(); i++) {
                System.out.println((i + 1) + ". " + Enclos.EnclosList.get(i).getNom());
            }
            System.out.println("Entrez le numéro de l'enclos source :");
            int choixEnclosSource = scanner.nextInt(); // Demander à l'utilisateur de choisir l'enclos source

            if (choixEnclosSource > 0 && choixEnclosSource <= Enclos.EnclosList.size()) {
                Enclos enclosSource = Enclos.EnclosList.get(choixEnclosSource - 1);
                System.out.println("Entrez le numéro de l'enclos cible :");
                int choixEnclosCible = scanner.nextInt(); // Demander à l'utilisateur de choisir l'enclos cible

                if (choixEnclosCible > 0 && choixEnclosCible <= Enclos.EnclosList.size()) {
                    Enclos enclosCible = Enclos.EnclosList.get(choixEnclosCible - 1);

                    System.out.println("Entrez le nom de la créature à transférer :");
                    scanner.nextLine(); // Consommer la nouvelle ligne
                    String nomCreature = scanner.nextLine();

                    CreatureFantastique creatureATransferer = enclosSource.getCreatureParNom(nomCreature);

                    if (creatureATransferer != null) {
                        if (enclosCible.ajouterCreature(creatureATransferer)) {
                            enclosSource.enleverCreature(creatureATransferer);
                            System.out.println("La créature " + nomCreature + " a été transférée de l'enclos " +
                                    enclosSource.getNom() + " à l'enclos " + enclosCible.getNom() + ".");
                                } else {
                                    System.out.println("L'enclos cible est plein. Transfert impossible.");
                                }
                            } else {
                                System.out.println("La créature spécifiée n'existe pas dans l'enclos source.");
                            }
                        } else {
                            System.out.println("Numéro d'enclos cible invalide.");
                        }
                    } else {
                        System.out.println("Numéro d'enclos source invalide.");
                    }
                } else {
                    System.out.println("Aucun enclos n'est disponible pour le transfert de créatures.");
                    retourAccueil(scanner);
        }

    }
    public  static void creerEnclos() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Créer un nouvel enclos :");

        // Consommer la fin de la ligne après la saisie précédente
        scanner.nextLine();
        System.out.println("Entrez le nom du nouvel enclos :");
        String nomEnclos = scanner.nextLine(); // Demander à l'utilisateur de saisir le nom de l'enclos

        System.out.println("Entrez la superficie du nouvel enclos (en m²) :");
        double superficieEnclos = scanner.nextDouble(); // Demander à l'utilisateur de saisir la superficie

        Enclos nouvelEnclos = new Enclos(); // Créer une nouvelle instance de la classe Enclos
        nouvelEnclos.setNomEnclos(nomEnclos); // Définir le nom de l'enclos
        Enclos.EnclosList.add(nouvelEnclos); // Ajouter le nouvel enclos à la liste des enclos existants
        System.out.println("Le nouvel enclos a été créé avec succès.");
    }

    public static void acheterCreature(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Acheter une nouvelle créature pour un enclos :");
        if (!Enclos.EnclosList.isEmpty()) {
            System.out.println("Liste des enclos disponibles :");
            for (int i = 0; i < Enclos.EnclosList.size(); i++) {
                System.out.println((i + 1) + ". " + Enclos.EnclosList.get(i).getNom());
            }

            System.out.println("Entrez le numéro de l'enclos dans lequel vous souhaitez ajouter une créature :");
            int choixEnclosAjoutCreature = scanner.nextInt(); // Demander à l'utilisateur de choisir l'enclos

            if (choixEnclosAjoutCreature > 0 && choixEnclosAjoutCreature <= Enclos.EnclosList.size()) {
                scanner.nextLine(); // Consommer la fin de la ligne après la saisie précédente

                System.out.println("Liste des espèces disponibles :");
                for (NomEspece espece : NomEspece.values()) {
                    System.out.println(espece.ordinal() + 1 + ". " + espece.name());
                }

                System.out.println("Entrez le numéro de l'espèce de la nouvelle créature :");
                int choixEspeceCreature = scanner.nextInt(); // Demander à l'utilisateur de choisir l'espèce de la créature

                if (choixEspeceCreature > 0 && choixEspeceCreature <= NomEspece.values().length) {
                    NomEspece especeCreature = NomEspece.values()[choixEspeceCreature - 1];

                    System.out.println("Entrez le nom de la nouvelle créature :");
                    scanner.nextLine(); // Consommer la fin de la ligne après la saisie précédente
                    String nomCreature = scanner.nextLine(); // Saisir le nom de la créature

                    // Créer une nouvelle créature avec le nom, l'espèce et un sexe aléatoire
                    CreatureFantastique nouvelleCreature = CreatureFantastique.creerNouvelleCreature(especeCreature, nomCreature);

                    // Ajouter la nouvelle créature à l'enclos sélectionné
                    Enclos.EnclosList.get(choixEnclosAjoutCreature - 1).ajouterCreature(nouvelleCreature);
                    System.out.println("La créature a été ajoutée avec succès à l'enclos "
                            + Enclos.EnclosList.get(choixEnclosAjoutCreature - 1).getNom() + ".");
                } else {
                    System.out.println("Numéro d'espèce invalide.");
                }
            } else {
                System.out.println("Numéro d'enclos invalide.");
            }
        } else {
            System.out.println("Aucun enclos n'est disponible pour ajouter une créature.");
        }

        System.out.println("Option invalide.");
    }
    public static void supprimerEnclos(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Supprimer un enclos :");
        if (!Enclos.EnclosList.isEmpty()) {
            System.out.println("Liste des enclos disponibles :");
            for (int i = 0; i < Enclos.EnclosList.size(); i++) {
                System.out.println((i + 1) + ". " + Enclos.EnclosList.get(i).getNom());
            }

            System.out.println("Entrez le numéro de l'enclos que vous souhaitez supprimer :");
            int choixEnclosASupprimer = scanner.nextInt(); // Demander à l'utilisateur de choisir l'enclos à supprimer

            if (choixEnclosASupprimer > 0 && choixEnclosASupprimer <= Enclos.EnclosList.size()) {
                Enclos enclosASupprimer = Enclos.EnclosList.remove(choixEnclosASupprimer - 1);
                System.out.println("L'enclos " + enclosASupprimer.getNom() + " a été supprimé avec succès.");
            } else {
                System.out.println("Numéro d'enclos invalide.");
            }
        } else {
            System.out.println("Aucun enclos n'est disponible pour la suppression.");
        }
    }

    public static char retourAccueil(Scanner scanner) {
        System.out.println("\nRetourner à l'accueil ? (Appuyez sur 'o' pour oui) : ");
        char choixRetour = scanner.next().charAt(0);
        if (choixRetour == 'o' || choixRetour == 'O') {

            Zoo.afficherOption();
        }
        return choixRetour;
    }
}
