package ma.emsi.projets.biblio;

/**
 * Classe Biblio contenant la méthode main pour tester les classes
 * Livre, LivreEnfant et LivreScolaire.
 */
public class Biblio {

    public static void main(String[] args) {
        System.out.println("GESTION DE LA BIBLIOTHÈQUE:");
        
        // Création d'un tableau de livres de différents types
        Livre[] livres = new Livre[6];
        
        // Livres génériques
        livres[0] = new Livre(1001, "Le Petit Prince", 50, 12.50);
        livres[1] = new Livre(1002, "1984", 30, 19.99);
        
        // Livres pour enfants
        livres[2] = new LivreEnfant(2001, "Les Aventures de Tintin", 25, 15.75, 6, 12);
        livres[3] = new LivreEnfant(2002, "Harry Potter à l'école des sorciers", 40, 22.50, 8, 14);
        
        // Livres scolaires
        livres[4] = new LivreScolaire(3001, "Mathématiques 5ème", 100, 18.90, "Mathématiques", "Collège - 5ème");
        livres[5] = new LivreScolaire(3002, "Histoire-Géographie Terminale", 80, 24.50, "Histoire-Géographie", "Lycée - Terminale");
        
        // Affichage des informations sur chaque livre
        System.out.println("\nInformations sur les livres:");
        
        for (int i = 0; i < livres.length; i++) {
            System.out.println("\n* Livre " + (i+1) + " *");
            // Affichage des informations générales du livre (toString)
            System.out.println(livres[i]);
            
            // Affichage du prix TTC
            System.out.println("Prix TTC: " + String.format("%.2f", livres[i].prixTTC()) + "€");
            
            // Si c'est un livre pour enfant, afficher la tranche d'âge
            if (livres[i] instanceof LivreEnfant) {
                LivreEnfant livreEnfant = (LivreEnfant) livres[i];
                livreEnfant.afficherTrancheAge();
            }
            
            // Si c'est un livre scolaire, afficher la discipline
            if (livres[i] instanceof LivreScolaire) {
                LivreScolaire livreScolaire = (LivreScolaire) livres[i];
                livreScolaire.afficherDiscipline();
            }
        }
        
        // Démonstration du polymorphisme
        System.out.println("\nDémonstration du polymorphisme:");
        
        // Création d'objets avec des références de type Livre
        Livre livreNormal = new Livre(1003, "Les Misérables", 15, 25.00);
        Livre livreEnfant = new LivreEnfant(2003, "Le Petit Chaperon Rouge", 20, 10.00, 4, 8);
        Livre livreScolaire = new LivreScolaire(3003, "Physique-Chimie 2nde", 60, 22.90, "Sciences Physiques", "Lycée - 2nde");
        
        // Calcul du prix TTC pour chaque type de livre
        System.out.println("Livre normal: Prix HT = " + livreNormal.getPrix() + "€, Prix TTC = " + 
                          String.format("%.2f", livreNormal.prixTTC()) + "€");
        System.out.println("Livre enfant: Prix HT = " + livreEnfant.getPrix() + "€, Prix TTC = " + 
                          String.format("%.2f", livreEnfant.prixTTC()) + "€ (avec réduction de 50%)");
        System.out.println("Livre scolaire: Prix HT = " + livreScolaire.getPrix() + "€, Prix TTC = " + 
                          String.format("%.2f", livreScolaire.prixTTC()) + "€ (avec réduction de 30%)");
        
        // Démonstration du calcul des prix avec des valeurs fixes pour vérification
        System.out.println("\nVérification des calculs de prix:");
        double prixFixe = 100.0; // Prix HT fixe pour la démonstration
        
        Livre livreDemo1 = new Livre(9001, "Livre Test Standard", 1, prixFixe);
        Livre livreDemo2 = new LivreEnfant(9002, "Livre Test Enfant", 1, prixFixe, 5, 10);
        Livre livreDemo3 = new LivreScolaire(9003, "Livre Test Scolaire", 1, prixFixe, "Test", "Test");
        
        System.out.println("Prix HT commun: " + prixFixe + "€");
        System.out.println("Livre standard: Prix TTC = " + String.format("%.2f", livreDemo1.prixTTC()) + "€ (Prix HT + 20% TVA)");
        System.out.println("Livre enfant: Prix TTC = " + String.format("%.2f", livreDemo2.prixTTC()) + "€ (Prix HT + 20% TVA - 50% réduction)");
        System.out.println("Livre scolaire: Prix TTC = " + String.format("%.2f", livreDemo3.prixTTC()) + "€ (Prix HT + 20% TVA - 30% réduction)");
    }
}