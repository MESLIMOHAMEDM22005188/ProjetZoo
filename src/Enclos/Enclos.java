package src.Enclos;

import src.Creatures.Licorne;

public class Enclos {
    private String nomEnclos;
    private double superficie;
    private int capaciteMax;
    private int nombreCreaturesPresentes;
    private String degreProprete;
    private int indicateurProprete;

    // Constructeur prenant en compte les détails de l'enclos
    public Enclos() {
        this.nomEnclos = nomEnclos;
        this.superficie = superficie;
        this.capaciteMax = capaciteMax;
        this.nombreCreaturesPresentes = 0;
        this.degreProprete = "Propre";
        this.indicateurProprete = 100;
    }

    // Méthode pour définir le nom de l'enclos
    public void setNomEnclos(String nomEnclos) {
        this.nomEnclos = nomEnclos;
    }

    // Méthode pour définir le nom de l'enclos
    public void definirNomEnclos(String nomEnclos) {
        this.nomEnclos = nomEnclos;
    }

    // Afficher les caractéristiques de l'enclos
    public void afficherCaracteristiques() {
        System.out.println("Nom: " + nomEnclos);
        System.out.println("Superficie: " + superficie + " m²");
        System.out.println("Capacité maximale: " + capaciteMax + " créatures");
        System.out.println("Nombre de créatures présentes: " + nombreCreaturesPresentes);
        System.out.println("Degré de propreté: " + degreProprete);
    }

    // Ajouter une créature à l'enclos
    public void ajouterCreature() {
        if (nombreCreaturesPresentes < capaciteMax) {
            nombreCreaturesPresentes++;
            System.out.println("Une créature a été ajoutée à l'enclos.");
        } else {
            System.out.println("L'enclos est plein. Impossible d'ajouter une nouvelle créature.");
        }
    }

    // Enlever une créature de l'enclos
    public void enleverCreature() {
        if (nombreCreaturesPresentes > 0) {
            nombreCreaturesPresentes--;
            System.out.println("Une créature a été enlevée de l'enclos.");
        } else {
            System.out.println("L'enclos est vide. Aucune créature à enlever.");
        }
    }

    // Nourrir les créatures
    public void nourrirCreatures() {
        System.out.println("Les créatures de l'enclos ont été nourries.");
    }

    // Vérifier la propreté et le vide de l'enclos
    public void verifierPropreteEtVide() {
        if (nombreCreaturesPresentes == 0) {
            System.out.println("L'enclos est vide.");
        }

        if (degreProprete.equals("Sale")) {
            System.out.println("L'enclos est sale. Il a besoin d'être nettoyé.");
        }
    }

    // Méthode pour définir le degré de propreté de l'enclos
    public void setProprete(String degreProprete) {
        this.degreProprete = degreProprete;
    }

    // Méthode pour obtenir le nom de l'enclos
    public String getNom() {
        return nomEnclos;
    }

    // Méthode pour obtenir le nombre de créatures présentes
    public int getNombreCreaturesPresentes() {
        return nombreCreaturesPresentes;
    }


    public String getType() {
        return null;
    }

    public void ajouterCreature(Licorne creature) {
    }
}
