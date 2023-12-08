package src.Enclos;
import src.Creatures.CreatureFantastique;
import java.util.ArrayList;
import java.util.List;

public class EnclosVoltigeur extends Enclos {
    private List<CreatureFantastique> creaturesEnclosSimple;
    public static List<String> nomsEnclosVoltigeurCrees = new ArrayList<>();

    // Méthode pour ajouter un nom d'enclos à la liste
    public static void ajouterNomEnclos(String nomEnclos) {
        nomsEnclosVoltigeurCrees.add(nomEnclos);
    }

    // Méthode pour obtenir la liste des noms d'enclos créés
    public static List<String> getNomsEnclosCrees() {
        return nomsEnclosVoltigeurCrees;
    }
    private boolean toitVerifie;
    private List<CreatureFantastique> creaturesVoltigeur;

    public EnclosVoltigeur(String nom, int capaciteMax) {
        super(nom, capaciteMax);
        this.toitVerifie = false; // Initialisation de la vérification du toit
        this.creaturesVoltigeur = new ArrayList<>(); // Initialisation de la liste de créatures pour l'enclos voltigeur
    }

    public void verifierToit() {
        System.out.println("Vérification du toit de l'enclos voltigeur en cours...");
        // Logique pour vérifier le toit de l'enclos voltigeur
        this.toitVerifie = true;
        System.out.println("La vérification du toit est terminée.");
    }

    public boolean ajouterCreature(CreatureFantastique creature) {
        System.out.println("Tentative d'ajout de la créature à l'enclos voltigeur...");
        if (this.creaturesVoltigeur.size() < this.capaciteMax) {
            this.creaturesVoltigeur.add(creature);
            System.out.printf("%s ajouté(e) à l'enclos voltigeur %s.%n", creature.getNomEspece(), this.nomEnclos);
            return true;
        } else {
            System.out.println("L'enclos voltigeur est plein, impossible d'ajouter la créature.");
            return false;
        }
    }

    // Autres méthodes spécifiques à l'enclos voltigeur
    // ...
}
