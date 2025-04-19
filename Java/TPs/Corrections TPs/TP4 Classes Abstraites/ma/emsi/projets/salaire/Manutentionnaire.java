package ma.emsi.projets.salaire;

import java.time.LocalDate;

/**
 * Classe Manutentionnaire représentant un employé manutentionnaire.
 * Son salaire est calculé comme le nombre d'heures travaillées multiplié par 500 DH.
 */
public class Manutentionnaire extends Employe {
    // Attribut spécifique aux manutentionnaires
    private int nombreHeures;
    
    // Constante pour le taux horaire
    private static final double TAUX_HORAIRE = 500.0; // 500 DH par heure
    
    /**
     * Constructeur avec paramètres
     * 
     * @param nom Le nom du manutentionnaire
     * @param prenom Le prénom du manutentionnaire
     * @param age L'âge du manutentionnaire
     * @param dateEntree La date d'entrée en service
     * @param nombreHeures Le nombre d'heures travaillées mensuellement
     */
    public Manutentionnaire(String nom, String prenom, int age, LocalDate dateEntree, int nombreHeures) {
        // Appel du constructeur de la classe parente
        super(nom, prenom, age, dateEntree);
        this.nombreHeures = nombreHeures;
    }
    
    /**
     * Implémentation de la méthode abstraite calculerSalaire pour les manutentionnaires.
     * Le salaire d'un manutentionnaire est le nombre d'heures travaillées multiplié par 500 DH.
     * 
     * @return Le salaire mensuel du manutentionnaire
     */
    @Override
    public double calculerSalaire() {
        return nombreHeures * TAUX_HORAIRE;
    }
    
    /**
     * Redéfinition de la méthode getNom pour spécifier "Manutentionnaire"
     * 
     * @return Le nom complet préfixé par "Manutentionnaire"
     */
    @Override
    public String getNom() {
        return "Manutentionnaire " + getPrenom() + " " + getNomBrut();
    }
    
    /**
     * Getter pour le nombre d'heures
     * @return Le nombre d'heures travaillées
     */
    public int getNombreHeures() {
        return nombreHeures;
    }
    
    /**
     * Setter pour mettre à jour le nombre d'heures
     * @param nombreHeures Le nouveau nombre d'heures
     */
    public void setNombreHeures(int nombreHeures) {
        this.nombreHeures = nombreHeures;
    }
    
    /**
     * Redéfinition de toString pour inclure les informations spécifiques
     * @return Une chaîne représentant le manutentionnaire
     */
    @Override
    public String toString() {
        return "Manutentionnaire: " + getPrenom() + " " + getNomBrut() + 
               ", âge: " + getAge() + 
               ", date d'entrée: " + getDateEntree() + 
               ", heures travaillées: " + nombreHeures +
               ", salaire: " + calculerSalaire() + " DH";
    }
}