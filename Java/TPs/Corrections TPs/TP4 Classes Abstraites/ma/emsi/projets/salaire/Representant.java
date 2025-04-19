package ma.emsi.projets.salaire;

import java.time.LocalDate;

/**
 * Classe Representant représentant un employé type représentant.
 * Son salaire est calculé comme 20% du chiffre d'affaires mensuel plus 2000 DH.
 */
public class Representant extends Commercial {
    // Constante pour le bonus fixe des représentants
    private static final double BONUS_FIXE = 2000.0; // 2000 DH
    
    /**
     * Constructeur avec paramètres
     * 
     * @param nom Le nom du représentant
     * @param prenom Le prénom du représentant
     * @param age L'âge du représentant
     * @param dateEntree La date d'entrée en service
     * @param chiffreAffaires Le chiffre d'affaires mensuel réalisé
     */
    public Representant(String nom, String prenom, int age, LocalDate dateEntree, double chiffreAffaires) {
        // Appel du constructeur de la classe parente (Commercial)
        super(nom, prenom, age, dateEntree, chiffreAffaires);
    }
    
    /**
     * Redéfinition de la méthode calculerSalaire pour les représentants.
     * Le salaire d'un représentant est 20% de son chiffre d'affaires plus 2000 DH.
     * 
     * @return Le salaire mensuel du représentant
     */
    @Override
    public double calculerSalaire() {
        // Appel de la méthode de la classe parente pour calculer la commission
        // puis ajout du bonus fixe
        return super.calculerSalaire() + BONUS_FIXE;
    }
    
    /**
     * Redéfinition de la méthode getNom pour spécifier "Représentant"
     * 
     * @return Le nom complet préfixé par "Représentant"
     */
    @Override
    public String getNom() {
        return "Représentant " + getPrenom() + " " + getNomBrut();
    }
    
    /**
     * Redéfinition de toString pour inclure les informations spécifiques
     * @return Une chaîne représentant le représentant
     */
    @Override
    public String toString() {
        return "Représentant: " + getPrenom() + " " + getNomBrut() + 
               ", âge: " + getAge() + 
               ", date d'entrée: " + getDateEntree() + 
               ", chiffre d'affaires: " + getChiffreAffaires() + " DH" +
               ", salaire: " + calculerSalaire() + " DH";
    }
}