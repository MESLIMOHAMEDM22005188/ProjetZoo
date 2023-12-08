package src.Creatures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Représente une classe décrivant une Sirene.
 * Hérite de la classe Ovipaire et implémente les interfaces Courrir, Nager, Voler de CreatureFantastique.
 */
public class Sirene extends Vivipaire implements CreatureFantastique.Nager, CreatureFantastique.Mortel{
    private static double POIDS_NAISSANCE = 100;
    private static double POIDS_MAXIMUM = 200;
    private static final double TAILLE_NAISSANCE = 20;
    private static final double TAILLE_MAXIMUM = 250;

    private List<Sirene> enfants;
    private static List<Sirene> adultes;
    private static List<Sirene> sirenes = new ArrayList<>();

    /**
     * Constructeur pour créer une instance de Sirene.
     * ... (rest of the code remains the same)
     */

    public Sirene(String nomEspece, char sexe, double poids, double taille, int age,
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

    public Sirene(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim, int indicateurSommeil, int indicateurSante) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim, indicateurSommeil, indicateurSante);
    }

    /**
     *
     */
    @Override
    public void canMettreBas() {

    }

    /**
     *
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

    /**
     * Crée une nouvelle instance de Sirene avec les paramètres spécifiés.
     * ... (rest of the code remains the same)
     */

    public static Sirene creerSirene(String nom, char sexe, double poids, double taille, int age) {
        double poidsNaissance = 100; // Poids de naissance par défaut
        double poidsMaximum = 200; // Poids maximum par défaut

        if (sexe != 'M' && sexe != 'F') {
            Random rand = new Random();
            sexe = rand.nextBoolean() ? 'M' : 'F';
        }
        Sirene nouvelleSirene = new Sirene(nom, sexe, poids, taille, age, 0, 0, 0, poidsNaissance, poidsMaximum);

        sirenes.add(nouvelleSirene); // Ajoute la nouvelle sirene à la liste des sirenes créées

        return nouvelleSirene;
    }

    /**
     * Renvoie la liste des sirenes créées.
     * ... (rest of the code remains the same)
     */

    public static List<Sirene> getSirenes() {
        return sirenes;
    }

    /**
     * Permet à la sirene de se reproduire et renvoie un nouveau bébé sirene.
     * ... (rest of the code remains the same)
     */



    /**
     * {@inheritDoc}
     */
    List<String> especesNageantes = new ArrayList<>();
    @Override
    public List<String> getEspecesNageantes() {
        especesNageantes.add("Sirene");
        return especesNageantes;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setEspecesNageantes() {
        especesNageantes = new ArrayList<>();
        especesNageantes.add("Dragon"); // Updated to "Sirene" if needed
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
