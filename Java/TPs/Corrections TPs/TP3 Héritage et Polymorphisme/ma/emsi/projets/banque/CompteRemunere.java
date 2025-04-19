package ma.emsi.projets.banque;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Classe CompteRemunere qui hérite de CompteBancaire et ajoute un taux d'intérêt.
 * Cette classe illustre le concept d'héritage en Java. (TP3 Exercice 2)
 */
public class CompteRemunere extends CompteBancaire {
    // Attribut spécifique au compte rémunéré
    private BigDecimal taux;
    
    // Constante pour le bonus de dépôt (2%)
    private static final BigDecimal BONUS_DEPOT = new BigDecimal("0.02");
    
    /**
     * Constructeur qui initialise un compte rémunéré
     * 
     * @param code Le code du compte
     * @param titulaire Le titulaire du compte
     * @param tauxInteret Le taux d'intérêt du compte (en pourcentage)
     */
    public CompteRemunere(String code, Personne titulaire, BigDecimal tauxInteret) {
        // Appel du constructeur de la classe parente (CompteBancaire)
        super(code, titulaire);
        
        // Initialisation du taux d'intérêt (doit être > 0)
        if (tauxInteret.compareTo(BigDecimal.ZERO) > 0) {
            this.taux = tauxInteret;
        } else {
            // Valeur par défaut si le taux fourni est négatif ou nul
            this.taux = new BigDecimal("1.0"); // 1% par défaut
        }
    }
    
    /**
     * Constructeur qui initialise un compte rémunéré avec un solde initial
     * 
     * @param code Le code du compte
     * @param titulaire Le titulaire du compte
     * @param soldeInitial Le solde initial du compte
     * @param tauxInteret Le taux d'intérêt du compte (en pourcentage)
     */
    public CompteRemunere(String code, Personne titulaire, BigDecimal soldeInitial, BigDecimal tauxInteret) {
        // Appel du constructeur de la classe parente avec les paramètres communs
        super(code, titulaire, soldeInitial);
        
        // Initialisation du taux d'intérêt (doit être > 0)
        if (tauxInteret.compareTo(BigDecimal.ZERO) > 0) {
            this.taux = tauxInteret;
        } else {
            // Valeur par défaut si le taux fourni est négatif ou nul
            this.taux = new BigDecimal("1.0"); // 1% par défaut
        }
    }
    
    /**
     * Redéfinition de la méthode deposer pour ajouter un bonus de 2%
     * Exemple de polymorphisme par redéfinition (override)
     * 
     * @param montant Le montant à déposer
     */
    @Override
    public void deposer(BigDecimal montant) {
        if (montant.compareTo(BigDecimal.ZERO) > 0) {
            // Calcul du bonus (2% du montant déposé)
            BigDecimal bonus = montant.multiply(BONUS_DEPOT);
            
            // On appelle la méthode deposer de la classe parente avec le montant + bonus
            // Utilisation de super pour accéder à la méthode de la classe parente
            super.deposer(montant.add(bonus));
        }
    }
    
    /**
     * Calcule le solde futur après n années en appliquant la formule:
     * Solde futur = Solde initial × (1 + taux/100)^n
     * 
     * @param annees Le nombre d'années
     * @return Le solde futur après n années
     */
    public BigDecimal calculerSoldeFutur(int annees) {
        if (annees < 0) {
            return getSolde(); // Si le nombre d'années est négatif, retourne le solde actuel
        }
        
        // Convertir le taux de pourcentage à sa forme décimale (ex: 5% -> 0.05)
        BigDecimal tauxDecimal = taux.divide(new BigDecimal("100"), 10, RoundingMode.HALF_UP);
        
        // Calculer (1 + taux/100)
        BigDecimal facteur = BigDecimal.ONE.add(tauxDecimal);
        
        // Élever à la puissance n: (1 + taux/100)^n
        // Comme BigDecimal n'a pas de méthode pow pour des exposants variables,
        // nous utilisons une boucle pour multiplier le facteur n fois
        BigDecimal facteurPuissance = BigDecimal.ONE;
        for (int i = 0; i < annees; i++) {
            facteurPuissance = facteurPuissance.multiply(facteur);
        }
        
        // Calculer le solde futur: soldeActuel * facteurPuissance
        BigDecimal soldeFutur = getSolde().multiply(facteurPuissance);
        
        // Arrondir à 2 décimales pour l'affichage monétaire
        return soldeFutur.setScale(2, RoundingMode.HALF_UP);
    }
    
    /**
     * Getter pour le taux d'intérêt
     * 
     * @return Le taux d'intérêt
     */
    public BigDecimal getTaux() {
        return taux;
    }
    
    /**
     * Redéfinition de la méthode toString() pour inclure le taux d'intérêt
     * 
     * @return Une représentation sous forme de chaîne du compte rémunéré
     */
    @Override
    public String toString() {
        // On réutilise toString() de la classe parente et on ajoute le taux
        return super.toString() + ", taux d'intérêt=" + taux.setScale(2, RoundingMode.HALF_UP) + "%";
    }
}