package src.Creatures;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe gère les espèces volantes dans le contexte des créatures fantastiques.
 */
interface Voler {
    /**
     * Liste des espèces volantes disponibles.
     */
    List<String> especesVolantes = new ArrayList<>();

    /**
     * Initialise les espèces volantes en ajoutant des espèces par défaut à la liste.
     */
    default void initialiserEspecesVolantes() {
        especesVolantes.add("Dragon");
        especesVolantes.add("Phenix");
    }

    /**
     * Vérifie si une créature peut voler en fonction de sa santé et d'autres conditions.
     *
     * @param creature La créature fantastique à évaluer pour sa capacité à voler.
     * @return Retourne vrai si la créature est en bonne santé et capable de voler, sinon faux.
     */
    static boolean peutVoler(CreatureFantastique creature) {
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
    default List<String> getEspecesVolantes() {
        return especesVolantes;
    }
}
