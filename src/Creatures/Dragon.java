package src.Creatures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Représente une classe décrivant un Dragon.
 * Hérite de la classe Ovipaire et implémente les interfaces Courrir, Nager, Voler de CreatureFantastique.
 */
public class Dragon extends Ovipaire implements CreatureFantastique.Courrir, CreatureFantastique.Nager, CreatureFantastique.Voler,CreatureFantastique.Imortel {
    private static double POIDS_NAISSANCE = 100;
    private static double POIDS_MAXIMUM = 200;
    private static final double TAILLE_NAISSANCE = 20;
    private static final double TAILLE_MAXIMUM = 250;

    private List<Dragon> enfants;
    private static List<Dragon> adultes;
    private static List<Dragon> dragons = new ArrayList<>();

    private int stade;

    /**
     * Constructeur pour créer une instance de Dragon.
     *
     * @param nomEspece         Le nom de l'espèce du dragon.
     * @param sexe              Le sexe du dragon ('M' pour mâle, 'F' pour femelle).
     * @param poids             Le poids du dragon.
     * @param taille            La taille du dragon.
     * @param age               L'âge du dragon.
     * @param indicateurFaim    Indicateur de faim du dragon.
     * @param indicateurSommeil Indicateur de sommeil du dragon.
     * @param indicateurSante   Indicateur de santé du dragon.
     * @param poidsNaissance    Le poids de naissance du dragon.
     * @param poidsMaximum      Le poids maximum du dragon.
     */
    public Dragon(String nomEspece, char sexe, double poids, double taille, int age,
                  int indicateurFaim, int indicateurSommeil, int indicateurSante,
                  double poidsNaissance, double poidsMaximum) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim);
        this.POIDS_NAISSANCE = poidsNaissance;
        this.POIDS_MAXIMUM = poidsMaximum;
        this.enfants = new ArrayList<>();

        if (adultes == null) {
            adultes = new ArrayList<>();
        }
    }
    /**
     * Crée une nouvelle instance de Dragon avec les paramètres spécifiés.
     *
     * @param nom   Le nom du dragon.
     * @param sexe  Le sexe du dragon.
     * @param poids Le poids du dragon.
     * @param taille La taille du dragon.
     * @param age   L'âge du dragon.
     * @return      Un nouveau dragon créé avec les paramètres spécifiés.
     */
    public static Dragon creerDragon(String nom, char sexe, double poids, double taille, int age) {
        double poidsNaissance = 100; // Poids de naissance par défaut
        double poidsMaximum = 200; // Poids maximum par défaut

        if (sexe != 'M' && sexe != 'F') {
            Random rand = new Random();
            sexe = rand.nextBoolean() ? 'M' : 'F';
        }
        Dragon nouveauDragon = new Dragon(nom, sexe, poids, taille, age, 0, 0, 0, poidsNaissance, poidsMaximum);

        dragons.add(nouveauDragon); // Ajoute le nouveau dragon à la liste des dragons créés

        return nouveauDragon;
    }
    /**
     * Renvoie la liste des dragons créés.
     *
     * @return La liste des dragons.
     */
    // Méthode pour obtenir la liste des dragons créés

    public static List<Dragon> getDragons() {

        return dragons;
    }
    /**
     * Permet au dragon de se reproduire et renvoie un nouveau bébé dragon.
     *
     * @return Le bébé dragon créé suite à la reproduction.
     */
    public Dragon seReproduire() {
        if (adultes.contains(this)) {
            Random rand = new Random();
            char sexeEnfant = rand.nextBoolean() ? 'F' : 'M';
            double poidsEnfant = POIDS_NAISSANCE;
            Dragon bebeDragon = new Dragon("Bébé Dragon", sexeEnfant, poidsEnfant, 0.3, 0, 0, 0, getAge(), POIDS_NAISSANCE, POIDS_MAXIMUM) {
            };

            return bebeDragon; // Retourne le bébé dragon créé
        } else {
            System.out.println("Ce dragon n'est pas adulte et ne peut pas se reproduire !");
            return null; // Retourne null car le dragon ne peut pas se reproduire
        }
    }

    /**
     * Méthode pour émettre un son en fonction de l'état du dragon.
     * Le dragon émet différents sons en fonction de ses indicateurs de faim, sommeil et santé.
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
    List<String> especesNageantes = new ArrayList<>();
    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getEspecesNageantes() {
        especesNageantes.add("Dragon");
        return especesNageantes;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setEspecesNageantes() {
        especesNageantes = new ArrayList<>();
        especesNageantes.add("Dragon");
    }
    /**
     * {@inheritDoc}
     */
    List<String> especesVolantes = new ArrayList<>();
    @Override
    public List<String> getEspecesVolantes(){
        especesVolantes.add("Dragon");
        return especesNageantes;
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

    List<String> especesCours;
    @Override
    public List<String> getEspecesCours(){
        especesCours.add("Dragon");
        return especesCours;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setEspecesCours() {
        especesCours = new ArrayList<>();
        especesCours.add("Dragon");
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> creerNouvelleCreature(Object... args) {
        return null;
    }
    @Override
    public void mourirImo() {
        if (this.stade < 10) {
            System.out.println("La créature est morte.");
            this.stade++;
            System.out.println("La créature renaît et passe au stade " + this.stade);
        } else {
            System.out.println("La créature est morte après avoir atteint le 10ème stade.");
            // Si c'est le dernier stade, supprime ce dragon de la liste dragons
            dragons.remove(this);
        }
    }

    @Override
    public void naissance() {
        System.out.println("La créature est née !");
        this.stade = 1; // Initialiser la créature à son premier stade à la naissance
        dragons.add(this); // Ajouter le dragon à la liste dragons lors de sa naissance
    }

    /**
     *
     */

    @Override
    public int getStade() {
        return this.stade;
    }
}
