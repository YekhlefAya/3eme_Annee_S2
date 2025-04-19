package ma.emsi.projets.formation;

/**
 * Classe FormateurStagiaire représentant un formateur stagiaire du centre.
 * Son salaire est calculé en fonction du nombre d'heures effectuées, avec un plafond.
 */
public class FormateurStagiaire extends Formateur {
    // Constantes pour le calcul du salaire
    private static final double TAUX_HORAIRE = 100.0; // Taux par heure en DH
    private static final int HEURES_MAX = 96; // Nombre maximum d'heures rémunérées
    
    /**
     * Constructeur avec paramètres
     * 
     * @param nom Le nom du formateur stagiaire
     * @param prenom Le prénom du formateur stagiaire
     * @param heuresFormation Le nombre d'heures de formation assurées
     */
    public FormateurStagiaire(String nom, String prenom, int heuresFormation) {
        super(nom, prenom, heuresFormation);
    }
    
    /**
     * Calcule le salaire du formateur stagiaire.
     * Salaire = min(heures effectuées, 96) * taux horaire
     * Les heures au-delà de 96 ne sont pas rémunérées.
     * 
     * @return Le salaire mensuel en dirhams
     */
    @Override
    public double calculerSalaire() {
        // On prend le minimum entre les heures effectuées et le plafond
        int heuresComptabilisees = Math.min(getHeuresFormation(), HEURES_MAX);
        return heuresComptabilisees * TAUX_HORAIRE;
    }
    
    /**
     * Retourne le nombre d'heures effectivement rémunérées
     * @return Le nombre d'heures rémunérées (max 96)
     */
    public int getHeuresRemunerees() {
        return Math.min(getHeuresFormation(), HEURES_MAX);
    }
    
    /**
     * Retourne le nombre d'heures non rémunérées (au-delà du plafond)
     * @return Le nombre d'heures non rémunérées
     */
    public int getHeuresNonRemunerees() {
        return Math.max(0, getHeuresFormation() - HEURES_MAX);
    }
    
    /**
     * Redéfinition de toString pour afficher les informations spécifiques aux formateurs stagiaires
     * @return Une chaîne représentant le formateur stagiaire
     */
    @Override
    public String toString() {
        return "Formateur Stagiaire: " + getPrenom() + " " + getNom() + 
               ", heures de formation: " + getHeuresFormation() + 
               ", heures rémunérées: " + getHeuresRemunerees() +
               ", heures non rémunérées: " + getHeuresNonRemunerees() +
               ", salaire: " + calculerSalaire() + " DH";
    }
}