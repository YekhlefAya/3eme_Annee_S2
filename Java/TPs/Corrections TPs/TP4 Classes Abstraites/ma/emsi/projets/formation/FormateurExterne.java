package ma.emsi.projets.formation;

/**
 * Classe FormateurExterne représentant un formateur externe venant d'un autre centre.
 * Son salaire est calculé en fonction du nombre d'heures effectuées.
 */
public class FormateurExterne extends Formateur {
    // Attribut spécifique aux formateurs externes
    private String nomCentreExterne;
    
    // Constante pour le calcul du salaire
    private static final double TAUX_HORAIRE = 250.0; // Taux par heure en DH
    
    /**
     * Constructeur avec paramètres
     * 
     * @param nom Le nom du formateur
     * @param prenom Le prénom du formateur
     * @param heuresFormation Le nombre d'heures de formation assurées
     * @param nomCentreExterne Le nom du centre externe
     */
    public FormateurExterne(String nom, String prenom, int heuresFormation, String nomCentreExterne) {
        super(nom, prenom, heuresFormation);
        this.nomCentreExterne = nomCentreExterne;
    }
    
    /**
     * Calcule le salaire du formateur externe.
     * Salaire = nombre d'heures * taux horaire
     * 
     * @return Le salaire mensuel en dirhams
     */
    @Override
    public double calculerSalaire() {
        return getHeuresFormation() * TAUX_HORAIRE;
    }
    
    /**
     * Getter pour le nom du centre externe
     * @return Le nom du centre externe
     */
    public String getNomCentreExterne() {
        return nomCentreExterne;
    }
    
    /**
     * Setter pour modifier le nom du centre externe
     * @param nomCentreExterne Le nouveau nom du centre externe
     */
    public void setNomCentreExterne(String nomCentreExterne) {
        this.nomCentreExterne = nomCentreExterne;
    }
    
    /**
     * Redéfinition de toString pour afficher les informations spécifiques aux formateurs externes
     * @return Une chaîne représentant le formateur externe
     */
    @Override
    public String toString() {
        return "Formateur Externe: " + getPrenom() + " " + getNom() + 
               ", heures de formation: " + getHeuresFormation() + 
               ", centre externe: " + nomCentreExterne +
               ", salaire: " + calculerSalaire() + " DH";
    }
}