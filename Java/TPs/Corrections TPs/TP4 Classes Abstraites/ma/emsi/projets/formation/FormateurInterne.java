package ma.emsi.projets.formation;

/**
 * Classe FormateurInterne représentant un formateur interne du centre.
 * Son salaire est un montant fixe plus des heures supplémentaires au-delà de 120h.
 */
public class FormateurInterne extends Formateur {
    // Constantes pour le calcul du salaire
    private static final double SALAIRE_FIXE = 10000.0; // Salaire fixe mensuel en DH
    private static final double TAUX_HEURE_SUP = 300.0; // Taux par heure supplémentaire en DH
    private static final int SEUIL_HEURES_SUP = 120; // Seuil pour les heures supplémentaires
    
    /**
     * Constructeur avec paramètres
     * 
     * @param nom Le nom du formateur
     * @param prenom Le prénom du formateur
     * @param heuresFormation Le nombre d'heures de formation assurées
     */
    public FormateurInterne(String nom, String prenom, int heuresFormation) {
        super(nom, prenom, heuresFormation);
    }
    
    /**
     * Calcule le salaire du formateur interne.
     * Salaire = salaire fixe + (heures au-delà de 120) * taux horaire supplémentaire
     * 
     * @return Le salaire mensuel en dirhams
     */
    @Override
    public double calculerSalaire() {
        int heuresFormation = getHeuresFormation();
        
        // Calcul des heures supplémentaires (au-delà de 120h)
        int heuresSupplementaires = Math.max(0, heuresFormation - SEUIL_HEURES_SUP);
        
        // Calcul du salaire total
        return SALAIRE_FIXE + (heuresSupplementaires * TAUX_HEURE_SUP);
    }
    
    /**
     * Redéfinition de toString pour afficher les informations spécifiques aux formateurs internes
     * @return Une chaîne représentant le formateur interne
     */
    @Override
    public String toString() {
        int heuresFormation = getHeuresFormation();
        int heuresSupplementaires = Math.max(0, heuresFormation - SEUIL_HEURES_SUP);
        
        return "Formateur Interne: " + getPrenom() + " " + getNom() + 
               ", heures de formation: " + heuresFormation + 
               ", heures supplémentaires: " + heuresSupplementaires + 
               ", salaire: " + calculerSalaire() + " DH";
    }
}