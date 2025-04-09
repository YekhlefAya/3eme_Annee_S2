import java.time.LocalDate;

public class Commercial extends Employe {
    private double ChiffreAffaire;
    public Commercial(String nom, String prenom, int age, LocalDate date, double chiffreAffaire) {
        super(nom, prenom, age, date);
        this.ChiffreAffaire = chiffreAffaire;
    }
    @Override
    public double CalculerSalaire(){
        return this.ChiffreAffaire * 0.2;
    }
}
