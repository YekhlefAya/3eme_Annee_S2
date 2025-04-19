package ma.emsi.projets.formes;

/**
 * Classe de test pour le système de gestion des formes tridimensionnelles.
 * Démontre l'utilisation des classes abstraites, du polymorphisme et des classes finales.
 */
public class TestFormes {

    public static void main(String[] args) {
        System.out.println("GESTION DES FORMES TRIDIMENSIONNELLES");
        
        // Création de plusieurs formes
        Forme[] formes = new Forme[4];
        
        // Création des centres de gravité
        Point3D centre1 = new Point3D(0, 0, 0);
        Point3D centre2 = new Point3D(5, 3, 2);
        Point3D centre3 = new Point3D(10, 4, 3);
        Point3D centre4 = new Point3D(2, 7, 9);
        
        // Création des formes
        formes[0] = new Boule(centre1, 1.0, 5.0);  // Boule de rayon 5
        formes[1] = new Cylindre(centre2, 2.0, 8.0, 3.0);  // Cylindre de hauteur 8 et rayon 3
        formes[2] = new Brique(centre3, 1.5, 10.5, 14.3, 4.6);  // Brique avec dimensions spécifiées
        formes[3] = new Cube(centre4, 2.5, 5.0);  // Cube de côté 5
        
        // Affichage des informations sur chaque forme
        System.out.println("\nInformations sur les formes:");
        
        for (int i = 0; i < formes.length; i++) {
            System.out.println("\nForme " + (i+1) + ":");
            System.out.println(formes[i]);
            System.out.println("Surface: " + formes[i].calculerSurface());
            System.out.println("Volume: " + formes[i].calculerVolume());
            System.out.println("Poids: " + formes[i].calculerPoids());
        }
        
        // Déplacement des formes
        System.out.println("\nDéplacement des formes:");
        
        // Déplacer la boule
        formes[0].bouger(2, 3, 4);
        System.out.println("Boule déplacée: " + formes[0].getCentreGravite());
        
        // Déplacer le cube
        formes[3].bouger(-1, 2, 5);
        System.out.println("Cube déplacé: " + formes[3].getCentreGravite());
        
        // Démonstration de l'utilisation de Point3D
        System.out.println("\nManipulation de Point3D:");
        
        Point3D p1 = new Point3D(1, 2, 3);
        Point3D p2 = new Point3D(1, 2, 3);
        Point3D p3 = new Point3D(4, 5, 6);
        
        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
        System.out.println("p3: " + p3);
        
        System.out.println("p1 equals p2: " + p1.equals(p2));
        System.out.println("p1 equals p3: " + p1.equals(p3));
        
        p1.bouger(3, 3, 3);
        System.out.println("p1 après déplacement: " + p1);
        System.out.println("p1 equals p3: " + p1.equals(p3));
        
        // Démonstration de la classe finale Cube
        System.out.println("\nManipulation spécifique du Cube:");
        
        Cube cube = (Cube) formes[3];
        System.out.println("Côté initial du cube: " + cube.getCote());
        
        cube.setCote(10.0);
        System.out.println("Cube après modification du côté:");
        System.out.println(cube);
        System.out.println("Nouveau volume du cube: " + cube.calculerVolume());
        
        // Test des contraintes: une classe ne peut pas hériter de Cube car elle est finale
        // class SuperCube extends Cube {} // Impossible - génère une erreur de compilation
        
        // Test des contraintes: Forme ne peut pas être instanciée car elle est abstraite
        // Forme forme = new Forme(new Point3D(0, 0, 0), 1.0); // Impossible - génère une erreur de compilation
    }
}