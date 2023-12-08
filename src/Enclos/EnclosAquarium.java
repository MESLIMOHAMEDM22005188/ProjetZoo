package src.Enclos;

import src.Creatures.CreatureFantastique;

import java.util.ArrayList;
import java.util.List;
public class EnclosAquarium extends Enclos {

    private List<CreatureFantastique> creaturesAquarium;

    public EnclosAquarium(String nomEnclos, int capaciteMax) {
        super(nomEnclos, capaciteMax);
        this.creaturesAquarium = new ArrayList<>();
    }
    public void verifierProfondeur() {
        System.out.println("Vérification de la profondeur de l'enclos aquarium en cours...");
        // Logique pour vérifier la profondeur de l'enclos aquarium
        System.out.println("La vérification de la profondeur est terminée.");
    }
    public void verifierSanite() {
        System.out.println("Vérification de la santé de l'enclos aquarium en cours...");
        // Logique pour vérifier la santé de l'enclos aquarium
        System.out.println("La vérification de la santé est terminée.");
    }
    public boolean ajouterCreature(CreatureFantastique creature) {
        System.out.println("Tentative d'ajout de la créature à l'enclos aquarium...");
        if (this.creaturesAquarium.size() < this.capaciteMax) {
            this.creaturesAquarium.add(creature);
            System.out.printf("%s ajouté(e) à l'enclos aquarium %s.%n", creature.getNomEspece(), this.nomEnclos);
            return true;
        } else {
            System.out.println("L'enclos aquarium est plein, impossible d'ajouter la créature.");
            return false;
        }
    }
}
