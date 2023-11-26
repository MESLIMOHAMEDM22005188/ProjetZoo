package Creatures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lycanthope extends CreatureFantastique implements CreatureFantastique.Vivipaire {
    private static double POIDS_NAISSANCE = 60;
    private static double POIDS_MAXIMUM = 90;
    private static final double TAILLE_NAISSANCE = 1.70;
    private static final double TAILLE_MAXIMUM = 200;

    private List<Lycanthope> enfants;
    private static List<Lycanthope> adultes;

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

    @Override
    public void canMettreBas() {
        Random rand = new Random();
        char sexeEnfant = rand.nextBoolean() ? 'F' : 'M';
        double poidsEnfant = POIDS_NAISSANCE;

        Lycanthope bebeLycanthrope = new Lycanthope("Bébé Lycanthrope", sexeEnfant, poidsEnfant, 0.5, 0, 0, 0, getAge(), POIDS_NAISSANCE, POIDS_MAXIMUM);
        enfants.add(bebeLycanthrope);
        System.out.println("Le lycanthrope a mis bas !");
    }

    @Override
    public void setIndicateurProprete(int i) {

    }

    @Override
    public void emettreSon() {
        // Ajoutez ici la logique pour émettre des sons spécifiques pour un lycanthrope
    }

    @Override
    public void soigner() {
        // Logique pour soigner un lycanthrope
    }

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
