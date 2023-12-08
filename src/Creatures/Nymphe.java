package src.Creatures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Représente une classe décrivant une créature fantastique appelée Nymphe.
 * Hérite de la classe Vivipaire et implémente les interfaces Courrir et Imortel de CreatureFantastique.
 */
public class Nymphe extends Vivipaire implements CreatureFantastique.Courrir, CreatureFantastique.Imortel {
    private static final double POIDS_NAISSANCE = 60;
    private static final double POIDS_MAXIMUM = 90;
    private static final double TAILLE_NAISSANCE = 17;
    private static final double TAILLE_MAXIMUM = 200;

    // Listes pour stocker les Nymphes et leurs enfants
    private final List<Nymphe> enfants;
    private static List<Nymphe> adultes;
    private static List<Nymphe> nymphes = new ArrayList<>(); // Champ statique pour stocker toutes les nymphes créées

    private int stade;
    /**
     * Constructeur pour créer une instance de Nymphe.
     *
     * @param nomEspece         Le nom de l'espèce de la nymphe.
     * @param sexe              Le sexe de la nymphe ('M' pour mâle, 'F' pour femelle).
     * @param poids             Le poids de la nymphe.
     * @param taille            La taille de la nymphe.
     * @param age               L'âge de la nymphe.
     * @param indicateurFaim    Indicateur de faim de la nymphe.
     * @param indicateurSommeil Indicateur de sommeil de la nymphe.
     * @param indicateurSante   Indicateur de santé de la nymphe.
     * @param poidsNaissance
     * @param poidsMaximum
     */
    public Nymphe(String nomEspece, char sexe, double poids, double taille, int age,
                  int indicateurFaim, int indicateurSommeil, int indicateurSante, double poidsNaissance, double poidsMaximum) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim, indicateurSommeil, indicateurSante);
        this.enfants = new ArrayList<>();

        if (adultes == null) {
            adultes = new ArrayList<>();
        }
    }

    public Nymphe(String nomEspece, char sexeEnfant, double poidsEnfant, double taille, int age, int indicateurFaim, int indicateurSommeil, List<Nymphe> enfants) {
        super(nomEspece);
        this.enfants = enfants;
    }

    /**
 * Méthode de reproduction pour un lycanthrope.
 * @return Le nouveau lycanthrope issu de la reproduction ou null si le lycanthrope ne peut pas se reproduire.
 */
    public Nymphe seReproduire() {
        Nymphe result;
        if (adultes.contains(this)) {
            Random rand = new Random();
            char sexeEnfant = rand.nextBoolean() ? 'F' : 'M';
            double poidsEnfant = POIDS_NAISSANCE;
            Nymphe bebeNymphe = new Nymphe("Bébé Nymphe", sexeEnfant, poidsEnfant, 0.5, 0, 0, 0, enfants) {};
            enfants.add(bebeNymphe);
            result = bebeNymphe;
        } else {
            System.out.println("Cette Nymphe n'est pas adulte et ne peut pas se reproduire !");
            result = null;
        }
        return result;
    }
    @Override
    public void emettreSon() {
        // Si le dragon a faim, il émet un cri spécifique
        if (getIndicateurFaim() > 50) {
            System.out.println("Le dragon émet un grognement de faim !");
        }

        // Si le dragon est fatigué, il émet un son différent
        if (getIndicateurSommeil() < 30) {
            System.out.println("Le dragon bâille bruyamment et émet un son de fatigue !");
        }

        // Si le dragon n'est pas en bonne santé, il émet un son indiquant sa souffrance
        if (getIndicateurSante() < 50) {
            System.out.println("Le dragon émet un cri de douleur !");
        }

        // Sinon, le dragon émet un son standard
        System.out.println("Le dragon émet un rugissement majestueux !");
    }
    /**
     * Méthode pour émettre un son en fonction de l'état du dragon.
     * Le dragon émet différents sons en fonction de ses indicateurs de faim, sommeil et santé.
     */

    @Override
    public void soigner() {
        // Augmenter la santé du dragon lorsqu'il est soigné
        int santeActuelle = getIndicateurSante();
        int santeAugmentee = santeActuelle + 20; // Augmentation de 20 pour l'exemple

        // Limiter la santé maximale à 100
        if (santeAugmentee > 100) {
            santeAugmentee = 100;
        }

        setIndicateurSante(santeAugmentee); // Met à jour la santé du dragon
        System.out.println("Le dragon a été soigné et sa santé a été augmentée !");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getEspecesCours() {
        return null;
    }
    List<String> especesCours;

    /**
     * {@inheritDoc}
     */
    @Override
    public void setEspecesCours() {
        especesCours = new ArrayList<>();
        especesCours.add("Nymphes");
    }

    /**
     * Méthode spécifique pour gérer le vieillissement d'une Nymphe.
     */
    @Override
    public void vieillir() {
        if (getAge() >= 5) {
            this.taille = TAILLE_MAXIMUM;
            this.poids = POIDS_MAXIMUM;
            if (!adultes.contains(this)) {
                adultes.add(this);
            }
        }
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
    public void naissance() {
        // Actions à effectuer lors de la naissance d'une nymphe
        System.out.println("Une nymphe est née !");
    }

    /**
     *
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
            nymphes.remove(this);
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getStade() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void canMettreBas() {
        // Méthode pour vérifier si la nymphe peut mettre bas
        // ...
    }
}
