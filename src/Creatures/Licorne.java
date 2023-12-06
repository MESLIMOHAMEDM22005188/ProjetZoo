package src.Creatures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * La classe Licorne représente une créature fantastique du monde magique.
 *
 * Elle hérite de la classe CreatureFantastique et implémente l'interface Vivipaire.
 */
public class Licorne extends CreatureFantastique implements CreatureFantastique.Vivipaire {

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
        super(nomEspece, sexe, poids, poids, taille, age, indicateurFaim, indicateurSommeil, indicateurSante);
        this.POIDS_NAISSANCE= poidsNaissance;
        this.POIDS_MAXIMUM = poidsMaximum;
        this.enfants = new ArrayList<>();

        if (adultes == null) {
            adultes = new ArrayList<>();
        }
    }
    /**
     * Méthode de reproduction pour une Licorne.
     * @return La nouvelle Licorne bébé issue de la reproduction.
     */    public static Licorne creerLicorne(String nom, char sexe, double poids, double taille, int age) {
        double poidsNaissance = 60; // Poids de naissance par défaut
        double poidsMaximum = 90; // Poids maximum par défaut

        // Si le sexe n'est pas fourni, choisissez-le aléatoirement
        if (sexe != 'M' && sexe != 'F') {
            Random rand = new Random();
            sexe = rand.nextBoolean() ? 'M' : 'F';
        }
        Licorne nouvelleLicorne = new Licorne(nom, sexe, poids, taille, age, 0, 0, 0, poidsNaissance, poidsMaximum);

        // Ajoute la nouvelle licorne à la liste des licornes créées
        licornes.add(nouvelleLicorne);

        return nouvelleLicorne;
    }
    /**
     * Méthode pour récuperer les nouvelles licornes pour une Licorne.
     */

    public static List<Licorne> getLicornes() {
        return licornes;
    }
    /**
     * Méthode de reproduction pour une Licorne.
     * @return La nouvelle Licorne bébé issue de la reproduction.
     */
    public Licorne seReproduire() {
        if (adultes.contains(this)) {
            Random rand = new Random();
            char sexeEnfant = rand.nextBoolean() ? 'F' : 'M';
            double poidsEnfant = POIDS_NAISSANCE;
            Licorne bebeLicorne = new Licorne("Bébé Licorne", sexeEnfant, poidsEnfant, 0.5, 0, 0, 0, age, POIDS_NAISSANCE, POIDS_MAXIMUM);
            enfants.add(bebeLicorne);
            return bebeLicorne;
        } else {
            System.out.println("Cette licorne n'est pas adulte et ne peut pas se reproduire !");
            return null;
        }
    }

    /**
     * Méthode pour mettre bas pour une licorne vivipare.
     */
    @Override
    public void canMettreBas() {
        Random rand = new Random();
        char sexeEnfant = rand.nextBoolean() ? 'F' : 'M';
        double poidsEnfant = POIDS_NAISSANCE;

        Licorne bebeLicorne = new Licorne("Bébé Licorne", sexeEnfant, poidsEnfant, 0.5, 0, 0, 0, getAge(), POIDS_NAISSANCE, POIDS_MAXIMUM);
        enfants.add(bebeLicorne);
        System.out.println("La licorne a mis bas !");
    }


    @Override
    public boolean peutMettreBas() {
        boolean mettreBas = false;
        if(sexe=='F') {
            mettreBas = true;
        }
        return mettreBas;
    }

    /**
     * Méthode pour faire émettre un son à la Licorne en fonction de son état.
     * Si la Licorne a faim, est fatiguée, ou se sent malade, elle émet un hennissement en conséquence.
     * Sinon, elle émet un hennissement joyeux.
     */
    @Override
    public void emettreSon() {
        if (getIndicateurFaim() > 70) {
            System.out.println("La licorne hennit avec impatience, elle a faim !");
        } else if (getIndicateurSommeil() > 70) {
            System.out.println("La licorne émet un hennissement doux, elle est fatiguée.");
        } else if (getIndicateurSante() < 30) {
            System.out.println("La licorne hennit faiblement, elle se sent malade.");
        } else {
            System.out.println("La licorne émet un hennissement joyeux !");
        }
    }

    @Override
    public void soigner() {
        System.out.println("Vous soignez la licorne.");;
        setIndicateurSante(10);
    }

}
