package TP2.src.ma.emsi.projets.banque;

import java.math.BigDecimal;

public class CompteRemunere extends CompteBancaire{
    private BigDecimal taux;
    public CompteRemunere(String code, Personne titulaire, BigDecimal soldeInitial, BigDecimal taux) {
        super(code, titulaire, soldeInitial);
        if (soldeInitial.compareTo(BigDecimal.ZERO) > 0) {
            this.taux = taux;
        }    
    }
    @Override
    public String toString() {
        return super.toString() + ", Taux: " + taux;
    }
    @Override
    public void deposer(BigDecimal montant) {
        BigDecimal bonus = montant.multiply(new BigDecimal("0.02")); 
        super.deposer(montant.add(bonus));
    }
    public BigDecimal calculerSoldeFutur(int n){
        return getSolde().multiply(BigDecimal.ONE.add(taux.divide(new BigDecimal("100"))));
    }

}
