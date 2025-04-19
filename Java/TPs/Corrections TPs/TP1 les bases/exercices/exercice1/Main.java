package exercices.exercice1;

import java.util.Scanner;
// Import de la classe Jeu du package exercices.exercice2
import exercices.exercice2.Jeu;
// Import de la classe AnalysePhrase du package exercices.exercice3
import exercices.exercice3.AnalysePhrase;

/**
 * Classe principale contenant le menu du programme
 * Cette classe intègre toutes les fonctionnalités des exercices
 */
public class Main {
    public static void main(String[] args) {
        // ==================== PARTIE B ====================
        // Création d'un objet Scanner pour lire les entrées utilisateur
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Mon premier programme Java");
        
        // Demande à l'utilisateur de saisir deux nombres de type double
        System.out.print("Entrez le premier nombre : ");
        // nextDouble() lit un nombre à virgule flottante (similaire à scanf("%lf") en C)
        double nombre1 = scanner.nextDouble();
        
        System.out.print("Entrez le deuxième nombre : ");
        double nombre2 = scanner.nextDouble();
        
        // Affichage des résultats des opérations arithmétiques
        System.out.println("\nRésultats des opérations arithmétiques :");
        System.out.println("Addition: " + nombre1 + " + " + nombre2 + " = " + (nombre1 + nombre2));
        System.out.println("Soustraction: " + nombre1 + " - " + nombre2 + " = " + (nombre1 - nombre2));
        System.out.println("Multiplication: " + nombre1 + " * " + nombre2 + " = " + (nombre1 * nombre2));
        
        // Vérification que le diviseur n'est pas zéro avant de faire la division
        // Cette vérification évite l'exception ArithmeticException (équivalent à une erreur à l'exécution en C)
        if (nombre2 != 0) {
            System.out.println("Division: " + nombre1 + " / " + nombre2 + " = " + (nombre1 / nombre2));
            System.out.println("Reste de division: " + nombre1 + " % " + nombre2 + " = " + (nombre1 % nombre2));
        } else {
            System.out.println("Division par zéro impossible");
        }
        
        // Affichage du maximum et du minimum
        System.out.println("\nMaximum et minimum :");
        // Math.max et Math.min sont des méthodes statiques de la classe Math
        // C'est équivalent à max() et min() de la bibliothèque math.h en C
        System.out.println("Maximum : " + Math.max(nombre1, nombre2));
        System.out.println("Minimum : " + Math.min(nombre1, nombre2));
        
        // Calcul et affichage des racines carrées
        System.out.println("\nRacines carrées :");
        // Math.sqrt calcule la racine carrée (équivalent à sqrt() en C)
        // Math.abs calcule la valeur absolue (équivalent à abs() en C)
        if (nombre1 >= 0) {
            System.out.println("Racine carrée de " + nombre1 + " = " + Math.sqrt(nombre1));
        } else {
            System.out.println("Racine carrée de |" + nombre1 + "| = " + Math.sqrt(Math.abs(nombre1)) + 
                              " (valeur absolue utilisée car le nombre est négatif)");
        }
        
        if (nombre2 >= 0) {
            System.out.println("Racine carrée de " + nombre2 + " = " + Math.sqrt(nombre2));
        } else {
            System.out.println("Racine carrée de |" + nombre2 + "| = " + Math.sqrt(Math.abs(nombre2)) + 
                              " (valeur absolue utilisée car le nombre est négatif)");
        }
        
        // Calcul et affichage des puissances
        System.out.println("\nPuissances :");
        // Math.pow calcule a puissance b (équivalent à pow() en C)
        System.out.println(nombre1 + " puissance " + nombre2 + " = " + Math.pow(nombre1, nombre2));
        System.out.println(nombre2 + " puissance " + nombre1 + " = " + Math.pow(nombre2, nombre1));
        
        System.out.println("\n==================== FIN PARTIE B ====================\n");
        
        // ==================== PARTIE C et intégration des exercices 2 et 3 ====================
        int choix;
        
        // Boucle do-while pour répéter le menu jusqu'à ce que l'utilisateur choisisse de quitter
        // Cette structure est similaire en C/C++
        do {
            // Affichage du menu
            System.out.println("\n===== MENU =====");
            System.out.println("1. Calculatrice");
            System.out.println("2. Trouver le nombre secret");
            System.out.println("3. Analyser une phrase");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            
            // Lecture du choix de l'utilisateur
            choix = scanner.nextInt();
            
            // Structure switch-case pour traiter le choix de l'utilisateur
            switch (choix) {
                case 1: // Calculatrice
                    System.out.print("Entrez le premier nombre : ");
                    double num1 = scanner.nextDouble();
                    
                    System.out.print("Entrez le deuxième nombre : ");
                    double num2 = scanner.nextDouble();
                    
                    System.out.println("Choisissez une opération :");
                    System.out.println("+ : Addition");
                    System.out.println("- : Soustraction");
                    System.out.println("* : Multiplication");
                    System.out.println("/ : Division");
                    System.out.println("% : Reste de division");
                    
                    // Consommer le retour à la ligne laissé par nextDouble()
                    // C'est une spécificité de Java: les méthodes nextInt() et nextDouble() 
                    // ne consomment pas le caractère de nouvelle ligne
                    scanner.nextLine();
                    
                    System.out.print("Opération : ");
                    // Lecture du premier caractère de la ligne
                    char operateur = scanner.nextLine().charAt(0);
                    
                    // Appel de la méthode statique Operation de la classe Calculatrice
                    // Notez la syntaxe: NomDeClasse.méthodeStatique()
                    Calculatrice.Operation(num1, num2, operateur);
                    break;
                    
                case 2: // Jeu: trouver le nombre secret
                    // Appel de la méthode statique trouverNombreSecret de la classe Jeu
                    // Comme la classe Jeu est dans un autre package, nous avons dû l'importer
                    Jeu.trouverNombreSecret();
                    break;
                    
                case 3: // Analyse de phrase
                    // Consommer le retour à la ligne laissé par le nextInt() précédent
                    scanner.nextLine();
                    
                    System.out.print("Entrez une phrase : ");
                    String phrase = scanner.nextLine();
                    
                    // Affichage du nombre de caractères
                    // En Java, length() est une méthode de la classe String, pas une fonction comme strlen() en C
                    System.out.println("Nombre de caractères : " + phrase.length());
                    
                    // Vérification que la phrase n'est pas vide avant d'afficher la première et dernière lettre
                    if (!phrase.isEmpty()) {
                        // charAt(index) permet d'accéder à un caractère spécifique dans une chaîne
                        // Similaire à phrase[0] en C, mais plus sécurisé (vérification des limites)
                        System.out.println("Première lettre : " + phrase.charAt(0));
                        System.out.println("Dernière lettre : " + phrase.charAt(phrase.length() - 1));
                    } else {
                        System.out.println("La phrase est vide.");
                    }
                    
                    // Appel des méthodes de la classe AnalysePhrase
                    System.out.println("Nombre de mots : " + AnalysePhrase.nombreDeMots(phrase));
                    System.out.println("Phrase inversée : " + AnalysePhrase.inverserPhrase(phrase));
                    
                    System.out.print("Entrez un symbole pour remplacer les voyelles : ");
                    char symbole = scanner.nextLine().charAt(0);
                    
                    System.out.println("Phrase après remplacement des voyelles : " + 
                                      AnalysePhrase.remplacerVoyelle(phrase, symbole));
                    break;
                    
                case 0: // Quitter
                    System.out.println("Au revoir !");
                    break;
                    
                default: // Choix invalide
                    System.out.println("Choix non valide. Veuillez réessayer.");
            }
            
        } while (choix != 0); // Continuer tant que l'utilisateur ne choisit pas 0
        
        // Fermeture du scanner pour libérer les ressources
        // En Java, il est important de fermer les ressources comme les Scanner
        // contrairement au C où il n'est pas nécessaire de fermer stdin/stdout
        scanner.close();
    }
}
