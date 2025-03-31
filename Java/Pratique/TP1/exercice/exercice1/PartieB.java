package exercice.exercice1;
import java.util.Scanner;
class PartieB {
    public static void main(String[] args) {
        java.util.Scanner sc= new Scanner (System.in);
        System.out.println("Entrer 2 nombres");
        double nombre1=sc.nextDouble();
        double nombre2=sc.nextDouble();
        System.out.println("Addition: "+(nombre1+nombre2));
        System.out.println("Soustraction: "+(nombre1-nombre2));
        System.out.println("Multiplication: "+(nombre1*nombre2));
        if(nombre2!=0){
            System.out.println("Division: "+(nombre1/nombre2));
        }
        else{
            System.out.println("Division impossible par zero");
        }
        System.out.println("Max: "+Math.max(nombre1,nombre2));
        System.out.println("Min: "+Math.min(nombre1,nombre2));
        System.out.println("Racine carrée premier nombre:"+(Math.sqrt(Math.abs(nombre1))));
        System.out.println("Racine carrée deuxième nombre: "+(Math.sqrt(Math.abs(nombre2))));
        System.out.println("Puissance: "+Math.pow(nombre1,nombre2));
        sc.close();
    }
}