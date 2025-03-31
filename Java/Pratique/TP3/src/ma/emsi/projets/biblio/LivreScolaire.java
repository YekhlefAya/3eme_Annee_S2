public class LivreScolaire extends Livre {
    private String discipline;
    private String niveauScolaire;  

    public LivreScolaire(int isbn, String titre, int stock, double prix, String discipline,String niveauScolaire) {
        super(isbn, titre, stock, prix);  
        this.discipline = discipline;  
        this.niveauScolaire = niveauScolaire;
    }

    @Override
    public double prixTTC() {
        return super.prixTTC() * 0.7;  
    }

    @Override
    public String toString() {
        return super.toString() + "Discipline: "+ discipline+", Niveau scolaire: " + niveauScolaire;
    }

    public void AfficherDiscipline() {
        System.out.println(" La discipline du livre est :" + discipline);
    }
}
