package ma.emsi.projets.salaire;

import java.time.LocalDate;

/**
 * Classe Technicien représentant un employé technicien.
 * Son salaire est calculé comme le nombre d'unités produites multiplié par 5 DH.
 */
public class Technicien extends Employe {
    // Attribut spécifique aux techniciens
    private int nombreUnites;
    
    // Constante pour le prix unitaire
    private static final double PRIX_UNITAIRE = 5.0; // 5 DH par unité
    
    /**
     * Constructeur avec paramètres
     * 
     * @param nom Le nom du technicien
     * @param prenom Le prénom du technicien
     * @param age L'âge du technicien
     * @param dateEntree La date d'entrée en service
     * @param nombreUnites Le nombre d'unités produites mensuellement
     */
    public Technicien(String nom, String prenom, int age, LocalDate dateEntree, int nombreUnites) {
        // Appel du constructeur de la classe parente
        super(nom, prenom, age, dateEntree);
        this.nombreUnites = nombreUnites;
    }
    
    /**
     * Implémentation de la méthode abstraite calculerSalaire pour les techniciens.
     * Le salaire d'un technicien est le nombre d'unités produites multiplié par 5 DH.
     * 
     * @return Le salaire mensuel du technicien
     */
    @Override
    public double calculerSalaire() {
        return nombreUnites * PRIX_UNITAIRE;
    }
    
    /**
     * Redéfinition de la méthode getNom pour spécifier "Technicien"
     * 
     * @return Le nom complet préfixé par "Technicien"
     */
    @Override
    public String getNom() {
        return "Technicien " + getPrenom() + " " + getNomBrut();
    }
    
    /**
     * Getter pour le nombre d'unités
     * @return Le nombre d'unités produites
     */
    public int getNombreUnites() {
        return nombreUnites;
    }
    
    /**
     * Setter pour mettre à jour le nombre d'unités
     * @param nombreUnites Le nouveau nombre d'unités
     */
    public void setNombreUnites(int nombreUnites) {
        this.nombreUnites = nombreUnites;
    }
    
    /**
     * Redéfinition de toString pour inclure les informations spécifiques
     * @return Une chaîne représentant le technicien
     */
    @Override
    public String toString() {
        return "Technicien: " + getPrenom() + " " + getNomBrut() + 
               ", âge: " + getAge() + 
               ", date d'entrée: " + getDateEntree() + 
               ", unités produites: " + nombreUnites +
               ", salaire: " + calculerSalaire() + " DH";
    }
}