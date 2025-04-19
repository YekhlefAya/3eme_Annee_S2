package ma.emsi.projets.banque;

/**
 * Classe Personne qui représente une personne physique.
 * Cette classe est utilisée pour représenter les titulaires des comptes bancaires.
 */
public class Personne {
    // Attributs privés pour encapsuler les données
    private String nom;
    private String prenom;
    
    /**
     * Constructeur avec paramètres pour initialiser une personne avec son nom et prénom
     * @param nom Le nom de la personne
     * @param prenom Le prénom de la personne
     */
    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
    
    /**
     * Getter pour récupérer le nom de la personne
     * @return Le nom de la personne
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * Getter pour récupérer le prénom de la personne
     * @return Le prénom de la personne
     */
    public String getPrenom() {
        return prenom;
    }
    
    /**
     * Redéfinition de la méthode toString() héritée de la classe Object
     * Cette méthode permet d'obtenir une représentation textuelle de l'objet
     * 
     * Pourquoi toString() est important:
     * 1. Facilite le débogage: affiche les informations de l'objet de manière lisible
     * 2. Utilisée automatiquement lors de la concaténation avec des chaînes de caractères
     * 3. Utilisée par les méthodes d'affichage comme System.out.println()
     * 4. Permet d'avoir une représentation standardisée de l'objet
     * 
     * @return Une chaîne contenant le nom et le prénom de la personne
     */
    @Override
    public String toString() {
        return prenom + " " + nom;
    }
}