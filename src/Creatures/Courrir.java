package src.Creatures;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe gère les espèces normales dans le contexte des créatures fantastiques.
 */
abstract class Courrir extends CreatureFantastique {
    /**
     * Liste des espèces normales disponibles.
     */
    protected static List<String> especesCours = new ArrayList<>();

    /**
     * Constructeur par défaut de la classe Courrir.
     * Initialise la liste des espèces normales.
     */
    public Courrir(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim, int indicateurSommeil, int indicateurSante) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim, indicateurSommeil, indicateurSante);
        initialiserEspecesNormales();
    }

    /**
     * Initialise les espèces normales en ajoutant des espèces par défaut à la liste.
     * Cette méthode doit être implémentée dans les sous-classes.
     */
    public abstract void initialiserEspecesNormales();

    /**
     * Méthode pour définir les espèces aquatiques.
     * Cette méthode doit être implémentée dans les sous-classes.
     */
    public abstract void setEspecesAquatiques();
}
