package src.Enclos;

import src.Creatures.CreatureFantastique;

import java.util.ArrayList;
import java.util.List;

public abstract class EnclosSimple extends Enclos {
    private List<CreatureFantastique> creaturesEnclosSimple;
    public static List<String> nomsEnclosSimpleCrees = new ArrayList<>();

    // Méthode pour ajouter un nom d'enclos à la liste
    public static void ajouterNomEnclos(String nomEnclos) {
        nomsEnclosSimpleCrees.add(nomEnclos);
    }

    // Méthode pour obtenir la liste des noms d'enclos créés
    public static List<String> getNomsEnclosCrees() {
        return nomsEnclosSimpleCrees;
    }

    protected String nom;
    protected CreatureFantastique[] occupants;
    protected int capaciteMax;

    protected int nombreOccupants;

    protected int nombreOccupantsMax = 024;
    protected String etatProprete;

    public EnclosSimple(String nom, int capaciteMax) {
        super(nom, capaciteMax);
        this.nom = nom;
        this.capaciteMax = capaciteMax;
        this.occupants = new CreatureFantastique[capaciteMax];
        this.nombreOccupants = 0; // Initialisation du compteur à zéro
        this.etatProprete = "Propre"; // Initialisation de l'état de propreté
    }

    public void nettoyerEnclos() {
        for (CreatureFantastique occupant : occupants) {
            if (occupant != null) {
            }
        }
        this.etatProprete = "Propre"; // Mettre à jour l'état de propreté de l'enclos après le nettoyage
        System.out.println("L'enclos " + nom + " a été nettoyé.");
    }


    public boolean ajouterCreature(CreatureFantastique creature) {
        if (nombreOccupants < capaciteMax) { // Vérifier si l'enclos n'est pas plein
            occupants[nombreOccupants] = creature;
            nombreOccupants++;
            System.out.printf("%s a été ajouté(e) à l'enclos %s.%n", creature.getNomEspece(), nom);
        } else {
            System.out.println("L'enclos " + nom + " est plein, impossible d'ajouter " + creature.getNomEspece() + ".");
        }
        return false;
    }

    // Getter pour l'état de propreté de l'enclos
    public String getEtatProprete() {


        return etatProprete;
    }
}