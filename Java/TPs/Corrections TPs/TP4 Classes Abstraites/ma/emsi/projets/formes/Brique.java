package ma.emsi.projets.formes;

/**
 * Classe Brique représentant un parallélépipède rectangle dans l'espace.
 */
public class Brique extends Forme {
    // Attributs spécifiques à la brique
    private double largeur;
    private double longueur;
    private double hauteur;
    
    /**
     * Constructeur avec paramètres
     * 
     * @param centreGravite Le centre de gravité de la brique
     * @param densite La densité de la brique
     * @param largeur La largeur de la brique
     * @param longueur La longueur de la brique
     * @param hauteur La hauteur de la brique
     */
    public Brique(Point3D centreGravite, double densite, double largeur, double longueur, double hauteur) {
        super(centreGravite, densite);
        this.largeur = largeur;
        this.longueur = longueur;
        this.hauteur = hauteur;
    }
    
    /**
     * Calcule la surface de la brique
     * Surface = 2 * (longueur * largeur + longueur * hauteur + largeur * hauteur)
     * 
     * @return La surface de la brique
     */
    @Override
    public double calculerSurface() {
        return 2 * (longueur * largeur + longueur * hauteur + largeur * hauteur);
    }
    
    /**
     * Calcule le volume de la brique (longueur * largeur * hauteur)
     * 
     * @return Le volume de la brique
     */
    @Override
    public double calculerVolume() {
        return longueur * largeur * hauteur;
    }
    
    /**
     * Getter pour la largeur
     * @return La largeur de la brique
     */
    public double getLargeur() {
        return largeur;
    }
    
    /**
     * Setter pour la largeur
     * @param largeur La nouvelle largeur
     */
    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }
    
    /**
     * Getter pour la longueur
     * @return La longueur de la brique
     */
    public double getLongueur() {
        return longueur;
    }
    
    /**
     * Setter pour la longueur
     * @param longueur La nouvelle longueur
     */
    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }
    
    /**
     * Getter pour la hauteur
     * @return La hauteur de la brique
     */
    public double getHauteur() {
        return hauteur;
    }
    
    /**
     * Setter pour la hauteur
     * @param hauteur La nouvelle hauteur
     */
    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }
    
    /**
     * Redéfinition de toString pour afficher les informations de la brique
     * @return Une chaîne représentant la brique
     */
    @Override
    public String toString() {
        return super.toString() + 
               "\n largeur : " + largeur +
               "\n longueur : " + longueur +
               "\n hauteur : " + hauteur +
               "\n]";
    }
}