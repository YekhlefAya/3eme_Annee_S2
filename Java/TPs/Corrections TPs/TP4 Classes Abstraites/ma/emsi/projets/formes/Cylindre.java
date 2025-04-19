package ma.emsi.projets.formes;

/**
 * Classe CylindrePlein représentant un cylindre plein dans l'espace.
 */
public class Cylindre extends Forme {
    // Attributs spécifiques au cylindre plein
    private double hauteur;
    private double rayon;
    
    /**
     * Constructeur avec paramètres
     * 
     * @param centreGravite Le centre de gravité du cylindre
     * @param densite La densité du cylindre
     * @param hauteur La hauteur du cylindre
     * @param rayon Le rayon du cylindre
     */
    public Cylindre(Point3D centreGravite, double densite, double hauteur, double rayon) {
        super(centreGravite, densite);
        this.hauteur = hauteur;
        this.rayon = rayon;
    }
    
    /**
     * Calcule la surface du cylindre (2 * π * r * (r + h))
     * Surface = surface des deux disques + surface latérale
     * 
     * @return La surface du cylindre
     */
    @Override
    public double calculerSurface() {
        // Surface des deux disques circulaires + surface latérale
        return 2 * Math.PI * rayon * rayon + 2 * Math.PI * rayon * hauteur;
    }
    
    /**
     * Calcule le volume du cylindre (π * r² * h)
     * 
     * @return Le volume du cylindre
     */
    @Override
    public double calculerVolume() {
        return Math.PI * rayon * rayon * hauteur;
    }
    
    /**
     * Getter pour la hauteur
     * @return La hauteur du cylindre
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
     * Getter pour le rayon
     * @return Le rayon du cylindre
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
     * Redéfinition de toString pour afficher les informations du cylindre
     * @return Une chaîne représentant le cylindre
     */
    @Override
    public String toString() {
        return super.toString() + 
               "\n hauteur : " + hauteur + 
               "\n rayon : " + rayon + 
               "\n]";
    }
}