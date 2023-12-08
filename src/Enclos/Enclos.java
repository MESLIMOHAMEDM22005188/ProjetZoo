package src.Enclos;

import src.Creatures.CreatureFantastique;
import src.Creatures.Licorne;

import java.util.ArrayList;
import java.util.List;

public class Enclos {
    public static List<Enclos> EnclosList = new ArrayList<>();
    public static List<Enclos> SimpleEnclosList = new ArrayList<>();
    public static List<Enclos> EnclosVoltigeur = new ArrayList<>();

    public static List<Enclos> EnclosAquarium = new ArrayList<>();

    public String nomEnclos;
    private double superficie;
    public int capaciteMax;
    private int nombreCreaturesPresentes;
    private String degreProprete;
    private int indicateurProprete;

    // Constructeur prenant en compte les détails de l'enclos
    public Enclos(String nom, int capaciteMax) {
        this.nomEnclos = nomEnclos;
        this.superficie = superficie;
        this.capaciteMax = this.capaciteMax;
        this.nombreCreaturesPresentes = 0;
        this.degreProprete = "Propre";
        this.indicateurProprete = 100;
    }

    Enclos nouvelEnclos = new Enclos(nomEnclos, capaciteMax); // Créer un nouvel enclos avec les informations saisies
    // Méthode pour définir le nom de l'enclos
    public void setNomEnclos(String nomEnclos) {
        this.nomEnclos = nomEnclos;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public void setCapaciteMax(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

    public void setNombreCreaturesPresentes(int nombreCreaturesPresentes) {
        this.nombreCreaturesPresentes = nombreCreaturesPresentes;
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
    public boolean ajouterCreature(CreatureFantastique nouvelleCreature) {
        if (nombreCreaturesPresentes < capaciteMax) {
            nombreCreaturesPresentes++;
            System.out.println("Une créature a été ajoutée à l'enclos.");
        } else {
            System.out.println("L'enclos est plein. Impossible d'ajouter une nouvelle créature.");
        }
        return false;

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
    public static Enclos trouverEnclosParNom(String nomEnclos) {
        for (Enclos enclos : Enclos.EnclosList) {
            if (enclos.getNom().equalsIgnoreCase(nomEnclos)) {
                return enclos;
            }
        }
        return null;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public static List<Enclos> getEnclosList() {
        return EnclosList;
    }

    public static void setEnclosList(List<Enclos> enclosList) {
        Enclos.EnclosList = enclosList;
    }

    // Méthode pour définir le degré de propreté de l'enclos
    public void setProprete(String degreProprete) {
        this.degreProprete = degreProprete;
    }
    public String getProprete() {
        return degreProprete;
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

    public List<String> getEspecesPresentes() {
        return null;
    }

    public void nourrirCreatureParEspece(String especeNourrie) {
    }

    public CreatureFantastique getCreatureParNom(String nomCreature) {
        return null;
    }

    public void enleverCreature(CreatureFantastique creatureATransferer) {
    }
}
