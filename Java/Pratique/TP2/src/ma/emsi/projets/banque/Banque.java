package TP2.src.ma.emsi.projets.banque;

import java.math.BigDecimal;

public class Banque {
    public static void main(String[] args) {
        Personne p1 = new Personne("Ali", "Mohamed");
        Personne p2 = new Personne("alami", "leila");

        CompteBancaire compte1 = new CompteBancaire("c123", p1, new BigDecimal("1000"));
        CompteBancaire compte2 = new CompteBancaire("c555", p2);
        CompteRemunere compteRemunere = new CompteRemunere("f1672", p2, new BigDecimal("1500"), new BigDecimal("5"));
        CompteBancaire[] comptes = { compte1, compte2, compteRemunere };


        for (CompteBancaire compte : comptes) {
            compte.deposer(new BigDecimal("500"));
            System.out.println(compte);
            if (compte instanceof CompteRemunere) {
                BigDecimal soldeFutur = ((CompteRemunere) compte).calculerSoldeFutur(5);
                System.out.println("Solde futur après 5 ans: " + soldeFutur);
            }
        }

    }
}
