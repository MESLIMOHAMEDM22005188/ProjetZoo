package src.Creatures;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe Licorne représente une créature fantastique du monde magique.
 *
 * Elle hérite de la classe CreatureFantastique et implémente l'interface Courrir.
 */
public abstract class Licorne extends Vivipaire  {

    // Constantes pour les caractéristiques de la Licorne
    private static double POIDS_NAISSANCE = 60;
    private static double POIDS_MAXIMUM = 90;
    private static final double TAILLE_NAISSANCE = 1.70;
    private static final double TAILLE_MAXIMUM = 200;

    // Listes pour stocker les Licornes et leurs enfants
    private List<Licorne> enfants;
    private static List<Licorne> adultes;
    private static List<Licorne> licornes = new ArrayList<>(); // Champ statique pour stocker toutes les licornes créées

    /**
     * Constructeur de la classe Licorne.
     * @param nomEspece Nom de l'espèce de la Licorne.
     * @param sexe Sexe de la Licorne ('M' pour mâle, 'F' pour femelle).
     * @param poids Poids de la Licorne.
     * @param taille Taille de la Licorne.
     * @param age Âge de la Licorne.
     * @param indicateurFaim Indicateur de faim de la Licorne.
     * @param indicateurSommeil Indicateur de sommeil de la Licorne.
     * @param indicateurSante Indicateur de santé de la Licorne.
     * @param poidsNaissance Poids à la naissance de la Licorne.
     * @param poidsMaximum Poids maximum que peut atteindre la Licorne.
     */
    public Licorne(String nomEspece, char sexe, double poids, double taille, int age,
                   int indicateurFaim, int indicateurSommeil, int indicateurSante,
                   double poidsNaissance, double poidsMaximum) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim, indicateurSommeil, indicateurSante);
        this.POIDS_NAISSANCE = poidsNaissance;
        this.POIDS_MAXIMUM = poidsMaximum;
        this.enfants = new ArrayList<>();

        if (adultes == null) {
            adultes = new ArrayList<>();
        }
    }
    /**
     * Méthode à implémenter pour définir les espèces en cours.
     */
    public void setEspecesCours() {
        // À compléter : logique pour définir les espèces en cours pour les Licornes
    }

    // Autres méthodes spécifiques aux Licornes à implémenter
}
