package exercice.exercice1;
import java.util.Scanner;
class Calculatrice {
    public static void operation(double num1, double num2, char op) {
        switch (op) {
            case '+':
                System.out.println("Resultat: " + (num1 + num2));
                break;
            case '-':
                System.out.println("Resultat: " + (num1 - num2));
                break;
            case '*':
                System.out.println("Resultat: " + (num1 * num2));
                break;
            case '/':
                if (num2 != 0) {
                    System.out.println("Resultat: " + (num1 / num2));
                } else {
                    System.out.println("Erreur: Division par zéro");
                }
                break;
            case '%':
                if (num2 != 0) {
                    System.out.println("Le reste: " + (num1 % num2));
                } else {
                    System.out.println("Erreur: Division par zéro");
                }
                break;
            default:
                System.out.println("Erreur: Opérateur inconnu");
                break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int decision;
        do{
            System.out.println("** Calculatrice **");
            System.out.println("Addition (+)");
            System.out.println("Soustraction (-)");
            System.out.println("Multiplication (*)");
            System.out.println("Division (/)");
            System.out.println("Modulo (%)");
            System.out.println("Entrez votre choix :");
            char op = sc.nextLine().charAt(0);
            System.out.println("Entrez 2 nombres: " );
            double num1 = sc.nextDouble();
            double num2 = sc.nextDouble();
            Calculatrice.operation(num1, num2, op);
            System.out.println("Voulez-vous continuer? (1/0)");
            decision= sc.nextInt();
        }while(decision==1);
        sc.close();
    }
}
