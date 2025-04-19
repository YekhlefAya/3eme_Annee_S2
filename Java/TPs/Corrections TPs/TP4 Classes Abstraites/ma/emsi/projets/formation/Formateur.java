package ma.emsi.projets.formation;

/**
 * Classe abstraite Formateur représentant un formateur du centre international de formation.
 * Le calcul du salaire dépend du type spécifique de formateur.
 */
public abstract class Formateur {
    // Attributs communs à tous les formateurs
    private String nom;
    private String prenom;
    private int heuresFormation;
    private String[] competences;
    
    /**
     * Constructeur avec paramètres
     * 
     * @param nom Le nom du formateur
     * @param prenom Le prénom du formateur
     * @param heuresFormation Le nombre d'heures de formation assurées
     */
    public Formateur(String nom, String prenom, int heuresFormation) {
        this.nom = nom;
        this.prenom = prenom;
        this.heuresFormation = heuresFormation;
        this.competences = new String[0]; // Tableau vide au départ
    }
    
    /**
     * Méthode abstraite pour calculer le salaire du formateur.
     * Chaque type de formateur aura sa propre implémentation.
     * 
     * @return Le salaire mensuel en dirhams
     */
    public abstract double calculerSalaire();
    
    /**
     * Ajoute une compétence au formateur
     * 
     * @param competence La compétence à ajouter
     */
    public void ajouterCompetence(String competence) {
        if (competence != null && !competence.trim().isEmpty()) {
            // Création d'un nouveau tableau avec une taille augmentée de 1
            String[] nouveauTableau = new String[competences.length + 1];
            
            // Copie des compétences existantes
            for (int i = 0; i < competences.length; i++) {
                nouveauTableau[i] = competences[i];
            }
            
            // Ajout de la nouvelle compétence
            nouveauTableau[competences.length] = competence;
            
            // Remplacement du tableau
            competences = nouveauTableau;
        }
    }
    
    /**
     * Vérifie si le formateur possède une compétence spécifique
     * 
     * @param competence La compétence à vérifier
     * @return true si le formateur possède cette compétence, false sinon
     */
    public boolean possedeCompetence(String competence) {
        for (int i = 0; i < competences.length; i++) {
            if (competences[i].equals(competence)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Getter pour le nom
     * @return Le nom du formateur
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * Getter pour le prénom
     * @return Le prénom du formateur
     */
    public String getPrenom() {
        return prenom;
    }
    
    /**
     * Getter pour le nombre d'heures de formation
     * @return Le nombre d'heures de formation
     */
    public int getHeuresFormation() {
        return heuresFormation;
    }
    
    /**
     * Setter pour modifier le nombre d'heures de formation
     * @param heuresFormation Le nouveau nombre d'heures
     */
    public void setHeuresFormation(int heuresFormation) {
        this.heuresFormation = heuresFormation;
    }
    
    /**
     * Getter pour le tableau des compétences
     * @return Le tableau des compétences
     */
    public String[] getCompetences() {
        return competences;
    }
    
    /**
     * Redéfinition de toString pour afficher les informations du formateur
     * @return Une chaîne représentant le formateur
     */
    @Override
    public String toString() {
        // Construction de la chaîne des compétences
        StringBuilder competencesStr = new StringBuilder();
        for (int i = 0; i < competences.length; i++) {
            competencesStr.append(competences[i]);
            if (i < competences.length - 1) {
                competencesStr.append(", ");
            }
        }
        
        return "Formateur: " + prenom + " " + nom + 
               ", heures de formation: " + heuresFormation + 
               ", compétences: [" + competencesStr.toString() + "]" + 
               ", salaire: " + calculerSalaire() + " DH";
    }
}