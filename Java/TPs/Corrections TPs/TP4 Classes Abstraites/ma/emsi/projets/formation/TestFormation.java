package ma.emsi.projets.formation;

/**
 * Classe de test pour le système de gestion des formateurs du centre de formation.
 * Démontre l'utilisation des classes abstraites et du polymorphisme.
 */
public class TestFormation {

    public static void main(String[] args) {
        System.out.println("GESTION DES FORMATEURS DU CENTRE DE FORMATION");
        
        // Création d'un tableau de formateurs de différents types
        Formateur[] formateurs = new Formateur[6];
        
        // Initialisation des formateurs
        // Formateurs internes
        formateurs[0] = new FormateurInterne("MA", "Abdellah", 110);
        formateurs[1] = new FormateurInterne("BE", "Hamza", 150);
        
        // Formateurs externes
        formateurs[2] = new FormateurExterne("JA", "Hajar", 80, "Institut Technologique de Madrid");
        formateurs[3] = new FormateurExterne("KE", "Khalid", 60, "Tech Academy London");
        
        // Formateurs stagiaires
        formateurs[4] = new FormateurStagiaire("BE", "Karim", 85);
        formateurs[5] = new FormateurStagiaire("El", "Fatima", 120);
        
        // Ajout de compétences aux formateurs
        ajouterCompetencesExemples(formateurs);
        
        // Affichage des informations sur chaque formateur
        System.out.println("\nListe des formateurs:");
        
        for (int i = 0; i < formateurs.length; i++) {
            System.out.println(formateurs[i]);
            afficherCompetences(formateurs[i]);
            System.out.println();
        }
        
        // Calcul de la masse salariale totale
        System.out.println("Statistiques:");
        double masseSalariale = 0;
        int totalHeuresFormation = 0;
        
        for (int i = 0; i < formateurs.length; i++) {
            masseSalariale += formateurs[i].calculerSalaire();
            totalHeuresFormation += formateurs[i].getHeuresFormation();
        }
        
        System.out.println("Masse salariale totale: " + masseSalariale + " DH");
        System.out.println("Total des heures de formation: " + totalHeuresFormation + " heures");
        
        // Démonstration du polymorphisme avec des cas spécifiques
        System.out.println("\nExemples spécifiques:");
        
        // Exemple 1: Formateur interne avec heures supplémentaires
        FormateurInterne formateurInterne = new FormateurInterne("GA", "Amina", 140);
        System.out.println("Exemple formateur interne:");
        System.out.println("Heures: 140 (20 heures supplémentaires)");
        System.out.println("Salaire attendu: 10000 + (20 * 300) = 16000 DH");
        System.out.println("Salaire calculé: " + formateurInterne.calculerSalaire() + " DH");
        
        // Exemple 2: Formateur stagiaire dépassant le plafond d'heures
        FormateurStagiaire formateurStagiaire = new FormateurStagiaire("AL", "Mehdi", 110);
        System.out.println("\nExemple formateur stagiaire:");
        System.out.println("Heures totales: 110");
        System.out.println("Heures rémunérées: " + formateurStagiaire.getHeuresRemunerees());
        System.out.println("Heures non rémunérées: " + formateurStagiaire.getHeuresNonRemunerees());
        System.out.println("Salaire attendu: 96 * 100 = 9600 DH");
        System.out.println("Salaire calculé: " + formateurStagiaire.calculerSalaire() + " DH");
    }
    
    /**
     * Ajoute des compétences d'exemple à chaque formateur
     * @param formateurs Le tableau des formateurs
     */
    private static void ajouterCompetencesExemples(Formateur[] formateurs) {
        // Compétences pour le premier formateur interne
        formateurs[0].ajouterCompetence("Java");
        formateurs[0].ajouterCompetence("Spring");
        formateurs[0].ajouterCompetence("SQL");
        
        // Compétences pour le deuxième formateur interne
        formateurs[1].ajouterCompetence("Python");
        formateurs[1].ajouterCompetence("Data Science");
        formateurs[1].ajouterCompetence("Machine Learning");
        
        // Compétences pour le premier formateur externe
        formateurs[2].ajouterCompetence("Web Development");
        formateurs[2].ajouterCompetence("JavaScript");
        formateurs[2].ajouterCompetence("React");
        
        // Compétences pour le deuxième formateur externe
        formateurs[3].ajouterCompetence("DevOps");
        formateurs[3].ajouterCompetence("Docker");
        formateurs[3].ajouterCompetence("Kubernetes");
        
        // Compétences pour le premier formateur stagiaire
        formateurs[4].ajouterCompetence("HTML/CSS");
        formateurs[4].ajouterCompetence("PHP");
        
        // Compétences pour le deuxième formateur stagiaire
        formateurs[5].ajouterCompetence("Android");
        formateurs[5].ajouterCompetence("Kotlin");
    }
    
    /**
     * Affiche les compétences d'un formateur
     * @param formateur Le formateur dont on veut afficher les compétences
     */
    private static void afficherCompetences(Formateur formateur) {
        String[] competences = formateur.getCompetences();
        if (competences.length > 0) {
            System.out.print("  Compétences: ");
            for (int i = 0; i < competences.length; i++) {
                System.out.print(competences[i]);
                if (i < competences.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
