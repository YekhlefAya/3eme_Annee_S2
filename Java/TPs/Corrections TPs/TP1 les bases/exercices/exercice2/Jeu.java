package exercices.exercice2;

import java.util.Random;
import java.util.Scanner;

/**
 * Classe Jeu qui implémente un jeu de devinette de nombre
 * Cette classe est utilisée dans l'exercice 2
 */
// La classe doit être déclarée public pour être accessible depuis d'autres packages
public class Jeu {
    
    /**
     * Méthode qui implémente un jeu de devinette de nombre.
     * Cette méthode est statique pour pouvoir être appelée sans créer d'instance de la classe Jeu.
     */
    public static void trouverNombreSecret() {
        // Création d'un objet Scanner pour lire les entrées utilisateur
        Scanner scanner = new Scanner(System.in);
        
        // Création d'un objet Random pour générer un nombre aléatoire
        // En Java, la génération de nombres aléatoires se fait via la classe Random
        // contrairement à C/C++ où on utilise généralement rand() de stdlib.h
        Random random = new Random();
        
        // Génération d'un nombre aléatoire entre 0 et 99 inclus
        // nextInt(100) génère un nombre entre 0 (inclus) et 100 (exclus)
        int nombreSecret = random.nextInt(100);
        
        int essai; // Variable pour stocker l'essai de l'utilisateur
        int compteur = 0; // Compteur du nombre d'essais
        
        System.out.println("=== Jeu : Trouvez le nombre secret ===");
        System.out.println("Je pense à un nombre entre 0 et 99. À vous de le deviner !");
        
        // Boucle du jeu
        do {
            System.out.print("Entrez votre proposition : ");
            
            // Lecture de l'essai de l'utilisateur
            essai = scanner.nextInt();
            compteur++; // Incrémentation du compteur d'essais
            
            // Vérification de l'essai
            if (essai > nombreSecret) {
                System.out.println("Trop grand ! Essayez encore.");
            } else if (essai < nombreSecret) {
                System.out.println("Trop petit ! Essayez encore.");
            } else {
                System.out.println("Bravo ! Vous avez trouvé le nombre secret en " + compteur + " coups !");
            }
            
        } while (essai != nombreSecret); // Continuer tant que l'utilisateur n'a pas trouvé le nombre secret
        
        // Nous ne fermons pas le scanner ici car il est utilisé dans la méthode main
        // Le fermer ici fermerait System.in et empêcherait toute lecture ultérieure
        // C'est différent de C/C++ où les flux d'entrée/sortie standard sont gérés globalement
    }
}