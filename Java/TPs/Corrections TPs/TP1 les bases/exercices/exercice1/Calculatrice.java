package exercices.exercice1;

/**
 * Classe Calculatrice qui contient des méthodes pour effectuer des opérations arithmétiques
 * Cette classe est utilisée dans l'exercice 1 - Partie C
 */
public class Calculatrice {
    
    /**
     * Méthode qui effectue une opération arithmétique entre deux nombres.
     * Cette méthode est déclarée static car elle n'a pas besoin d'un objet Calculatrice 
     * pour être appelée. Elle peut être appelée directement via la classe: Calculatrice.Operation(...)
     * En C/C++, toutes les fonctions sont par défaut "statiques" alors qu'en Java, 
     * par défaut les méthodes sont liées à une instance (objet).
     *
     * @param num1 Premier nombre
     * @param num2 Deuxième nombre
     * @param operateur Caractère représentant l'opération à effectuer (+, -, *, /, %)
     */
    public static void Operation(double num1, double num2, char operateur) {
        // Structure switch pour déterminer quelle opération effectuer
        // En Java 7+, le switch peut utiliser des chaînes de caractères (String) contrairement à C/C++
        switch (operateur) {
            case '+':
                System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
                break;
            case '-':
                System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
                break;
            case '*':
                System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
                break;
            case '/':
                // Vérification que le diviseur n'est pas zéro
                if (num2 != 0) {
                    System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
                } else {
                    System.out.println("Division par zéro impossible");
                }
                break;
            case '%':
                // Vérification que le diviseur n'est pas zéro
                if (num2 != 0) {
                    System.out.println(num1 + " % " + num2 + " = " + (num1 % num2));
                } else {
                    System.out.println("Reste de division par zéro impossible");
                }
                break;
            default:
                System.out.println("Opérateur non reconnu");
        }
    }
    
    // La méthode Operation doit être static car elle est appelée directement depuis la classe Main
    // sans créer d'instance de la classe Calculatrice. C'est similaire aux fonctions 
    // dans un fichier .c ou .cpp, qui peuvent être appelées sans créer d'objet.
}