package src.Creatures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Représente une classe décrivant un Megalodon.
 * Hérite de la classe Ovipaire et implémente les interfaces Courrir, Nager, Voler de CreatureFantastique.
 */
public class Megalodon extends Ovipaire implements CreatureFantastique.Nager {
    private static final double POIDS_MAXIMUM_DEFAULT = 60000 ;
    private static final double POIDS_NAISSANCE_DEFAULT = 3000;
    private static double POIDS_NAISSANCE = 300;
    private static double POIDS_MAXIMUM = 200;
    private static final double TAILLE_NAISSANCE = 20;
    private static final double TAILLE_MAXIMUM = 250;

    private List<Megalodon> enfants;
    private static List<Ovipaire> adultes;
    private static List<Megalodon> megalodons = new ArrayList<>();

    /**
     * Constructeur pour créer une instance de Megalodon.
     * @param nomEspece Nom de l'espèce.
     * @param sexe Sexe du Megalodon ('M' ou 'F').
     * @param poids Poids du Megalodon.
     * @param taille Taille du Megalodon.
     * @param age Âge du Megalodon.
     * @param indicateurFaim Indicateur de faim.
     * @param indicateurSommeil Indicateur de sommeil.
     * @param indicateurSante Indicateur de santé.
     * @param poidsNaissance Poids de naissance du Megalodon.
     * @param poidsMaximum Poids maximum du Megalodon.
     */
    public Megalodon(String nomEspece, char sexe, double poids, double taille, int age,
                     int indicateurFaim, int indicateurSommeil, int indicateurSante,
                     double poidsNaissance, double poidsMaximum) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim);
        this.POIDS_NAISSANCE = poidsNaissance;
        this.POIDS_MAXIMUM = poidsMaximum;
        this.enfants = new ArrayList<>();

        if (adultes == null) {
            adultes = new ArrayList<Ovipaire>();
        }
    }

    /**
     * Autre constructeur de Megalodon sans spécification de poids de naissance et poids maximum.
     * @param nomEspece Nom de l'espèce.
     * @param sexe Sexe du Megalodon ('M' ou 'F').
     * @param poids Poids du Megalodon.
     * @param taille Taille du Megalodon.
     * @param age Âge du Megalodon.
     * @param indicateurFaim Indicateur de faim.
     * @param indicateurSommeil Indicateur de sommeil.
     * @param indicateurSante Indicateur de santé.
     */
    public Megalodon(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim, int indicateurSommeil, int indicateurSante) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim);
    }

    /**
     * Renvoie la liste des espèces nageantes.
     * @return Liste des espèces nageantes.
     */
    @Override
    public List<String> getEspecesNageantes() {
        return null;
    }

    /**
     * Définit les espèces nageantes.
     */
    @Override
    public void setEspecesNageantes() {

    }

    /**
     * Crée une nouvelle créature.
     * @param args Arguments pour la création de la nouvelle créature.
     * @return Liste de nouvelles créatures.
     */
    @Override
    public List<String> creerNouvelleCreature(Object... args) {
        return null;
    }

    /**
     * Crée un nouveau Megalodon avec des paramètres spécifiés.
     * @param nom Nom du Megalodon.
     * @param sexe Sexe du Megalodon ('M' ou 'F').
     * @param poids Poids du Megalodon.
     * @param taille Taille du Megalodon.
     * @param age Âge du Megalodon.
     * @return Nouveau Megalodon créé.
     */
    public static Megalodon creerMegalodon(String nom, char sexe, double poids, double taille, int age) {
        double poidsNaissance = POIDS_NAISSANCE_DEFAULT; // Poids de naissance par défaut
        double poidsMaximum = POIDS_MAXIMUM_DEFAULT; // Poids maximum par défaut

        if (sexe != 'M' && sexe != 'F') {
            Random rand = new Random();
            sexe = rand.nextBoolean() ? 'M' : 'F';
        }
        Megalodon nouveauMegalodon = new Megalodon(nom, sexe, poids, taille, age, 0, 0, 0, poidsNaissance, poidsMaximum);

        megalodons.add(nouveauMegalodon); // Ajoute le nouveau megalodon à la liste des megalodons créés

        return nouveauMegalodon;
    }

    /**
     * Méthode pour émettre un son en fonction de l'état du megalodon.
     * Le megalodon émet différents sons en fonction de ses indicateurs de faim, sommeil et santé.
     */
    @Override
    public void emettreSon() {
        // Si le megalodon a faim, il émet un cri spécifique
        if (getIndicateurFaim() > 50) {
            System.out.println("Le megalodon émet un grognement de faim !");
        }

        // Si le dragon est fatigué, il émet un son différent
        if (getIndicateurSommeil() < 30) {
            System.out.println("Le megalodon bâille bruyamment et émet un son de fatigue !");
        }

        // Si le megalodon n'est pas en bonne santé, il émet un son indiquant sa souffrance
        if (getIndicateurSante() < 50) {
            System.out.println("Le megalodon émet un cri de douleur !");
        }

        // Sinon, le megalodon émet un son standard
        System.out.println("Le megalodon émet un rugissement majestueux !");
    }
    /**
     * Méthode pour augmenter la santé du megalodon en le soignant.
     * Augmente l'indicateur de santé du megalodon.
     */
    @Override
    public void soigner() {
        // Augmenter la santé du megalodon lorsqu'il est soigné
        int santeActuelle = getIndicateurSante();
        int santeAugmentee = santeActuelle + 20; // Augmentation de 20 pour l'exemple

        // Limiter la santé maximale à 100
        if (santeAugmentee > 100) {
            santeAugmentee = 100;
        }

        setIndicateurSante(santeAugmentee); // Met à jour la santé du megalodon
        System.out.println("Le megalodon a été soigné et sa santé a été augmentée !");
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
     * Renvoie la liste des megalodons créés.
     * @return Liste des megalodons créés.
     */
    public static List<Megalodon> getMegalodons() {
        return megalodons;
    }

    /**
     * Permet au Megalodon de se reproduire et renvoie un nouveau bébé Megalodon.
     * @return Nouveau bébé Megalodon.
     */
    public Megalodon seReproduire() {
        if (adultes.contains(this)) {
            Random rand = new Random();
            char sexeEnfant = rand.nextBoolean() ? 'F' : 'M';
            double poidsEnfant = POIDS_NAISSANCE;
            Megalodon bebeMegalodon = new Megalodon("Bébé Megalodon", sexeEnfant, poidsEnfant, 0.3, 0, 0, 0, getAge(), POIDS_NAISSANCE, POIDS_MAXIMUM) {
            };

            return bebeMegalodon; // Retourne le bébé megalodon créé
        } else {
            System.out.println("Ce megalodon n'est pas adulte et ne peut pas se reproduire !");
            return null; // Retourne null car le megalodon ne peut pas se reproduire
        }
    }
}
