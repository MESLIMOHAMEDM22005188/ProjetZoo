package src.Creatures.TypeCreature;

import src.Creatures.CreatureFantastique;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe gère les espèces volantes dans le contexte des créatures fantastiques.
 */
public class CréatureVolante {
    /**
     * Liste des espèces volantes disponibles.
     */
    private List<String> especesVolantes;

    /**
     * Constructeur par défaut de la classe Vol.
     * Initialise la liste des espèces volantes et ajoute des espèces par défaut.
     */
    public CréatureVolante() {
        especesVolantes = new ArrayList<>();
    }


    /**
     * Vérifie si une créature peut voler en fonction de sa santé et d'autres conditions.
     *
     * @param creature La créature fantastique à évaluer pour sa capacité à voler.
     * @return Retourne vrai si la créature est en bonne santé et capable de voler, sinon faux.
     */
    public boolean peutVoler(CreatureFantastique creature) {
        boolean estEnBonneSante = creature.getIndicateurSante() > 0; // Vérifie la santé de la créature

        if (!estEnBonneSante) {
            System.out.println(creature.getNom() + " est malade et ne peut pas voler.");
            return false;
        }

        // Ajoutez votre logique pour déterminer si la créature peut voler (par exemple, basée sur d'autres conditions)

        return true; // Si la créature est en bonne santé et peut voler
    }

    /**
     * Récupère la liste des espèces volantes disponibles.
     *
     * @return Liste des noms des espèces volantes.
     */
    public List<String> getEspecesVolantes() {
        return especesVolantes;
    }
}
