package ma.emsi.projets.biblio;

/**
 * Classe LivreScolaire représentant un livre scolaire.
 * Hérite de la classe Livre et ajoute des attributs spécifiques
 * ainsi qu'une réduction de 30% sur le prix TTC.
 */
public class LivreScolaire extends Livre {
    // Attributs spécifiques aux livres scolaires
    private String discipline;
    private String niveauEtudes;
    
    // Constante pour la réduction appliquée (30%)
    private static final double REDUCTION = 0.30;
    
    /**
     * Constructeur avec paramètres
     * 
     * @param isbn Le numéro ISBN du livre
     * @param titre Le titre du livre
     * @param nombreExemplaires Nombre d'exemplaires en stock
     * @param prix Prix hors taxe du livre
     * @param discipline La discipline du livre scolaire
     * @param niveauEtudes Le niveau d'études correspondant
     */
    public LivreScolaire(int isbn, String titre, int nombreExemplaires, double prix, 
                         String discipline, String niveauEtudes) {
        // Appel du constructeur de la classe parente
        super(isbn, titre, nombreExemplaires, prix);
        
        // Initialisation des attributs spécifiques
        this.discipline = discipline;
        this.niveauEtudes = niveauEtudes;
    }
    
    /**
     * Redéfinition de la méthode prixTTC pour appliquer une réduction de 30%
     * sur le prix TTC calculé par la classe parente
     * 
     * @return Le prix TTC avec réduction
     */
    @Override
    public double prixTTC() {
        // Calcul du prix TTC normal, puis application de la réduction
        double prixTTCNormal = super.prixTTC();
        return prixTTCNormal * (1 - REDUCTION);
    }
    
    /**
     * Méthode qui affiche la discipline du livre scolaire
     */
    public void afficherDiscipline() {
        System.out.println("Ce livre scolaire concerne la matière : " + discipline);
    }
    
    /**
     * Getter pour la discipline
     * @return La discipline du livre
     */
    public String getDiscipline() {
        return discipline;
    }
    
    /**
     * Getter pour le niveau d'études
     * @return Le niveau d'études
     */
    public String getNiveauEtudes() {
        return niveauEtudes;
    }
    
    /**
     * Redéfinition de la méthode toString() pour inclure les informations spécifiques
     * 
     * @return Une chaîne représentant le livre scolaire
     */
    @Override
    public String toString() {
        return "Livre scolaire [ISBN=" + getIsbn() + 
               ", Titre=" + getTitre() + 
               ", Exemplaires=" + getNombreExemplaires() + 
               ", Prix HT=" + getPrix() + "€" +
               ", Prix TTC avec réduction=" + String.format("%.2f", prixTTC()) + "€" +
               ", Discipline=" + discipline + 
               ", Niveau=" + niveauEtudes + "]";
    }
}