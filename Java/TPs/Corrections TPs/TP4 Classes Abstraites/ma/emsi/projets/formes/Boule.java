package ma.emsi.projets.formes;

/**
 * Classe Boule représentant une sphère dans l'espace.
 */
public class Boule extends Forme {
    // Attribut spécifique à la boule
    private double rayon;
    
    /**
     * Constructeur avec paramètres
     * 
     * @param centreGravite Le centre de gravité de la boule
     * @param densite La densité de la boule
     * @param rayon Le rayon de la boule
     */
    public Boule(Point3D centreGravite, double densite, double rayon) {
        super(centreGravite, densite);
        this.rayon = rayon;
    }
    
    /**
     * Calcule la surface de la boule (4 * π * r²)
     * 
     * @return La surface de la boule
     */
    @Override
    public double calculerSurface() {
        return 4 * Math.PI * rayon * rayon;
    }
    
    /**
     * Calcule le volume de la boule (4/3 * π * r³)
     * 
     * @return Le volume de la boule
     */
    @Override
    public double calculerVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(rayon, 3);
    }
    
    /**
     * Getter pour le rayon
     * @return Le rayon de la boule
     */
    public double getRayon() {
        return rayon;
    }
    
    /**
     * Setter pour le rayon
     * @param rayon Le nouveau rayon
     */
    public void setRayon(double rayon) {
        this.rayon = rayon;
    }
    
    /**
     * Redéfinition de toString pour afficher les informations de la boule
     * @return Une chaîne représentant la boule
     */
    @Override
    public String toString() {
        return super.toString() + 
               "\n rayon : " + rayon + 
               "\n]";
    }
}