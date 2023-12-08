package src.Creatures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Représente une classe décrivant un Phénix.
 * Hérite de la classe Ovipaire et implémente les interfaces Voler et Imortel de CreatureFantastique.
 */
public class Phenix extends Ovipaire implements CreatureFantastique.Voler, CreatureFantastique.Imortel {

    // Constantes pour définir les caractéristiques du Phénix
    private static final double POIDS_NAISSANCE = 50;
    private static final double POIDS_MAXIMUM = 150;
    private static final double TAILLE_NAISSANCE = 15;
    private static final double TAILLE_MAXIMUM = 200;

    private List<Phenix> enfants;
    private static List<Phenix> adultes;
    private static List<Phenix> phenixes = new ArrayList<>();

    private int stade;

    /**
     * Constructeur pour créer une instance de Phénix.
     *
     * @param nomEspece
     *         Le nom de l'espèce du Phénix.
     * @param sexe
     *         Le sexe du Phénix ('M' pour mâle, 'F' pour femelle).
     * @param poids
     *         Le poids du Phénix.
     * @param taille
     *         La taille du Phénix.
     * @param age
     *         L'âge du Phénix.
     * @param indicateurFaim
     *         Indicateur de faim du Phénix.
     */
    public Phenix(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim);
        this.enfants = new ArrayList<>();

        if (adultes == null) {
            adultes = new ArrayList<>();
        }
    }

    /**
     * Crée un nouveau Phénix avec les paramètres spécifiés.
     *
     * @param nom
     *         Le nom du Phénix.
     * @param sexe
     *         Le sexe du Phénix.
     * @param poids
     *         Le poids du Phénix.
     * @param taille
     *         La taille du Phénix.
     * @param age
     *         L'âge du Phénix.
     *
     * @return Un nouveau Phénix créé avec les paramètres spécifiés.
     */
    public static Phenix creerPhenix(String nom, char sexe, double poids, double taille, int age) {
        double poidsNaissance = POIDS_NAISSANCE;
        double poidsMaximum = POIDS_MAXIMUM;

        if (sexe != 'M' && sexe != 'F') {
            Random rand = new Random();
            sexe = rand.nextBoolean() ? 'M' : 'F';
        }

        Phenix nouveauPhenix = new Phenix(nom, sexe, poids, taille, age, 0);

        phenixes.add(nouveauPhenix);

        return nouveauPhenix;
    }

    /**
     * Renvoie la liste des Phénix créés.
     *
     * @return La liste des Phénix.
     */
    public static List<Phenix> getPhenixes() {
        return phenixes;
    }

    /**
     * Permet au Phénix de se reproduire et renvoie un nouveau bébé Phénix.
     *
     * @return Le bébé Phénix créé suite à la reproduction.
     */
    public Phenix seReproduire() {
        if (adultes.contains(this)) {
            Random rand = new Random();
            char sexeEnfant = rand.nextBoolean() ? 'F' : 'M';
            double poidsEnfant = POIDS_NAISSANCE;
            Phenix bebePhenix = new Phenix("Bébé Phenix", sexeEnfant, poidsEnfant, 0.3, 0, 0) {
            };

            return bebePhenix;
        } else {
            System.out.println("Ce phénix n'est pas adulte et ne peut pas se reproduire !");
            return null;
        }
    }

    /**
     * Méthode pour émettre un son spécifique au Phénix.
     */
    @Override
    public void emettreSon() {
        System.out.println("Le phénix émet un chant mélodieux !");
    }

    /**
     * Méthode pour soigner le Phénix en augmentant son indicateur de santé.
     */
    @Override
    public void soigner() {
        int santeActuelle = getIndicateurSante();
        int santeAugmentee = santeActuelle + 20;

        if (santeAugmentee > 100) {
            santeAugmentee = 100;
        }

        setIndicateurSante(santeAugmentee);
        System.out.println("Le phénix a été soigné et sa santé a été augmentée !");
    }

    /**
     * {@inheritDoc}
     */
    List<String> especesVolantes = new ArrayList<>();
    @Override
    public List<String> getEspecesVolantes(){
        especesVolantes.add("Dragon");
        return especesVolantes;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setEspecesVolantes() {
        especesVolantes = new ArrayList<>();
        especesVolantes.add("Dragon");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> creerNouvelleCreature(Object... args) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mourirImo() {
        if (this.stade < 10) {
            System.out.println("La créature est morte.");
            this.stade++;
            System.out.println("La créature renaît et passe au stade " + this.stade);
        } else {
            System.out.println("La créature est morte après avoir atteint le 10ème stade.");
            // Si c'est le dernier stade, supprime ce dragon de la liste dragons
            phenixes.remove(this);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void naissance() {
        System.out.println("La créature est née !");
        this.stade = 1; // Initialiser la créature à son premier stade à la naissance
        phenixes.add(this); // Ajouter le dragon à la liste dragons lors de sa naissance
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getStade() {
        return this.stade;
    }
}
