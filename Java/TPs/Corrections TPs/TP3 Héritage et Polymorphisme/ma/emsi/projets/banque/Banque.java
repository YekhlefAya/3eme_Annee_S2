package ma.emsi.projets.banque;

import java.math.BigDecimal;

/**
 * Classe de test pour démontrer l'utilisation de l'héritage et du polymorphisme
 * avec CompteBancaire et CompteRemunere
 */
public class Banque {

    public static void main(String[] args) {
        System.out.println("TP3: GESTION DES COMPTES BANCAIRES");
        
        // Création de quelques personnes (titulaires de comptes)
        Personne client1 = new Personne("AS", "Ayamen");
        Personne client2 = new Personne("BE", "Sanae");
        Personne client3 = new Personne("AG", "Hicham");
        
        // Création d'un tableau de comptes de différents types (polymorphisme)
        // Le tableau est de type CompteBancaire mais peut contenir des objets CompteRemunere
        CompteBancaire[] comptes = new CompteBancaire[4];
        
        // Initialisation des comptes
        comptes[0] = new CompteBancaire("FR7610001000100000000000001", client1);
        comptes[1] = new CompteRemunere("FR7610001000100000000000002", client2, new BigDecimal("2.5"));
        comptes[2] = new CompteBancaire("FR7610001000100000000000003", client3, new BigDecimal("500"));
        comptes[3] = new CompteRemunere("FR7610001000100000000000004", client1, new BigDecimal("1000"), new BigDecimal("3.75"));
        
        // Effectuer un dépôt sur chaque compte
        System.out.println("\nDépôt sur chaque compte:");
        BigDecimal montantDepot = new BigDecimal("1000");
        
        for (CompteBancaire compte : comptes) {
            System.out.println("Solde avant dépôt: " + compte.getSolde() + " €");
            compte.deposer(montantDepot);
            System.out.println("Dépôt de " + montantDepot + " € effectué sur le compte " + compte.getCode());
            System.out.println("Solde après dépôt: " + compte.getSolde() + " €");
            System.out.println();
        }
        
        // Afficher les informations de chaque compte
        System.out.println("\nInformations des comptes:");
        int numeroCompte = 1;
        
        for (CompteBancaire compte : comptes) {
            System.out.println("Compte " + numeroCompte + ": " + compte);
            
            // Vérifier si le compte est un compte rémunéré (instanceof)
            if (compte instanceof CompteRemunere) {
                // Cast pour accéder aux méthodes spécifiques de CompteRemunere
                CompteRemunere compteRem = (CompteRemunere) compte;
                
                // Utilisation de la méthode spécifique à CompteRemunere
                BigDecimal soldeFutur = compteRem.calculerSoldeFutur(5);
                System.out.println("   Solde futur après 5 ans: " + soldeFutur + " €");
                System.out.println("   Intérêts gagnés après 5 ans: " + 
                        soldeFutur.subtract(compte.getSolde()) + " €");
            }
            
            System.out.println();
            numeroCompte++;
        }
        
        // Démonstration supplémentaire du polymorphisme d'exécution
        System.out.println("\nDémonstration du polymorphisme d'exécution:");
        
        // Création d'un compte rémunéré
        CompteRemunere compteRemunere = new CompteRemunere(
                "FR7610001000100000000000005", 
                new Personne("Dubois", "Marie"), 
                new BigDecimal("5.0"));
        
        // Référence de type CompteBancaire pointant sur un objet CompteRemunere
        CompteBancaire comptePolymorphe = compteRemunere;
        
        // Dépôt via la référence polymorphe
        System.out.println("Solde avant dépôt: " + comptePolymorphe.getSolde() + " €");
        comptePolymorphe.deposer(new BigDecimal("500"));
        System.out.println("Solde après dépôt: " + comptePolymorphe.getSolde() + " €");
        
        // Même avec une référence de type CompteBancaire, 
        // c'est la méthode redéfinie de CompteRemunere qui est appelée
        System.out.println("Le bonus de 2% a été appliqué automatiquement grâce au polymorphisme d'exécution.");
    }
}