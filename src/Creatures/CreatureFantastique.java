package src.Creatures;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface définissant les actions disponibles pour une créature
 * @author d21218703
  */
interface ActionsCreature {
    void manger();
    void emettreSon();
    void soigner();
    void dormir();
    void seReveiller();
    void vieillir();
}
/**
 * Enumérations pour la catégorie d'âge
 * @author d21218703
 */

enum CategorieAge {
    JEUNE, ADULTE, VIEUX, MORT
}
/**
 * Classe abstraite représentant les créatures fantastiques.
 *  @author b22025963 d21218703 m22005188
 */
public abstract class CreatureFantastique {
    /**
     * Liste de créatures fantastiques.
     */
    public static List<CreatureFantastique> Creature = new ArrayList<>();



    /**
     * Nom de la créature.
     */
    protected String nom;

    /**
     * Sexe de la créature.
     */
    protected char sexe;

    /**
     * Poids de la créature.
     */
    protected double poids;

    /**
     * Taille de la créature.
     */
    protected double taille;

    /**
     * Âge de la créature.
     */
    protected int age;

    /**
     * Indicateur de faim de la créature.
     */
    protected int indicateurFaim;

    /**
     * Indique si la créature dort.
     */
    protected boolean dort;

    /**
     * Indicateur de santé de la créature.
     */
    protected int indicateurSante;

    // ... (autres attributs et méthodes de la classe)

    /**
     * Indicateur de sommeil de la créature.
     */
    protected int indicateurSommeil;

    /**
     * Constructeur de la classe CreatureFantastique.
     *
     * @param 'nomEspece'         Le nom de l'espèce de la créature.
     * @param 'sexe'              Le sexe de la créature.
     * @param 'poids'             Le poids de la créature.
     * @param 'taille'            La taille de la créature.
     * @param 'age'               L'âge de la créature.
     * @param 'indicateurFaim     L'indicateur de faim de la créature.
     * @param 'indicateurSommeil' L'indicateur de sommeil de la créature.
     * @param 'indicateurSante'   L'indicateur de santé de la créature.
     * @param nomEspece
     * @param sexe
     * @param poids
     * @param taille
     * @param age
     * @param indicateurFaim
     * @param indicateurSommeil
     * @param indicateurSante
     */
    public CreatureFantastique(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim, int indicateurSommeil, int indicateurSante) {
        this.nom = nom;
        this.sexe = this.sexe;
        this.poids = this.poids;
        this.taille = this.taille;
        this.age = this.age;
        this.indicateurFaim = 100;
        this.dort = false;
        this.indicateurSante = 100;
        this.indicateurSommeil = 0; // Initialise à 0 par défaut
    }
    /**
     * Méthode statique pour créer une nouvelle créature.
     * @param especeCreature L'espèce de la nouvelle créature.
     * @param nomCreature Le nom de la nouvelle créature.
     * @return La nouvelle créature fantastique créée.
     */
    public static <NomEspece> CreatureFantastique creerNouvelleCreature(NomEspece especeCreature, String nomCreature) {
        return null;
    }

    public String getNom() {
        return nom;
    }
    /**
     * Méthode permettant à la créature de se nourrir.
     * La créature mangera seulement si elle n'est pas malade et si elle n'est pas en train de dormir.
     * Sinon, un message approprié sera affiché.
     */
    public void manger() {
        boolean isMalade = false;
        boolean estEnTrainDeDormir = indicateurSommeil == 1;
        if (!isMalade && !estEnTrainDeDormir) {
            System.out.println(nom + " mange.");
            setIndicateurFaim(10);
        } else if (isMalade) {
            System.out.println(nom + " est malade et ne peut pas manger.");
        } else if (estEnTrainDeDormir) {
            System.out.println(nom + " dort et ne peut pas manger.");
        }
    }


    /**
     * Obtient le nom de l'espèce de la créature.
     *
     * @return false car cette méthode devrait normalement retourner une chaîne de caractères représentant le nom de l'espèce.
     */
    public String getNomEspece() {
        Object nomEspece;


        return null;
    }

    // Méthode pour mettre bas pour une licorne vivipare

    public abstract void emettreSon();

    public abstract void soigner();


    public interface Nager {

        void initialiserEspecesNage();

        void setEspecesNage();

        List<String> creerNouvelleCreature(Object... args);

    }

    public interface Voler {

        void initialiserEspecesVole();

        void setEspecesVole();

        List<String> creerNouvelleCreature(Object... args);

    }

    public interface Courrir {

        /**
         * Méthode pour initialiser les espèces normales.
         * Cette méthode doit être implémentée dans les classes qui implémentent cette interface.
         */
        void initialiserEspecesCours();

        /**
         * Méthode pour définir les espèces en cours.
         * Cette méthode doit être implémentée dans les classes qui implémentent cette interface.
         */
        void setEspecesCours();
        List<String> creerNouvelleCreature(Object... args);

    }


    public void sEndormir() {
        if (indicateurSommeil == 1) {
            System.out.println(nom + " est déjà endormi(e).");
        } else {
            indicateurSommeil = 1;
            System.out.println(nom + " s'endort.");
        }
    }
    /**
     * Méthode permettant à la créature de vieillir d'une unité.
     * Incrémente l'âge de la créature et affiche un message indiquant son nouvel âge.
     * La logique de vieillissement pour différentes espèces doit être complétée dans les classes filles.
     */
    public void vieillir() {
        age++;
        System.out.println(nom + " vieillit. Âge actuel : " + age);
        // Logique de vieillissement pour les différentes espèces (à compléter)
    }

    public char getSexe() {
        return sexe;
    }

    public double getPoids() {
        return poids;
    }

    public double getTaille() {
        return taille;
    }

    public int getAge() {
        return age;
    }

    public int getIndicateurFaim() {
        return indicateurFaim;
    }

    public int getIndicateurSommeil() {
        return indicateurSommeil;
    }

    public int getIndicateurSante() {
        return indicateurSante;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIndicateurFaim(int indicateurFaim) {
        this.indicateurFaim = indicateurFaim;
    }

    public void setIndicateurSommeil(int indicateurSommeil) {
        this.indicateurSommeil = indicateurSommeil;
    }

    public void setIndicateurSante(int indicateurSante) {
        this.indicateurSante = indicateurSante;
    }
}
/**
 * Classe abstraite représentant les différentes créatures et implémentant l'interface ActionsCreature.
 */
abstract class Creatures implements ActionsCreature {
    protected String nomEspece;

    protected int phase = 1;
    /**
     * Getter pour récupérer le nom de l'espèce de la créature.
     * @return Le nom de l'espèce de la créature.
     */
    public String getNomEspece() {
        return nomEspece;
    }
    /**
     * Constructeur pour initialiser le nom de l'espèce de la créature.
     */
    public Creatures(String nomEspece) {
        this.nomEspece = nomEspece;
        // ... (initialisation)
    }

    /**
     * Méthode pour permettre à la créature d'émettre un son.
     * Affiche un message indiquant que la créature émet un son spécifique à son espèce.
     */
    @Override
    public void emettreSon() {
        System.out.println(nomEspece + " émet un son.");
    }
    /**
     * Méthode pour soigner la créature.
     * Affiche un message indiquant que la créature a été soignée, puis met à jour l'état de santé de la créature.
     * La méthode setIsMalade(false) indique que la créature n'est plus malade.
     * La méthode setIndicateurSante(10) met à jour l'indicateur de santé de la créature.
     */
    @Override
    public void soigner() {
        System.out.println(nomEspece + " a été soigné.");
        setIsMalade(false);
        setIndicateurSante(10);
    }

    /**
     * Méthode abstraite à implémenter dans les sous-classes pour définir l'indicateur de santé de la créature.
     * @param i La valeur de l'indicateur de santé à définir.
     */
    protected abstract void setIndicateurSante(int i);

    /**
     * Méthode abstraite à implémenter dans les sous-classes pour définir si la créature est malade.
     * @param b Valeur booléenne indiquant si la créature est malade ou non.
     */
    protected abstract void setIsMalade(boolean b);
}
