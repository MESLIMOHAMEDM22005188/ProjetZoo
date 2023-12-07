package src.Creatures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sirene extends Vivipaire {
    private static final double POIDS_NAISSANCE = 50.0;
    private List<Sirene> enfants;
    private static List<Sirene> adultes;
    private static List<Sirene> sirenes = new ArrayList<>();

    public Sirene(String nomEspece, char sexe, double poids, double taille, int age,
                  int indicateurFaim, int indicateurSommeil, int indicateurSante) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim, indicateurSommeil, indicateurSante);
        this.enfants = new ArrayList<>();

        if (adultes == null) {
            adultes = new ArrayList<>();
        }
    }

    @Override
    public boolean peutMettreBas() {
        // Implémentation de la reproduction pour une sirène
        if (adultes.contains(this)) {
            Random rand = new Random();
            char sexeEnfant = rand.nextBoolean() ? 'F' : 'M';
            double poidsEnfant = POIDS_NAISSANCE;
            System.out.println("La sirène a mis bas !");
        } else {
            System.out.println("Cette sirène n'est pas adulte et ne peut pas se reproduire !");
        }
        return false;
    }

    /**
     * @return
     */
    @Override
    public List<String> getEspecesNageantes() {
        return null;
    }

    /**
     * @param especes Liste des noms des espèces nageantes.
     */
    @Override
    public void setEspecesNageantes(List<String> especes) {

    }
}
