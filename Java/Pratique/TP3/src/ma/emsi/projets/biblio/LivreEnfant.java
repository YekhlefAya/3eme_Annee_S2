public class LivreEnfant extends Livre{
    private int ageMin;  
    private int ageMax;
    public LivreEnfant(int ISBN, String titre, int stock,double prix, int ageMin, int ageMax) {
        super(ISBN, titre, stock, prix);
        this.ageMin = ageMin;
        this.ageMax = ageMax;
    }
    @Override
    public double prixTTC() {
        return super.prixTTC() * 0.5;  
    }
    @Override
    public String toString() {
        return super.toString() + ", age min: " + ageMin + " ans, age max " + ageMax + " ans";
    }
    public void afficherTrancheAge() {
        System.out.println(" La Tranche d'age du livre est de :" + ageMin + " à " + ageMax + " ans.");
    }
}
