package ma.emsi.projets.formes;

/**
 * Classe Cube représentant un cube dans l'espace.
 * Un cube est une brique spéciale où largeur = longueur = hauteur.
 * Cette classe ne peut pas être étendue (mot-clé final).
 */
public final class Cube extends Brique {
    
    /**
     * Constructeur avec paramètres
     * 
     * @param centreGravite Le centre de gravité du cube
     * @param densite La densité du cube
     * @param cote La longueur du côté du cube (identique pour largeur, longueur et hauteur)
     */
    public Cube(Point3D centreGravite, double densite, double cote) {
        // Appel du constructeur de la classe parente avec les mêmes valeurs pour largeur, longueur et hauteur
        super(centreGravite, densite, cote, cote, cote);
    }
    
    /**
     * Getter pour le côté du cube
     * @return La longueur du côté du cube
     */
    public double getCote() {
        return getLargeur(); // ou getLongueur() ou getHauteur() car elles sont égales
    }
    
    /**
     * Setter pour le côté du cube
     * Les trois dimensions doivent rester égales
     * 
     * @param cote La nouvelle longueur du côté
     */
    public void setCote(double cote) {
        setLargeur(cote);
        setLongueur(cote);
        setHauteur(cote);
    }
    
    /**
     * Redéfinition du setter de largeur pour maintenir l'égalité des côtés
     * @param largeur La nouvelle largeur (sera appliquée aux trois dimensions)
     */
    @Override
    public void setLargeur(double largeur) {
        super.setLargeur(largeur);
        super.setLongueur(largeur);
        super.setHauteur(largeur);
    }
    
    /**
     * Redéfinition du setter de longueur pour maintenir l'égalité des côtés
     * @param longueur La nouvelle longueur (sera appliquée aux trois dimensions)
     */
    @Override
    public void setLongueur(double longueur) {
        super.setLargeur(longueur);
        super.setLongueur(longueur);
        super.setHauteur(longueur);
    }
    
    /**
     * Redéfinition du setter de hauteur pour maintenir l'égalité des côtés
     * @param hauteur La nouvelle hauteur (sera appliquée aux trois dimensions)
     */
    @Override
    public void setHauteur(double hauteur) {
        super.setLargeur(hauteur);
        super.setLongueur(hauteur);
        super.setHauteur(hauteur);
    }
    
    /**
     * Redéfinition de toString pour afficher les informations du cube
     * @return Une chaîne représentant le cube
     */
    @Override
    public String toString() {
        return "[Cube" + 
               "\n centre de gravité : [" + getCentreGravite() + "]" +
               "\n densité : " + getDensite() +
               "\n côté : " + getCote() +
               "\n]";
    }
}