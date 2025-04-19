package ma.emsi.projets.salaire;

import java.time.LocalDate;

/**
 * Classe de test pour le système de gestion des salaires.
 * Cette classe démontre l'utilisation des classes abstraites et du polymorphisme.
 */
public class TestSalaire {

    public static void main(String[] args) {
        System.out.println("GESTION DES SALAIRES DE L'ENTREPRISE");
        
        // Création d'un tableau d'employés de différents types
        // Employe est une classe abstraite, on ne peut pas l'instancier directement
        Employe[] employes = new Employe[4];
        
        // Création des employés de différents types
        employes[0] = new Commercial("AB", "Maria", 35, 
                                     LocalDate.of(2015, 3, 15), 50000);
        
        employes[1] = new Representant("CD", "Khouloud", 42, 
                                        LocalDate.of(2010, 7, 1), 65000);
        
        employes[2] = new Technicien("AN", "Abdelghani", 28, 
                                      LocalDate.of(2018, 11, 10), 1200);
        
        employes[3] = new Manutentionnaire("BE", "Ahmed", 39, 
                                           LocalDate.of(2012, 5, 20), 160);
        
        // Affichage des informations sur chaque employé
        System.out.println("\nListe des employés:");
        
        for (Employe employe : employes) {
            // Utilisation de polymorphisme: la méthode appelée dépend du type réel de l'objet
            System.out.println(employe.getNom());
            System.out.println("Salaire mensuel: " + employe.calculerSalaire() + " DH");
            System.out.println("Informations complètes: " + employe);
            System.out.println();
        }
        
        // Calcul de la masse salariale totale
        System.out.println("Masse salariale:");
        double masseSalariale = 0;
        
        for (Employe employe : employes) {
            masseSalariale += employe.calculerSalaire();
        }
        
        System.out.println("Masse salariale totale: " + masseSalariale + " DH");
        
        // Démonstration du polymorphisme et des classes abstraites
        System.out.println("\nDémonstration du polymorphisme:");
        
        // Tableau de référence Commercial contenant un Commercial et un Représentant
        Commercial[] commerciaux = new Commercial[2];
        commerciaux[0] = new Commercial("Leroy", "Marc", 30, 
                                       LocalDate.of(2019, 2, 1), 45000);
        commerciaux[1] = new Representant("Dubois", "Marie", 45, 
                                         LocalDate.of(2008, 9, 15), 70000);
        
        System.out.println("Salaires des commerciaux:");
        
        for (Commercial commercial : commerciaux) {
            System.out.println(commercial.getNom() + ": " + commercial.calculerSalaire() + " DH");
        }
        
        // Tentative d'instanciation de la classe abstraite (doit être en commentaire)
        // Employe employe = new Employe("Nom", "Prenom", 25, LocalDate.now()); // Impossible!
        
        System.out.println("\nRéponses aux questions du TP");
        System.out.println("1. Pourquoi on ne peut pas donner un code à la méthode calculerSalaire au niveau de la classe Employe ?");
        System.out.println("   Parce que le calcul du salaire est spécifique à chaque type d'employé,");
        System.out.println("   il n'existe pas de formule générale qui s'applique à tous les employés.");
        
        System.out.println("\n2. Comment doit être la méthode calculerSalaire pour que le compilateur accepte qu'elle n'ait pas de code ?");
        System.out.println("   Elle doit être déclarée comme abstraite avec le mot-clé 'abstract':");
        System.out.println("   public abstract double calculerSalaire();");
        
        System.out.println("\n3. Comment doit être déclarée la classe Employe ?");
        System.out.println("   Elle doit être déclarée comme abstraite avec le mot-clé 'abstract':");
        System.out.println("   public abstract class Employe { ... }");
    }
}
