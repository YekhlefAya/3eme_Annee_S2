package TP2.src.ma.emsi.projets.banque;

import java.math.BigDecimal;

public class CompteBancaire {
     private String code;
    private Personne titulaire;
    private BigDecimal solde;
    private BigDecimal decouvert; 
    private static int nbDebiteurs = 0;

    public CompteBancaire(String code, Personne titulaire) {
        this.code = code;
        this.titulaire = titulaire;
        this.solde = BigDecimal.ZERO;
        this.decouvert = BigDecimal.ZERO;
    }
    public CompteBancaire(String code, Personne titulaire, BigDecimal soldeInitial) {
        this(code, titulaire); 
        if (soldeInitial.compareTo(BigDecimal.ZERO) > 0) {
            this.solde = soldeInitial;
        }
    }
    public void deposer(BigDecimal montant) {
        if (montant.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal ancienSolde = solde;
            solde = solde.add(montant);
            if (ancienSolde.compareTo(BigDecimal.ZERO) < 0 && solde.compareTo(BigDecimal.ZERO) >= 0) {
                nbDebiteurs--;
            }
        }
    }
    public boolean retirer(BigDecimal montant) {
        if (montant.compareTo(BigDecimal.ZERO) > 0 && montant.compareTo(solde.add(decouvert)) <= 0) {
            BigDecimal ancienSolde = solde;
            solde = solde.subtract(montant);
            if (ancienSolde.compareTo(BigDecimal.ZERO) >= 0 && solde.compareTo(BigDecimal.ZERO) < 0) {
                nbDebiteurs++;
            }
            return true;
        }
        return false;
    }

    
    public BigDecimal getSolde() {
        return solde;
    }
    public void decouvertAutorise(BigDecimal montant) {
        if (montant.compareTo(BigDecimal.ZERO) > 0) {
            this.decouvert = montant;
        }
    }
    public boolean estDebiteur() {
        return solde.compareTo(BigDecimal.ZERO) < 0;
    }
    
    @Override
    public String toString() {
        return "CompteBancaire [code=" + code + ", titulaire=" + titulaire + ", solde=" + solde + ", decouvert="
                + decouvert + "]";
    }

    public class main{
        public static void main(String[] args) {
            Personne p1 = new Personne("Ali", "Mohamed");
            CompteBancaire compte1 = new CompteBancaire("C123", p1, new BigDecimal("1000"));
            boolean retrait = compte1.retirer(new BigDecimal("500"));
            compte1.deposer(new BigDecimal("200"));
            compte1.decouvertAutorise(new BigDecimal("300"));
    
        }
    }
}

