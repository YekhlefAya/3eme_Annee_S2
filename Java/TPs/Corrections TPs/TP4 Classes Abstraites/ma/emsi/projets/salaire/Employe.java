package ma.emsi.projets.salaire;

import java.time.LocalDate;

/**
 * Classe abstraite Employe représentant un employé générique de l'entreprise.
 * Cette classe ne peut pas être instanciée directement car le calcul du salaire
 * dépend du type spécifique d'employé.
 */
public abstract class Employe {
	
	/**
	 * Note sur LocalDate:
	LocalDate est une classe de Java 8+ pour représenter une date (sans heure).
	Avantages:
	- Plus simple à utiliser que les anciennes classes Date/Calendar
	- Méthodes claires (plusDays(), isBefore(), etc.)
	- Non modifiable une fois créée (immuable)
	Exemples d'utilisation:
	- LocalDate.of(2020, 3, 15) → crée la date 15/03/2020
	 - LocalDate.now() → date d'aujourd'hui
	 * 
	 */
	
    // Attributs communs à tous les employés
    private String nom;
    private String prenom;
    private int age;
    private LocalDate dateEntree;
    
    /**
     * Constructeur avec paramètres
     * 
     * @param nom Le nom de l'employé
     * @param prenom Le prénom de l'employé
     * @param age L'âge de l'employé
     * @param dateEntree La date d'entrée en service
     */
    public Employe(String nom, String prenom, int age, LocalDate dateEntree) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.dateEntree = dateEntree;
    }
    
    /**
     * Méthode qui retourne une représentation textuelle de l'employé.
     * Cette méthode peut être redéfinie par les sous-classes pour personnaliser
     * le préfixe "Employé".
     * 
     * @return Le nom complet de l'employé préfixé par "Employé"
     */
    public String getNom() {
        return "Employé " + prenom + " " + nom;
    }
    
    /**
     * Méthode abstraite pour calculer le salaire mensuel de l'employé.
     * Cette méthode doit être implémentée par chaque sous-classe car
     * le calcul du salaire dépend du type spécifique de l'employé.
     * 
     * @return Le salaire mensuel de l'employé
     */
    public abstract double calculerSalaire();
    
    /**
     * Getter pour le nom
     * @return Le nom de l'employé
     */
    public String getNomBrut() {
        return nom;
    }
    
    /**
     * Getter pour le prénom
     * @return Le prénom de l'employé
     */
    public String getPrenom() {
        return prenom;
    }
    
    /**
     * Getter pour l'âge
     * @return L'âge de l'employé
     */
    public int getAge() {
        return age;
    }
    
    /**
     * Getter pour la date d'entrée
     * @return La date d'entrée en service
     */
    public LocalDate getDateEntree() {
        return dateEntree;
    }
    
    /**
     * Redéfinition de la méthode toString pour afficher les informations de l'employé
     * @return Une chaîne représentant l'employé
     */
    @Override
    public String toString() {
        return "Employé: " + prenom + " " + nom + 
               ", âge: " + age + 
               ", date d'entrée: " + dateEntree + 
               ", salaire: " + calculerSalaire() + " DH";
    }
}