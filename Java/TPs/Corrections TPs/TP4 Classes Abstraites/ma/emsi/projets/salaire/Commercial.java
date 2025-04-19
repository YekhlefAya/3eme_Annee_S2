package ma.emsi.projets.salaire;

import java.time.LocalDate;

/**
 * Classe Commercial représentant un employé commercial.
 * Son salaire est calculé comme 20% du chiffre d'affaires mensuel.
 */
public class Commercial extends Employe {
    // Attribut spécifique aux commerciaux
    private double chiffreAffaires;
    
    // Constante pour le pourcentage de commission
    private static final double TAUX_COMMISSION = 0.20; // 20%
    
    /**
     * Constructeur avec paramètres
     * 
     * @param nom Le nom du commercial
     * @param prenom Le prénom du commercial
     * @param age L'âge du commercial
     * @param dateEntree La date d'entrée en service
     * @param chiffreAffaires Le chiffre d'affaires mensuel réalisé
     */
    public Commercial(String nom, String prenom, int age, LocalDate dateEntree, double chiffreAffaires) {
        // Appel du constructeur de la classe parente
        super(nom, prenom, age, dateEntree);
        this.chiffreAffaires = chiffreAffaires;
    }
    
    /**
     * Redéfinition de la méthode abstraite calculerSalaire pour les commerciaux.
     * Le salaire d'un commercial est 20% de son chiffre d'affaires.
     * 
     * @return Le salaire mensuel du commercial
     */
    @Override
    public double calculerSalaire() {
        return chiffreAffaires * TAUX_COMMISSION;
    }
    
    /**
     * Redéfinition de la méthode getNom pour spécifier "Commercial"
     * au lieu de "Employé"
     * 
     * @return Le nom complet préfixé par "Commercial"
     */
    @Override
    public String getNom() {
        return "Commercial " + getPrenom() + " " + getNomBrut();
    }
    
    /**
     * Getter pour le chiffre d'affaires
     * @return Le chiffre d'affaires mensuel
     */
    public double getChiffreAffaires() {
        return chiffreAffaires;
    }
    
    /**
     * Setter pour mettre à jour le chiffre d'affaires
     * @param chiffreAffaires Le nouveau chiffre d'affaires
     */
    public void setChiffreAffaires(double chiffreAffaires) {
        this.chiffreAffaires = chiffreAffaires;
    }
    
    /**
     * Redéfinition de toString pour inclure les informations spécifiques
     * @return Une chaîne représentant le commercial
     */
    @Override
    public String toString() {
        return "Commercial: " + getPrenom() + " " + getNomBrut() + 
               ", âge: " + getAge() + 
               ", date d'entrée: " + getDateEntree() + 
               ", chiffre d'affaires: " + chiffreAffaires + " DH" +
               ", salaire: " + calculerSalaire() + " DH";
    }
}