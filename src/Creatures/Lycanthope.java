package src.Creatures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * La classe abstraite Lycanthope représente une catégorie de créatures fantastiques vivipares.
 * Elle étend la classe Vivipaire et implémente l'interface Courrir de CreatureFantastique.
 */
public abstract class Lycanthope extends Vivipaire implements CreatureFantastique.Courrir {
    private static double POIDS_NAISSANCE = 60;
    private static double POIDS_MAXIMUM = 90;
    private static final double TAILLE_NAISSANCE = 1.70;
    private static final double TAILLE_MAXIMUM = 200;

    private List<Lycanthope> enfants;
    private static List<Lycanthope> adultes;
    private static List<Lycanthope> licornes = new ArrayList<>();

    /**
     * Constructeur pour la classe Lycanthope.
     *
     * @param nomEspece          Le nom de l'espèce de lycanthrope.
     * @param sexe               Le sexe du lycanthrope (M/F).
     * @param poids              Le poids actuel du lycanthrope.
     * @param taille             La taille actuelle du lycanthrope.
     * @param age                L'âge du lycanthrope.
     * @param indicateurFaim     L'indicateur de faim du lycanthrope.
     * @param indicateurSommeil  L'indicateur de sommeil du lycanthrope.
     * @param indicateurSante    L'indicateur de santé du lycanthrope.
     * @param poidsNaissance     Le poids de naissance du lycanthrope.
     * @param poidsMaximum       Le poids maximum que peut atteindre le lycanthrope.
     */
    public Lycanthope(String nomEspece, char sexe, double poids, double taille, int age,
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
     * Méthode abstraite décrivant le son émis par cette créature.
     */
    public abstract void emettreSon();

    /**
     * Méthode abstraite pour soigner cette créature.
     */
    public abstract void soigner();

    /**
     * Méthode pour la reproduction de cette créature.
     *
     * @return Un nouveau lycanthrope issu de la reproduction, ou null si la créature ne peut pas se reproduire.
     */
    public Lycanthope seReproduire() {
        if (adultes.contains(this)) {
            Random rand = new Random();
            char sexeEnfant = rand.nextBoolean() ? 'F' : 'M';
            double poidsEnfant = POIDS_NAISSANCE;
            Lycanthope bebeLycanthrope = creerNouveauLycanthrope("Bébé Lycanthrope", sexeEnfant, poidsEnfant, 0.5, 0, 0, 0, getAge(), POIDS_NAISSANCE, POIDS_MAXIMUM);
            enfants.add(bebeLycanthrope);
            return bebeLycanthrope;
        } else {
            System.out.println("Ce lycanthrope n'est pas adulte et ne peut pas se reproduire !");
            return null;
        }
    }

    /**
     * Méthode abstraite pour mettre bas cette créature.
     */
    public abstract void canMettreBas();

    /**
     * Méthode pour vieillir cette créature.
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
     * Liste des espèces en cours.
     */
    List<String> especesCours = new ArrayList<>();

    /**
     * @return La liste des espèces en cours.
     */
    @Override
    public List<String> getEspecesCours(){
        especesCours.add("Lycanthrope");
        return especesCours;
    }

    /**
     * Méthode pour définir les espèces en cours.
     */
    @Override
    public void setEspecesCours() {
        especesCours = new ArrayList<>();
        especesCours.add("Dragon");
    }

    /**
     * Méthode abstraite pour créer un nouveau lycanthrope avec les paramètres spécifiés.
     *
     * @param nom               Le nom du nouveau lycanthrope.
     * @param sexe              Le sexe du nouveau lycanthrope (M/F).
     * @param poids             Le poids du nouveau lycanthrope.
     * @param taille            La taille du nouveau lycanthrope.
     * @param age               L'âge du nouveau lycanthrope.
     * @param indicateurFaim    L'indicateur de faim du nouveau lycanthrope.
     * @param indicateurSommeil L'indicateur de sommeil du nouveau lycanthrope.
     * @param indicateurSante   L'indicateur de santé du nouveau lycanthrope.
     * @param poidsNaissance    Le poids de naissance du nouveau lycanthrope.
     * @param poidsMaximum      Le poids maximum du nouveau lycanthrope.
     * @return                  Le nouveau lycanthrope créé.
     */
    public abstract Lycanthope creerNouveauLycanthrope(String nom, char sexe, double poids, double taille, int age, int indicateurFaim, int indicateurSommeil, int indicateurSante, double poidsNaissance, double poidsMaximum);

    /**
     * Méthode pour créer une nouvelle créature.
     *
     * @param args Les arguments pour la création.
     * @return     La nouvelle créature créée.
     */
    @Override
    public List<String> creerNouvelleCreature(Object... args) {
        return null;
    }
}
