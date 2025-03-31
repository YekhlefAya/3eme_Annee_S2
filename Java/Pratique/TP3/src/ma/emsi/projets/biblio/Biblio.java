public class Biblio {

    public static void main(String[] args) {
        Livre livre1 = new Livre(123, "Livre1", 10, 150);
        LivreEnfant livre2 = new LivreEnfant(678, "Livre2", 8, 120.50, 5, 8);
        LivreScolaire livre3 = new LivreScolaire(543, "Livre3", 20, 250.75, "des","Mathématiques");
        
        Livre[] livres = { livre1, livre2, livre3 };
        
        for (Livre livre : livres) {
            System.out.println(livre.toString());
            
            System.out.println("Prix TTC: " + livre.prixTTC());
            
            if (livre instanceof LivreEnfant) {
                ((LivreEnfant) livre).afficherTrancheAge();
            }
            
            if (livre instanceof LivreScolaire) {
                ((LivreScolaire) livre).AfficherDiscipline();
                
            }        }
    }
}

