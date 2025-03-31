package ma.emsi.projets.magasin;

class Article {
    private Long reference;
    private String description;
    private Double pht;
    private int unitesDispo;

    public Article(Long reference, String description, Double pht, int unitesDispo) {
        this.reference = reference;
        this.description = description;
        this.pht = pht;
        this.unitesDispo = unitesDispo;
    }

    public void approvisionner(int nombreUnites) {
        this.unitesDispo += nombreUnites;
    }

    public Boolean vendre(int nombreUnites) {
        if (nombreUnites > this.unitesDispo) {
            return false;
        } else {
            this.unitesDispo -= nombreUnites;
            return true;
        }
    }

    public double prixTTC() {
        return pht * 1.10; // Correction
    }

    public double prixVenteTTC(int nombreUnites) {
        return prixTTC() * nombreUnites;
    }

    @Override
    public String toString() {
        return "Article [Reference=" + reference + ", Description=" + description + ", PHT=" + pht + ", Unités Disponibles=" + unitesDispo + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((reference == null) ? 0 : reference.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Article other = (Article) obj;
        if (reference == null) {
            if (other.reference != null)
                return false;
        } else if (!reference.equals(other.reference))
            return false;
        return true;
    }
}

// Classe contenant le main
public class Main {
    public static void main(String[] args) {
        Article[] articles = {
            new Article(101L, "Ordinateur", 5000.0, 10),
            new Article(102L, "Smartphone", 3000.0, 5),
            new Article(103L, "Casque Audio", 500.0, 15),
            new Article(104L, "Clavier", 200.0, 20),
            new Article(105L, "Souris", 150.0, 25),
            new Article(106L, "Imprimante", 1200.0, 8),
            new Article(107L, "Tablette", 2500.0, 12),
            new Article(108L, "Chargeur", 300.0, 30),
            new Article(109L, "Écran", 2000.0, 7),
            new Article(110L, "Disque Dur", 800.0, 10)
        };

        System.out.println("Approvisionnement");
        articles[1].approvisionner(5);
        System.out.println(articles[1]);

        System.out.println("Vente : " + articles[0].vendre(3));
        System.out.println(articles[0]);

        System.out.println("Prix TTC " + articles[2].prixTTC());
        System.out.println("Prix TTC de 2 unités de l'article 104 : " + articles[3].prixVenteTTC(2));
    }
}
