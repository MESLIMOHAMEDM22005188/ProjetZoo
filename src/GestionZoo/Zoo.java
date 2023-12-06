package src.GestionZoo;

import src.Creatures.CreatureFantastique;
import src.Creatures.NomEspece;
import src.Enclos.Enclos;

import java.util.Scanner;

import static src.Enclos.Enclos.trouverEnclosParNom;

public class Zoo {
    private static String nom;
    private static int age;
    private String prenom;

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
        afficherJeu(nom, age, scanner, zoo);
    }

    public static void choix (){
    }
        public static void afficherJeu(String nom, int age, Scanner scanner, Zoo zoo) {
            scanner = new Scanner(System.in);
            zoo = new Zoo("Nom par défaut", "Prénom par défaut", 0);
            nom = zoo.getNom();
            age = zoo.age;
            char choix = scanner.next().charAt(0);
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    ControleZoo.afficherInformationsZoo( nom, age, scanner); // Appel corrigé avec les arguments nécessaires
                    break;
                case 2:
                    ControleZoo.afficherDetailEnclos(scanner, choix); // Appel corrigé avec les arguments nécessaires
                    break;
                case 3:
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
                    break;

                case 4:
                    System.out.println("Nettoyer un enclos :");
                    if (!Enclos.EnclosList.isEmpty()) {
                        System.out.println("Liste des enclos disponibles :");
                        for (int i = 0; i < Enclos.EnclosList.size(); i++) {
                            System.out.println((i + 1) + ". " + Enclos.EnclosList.get(i).getNom());
                        }

                        System.out.println("Entrez le numéro de l'enclos que vous souhaitez nettoyer :");
                        int choixEnclos = scanner.nextInt(); // Demander à l'utilisateur de choisir l'enclos

                        if (choixEnclos > 0 && choixEnclos <= Enclos.EnclosList.size()) {
                            Enclos enclosANettoyer = Enclos.EnclosList.get(choixEnclos - 1);

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
                    break;
                case 5:
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
                            enclosANourrir.nourrirCreatures();
                            System.out.println("Les créatures de l'enclos " + enclosANourrir.getNom() + " ont été nourries.");
                        } else {
                            System.out.println("Numéro d'enclos invalide.");
                        }
                    } else {
                        System.out.println("Aucun enclos n'est disponible pour nourrir les créatures.");
                    }
                    break;

                case 6:
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
                            enclosANourrir.nourrirCreatures();
                            System.out.println("Les créatures de l'enclos " + enclosANourrir.getNom() + " ont été nourries.");
                        } else {
                            System.out.println("Numéro d'enclos invalide.");
                        }
                    } else {
                        System.out.println("Aucun enclos n'est disponible pour nourrir les créatures.");
                    }
                    break;

                case 7:
                    System.out.println("Créer un nouvel enclos :");
                    scanner.nextLine(); // Pour consommer la fin de la ligne après la saisie précédente

                    System.out.println("Entrez le nom du nouvel enclos :");
                    String nomEnclos = scanner.nextLine(); // Demander à l'utilisateur de saisir le nom de l'enclos

                    System.out.println("Entrez la superficie du nouvel enclos (en m²) :");
                    double superficieEnclos = scanner.nextDouble(); // Demander à l'utilisateur de saisir la superficie

                    System.out.println("Entrez la capacité maximale du nouvel enclos :");
                    int capaciteMaxEnclos = scanner.nextInt(); // Demander à l'utilisateur de saisir la capacité maximale

                    Enclos nouvelEnclos = new Enclos(); // Créer une nouvelle instance de la classe Enclos
                    nouvelEnclos.setNomEnclos(nomEnclos); // Définir le nom de l'enclos
                    nouvelEnclos.setSuperficie(superficieEnclos); // Définir la superficie de l'enclos
                    nouvelEnclos.setCapaciteMax(capaciteMaxEnclos); // Définir la capacité maximale de l'enclos

                    Enclos.EnclosList.add(nouvelEnclos); // Ajouter le nouvel enclos à la liste des enclos existants
                    System.out.println("Le nouvel enclos a été créé avec succès.");
                    break;

                case 8:
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
                    break;

                case 9:
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
                    break;

                default:
                    System.out.println("Option invalide.");
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
