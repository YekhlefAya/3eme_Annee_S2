package ma.emsi.projets.magasin;

/**
 * Classe Article représentant les articles vendus dans un magasin.
 * Exercice 1 du TP2
 */
public class Article {
    // Attributs (variables d'instance)
    // En Java, les attributs sont généralement déclarés en private pour respecter l'encapsulation
    // Différent de C++ où ils peuvent être publics, protégés ou privés
    private long reference;       // Référence unique de l'article
    private String description;   // Description de l'article
    private double prixHT;        // Prix hors taxe
    private int quantiteStock;    // Nombre d'unités disponibles en stock
    
    // Taux de TVA appliqué à tous les articles (10%)
    // 'static' signifie que cette variable est partagée par toutes les instances de la classe
    // 'final' signifie qu'elle ne peut pas être modifiée (constante)
    private static final double TAUX_TVA = 0.1;
    
    /**
     * Constructeur avec paramètres
     * Initialise un nouvel article avec les valeurs spécifiées
     * 
     * @param reference Référence unique de l'article
     * @param description Description de l'article
     * @param prixHT Prix hors taxe
     * @param quantiteStock Nombre d'unités disponibles initialement
     */
    public Article(long reference, String description, double prixHT, int quantiteStock) {
        // 'this' fait référence à l'instance courante (comme en C++)
        this.reference = reference;
        this.description = description;
        this.prixHT = prixHT;
        this.quantiteStock = quantiteStock;
    }
    
    /**
     * Méthode pour augmenter la quantité en stock d'un article
     * 
     * @param nombreUnites Nombre d'unités à ajouter au stock
     */
    public void approvisionner(int nombreUnites) {
        // Vérification que le nombre d'unités est positif
        if (nombreUnites > 0) {
            quantiteStock += nombreUnites;
        }
    }
    
    /**
     * Méthode pour enregistrer la vente d'un certain nombre d'unités
     * 
     * @param nombreUnites Nombre d'unités à vendre
     * @return true si la vente a été effectuée, false sinon (stock insuffisant)
     */
    public boolean vendre(int nombreUnites) {
        // Vérification que le nombre d'unités est positif et disponible en stock
        if (nombreUnites > 0 && nombreUnites <= quantiteStock) {
            quantiteStock -= nombreUnites;
            return true;
        }
        return false;  // Retourne false si la vente n'a pas pu être effectuée
    }
    
    /**
     * Calcule le prix TTC d'un article (prix unitaire)
     * 
     * @return Prix TTC de l'article
     */
    public double prixTTC() {
        // Calcul du prix TTC: prix HT + (prix HT * taux TVA)
        return prixHT + (prixHT * TAUX_TVA);
    }
    
    /**
     * Calcule le prix de vente TTC pour un certain nombre d'unités
     * 
     * @param nombreUnites Nombre d'unités à acheter
     * @return Prix total TTC pour le nombre d'unités spécifié
     */
    public double prixVenteTTC(int nombreUnites) {
        // Vérification que le nombre d'unités est positif
        if (nombreUnites > 0) {
            return prixTTC() * nombreUnites;
        }
        return 0;  // Retourne 0 si le nombre d'unités est négatif ou nul
    }
    
    /**
     * Redéfinition de la méthode toString() héritée de la classe Object
     * Retourne une représentation textuelle de l'article
     * 
     * @return Chaîne de caractères décrivant l'article
     */
    @Override  // Annotation indiquant que cette méthode redéfinit une méthode de la superclasse
    public String toString() {
        return "Article [reference=" + reference + ", description=" + description + ", prixHT=" + prixHT
                + ", prixTTC=" + prixTTC() + ", quantiteStock=" + quantiteStock + "]";
    }

    /**
     * Redéfinition de la méthode equals() héritée de la classe Object
     * Vérifie si deux articles sont égaux en comparant leurs références
     * 
     * @param obj Objet à comparer avec l'instance courante
     * @return true si les deux articles ont la même référence, false sinon
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)  // Si c'est le même objet en mémoire
            return true;
        if (obj == null)  // Si l'objet comparé est null
            return false;
        if (getClass() != obj.getClass())  // Si les classes sont différentes
            return false;
        Article other = (Article) obj;  // Cast en Article
        // Comparaison des références uniquement
        return reference == other.reference;
    }

    /**
     * Redéfinition de la méthode hashCode() héritée de la classe Object
     * Génère un code de hachage basé sur la référence
     * 
     * @return Code de hachage
     */
    @Override
    public int hashCode() {
        // Génération d'un code de hachage basé sur la référence
        // Cette méthode est souvent redéfinie avec equals pour garantir la cohérence
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (reference ^ (reference >>> 32));
        return result;
    }
    
    /**
     * Méthode principale pour tester la classe Article
     */
    public static void main(String[] args) {
        // Création d'un tableau de 10 articles
        Article[] articles = new Article[10];
        
        // Initialisation des articles avec différentes valeurs
        articles[0] = new Article(1001, "Ordinateur portable", 899.99, 15);
        articles[1] = new Article(1002, "Smartphone", 499.99, 25);
        articles[2] = new Article(1003, "Casque audio", 79.99, 50);
        articles[3] = new Article(1004, "Montre connectée", 199.99, 20);
        articles[4] = new Article(1005, "Tablette", 349.99, 18);
        articles[5] = new Article(1006, "Enceinte Bluetooth", 59.99, 40);
        articles[6] = new Article(1007, "Clavier sans fil", 39.99, 30);
        articles[7] = new Article(1008, "Souris optique", 19.99, 45);
        articles[8] = new Article(1009, "Webcam HD", 69.99, 22);
        articles[9] = new Article(1010, "Écouteurs sans fil", 89.99, 35);
        
        // Test des méthodes de la classe Article
        System.out.println("Test de la classe Article:");
        
        // Affichage des articles (méthode toString)
        System.out.println("\nListe des articles:");
        for (Article article : articles) {
            System.out.println(article);
        }
        
        // Test de la méthode approvisionner
        System.out.println("\nTest de la méthode approvisionner:");
        System.out.println("Avant approvisionnement: " + articles[0]);
        articles[0].approvisionner(5);
        System.out.println("Après approvisionnement de 5 unités: " + articles[0]);
        
        // Test de la méthode vendre
        System.out.println("\nTest de la méthode vendre:");
        System.out.println("Avant vente: " + articles[1]);
        
        boolean venteReussie = articles[1].vendre(3);
        System.out.println("Tentative de vente de 3 unités... Résultat: " + 
                          (venteReussie ? "Réussie" : "Échouée"));
        System.out.println("Après vente: " + articles[1]);
        
        // Tentative de vente avec un stock insuffisant
        System.out.println("\nAvant vente (stock insuffisant): " + articles[2]);
        venteReussie = articles[2].vendre(100);  // Quantité supérieure au stock
        System.out.println("Tentative de vente de 100 unités... Résultat: " + 
                          (venteReussie ? "Réussie" : "Échouée"));
        System.out.println("Après tentative de vente: " + articles[2]);
        
        // Test de la méthode prixTTC
        System.out.println("\nTest de la méthode prixTTC:");
        for (int i = 0; i < 3; i++) {
            System.out.println("Prix HT de " + articles[i].description + ": " + articles[i].prixHT + 
                              " € | Prix TTC: " + articles[i].prixTTC() + " €");
        }
        
        // Test de la méthode prixVenteTTC
        System.out.println("\nTest de la méthode prixVenteTTC:");
        int quantiteAchat = 3;
        for (int i = 0; i < 3; i++) {
            System.out.println("Prix TTC pour " + quantiteAchat + " unités de " + 
                              articles[i].description + ": " + articles[i].prixVenteTTC(quantiteAchat) + " €");
        }
        
        // Test de la méthode equals
        System.out.println("\nTest de la méthode equals:");
        // Création d'un nouvel article avec la même référence que articles[0]
        Article articleDuplique = new Article(1001, "Produit similaire", 599.99, 10);
        System.out.println("Article original: " + articles[0]);
        System.out.println("Article avec même référence mais description différente: " + articleDuplique);
        System.out.println("Les articles sont-ils égaux? " + articles[0].equals(articleDuplique));
        
        // Création d'un article avec une référence différente
        Article articleDifferent = new Article(9999, "Ordinateur portable", 899.99, 15);
        System.out.println("\nArticle original: " + articles[0]);
        System.out.println("Article avec même description mais référence différente: " + articleDifferent);
        System.out.println("Les articles sont-ils égaux? " + articles[0].equals(articleDifferent));
    }
}