package ma.emsi.projets.banque;

import java.math.BigDecimal;

/**
 * Classe de test pour la classe CompteBancaire
 * Cette classe démontre l'utilisation de BigDecimal et des comptes bancaires
 */
public class TestCompteBancaire {

    public static void main(String[] args) {
        
        // Création de quelques personnes (titulaires de comptes)
        Personne client1 = new Personne("AB", "Ahmed");
        Personne client2 = new Personne("CD", "Sophia");
        
        System.out.println("\nCréation des clients:");
        System.out.println("Client 1: " + client1); // Appel implicite à toString()
        System.out.println("Client 2: " + client2); // Appel implicite à toString()
        
        // Création de comptes bancaires
        System.out.println("\nCréation des comptes bancaires:");
        
        // Premier compte avec solde initial à zéro
        CompteBancaire compte1 = new CompteBancaire("FR7610001000100000000000001", client1);
        System.out.println("Compte 1 créé: " + compte1);
        
        // Deuxième compte avec solde initial positif
        // Démonstration de la création d'un objet BigDecimal de plusieurs façons
        BigDecimal soldeInitial = new BigDecimal("1000.50"); // À partir d'une chaîne (précision exacte)
        CompteBancaire compte2 = new CompteBancaire("FR7610001000100000000000002", client2, soldeInitial);
        System.out.println("Compte 2 créé: " + compte2);
        
        // Troisième compte avec tentative de solde initial négatif (doit être initialisé à 0)
        BigDecimal soldeNegatif = new BigDecimal("-500"); // Solde négatif qui sera rejeté
        CompteBancaire compte3 = new CompteBancaire("FR7610001000100000000000003", client1, soldeNegatif);
        System.out.println("Compte 3 créé (avec tentative de solde négatif): " + compte3);
        
        // Démonstration des opérations sur les comptes
        System.out.println("\nOpérations sur le compte 1:");
        
        // Dépôt d'argent
        BigDecimal montantDepot = new BigDecimal("500.75");
        System.out.println("Solde avant dépôt: " + compte1.getSolde());
        compte1.deposer(montantDepot);
        System.out.println("Dépôt de " + montantDepot + " effectué");
        System.out.println("Solde après dépôt: " + compte1.getSolde());
        
        // Tentative de retrait sans découvert
        BigDecimal montantRetrait1 = new BigDecimal("200.25");
        System.out.println("\nTentative de retrait de " + montantRetrait1);
        boolean retraitEffectue1 = compte1.retirer(montantRetrait1);
        System.out.println("Retrait " + (retraitEffectue1 ? "réussi" : "échoué"));
        System.out.println("Solde après retrait: " + compte1.getSolde());
        
        // Tentative de retrait excessif sans découvert
        BigDecimal montantRetrait2 = new BigDecimal("1000");
        System.out.println("\nTentative de retrait excessif de " + montantRetrait2);
        boolean retraitEffectue2 = compte1.retirer(montantRetrait2);
        System.out.println("Retrait " + (retraitEffectue2 ? "réussi" : "échoué"));
        System.out.println("Solde inchangé: " + compte1.getSolde());
        
        // Configuration d'un découvert autorisé
        System.out.println("\nConfiguration du découvert:");
        BigDecimal montantDecouvert = new BigDecimal("300");
        compte1.decouvertAutorise(montantDecouvert);
        System.out.println("Découvert autorisé de " + montantDecouvert + " configuré");
        System.out.println("Compte 1 mis à jour: " + compte1);
        
        // Retrait avec découvert
        System.out.println("\nRetrait avec découvert:");
        BigDecimal montantRetrait3 = new BigDecimal("600"); // Dépasse le solde mais pas solde+découvert
        System.out.println("Tentative de retrait de " + montantRetrait3);
        boolean retraitEffectue3 = compte1.retirer(montantRetrait3);
        System.out.println("Retrait " + (retraitEffectue3 ? "réussi" : "échoué"));
        System.out.println("Solde après retrait: " + compte1.getSolde());
        System.out.println("Le compte est " + (compte1.estDebiteur() ? "débiteur" : "créditeur"));
        
        // Vérification du nombre de comptes débiteurs
        System.out.println("\nNombre de comptes débiteurs:");
        System.out.println("Nombre de comptes débiteurs: " + CompteBancaire.getNombreComptesDebiteurs());
        
        // Remise à zéro du compte débiteur
        System.out.println("\nRemise à zéro du compte débiteur:");
        BigDecimal montantRedressement = new BigDecimal("300");
        compte1.deposer(montantRedressement);
        System.out.println("Dépôt de " + montantRedressement + " effectué");
        System.out.println("Solde après dépôt: " + compte1.getSolde());
        System.out.println("Le compte est maintenant " + (compte1.estDebiteur() ? "débiteur" : "créditeur"));
        
        // Vérification du nombre de comptes débiteurs après redressement
        System.out.println("\nNombre de comptes débiteurs après redressement: " + CompteBancaire.getNombreComptesDebiteurs());
        
        // Démonstration des problèmes de précision avec double vs BigDecimal
        System.out.println("\nDÉMONSTRATION BIGDECIMAL VS DOUBLE:");
        demonstrationBigDecimalVsDouble();
    }
    
    /**
     * Méthode qui démontre les problèmes de précision avec double
     * et comment BigDecimal résout ces problèmes
     */
    private static void demonstrationBigDecimalVsDouble() {
        System.out.println("\nProblèmes de précision avec double:");
        
        // Problème 1: Précision avec les nombres décimaux
        double montant1 = 0.1;
        double montant2 = 0.2;
        double sommeDouble = montant1 + montant2;
        
        System.out.println("Utilisation de double:");
        System.out.println("0.1 + 0.2 = " + sommeDouble);
        System.out.println("Est-ce que 0.1 + 0.2 == 0.3? " + (sommeDouble == 0.3));
        
        // Solution avec BigDecimal
        BigDecimal bd1 = new BigDecimal("0.1");
        BigDecimal bd2 = new BigDecimal("0.2");
        BigDecimal sommeBD = bd1.add(bd2);
        
        System.out.println("\nUtilisation de BigDecimal (à partir de chaînes):");
        System.out.println("0.1 + 0.2 = " + sommeBD);
        System.out.println("Est-ce que 0.1 + 0.2 == 0.3? " + sommeBD.equals(new BigDecimal("0.3")));
        
        // Problème 2: Erreur d'arrondi en utilisant double pour les calculs monétaires
        System.out.println("\nErreurs d'arrondi avec les calculs monétaires:");
        
        double prix = 19.99;
        double quantite = 10;
        double taxe = 0.05; // 5% de taxe
        
        double totalDouble = prix * quantite * (1 + taxe);
        System.out.println("Utilisation de double:");
        System.out.println("Prix unitaire: " + prix);
        System.out.println("Quantité: " + quantite);
        System.out.println("Taxe: " + taxe);
        System.out.println("Total calculé avec double: " + totalDouble);
        System.out.println("Total formaté: " + String.format("%.2f", totalDouble));
        
        // Solution avec BigDecimal
        BigDecimal prixBD = new BigDecimal("19.99");
        BigDecimal quantiteBD = new BigDecimal("10");
        BigDecimal taxeBD = new BigDecimal("0.05");
        BigDecimal unBD = new BigDecimal("1");
        
        BigDecimal totalBD = prixBD.multiply(quantiteBD).multiply(unBD.add(taxeBD));
        System.out.println("\nUtilisation de BigDecimal:");
        System.out.println("Prix unitaire: " + prixBD);
        System.out.println("Quantité: " + quantiteBD);
        System.out.println("Taxe: " + taxeBD);
        System.out.println("Total calculé avec BigDecimal: " + totalBD);
        System.out.println("Total avec 2 décimales: " + totalBD.setScale(2, java.math.RoundingMode.HALF_UP));
        
        // Démonstration des opérations arithmétiques avec BigDecimal
        System.out.println("\nOpérations arithmétiques avec BigDecimal:");
        BigDecimal a = new BigDecimal("10.5");
        BigDecimal b = new BigDecimal("3.25");
        
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("Addition (a + b): " + a.add(b));
        System.out.println("Soustraction (a - b): " + a.subtract(b));
        System.out.println("Multiplication (a * b): " + a.multiply(b));
        System.out.println("Division (a / b) avec 4 décimales: " + 
                a.divide(b, 4, java.math.RoundingMode.HALF_UP));
        System.out.println("Puissance (a^2): " + a.pow(2));
    }
}
