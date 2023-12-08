package src.Creatures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Cette classe représente un gestionnaire pour les créatures fantastiques nageant.
 */
interface Nager {
    /**
     * Récupère la liste des espèces nageantes disponibles.
     *
     * @return Liste des noms des espèces nageantes.
     */
    List<String> getEspecesNageantes();


    /**
     * Initialise les espèces nageantes en ajoutant des espèces par défaut à la liste.
     * Cette méthode par défaut doit être appelée dans les implémentations de cette interface.
     */
    default void initialiserEspecesNageantes() {
        List<String> especesAquatiques = new ArrayList<>();
        especesAquatiques.add("Licornes");
        especesAquatiques.add("Lycanthropes");
        especesAquatiques.add("Dragons");
        especesAquatiques.add("Nymphes");
        setEspecesNageantes(Collections.unmodifiableList(especesAquatiques));
    }

    /**
     * Modifie la liste des espèces nageantes avec la liste passée en argument.
     *
     * @param especes Liste des noms des espèces nageantes.
     */
    void setEspecesNageantes(List<String> especes);

    /**
     * Vérifie si une créature peut nager en fonction de sa santé et d'autres conditions.
     *
     * @param creature La créature fantastique à évaluer pour sa capacité à nager.
     * @return Retourne vrai si la créature est en bonne santé et capable de nager, sinon faux.
     */
    default boolean peutNager(CreatureFantastique creature) {
        boolean estEnBonneSante = creature.getIndicateurSante() > 0; // Vérifie la santé de la créature

        if (!estEnBonneSante) {
            System.out.println(creature.getNom() + " est malade et ne peut pas nager.");
            return false;
        }
        return true;
    }
}
