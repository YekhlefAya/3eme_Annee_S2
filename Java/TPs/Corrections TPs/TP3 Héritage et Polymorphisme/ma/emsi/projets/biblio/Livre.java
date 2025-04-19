package ma.emsi.projets.biblio;

/**
 * Classe Livre représentant un livre générique vendu en boutique.
 * Classe parente pour les différents types de livres.
 */
public class Livre {
    // Attributs privés communs à tous les livres
    private int isbn;
    private String titre;
    private int nombreExemplaires;
    private double prix;
    
    // Constante pour la taxe appliquée sur tous les livres (20%)
    private static final double TAUX_TAXE = 0.20;
    
    /**
     * Constructeur avec paramètres
     * 
     * @param isbn Le numéro ISBN du livre
     * @param titre Le titre du livre
     * @param nombreExemplaires Nombre d'exemplaires en stock
     * @param prix Prix hors taxe du livre
     */
    public Livre(int isbn, String titre, int nombreExemplaires, double prix) {
        this.isbn = isbn;
        this.titre = titre;
        this.nombreExemplaires = nombreExemplaires;
        this.prix = prix;
    }
    
    /**
     * Calcule le prix TTC du livre en appliquant une taxe de 20%
     * 
     * @return Le prix TTC
     */
    public double prixTTC() {
        return prix * (1 + TAUX_TAXE);
    }
    
    /**
     * Getter pour l'ISBN
     * @return Le numéro ISBN
     */
    public int getIsbn() {
        return isbn;
    }
    
    /**
     * Getter pour le titre
     * @return Le titre du livre
     */
    public String getTitre() {
        return titre;
    }
    
    /**
     * Getter pour le nombre d'exemplaires
     * @return Le nombre d'exemplaires en stock
     */
    public int getNombreExemplaires() {
        return nombreExemplaires;
    }
    
    /**
     * Getter pour le prix (hors taxe)
     * @return Le prix hors taxe
     */
    public double getPrix() {
        return prix;
    }
    
    /**
     * Redéfinition de la méthode toString() pour afficher les informations du livre
     * 
     * @return Une chaîne représentant le livre
     */
    @Override
    public String toString() {
        return "Livre [ISBN=" + isbn + 
               ", Titre=" + titre + 
               ", Exemplaires=" + nombreExemplaires + 
               ", Prix HT=" + prix + "€" +
               ", Prix TTC=" + String.format("%.2f", prixTTC()) + "€]";
    }
}
