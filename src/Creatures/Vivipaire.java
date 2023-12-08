package src.Creatures;

public abstract class Vivipaire extends CreatureFantastique {
    private boolean gestation; // Indique si la créature vivipare est en gestation
    private char sexe; // Sexe de la créature

    // Constructeur prenant en compte le sexe de la créature
    public Vivipaire(String nomEspece) {
        super();
        this.sexe = sexe;
        this.gestation = false; // Par défaut, la créature n'est pas en gestation
    }

    // Autre constructeur
    public Vivipaire(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim, int indicateurSommeil, int indicateurSante) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim);
        this.sexe = sexe;
        this.gestation = false; // Par défaut, la créature n'est pas en gestation
    }

    public abstract void canMettreBas();

    // Méthode pour vérifier si la créature vivipare peut mettre bas
    public boolean peutMettreBas() {
        return gestation && sexe == 'F'; // Retourne vrai si la créature est en gestation et de sexe féminin, sinon faux
    }

    // Méthode pour démarrer la gestation
    public void demarrerGestation() {
        if (sexe == 'F') {
            gestation = true;
            System.out.println("La gestation a commencé.");
        } else {
            System.out.println("Seules les créatures de sexe féminin peuvent démarrer une gestation.");
        }
    }

    // Méthode pour arrêter la gestation
    public void arreterGestation() {
        gestation = false;
        System.out.println("La gestation s'est terminée.");
    }


}
