package src.Creatures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sirène extends CreatureFantastique implements CreatureFantastique.Vivipaire {
    private static double POIDS_NAISSANCE = 50;
    private static double POIDS_MAXIMUM = 80;
    private static final double TAILLE_NAISSANCE = 1.50;
    private static final double TAILLE_MAXIMUM = 180;

    private List<Sirène> enfants;
    private static List<Sirène> adultes;
    private static List<Sirène> sirènes = new ArrayList<>();

    public Sirène(String nomEspece, char sexe, double poids, double taille, int age,
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

    public static Sirène creerSirène(String nom, char sexe, double poids, double taille, int age) {
        double poidsNaissance = 50; // Poids de naissance par défaut
        double poidsMaximum = 80; // Poids maximum par défaut

        // Si le sexe n'est pas fourni, choisissez-le aléatoirement
        if (sexe != 'M' && sexe != 'F') {
            Random rand = new Random();
            sexe = rand.nextBoolean() ? 'M' : 'F';
        }
        Sirène nouvelleSirène = new Sirène(nom, sexe, poids, taille, age, 0, 0, 0, poidsNaissance, poidsMaximum);

        // Ajoute la nouvelle sirène à la liste des sirènes créées
        sirènes.add(nouvelleSirène);

        return nouvelleSirène;
    }

    public static List<Sirène> getSirènes() {
        return sirènes;
    }

    public Sirène seReproduire() {
        if (adultes.contains(this)) {
            Random rand = new Random();
            char sexeEnfant = rand.nextBoolean() ? 'F' : 'M';
            double poidsEnfant = POIDS_NAISSANCE;
            Sirène bebeSirène = new Sirène("Bébé Sirène", sexeEnfant, poidsEnfant, 0.3, 0, 0, 0, getAge(), POIDS_NAISSANCE, POIDS_MAXIMUM);
            enfants.add(bebeSirène);
            return bebeSirène;
        } else {
            System.out.println("Cette sirène n'est pas adulte et ne peut pas se reproduire !");
            return null;
        }
    }

    @Override
    public void canMettreBas() {
        Random rand = new Random();
        char sexeEnfant = rand.nextBoolean() ? 'F' : 'M';
        double poidsEnfant = POIDS_NAISSANCE;

        Sirène bebeSirène = new Sirène("Bébé Sirène", sexeEnfant, poidsEnfant, 0.3, 0, 0, 0, getAge(), POIDS_NAISSANCE, POIDS_MAXIMUM);
        enfants.add(bebeSirène);
        System.out.println("La sirène a mis bas !");
    }

    @Override
    public void setIndicateurProprete(int i) {
    }

    @Override
    public void emettreSon() {
    }

    @Override
    public void soigner() {
    }
}
