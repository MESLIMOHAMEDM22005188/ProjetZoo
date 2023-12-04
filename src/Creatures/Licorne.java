package src.Creatures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
     * Méthode pour créer une licorne avec des caractéristiques par défaut et un sexe aléatoire.
     * @param nom    Le nom de la licorne.
     * @param sexe   Le sexe de la licorne (M/F).
     * @param poids  Le poids de la licorne.
     * @param taille La taille de la licorne.
     * @param age    L'âge de la licorne.
     * @return       La nouvelle instance de Licorne créée.
     */
public class Licorne extends CreatureFantastique implements CreatureFantastique.Vivipaire {
    private static double POIDS_NAISSANCE = 60;
    private static double POIDS_MAXIMUM = 90;
    private static final double TAILLE_NAISSANCE = 1.70;
    private static final double TAILLE_MAXIMUM = 200;
 /**
     * Méthode pour récupérer toutes les licornes créées.
     * @return Une liste contenant toutes les licornes créées.
     */
    private List<Licorne> enfants;
    private static List<Licorne> adultes;
    private static List<Licorne> licornes = new ArrayList<>(); 
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

    // Méthode pour créer une licorne avec des caractéristiques par défaut et un sexe aléatoire
    public static Licorne creerLicorne(String nom, char sexe, double poids, double taille, int age) {
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

    // Méthode pour récupérer toutes les licornes créées
    public static List<Licorne> getLicornes() {
        return licornes;
    }
 /**
     * Méthode de reproduction pour une licorne.
     * @return La nouvelle licorne issue de la reproduction ou null si la licorne ne peut pas se reproduire.
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
     * Méthode pour mettre bas pour une licorne.
     */    @Override
    public void canMettreBas() {
        Random rand = new Random();
        char sexeEnfant = rand.nextBoolean() ? 'F' : 'M';
        double poidsEnfant = POIDS_NAISSANCE;

        Licorne bebeLicorne = new Licorne("Bébé Licorne", sexeEnfant, poidsEnfant, 0.5, 0, 0, 0, getAge(), POIDS_NAISSANCE, POIDS_MAXIMUM);
        enfants.add(bebeLicorne);
        System.out.println("La licorne a mis bas !");
    }

  /**
     * Définition de la méthode abstraite setIndicateurProprete de l'interface CreatureFantastique.
     * @param i L'indicateur de propreté à définir.
     */
    @Override
    public void setIndicateurProprete(int i) {
    }
  /**
     * Implémentation de la méthode abstraite emettreSon de l'interface CreatureFantastique.
     */
    @Override
    public void emettreSon() {

    }
 /**
     * Implémentation de la méthode abstraite soigner de l'interface CreatureFantastique.
     */
    @Override
    public void soigner() {

    }
}
