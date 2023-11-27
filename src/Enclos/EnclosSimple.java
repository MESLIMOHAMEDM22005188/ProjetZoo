
package src.Enclos;
import  src.Creatures.CreatureFantastique;
public abstract class EnclosSimple extends  Enclos  {

    protected String nom;
    protected CreatureFantastique[] occupants;
    protected int capaciteMax;
    protected int nombreOccupants; // Ajout d'un compteur pour suivre le nombre d'occupants actuels

    protected int nombreOccupantsMax = 024;
    protected String etatProprete; // Ajout de l'état de propreté de l'enclos

    public EnclosSimple(String nom, int capaciteMax) {
        super();
        this.nom = nom;
        this.capaciteMax = capaciteMax;
        this.occupants = new CreatureFantastique[capaciteMax];
        this.nombreOccupants = 0; // Initialisation du compteur à zéro
        this.etatProprete = "Propre"; // Initialisation de l'état de propreté
    }

    public abstract void afficherType();

    public void nettoyerEnclos() {
        for (CreatureFantastique occupant : occupants) {
            if (occupant != null) {
                occupant.setIndicateurProprete(100); // Remettre l'indicateur de propreté à 100 pour tous les occupants
            }
        }
        this.etatProprete = "Propre"; // Mettre à jour l'état de propreté de l'enclos après le nettoyage
        System.out.println("L'enclos " + nom + " a été nettoyé.");
    }

    public void miseAJourSante() {
        for (CreatureFantastique occupant : occupants) {
            if (occupant != null) {
                occupant.updateSanteFromProprete(); // Mettre à jour la santé des occupants en fonction de la propreté
            }
        }
    }

    public void ajouterCreature(CreatureFantastique creature) {
        if (nombreOccupants < capaciteMax) { // Vérifier si l'enclos n'est pas plein
            occupants[nombreOccupants] = creature;
            nombreOccupants++;
            System.out.println(creature.getNomEspece() + " a été ajouté(e) à l'enclos " + nom + ".");
        } else {
            System.out.println("L'enclos " + nom + " est plein, impossible d'ajouter " + creature.getNomEspece() + ".");
        }
    }

    // Getter pour l'état de propreté de l'enclos
    public String getEtatProprete() {


        return etatProprete;
    }
}