package src.Creatures.TypeCreature;

import src.Creatures.CreatureFantastique;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe représente un gestionnaire pour les créatures fantastiques nageant.
 */
public class CreatureAquatique {
    /**
     * Liste des espèces nageantes disponibles.
     */
    private List<String> especesNageantes;

    /**
     * Constructeur par défaut de la classe Nageur.
     * Initialise la liste des espèces nageantes et ajoute des espèces par défaut.
     */
    public CreatureAquatique() {
        especesNageantes = new ArrayList<>();
        initialiserEspecesNageantes();
    }

    /**
     * Initialise les espèces nageantes en ajoutant des espèces par défaut à la liste.*/
    private void initialiserEspecesNageantes() {
    }

    /**
     * Vérifie si une créature peut nager en fonction de sa santé et d'autres conditions.
     *
     * @param creature La créature fantastique à évaluer pour sa capacité à nager.
     * @return Retourne vrai si la créature est en bonne santé et capable de nager, sinon faux.
     */
    public boolean peutNager(CreatureFantastique creature) {
        boolean estEnBonneSante = creature.getIndicateurSante() > 0; // Vérifie la santé de la créature

        if (!estEnBonneSante) {
            System.out.println(creature.getNom() + " est malade et ne peut pas nager.");
            return false;
        }
        return true; // Si la créature est en bonne santé et peut nager
    }

    /**
     * Récupère la liste des espèces nageantes disponibles.
     *
     * @return Liste des noms des espèces nageantes.
     */
    public List<String> getEspecesNageantes() {
        return especesNageantes;
    }
}
