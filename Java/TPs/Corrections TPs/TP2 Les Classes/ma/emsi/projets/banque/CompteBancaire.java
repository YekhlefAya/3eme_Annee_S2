package ma.emsi.projets.banque;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Classe CompteBancaire qui représente un compte bancaire.
 * Cette classe utilise BigDecimal pour gérer les montants monétaires.
 */
public class CompteBancaire {
    // Attributs privés
    private String code;
    private Personne titulaire;
    private BigDecimal solde;
    private BigDecimal decouvert;
    
    // Variable statique pour compter le nombre de comptes débiteurs
    private static int nombreComptesDebiteurs = 0;
    
    /**
     * Premier constructeur avec paramètres qui initialise un compte
     * avec un solde initial de zéro et un découvert de zéro
     * 
     * @param code Le code du compte
     * @param titulaire Le titulaire du compte (objet Personne)
     */
    public CompteBancaire(String code, Personne titulaire) {
        this.code = code;
        this.titulaire = titulaire;
        this.solde = BigDecimal.ZERO;
        this.decouvert = BigDecimal.ZERO;
    }
    
    /**
     * Deuxième constructeur avec paramètres qui réutilise le premier constructeur
     * et modifie le solde initial si celui-ci est positif
     * 
     * @param code Le code du compte
     * @param titulaire Le titulaire du compte (objet Personne)
     * @param soldeInitial Le solde initial du compte
     */
    public CompteBancaire(String code, Personne titulaire, BigDecimal soldeInitial) {
        // Réutilisation du premier constructeur avec this()
        this(code, titulaire);
        
        // Si le solde initial est positif, on l'affecte au solde
        if (soldeInitial.compareTo(BigDecimal.ZERO) > 0) {
            this.solde = soldeInitial;
        }
        // Sinon, le solde reste à 0 comme initialisé dans le premier constructeur
    }
    
    /**
     * Méthode pour effectuer un dépôt sur le compte
     * 
     * @param montant Le montant à déposer
     */
    public void deposer(BigDecimal montant) {
        // Vérification que le montant est positif
        if (montant.compareTo(BigDecimal.ZERO) > 0) {
            // Le solde est incrémenté du montant du dépôt
            boolean etaitDebiteur = estDebiteur();
            solde = solde.add(montant);
            
            // Vérification si le compte n'est plus débiteur après le dépôt
            if (etaitDebiteur && !estDebiteur()) {
                nombreComptesDebiteurs--;
            }
        }
    }
    
    /**
     * Méthode pour effectuer un retrait sur le compte
     * 
     * @param montant Le montant à retirer
     * @return true si le retrait a été effectué, false sinon
     */
    public boolean retirer(BigDecimal montant) {
        // Vérification que le montant est positif
        if (montant.compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }
        
        // Vérification que le retrait ne dépasse pas le découvert autorisé
        // solde + decouvert représente le montant maximum qu'on peut retirer
        if (solde.add(decouvert).compareTo(montant) >= 0) {
            boolean etaitDebiteur = estDebiteur();
            // Le solde est décrémenté du montant du retrait
            solde = solde.subtract(montant);
            
            // Vérification si le compte est devenu débiteur après le retrait
            if (!etaitDebiteur && estDebiteur()) {
                nombreComptesDebiteurs++;
            }
            return true;
        }
        
        // Si le montant dépasse le découvert autorisé, le retrait est refusé
        return false;
    }
    
    /**
     * Méthode pour définir le découvert autorisé
     * 
     * @param montant Le montant du découvert autorisé
     */
    public void decouvertAutorise(BigDecimal montant) {
        // Le découvert n'est modifié que si le montant est positif
        if (montant.compareTo(BigDecimal.ZERO) > 0) {
            this.decouvert = montant;
        }
    }
    
    /**
     * Méthode qui vérifie si un compte est débiteur (solde négatif)
     * 
     * @return true si le compte est débiteur, false sinon
     */
    public boolean estDebiteur() {
        return solde.compareTo(BigDecimal.ZERO) < 0;
    }
    
    /**
     * Getter pour consulter le solde du compte
     * 
     * @return Le solde du compte
     */
    public BigDecimal getSolde() {
        return solde;
    }
    
    /**
     * Getter pour consulter le découvert autorisé
     * 
     * @return Le découvert autorisé
     */
    public BigDecimal getDecouvert() {
        return decouvert;
    }
    
    /**
     * Getter pour consulter le code du compte
     * 
     * @return Le code du compte
     */
    public String getCode() {
        return code;
    }
    
    /**
     * Getter pour consulter le titulaire du compte
     * 
     * @return Le titulaire du compte
     */
    public Personne getTitulaire() {
        return titulaire;
    }
    
    /**
     * Méthode statique qui retourne le nombre de comptes débiteurs
     * 
     * @return Le nombre de comptes débiteurs
     */
    public static int getNombreComptesDebiteurs() {
        return nombreComptesDebiteurs;
    }
    
    /**
     * Redéfinition de la méthode toString() héritée de la classe Object
     * @return Une chaîne contenant les informations du compte bancaire
     */
    @Override
    public String toString() {
        // Formatage du solde pour afficher 2 décimales
        BigDecimal soldeFormate = solde.setScale(2, RoundingMode.HALF_UP);
        
        return "CompteBancaire [code=" + code + 
               ", titulaire=" + titulaire + 
               ", solde=" + soldeFormate + 
               ", découvert autorisé=" + decouvert.setScale(2, RoundingMode.HALF_UP) + 
               ", état=" + (estDebiteur() ? "DÉBITEUR" : "CRÉDITEUR") + "]";
    }
    /**
     * RoundingMode.HALF_UP Explication:
     * 
     * RoundingMode.HALF_UP est un mode d'arrondi utilisé avec BigDecimal. C'est l'arrondi
     * mathématique classique enseigné dans les écoles :
     * - Si le chiffre à supprimer est >= 5, on arrondit au chiffre supérieur
     * - Si le chiffre à supprimer est < 5, on arrondit au chiffre inférieur
     * 
     * Exemples :
     * - 10.5 arrondi à 11
     * - 10.4 arrondi à 10
     * - 10.65 arrondi à 10.7 (avec 1 décimale)
     * - -10.5 arrondi à -11 (s'éloigne de zéro)
     * 
     * C'est particulièrement important pour les applications financières où les arrondis
     * doivent être cohérents et équilibrés. Par exemple, pour afficher un montant avec 
     * exactement 2 décimales : montant.setScale(2, RoundingMode.HALF_UP)
     */
}