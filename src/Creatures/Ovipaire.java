package src.Creatures;


public abstract class Ovipaire extends CreatureFantastique {
        public Ovipaire(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim) {
            super(nomEspece, sexe, poids, taille, age, indicateurFaim);
            // Assurez-vous d'appeler le constructeur de la classe mère avec les paramètres appropriés
        }


    /**
     *
     */
    @Override
    public void emettreSon() {

    }

    /**
     *
     */
    @Override
    public void soigner() {

    }

    /**
     * Méthode définissant la capacité de pondre pour une créature ovipare.
     * Vérifie si la créature est de type Vivipaire et de sexe féminin ('F').
     * Si tel est le cas, la créature peut mettre bas en appelant la méthode appropriée.
     * Sinon, affiche un message indiquant que la créature ne peut pas pondre.
     */
    public void pondre() {
        if (this.getSexe() == 'F' && peutPondre()) {
            peutPondre();
        } else {
            System.out.println("Cette créature ovipare ne peut pas pondre !");
        }
    }

    public boolean peutPondre() {
        // Logique pour déterminer si la créature ovipare peut pondre
        // Vous pouvez mettre en place ici la logique spécifique pour vérifier si la créature peut pondre
        return true; // Ou retournez true ou false selon la logique à implémenter
    }


    // Les autres méthodes spécifiques à Ovipaire
}
