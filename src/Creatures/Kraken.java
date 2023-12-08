package src.Creatures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * La classe Kraken représente une créature fantastique marine.
 *
 * Hérite de la classe Ovipaire et implémente l'interface Nager de CreatureFantastique.
 */
public class Kraken extends Ovipaire implements CreatureFantastique.Nager {
    private static final double POIDS_NAISSANCE = 100;
    private static final double POIDS_MAXIMUM = 200;
    private static final double TAILLE_NAISSANCE = 20;
    private static final double TAILLE_MAXIMUM = 250;

    private List<Kraken> enfants;
    private static List<Ovipaire> adultes;
    private static List<Kraken> krakens = new ArrayList<>();

    /**
     * Constructeur pour créer une instance de Kraken avec des paramètres spécifiés.
     * @param nomEspece Nom de l'espèce du Kraken.
     * @param sexe Sexe du Kraken ('M' pour mâle, 'F' pour femelle).
     * @param poids Poids du Kraken.
     * @param taille Taille du Kraken.
     * @param age Âge du Kraken.
     * @param indicateurFaim Indicateur de faim du Kraken.
     * @param indicateurSommeil Indicateur de sommeil du Kraken.
     * @param indicateurSante Indicateur de santé du Kraken.
     */
    public Kraken(String nomEspece, char sexe, double poids, double taille, int age,
                  int indicateurFaim, int indicateurSommeil, int indicateurSante) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim);
        this.enfants = new ArrayList<>();

        if (adultes == null) {
            adultes = new ArrayList<>();
        }
    }

    /**
     * Autre constructeur de Kraken sans spécification de certains paramètres.
     * @param nomEspece Nom de l'espèce du Kraken.
     * @param sexe Sexe du Kraken ('M' pour mâle, 'F' pour femelle).
     * @param poids Poids du Kraken.
     * @param taille Taille du Kraken.
     * @param age Âge du Kraken.
     * @param indicateurFaim Indicateur de faim du Kraken.
     */
    public Kraken(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim);
    }

    /**
     * Méthode statique pour créer un nouveau Kraken.
     * @param nom Nom du nouveau Kraken.
     * @param sexe Sexe du nouveau Kraken ('M' pour mâle, 'F' pour femelle).
     * @param poids Poids du nouveau Kraken.
     * @param taille Taille du nouveau Kraken.
     * @param age Âge du nouveau Kraken.
     * @return Le nouveau Kraken créé.
     */
    public static Kraken creerKraken(String nom, char sexe, double poids, double taille, int age) {
        double poidsNaissance = 100; // Poids de naissance par défaut
        double poidsMaximum = 200; // Poids maximum par défaut
        if (sexe != 'M' && sexe != 'F') {
            Random rand = new Random();
            sexe = rand.nextBoolean() ? 'M' : 'F';
        }
        Kraken nouveauKraken = new Kraken(nom, sexe, poids, taille, age, 0, 0, 0);

        krakens.add(nouveauKraken); // Ajoute le nouveau kraken à la liste des krakens créés

        return nouveauKraken;
    }

    /**
     * Méthode pour obtenir la liste des Krakens créés.
     * @return Liste des Krakens créés.
     */
    public static List<Kraken> getKrakens() {
        return krakens;
    }
    /**
     * Méthode pour émettre un son en fonction de l'état du kraken.
     * Le kraken émet différents sons en fonction de ses indicateurs de faim, sommeil et santé.
     */
    @Override
    public void emettreSon() {
        // Si le kraken a faim, il émet un cri spécifique
        if (getIndicateurFaim() > 50) {
            System.out.println("Le kraken émet un grognement de faim !");
        }

        // Si le kraken est fatigué, il émet un son différent
        if (getIndicateurSommeil() < 30) {
            System.out.println("Le kraken bâille bruyamment et émet un son de fatigue !");
        }

        // Si le kraken n'est pas en bonne santé, il émet un son indiquant sa souffrance
        if (getIndicateurSante() < 50) {
            System.out.println("Le kraken émet un cri de douleur !");
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

    /**
     * Méthode pour permettre au Kraken de se reproduire et renvoyer un nouveau bébé Kraken.
     * @return Nouveau bébé Kraken.
     */
    public Kraken seReproduire() {
        if (adultes.contains(this)) {
            Random rand = new Random();
            char sexeEnfant = rand.nextBoolean() ? 'F' : 'M';
            double poidsEnfant = POIDS_NAISSANCE;
            Kraken bebeKraken = new Kraken("Bébé Kraken", sexeEnfant, poidsEnfant, 0.3, 0, 0);

            return bebeKraken; // Retourne le bébé kraken créé
        } else {
            System.out.println("Ce Kraken n'est pas adulte et ne peut pas se reproduire !");
            return null; // Retourne null car le kraken ne peut pas se reproduire
        }
    }

    // Implémentation des méthodes de l'interface CreatureFantastique.Nager

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getEspecesNageantes() {
        List<String> especesNageantes = new ArrayList<>();
        especesNageantes.add("Kraken");
        return especesNageantes;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setEspecesNageantes() {
        List<String> especesNageantes = new ArrayList<>();
        especesNageantes.add("Kraken");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> creerNouvelleCreature(Object... args) {
        return null;
    }
}
