package src.Creatures;

// Interface définissant les actions disponibles pour une créature
interface ActionsCreature {
    void manger();
    void emettreSon();
    void soigner();
    void dormir();
    void seReveiller();
    void vieillir();
}
// Enumérations pour la catégorie d'âge
enum CategorieAge {
    JEUNE, ADULTE, VIEUX, MORT
}
// Enumérations des noms des espèces
enum NomEspece {
    DRAGONS, KRAKENS, LICORNES, LYCANTHROPES, MEGALODONS, NYMPHES, PHENIX, SIRENES
}
// Classe abstraite représentant les créatures fantastiques

public abstract class CreatureFantastique {
    // ... (attributs de la créature)

    protected String nom;
    protected char sexe;
    protected double poids;
    protected double taille;
    protected int age;
    protected int indicateurFaim;
    protected boolean dort;
    protected int indicateurSante;

    protected int indicateurSommeil;

    // Constructeur de la classe CreatureFantastique
    public CreatureFantastique(String nom, char sexe, double poids11, double poids1, double v, int i, double poids, double taille, int age) {
        this.nom = nom;
        this.sexe = sexe;
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.indicateurFaim = 100;
        this.dort = false;
        this.indicateurSante = 100;
        this.indicateurSommeil = 0; // Initialise à 0 par défaut
    }

    public String getNom() {
        return nom;
    }
    // Méthodes de la créature pour manger, mettre à jour la santé, etc.

    public void manger() {
        boolean isMalade = false;
        boolean estEnTrainDeDormir = indicateurSommeil == 1;
        if (!isMalade && !estEnTrainDeDormir) {
            System.out.println(nom + " mange.");
            setIndicateurFaim(10);
        } else if (isMalade) {
            System.out.println(nom + " est malade et ne peut pas manger.");
        } else if (estEnTrainDeDormir) {
            System.out.println(nom + " dort et ne peut pas manger.");
        }
    }

    public void updateSanteFromProprete() {
    }

    public boolean getNomEspece() {
        return false;
    }

    public abstract void setIndicateurProprete(int i);


    // Interface pour la capacité de courir
    public interface Run {
        default void canRun(boolean hasLegs) {
            if (hasLegs) {
                System.out.println("La créature peut courir !");
            } else {
                System.out.println("La créature ne peut pas courir car elle n'a pas de pattes !");
            }
        }
    }

    // Interface pour la capacité de nager
    public interface CanSwim {
        default void canSwim(boolean hasFins) {
            if (hasFins) {
                System.out.println("La créature peut nager !");
            } else {
                System.out.println("La créature ne peut pas nager car elle n'a pas de nageoires !");
            }
        }
    }

    // Interface pour la capacité de voler
    public interface CanFly {
        default void canFly(boolean hasWings) {
            if (hasWings) {
                System.out.println("La créature peut voler !");
            } else {
                System.out.println("La créature ne peut pas voler car elle n'a pas d'ailes !");
            }
        }
    }

    public void pandre() {
        if (this instanceof Vivipaire && sexe == 'F') {
            Vivipaire creatureVivipaire = (Vivipaire) this;
            creatureVivipaire.canMettreBas();
        } else {
            System.out.println("Cette créature ne peut pas pandre !");
        }
    }

    public void mettreBas() {
        if (this instanceof Vivipaire && sexe == 'F') {
            Vivipaire creatureVivipaire = (Vivipaire) this;
            creatureVivipaire.canMettreBas();
        } else {
            System.out.println("Cette créature ne peut pas mettre bas !");
        }
    }

    public interface Ovipaire {
        void canPandre();
    }

    public interface Vivipaire {
        void canMettreBas();
    }

    public void sEndormir() {
        if (indicateurSommeil == 1) {
            System.out.println(nom + " est déjà endormi(e).");
        } else {
            indicateurSommeil = 1;
            System.out.println(nom + " s'endort.");
        }
    }

    public abstract void emettreSon();

    public abstract void soigner();

    public void vieillir() {
        age++;
        System.out.println(nom + " vieillit. Âge actuel : " + age);
        // Logique de vieillissement pour les différentes espèces (à compléter)
    }

    public char getSexe() {
        return sexe;
    }

    public double getPoids() {
        return poids;
    }

    public double getTaille() {
        return taille;
    }

    public int getAge() {
        return age;
    }

    public int getIndicateurFaim() {
        return indicateurFaim;
    }

    public int getIndicateurSommeil() {
        return indicateurSommeil;
    }

    public int getIndicateurSante() {
        return indicateurSante;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIndicateurFaim(int indicateurFaim) {
        this.indicateurFaim = indicateurFaim;
    }

    public void setIndicateurSommeil(int indicateurSommeil) {
        this.indicateurSommeil = indicateurSommeil;
    }

    public void setIndicateurSante(int indicateurSante) {
        this.indicateurSante = indicateurSante;
    }
}

abstract class Creatures implements ActionsCreature {
    protected String nomEspece;

    protected int phase = 1;

    public Creatures(String nomEspece) {
        this.nomEspece = nomEspece;
        // ... (initialisation)
    }

    public String getNomEspece() {
        return nomEspece;
    }

    protected abstract void setIndicateurFaim(int i);

    @Override
    public void emettreSon() {
        System.out.println(nomEspece + " émet un son.");
    }

    @Override
    public void soigner() {
        System.out.println(nomEspece + " a été soigné.");
        setIsMalade(false);
        setIndicateurSante(10);
    }

    protected abstract void setIndicateurSante(int i);

    protected abstract void setIsMalade(boolean b);

    @Override
    public void vieillir() {
        CategorieAge categorieAge = CategorieAge.JEUNE;
        if (categorieAge != CategorieAge.MORT) {
            int age = 0;
            age++;
            try {
                NomEspece espece = NomEspece.valueOf(nomEspece.toUpperCase());
                // Logique de catégorisation par âge pour différentes espèces (à compléter)
            } catch (IllegalArgumentException e) {
                System.err.println("Nom d'espèce erroné !");
            }
        }
    }
}
