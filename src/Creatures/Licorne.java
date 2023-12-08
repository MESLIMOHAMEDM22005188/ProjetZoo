package src.Creatures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * La classe Licorne représente une créature fantastique du monde magique.
 *
 * Elle hérite de la classe CreatureFantastique et implémente l'interface Courrir.
 */
public  class Licorne extends Vivipaire implements CreatureFantastique.Courrir, CreatureFantastique.Mortel {

    // Constantes pour les caractéristiques de la Licorne
    private static double POIDS_NAISSANCE = 60;
    private static double POIDS_MAXIMUM = 90;
    private static final double TAILLE_NAISSANCE = 17;
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
    } /**
     * Méthode de reproduction pour un lycanthrope.
     * @return Le nouveau lycanthrope issu de la reproduction ou null si le lycanthrope ne peut pas se reproduire.
     */
    public Licorne seReproduire() {
        if (adultes.contains(this)) {
            Random rand = new Random();
            char sexeEnfant = rand.nextBoolean() ? 'F' : 'M';
            double poidsEnfant = POIDS_NAISSANCE;
            Licorne bebeLicorne = new Licorne("Bébé Lycanthrope", sexeEnfant, poidsEnfant, 0.5, 0, 0, 0, getAge(), POIDS_NAISSANCE, POIDS_MAXIMUM) {};
            enfants.add(bebeLicorne);
            return bebeLicorne;
        } else {
            System.out.println("Ce lycanthrope n'est pas adulte et ne peut pas se reproduire !");
            return null;
        }
    }
    /**
     * Méthode pour mettre bas pour un lycanthrope vivipare.
     */
    @Override
    public void canMettreBas() {
        Random rand = new Random();
        char sexeEnfant = rand.nextBoolean() ? 'F' : 'M';
        double poidsEnfant = POIDS_NAISSANCE;

        Licorne bebeLicorne;
        bebeLicorne = new Licorne("Bébé Lycanthrope", sexeEnfant, poidsEnfant, 0.5, 0, 0, 0, getAge(), POIDS_NAISSANCE, POIDS_MAXIMUM);
        enfants.add(bebeLicorne);
        System.out.println("Le lycanthrope a mis bas !");
    }

    /**
     * Définition de la méthode abstraite peutMettreBas de l'interface CreatureFantastique.
     *
     * @return
     */
    @Override
    public boolean peutMettreBas() {

        return false;
    }

    /**
     * Implémentation de la méthode abstraite emettreSon de l'interface CreatureFantastique.
     */
    /**
     * Méthode pour émettre un son en fonction de l'état de la  licorne.
     * La licorne émet différents sons en fonction de ses indicateurs de faim, sommeil et santé.
     */
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
     * Méthode pour augmenter la santé du dragon en le soignant.
     * Augmente l'indicateur de santé du dragon.
     */
    @Override
    public void soigner() {
        // Augmenter la santé du licorne lorsqu'il est soigné
        int santeActuelle = getIndicateurSante();
        int santeAugmentee = santeActuelle + 20; // Augmentation de 20 pour l'exemple

        // Limiter la santé maximale à 100
        if (santeAugmentee > 100) {
            santeAugmentee = 100;
        }

        setIndicateurSante(santeAugmentee); // Met à jour la santé du licorne
        System.out.println("Le licorne a été soigné et sa santé a été augmentée !");
    }


    /**
     * @return
     */

    /**
     * Méthode spécifique pour gérer le vieillissement d'une licorne.
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

    List<String> especesCours;
    @Override
    public List<String> getEspecesCours(){
        especesCours.add("Licorne");
        return especesCours;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setEspecesCours() {
        especesCours= new ArrayList<>();
        especesCours.add("Licorne");
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> creerNouvelleCreature(Object... args) {
        return null;
    }

    /**
     * @param age             L'âge de la créature.
     * @param indicateurSante L'indicateur de santé de la créature.
     * @return
     */

    @Override
    public boolean mourrir(int age, int indicateurSante) {
        boolean tropVieille = age > 100; // Exemple : considérer qu'une créature est morte si elle dépasse l'âge de 100 ans
        boolean tropBlessee = indicateurSante <= 0; // Exemple : considérer qu'une créature meurt si son indicateur de santé atteint 0

        if (tropVieille || tropBlessee) {
            System.out.println("La créature est morte.");
            return true;
        } else {
            System.out.println("La créature est toujours en vie.");
            return false;
        }
    }
}

