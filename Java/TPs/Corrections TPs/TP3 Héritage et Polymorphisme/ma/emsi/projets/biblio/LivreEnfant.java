package ma.emsi.projets.biblio;

/**
 * Classe LivreEnfant représentant un livre pour enfants.
 * Hérite de la classe Livre et ajoute des attributs spécifiques
 * ainsi qu'une réduction de 50% sur le prix TTC.
 */
public class LivreEnfant extends Livre {
    // Attributs spécifiques aux livres pour enfants
    private int ageMin;
    private int ageMax;
    
    // Constante pour la réduction appliquée (50%)
    private static final double REDUCTION = 0.50;
    
    /**
     * Constructeur avec paramètres
     * 
     * @param isbn Le numéro ISBN du livre
     * @param titre Le titre du livre
     * @param nombreExemplaires Nombre d'exemplaires en stock
     * @param prix Prix hors taxe du livre
     * @param ageMin L'âge minimum recommandé
     * @param ageMax L'âge maximum recommandé
     */
    public LivreEnfant(int isbn, String titre, int nombreExemplaires, double prix, int ageMin, int ageMax) {
        // Appel du constructeur de la classe parente
        super(isbn, titre, nombreExemplaires, prix);
        
        // Initialisation des attributs spécifiques
        this.ageMin = ageMin;
        this.ageMax = ageMax;
    }
    
    /**
     * Redéfinition de la méthode prixTTC pour appliquer une réduction de 50%
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
     * Méthode qui affiche la tranche d'âge du livre pour enfant
     */
    public void afficherTrancheAge() {
        System.out.println("Ce livre est recommandé pour les enfants de " + ageMin + " à " + ageMax + " ans.");
    }
    
    /**
     * Getter pour l'âge minimum
     * @return L'âge minimum recommandé
     */
    public int getAgeMin() {
        return ageMin;
    }
    
    /**
     * Getter pour l'âge maximum
     * @return L'âge maximum recommandé
     */
    public int getAgeMax() {
        return ageMax;
    }
    
    /**
     * Redéfinition de la méthode toString() pour inclure les informations spécifiques
     * 
     * @return Une chaîne représentant le livre pour enfant
     */
    @Override
    public String toString() {
        return "Livre pour enfant [ISBN=" + getIsbn() + 
               ", Titre=" + getTitre() + 
               ", Exemplaires=" + getNombreExemplaires() + 
               ", Prix HT=" + getPrix() + "€" +
               ", Prix TTC avec réduction=" + String.format("%.2f", prixTTC()) + "€" +
               ", Tranche d'âge=" + ageMin + "-" + ageMax + " ans]";
    }
}
