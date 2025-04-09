import java.time.LocalDate;

public abstract class Employe{
    protected String nom;
    protected String prenom;
    protected int age;
    protected LocalDate date_entree;
    public Employe(String nom,String prenom,int age,LocalDate date){
        this.nom=nom;
        this.prenom=prenom;
        this.age=age;
        this.date_entree=date;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public abstract double CalculerSalaire(){

    }

}