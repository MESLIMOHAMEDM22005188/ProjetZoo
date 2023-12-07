package src.Creatures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * La classe Megalodon représente une créature fantastique ovipare.
 */
public class Megalodon extends Ovipaire implements Nager {
    private static double poidsNaissance = 2000;
    private static double poidsMaximum = 30000;
    private static double tailleNaissance = 2.5;
    private static double tailleMaximum = 20;


    private List<Megalodon> enfants;
    private static List<Megalodon> adultes;

    /**
     * Constructeur pour la classe Megalodon.
     *
     * @param nomEspece         Le nom de l'espèce de Mégalodon.
     * @param sexe              Le sexe du Mégalodon (M/F).
     * @param poids             Le poids actuel du Mégalodon.
     * @param taille            La taille actuelle du Mégalodon.
     * @param age               L'âge du Mégalodon.
     * @param indicateurFaim    L'indicateur de faim du Mégalodon.
     * @param indicateurSommeil L'indicateur de sommeil du Mégalodon.
     * @param indicateurSante   L'indicateur de santé du Mégalodon.
     * @param poidsNaissance    Le poids de naissance du Mégalodon.
     * @param poidsMaximum      Le poids maximum que peut atteindre le Mégalodon.
     */

    public Megalodon(String nomEspece, char sexe, double poids, double taille, int age,
                     int indicateurFaim, int indicateurSommeil, int indicateurSante,
                     double poidsNaissance, double poidsMaximum) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim, indicateurSommeil, indicateurSante);
        this.poidsNaissance = poidsNaissance;
        this.poidsMaximum = poidsMaximum;
        this.enfants = new ArrayList<>();

        if (adultes == null) {
            adultes = new ArrayList<>();
        }
    }

    /**
     * Méthode de reproduction pour un Mégalodon.
     *
     * @return Le nouveau Mégalodon issu de la reproduction ou null si le Mégalodon ne peut pas se reproduire.
     */
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

    /**
     * Méthode pour la ponte d'œufs pour un Mégalodon ovipare.
     */
    public void canPandre() {
        Random rand = new Random();
        char sexeEnfant = rand.nextBoolean() ? 'F' : 'M';
        double poidsEnfant = poidsNaissance;

        Megalodon bebeMegalodon = new Megalodon("Bébé Mégalodon", sexeEnfant, poidsEnfant, 1, 0, 0, 0, getAge(), poidsNaissance, poidsMaximum);
        enfants.add(bebeMegalodon);
        System.out.println("Le Mégalodon a pondu des œufs !");
    }

    /**
     * Implémentation de la méthode abstraite emettreSon de l'interface CreatureFantastique.
     */
    @Override
    public void emettreSon() {

    }

    /**
     * Implémentation de la méthode abstraite soigner de l'interface CreatureFantastique.
     */
    @Override
    public void soigner() {

    }

    /**
     * Méthode spécifique pour gérer le vieillissement d'un Mégalodon.
     */
    public void vieillir() {
        if (getAge() >= 7) {
            this.taille = tailleMaximum;
            this.poids = poidsMaximum;
            if (!adultes.contains(this)) {
                adultes.add(this);
            }
        }
    }

    /**
     * Méthode pour mettre à jour l'état du Mégalodon.
     */
    public void miseAJourEtat() {
        vieillir();

    }

    /**
     *
     */
    @Override
    public void EspecesAquatiques() {
        Nager.super.EspecesAquatiques();
    }

    /**
     * @param creature La créature fantastique à évaluer pour sa capacité à nager.
     * @return
     */
    @Override
    public boolean peutNager(CreatureFantastique creature) {
        return Nager.super.peutNager(creature);
    }

    /**
     * @return
     */
    @Override
    public List<String> getEspecesNageantes() {
        return Nager.super.getEspecesNageantes();
    }
}



