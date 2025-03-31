
class Livre{
    private int ISBN ;
    private String titre;
    private int stock;
    private double prix;
    public Livre(int ISBN, String titre, int stock,double prix){
        this.ISBN = ISBN;
        this.titre = titre;
        this.stock = stock;
        this.prix = prix;
    }
    @Override
    public String toString() {
        return "Livre [ISBN=" + ISBN + ", titre=" + titre + ", stock=" + stock + ", prix=" + prix + "]";
    }
    
    public double prixTTC(){
        return prix * 1.2; 
    }
}