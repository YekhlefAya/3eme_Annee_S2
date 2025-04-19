package ma.emsi.projets.formes;

/**
 * Classe abstraite Forme représentant une forme tridimensionnelle.
 * Cette classe ne peut pas être instanciée directement.
 */
public abstract class Forme {
    // Attributs communs à toutes les formes
    private Point3D centreGravite;
    private double densite;
    
    /**
     * Constructeur avec paramètres
     * 
     * @param centreGravite Le centre de gravité de la forme
     * @param densite La densité de la forme
     */
    public Forme(Point3D centreGravite, double densite) {
        this.centreGravite = centreGravite;
        this.densite = densite;
    }
    
    /**
     * Déplace la forme selon un vecteur donné
     * 
     * @param dx Déplacement sur l'axe x
     * @param dy Déplacement sur l'axe y
     * @param dz Déplacement sur l'axe z
     */
    public void bouger(double dx, double dy, double dz) {
        centreGravite.bouger(dx, dy, dz);
    }
    
    /**
     * Méthode abstraite pour calculer la surface de la forme
     * 
     * @return La surface de la forme
     */
    public abstract double calculerSurface();
    
    /**
     * Méthode abstraite pour calculer le volume de la forme
     * 
     * @return Le volume de la forme
     */
    public abstract double calculerVolume();
    
    /**
     * Calcule le poids de la forme (volume * densité)
     * 
     * @return Le poids de la forme
     */
    public double calculerPoids() {
        return calculerVolume() * densite;
    }
    
    /**
     * Getter pour le centre de gravité
     * @return Le centre de gravité de la forme
     */
    public Point3D getCentreGravite() {
        return centreGravite;
    }
    
    /**
     * Getter pour la densité
     * @return La densité de la forme
     */
    public double getDensite() {
        return densite;
    }
    
    /**
     * Setter pour le centre de gravité
     * @param centreGravite Le nouveau centre de gravité
     */
    public void setCentreGravite(Point3D centreGravite) {
        this.centreGravite = centreGravite;
    }
    
    /**
     * Setter pour la densité
     * @param densite La nouvelle densité
     */
    public void setDensite(double densite) {
        this.densite = densite;
    }
    
    /**
     * Redéfinition de toString pour afficher les informations de la forme
     * @return Une chaîne représentant la forme
     */
    @Override
    public String toString() {
        return "[" + getClass().getSimpleName() + 
               "\n centre de gravité : [" + centreGravite + "]" +
               "\n densité : " + densite;
    }
}