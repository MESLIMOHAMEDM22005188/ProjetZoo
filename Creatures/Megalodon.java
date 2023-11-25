package Creatures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Megalodon extends CreatureFantastique implements CreatureFantastique.Ovipaire {
    private static double poidsNaissance = 2000;
    private static double poidsMaximum = 30000;
    private static double tailleNaissance = 2.5;
    private static double tailleMaximum = 20;

    private List<Megalodon> enfants;
    private static List<Megalodon> adultes;

    public Megalodon(String nomEspece, char sexe, double poids, double taille, int age,
                     int indicateurFaim, int indicateurSommeil, int indicateurSante,
                     double poidsNaissance, double poidsMaximum) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim, indicateurSommeil, indicateurSante, indicateurSante);
        this.poidsNaissance = poidsNaissance;
        this.poidsMaximum = poidsMaximum;
        this.enfants = new ArrayList<>();

        if (adultes == null) {
            adultes = new ArrayList<>();
        }
    }

    public Megalodon seReproduire() {
        if (adultes.contains(this)) {
            Random rand = new Random();
            char sexeEnfant = rand.nextBoolean() ? 'F' : 'M';
            double poidsEnfant = poidsNaissance;
            Megalodon bebeMegalodon = new Megalodon("Bébé Mégalodon", sexeEnfant, poidsEnfant, 1, 0, 0, 0, getAge(), poidsNaissance, poidsMaximum);
            enfants.add(bebeMegalodon);
            return bebeMegalodon;
        } else {
            System.out.println("Ce mégalodon n'est pas adulte et ne peut pas se reproduire !");
            return null;
        }
    }

    public void canPandre() {
        Random rand = new Random();
        char sexeEnfant = rand.nextBoolean() ? 'F' : 'M';
        double poidsEnfant = poidsNaissance;

        Megalodon bebeMegalodon = new Megalodon("Bébé Mégalodon", sexeEnfant, poidsEnfant, 1, 0, 0, 0, getAge(), poidsNaissance, poidsMaximum);
        enfants.add(bebeMegalodon);
        System.out.println("Le Mégalodon a pondu des œufs !");
    }

    @Override
    public void emettreSon() {

    }

    @Override
    public void soigner() {

    }

    public void vieillir() {
        if (getAge() >= 7) {
            this.taille = tailleMaximum;
            this.poids = poidsMaximum;
            if (!adultes.contains(this)) {
                adultes.add(this);
            }
        }
    }

    public void miseAJourEtat() {
        vieillir();
    }

    /*
    public void creatureAquatique() {
        if  (this instanceof Megalodon) {
            EnclosNageurs enclosNageurs =new EnclosNageurs("Enclos nageur", 10, 30, false, false);
            EnclosNageurs.ajouterCreature(this);
            System.out.println("Le Licorne ne vole pas et ne nage pas elle doit etre dans un enclos simple");
        } else {
            System.out.println("Cette créature doit etre atribuer à un autre enclos.");
        }
    }
    */
}