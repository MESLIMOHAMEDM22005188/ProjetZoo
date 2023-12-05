package src.Creatures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * La classe Lycanthope représente une créature fantastique vivipare.
 */
public class Lycanthope extends CreatureFantastique implements CreatureFantastique.Vivipaire {
    private static double POIDS_NAISSANCE = 60;
    private static double POIDS_MAXIMUM = 90;
    private static final double TAILLE_NAISSANCE = 1.70;
    private static final double TAILLE_MAXIMUM = 200;

    private List<Lycanthope> enfants;
    private static List<Lycanthope> adultes;
    // Champ statique pour stocker tout les lycanthrope créées
    private static List<Lycanthope> licornes = new ArrayList<>(); 
/**
     * Constructeur pour la classe Lycanthope.
     *
     * @param nomEspece        Le nom de l'espèce de lycanthrope.
     * @param sexe             Le sexe du lycanthrope (M/F).
     * @param poids            Le poids actuel du lycanthrope.
     * @param taille           La taille actuelle du lycanthrope.
     * @param age              L'âge du lycanthrope.
     * @param indicateurFaim   L'indicateur de faim du lycanthrope.
     * @param indicateurSommeil L'indicateur de sommeil du lycanthrope.
     * @param indicateurSante  L'indicateur de santé du lycanthrope.
     * @param poidsNaissance   Le poids de naissance du lycanthrope.
     * @param poidsMaximum     Le poids maximum que peut atteindre le lycanthrope.
     */
    public Lycanthope(String nomEspece, char sexe, double poids, double taille, int age,
                      int indicateurFaim, int indicateurSommeil, int indicateurSante,
                      double poidsNaissance, double poidsMaximum) {
        super(nomEspece, sexe, poids, poids, taille, age, indicateurFaim, indicateurSommeil, indicateurSante);
        this.POIDS_NAISSANCE = poidsNaissance;
        this.POIDS_MAXIMUM = poidsMaximum;
        this.enfants = new ArrayList<>();

        if (adultes == null) {
            adultes = new ArrayList<>();
        }
    }
  /**
     * Méthode de reproduction pour un lycanthrope.
     * @return Le nouveau lycanthrope issu de la reproduction ou null si le lycanthrope ne peut pas se reproduire.
     */
    public Lycanthope seReproduire() {
        if (adultes.contains(this)) {
            Random rand = new Random();
            char sexeEnfant = rand.nextBoolean() ? 'F' : 'M';
            double poidsEnfant = POIDS_NAISSANCE;
            Lycanthope bebeLycanthrope = new Lycanthope("Bébé Lycanthrope", sexeEnfant, poidsEnfant, 0.5, 0, 0, 0, getAge(), POIDS_NAISSANCE, POIDS_MAXIMUM);
            enfants.add(bebeLycanthrope);
            return bebeLycanthrope;
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

        Lycanthope bebeLycanthrope = new Lycanthope("Bébé Lycanthrope", sexeEnfant, poidsEnfant, 0.5, 0, 0, 0, getAge(), POIDS_NAISSANCE, POIDS_MAXIMUM);
        enfants.add(bebeLycanthrope);
        System.out.println("Le lycanthrope a mis bas !");
    }
     /**
         * Définition de la méthode abstraite setIndicateurProprete de l'interface CreatureFantastique.
         * @param i L'indicateur de propreté à définir.
     */
    @Override
    public void setIndicateurProprete(int i) {

    }

    @Override
    public void peutMettreBas() {

    }

    /**
     * Implémentation de la méthode abstraite emettreSon de l'interface CreatureFantastique.
     */
    @Override
    public void emettreSon() {
        // Ajoutez ici la logique pour émettre des sons spécifiques pour un lycanthrope
    }
    /**
         * Implémentation de la méthode abstraite soigner de l'interface CreatureFantastique.
     */
    @Override
    public void soigner() {
        // Logique pour soigner un lycanthrope
    }
     /**
     * Méthode spécifique pour gérer le vieillissement d'un lycanthrope.
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
    // Autres méthodes spécifiques à un lycanthrope
}
