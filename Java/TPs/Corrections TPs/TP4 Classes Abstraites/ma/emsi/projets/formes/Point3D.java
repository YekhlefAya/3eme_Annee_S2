package ma.emsi.projets.formes;

/**
 * Classe Point3D représentant un point dans l'espace en 3D.
 * Cette classe est utilisée comme centre de gravité des formes.
 */
public class Point3D {
    // Coordonnées du point en 3D
    private double x;
    private double y;
    private double z;
    
    /**
     * Constructeur avec paramètres
     * 
     * @param x Coordonnée x du point
     * @param y Coordonnée y du point
     * @param z Coordonnée z du point
     */
    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    /**
     * Translate le point selon un vecteur donné
     * 
     * @param dx Déplacement sur l'axe x
     * @param dy Déplacement sur l'axe y
     * @param dz Déplacement sur l'axe z
     */
    public void bouger(double dx, double dy, double dz) {
        this.x += dx;
        this.y += dy;
        this.z += dz;
    }
    
    /**
     * Vérifie si deux points sont identiques
     * 
     * @param o L'objet à comparer
     * @return true si les deux points sont identiques, false sinon
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Point3D point3D = (Point3D) o;
        
        if (Double.compare(point3D.x, x) != 0) return false;
        if (Double.compare(point3D.y, y) != 0) return false;
        return Double.compare(point3D.z, z) == 0;
    }
    
    /**
     * Fixe les coordonnées du point
     * 
     * @param x Nouvelle coordonnée x
     * @param y Nouvelle coordonnée y
     * @param z Nouvelle coordonnée z
     */
    public void setXYZ(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    /**
     * Getter pour la coordonnée x
     * @return La coordonnée x
     */
    public double getX() {
        return x;
    }
    
    /**
     * Getter pour la coordonnée y
     * @return La coordonnée y
     */
    public double getY() {
        return y;
    }
    
    /**
     * Getter pour la coordonnée z
     * @return La coordonnée z
     */
    public double getZ() {
        return z;
    }
    
    /**
     * Redéfinition de toString pour afficher les informations du point
     * @return Une chaîne représentant le point
     */
    @Override
    public String toString() {
        return "Point3D x: " + x + ", y: " + y + ", z: " + z;
    }
}