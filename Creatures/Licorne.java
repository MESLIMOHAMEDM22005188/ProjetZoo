package Creatures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Licorne extends CreatureFantastique implements CreatureFantastique.Vivipaire {
    private static double POIDS_NAISSANCE = 60;
    private static double POIDS_MAXIMUM = 90;
    private static final double TAILLE_NAISSANCE = 1.70;
    private static final double TAILLE_MAXIMUM = 200;

    private List<Licorne> enfants;
    private static List<Licorne> adultes;

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
    public void setIndicateurProprete(int i) {

    }

    @Override
    public void emettreSon() {
        if (indicateurFaim > 50) {
            System.out.println("La Licorne hennit joyeusement.");
        } else if (indicateurFaim > 20) {
            System.out.println("La Licorne hennit calmement.");
        } else {
            System.out.println("La Licorne hennit faiblement.");
        }
    }


    @Override
    public void soigner() {
        // Implémenter le comportement de soin de la Licorne
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
}
