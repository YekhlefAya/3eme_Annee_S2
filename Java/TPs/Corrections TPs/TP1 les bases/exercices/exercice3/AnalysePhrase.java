package exercices.exercice3;

/**
 * Classe AnalysePhrase qui contient des méthodes pour analyser et manipuler des phrases
 * Cette classe est utilisée dans l'exercice 3
 */
public class AnalysePhrase {
    
    /**
     * Méthode qui compte le nombre de mots dans une phrase.
     * Un mot est défini comme une séquence de caractères séparée par des espaces.
     * 
     * @param phrase La phrase à analyser
     * @return Le nombre de mots dans la phrase
     */
    public static int nombreDeMots(String phrase) {
        // Si la phrase est vide ou null, elle ne contient aucun mot
        // La méthode trim() supprime les espaces au début et à la fin de la chaîne
        if (phrase == null || phrase.trim().isEmpty()) {
            return 0;
        }
        
        // La méthode split divise la chaîne en sous-chaînes en fonction d'un délimiteur
        // "\\s+" est une expression régulière qui représente une séquence d'un ou plusieurs espaces
        // C'est similaire à strtok en C, mais plus puissant car utilise des expressions régulières
        String[] mots = phrase.trim().split("\\s+");
        
        // Retourne la longueur du tableau (nombre de mots)
        // En Java, les tableaux ont une propriété length (pas une fonction comme en C)
        return mots.length;
    }
    
    /**
     * Méthode qui vérifie si un caractère est une voyelle.
     * 
     * @param c Le caractère à vérifier
     * @return true si c'est une voyelle, false sinon
     */
    public static boolean estVoyelle(char c) {
        // indexOf retourne la position d'un caractère dans une chaîne, ou -1 s'il n'est pas trouvé
        // Donc, si le caractère est une voyelle, la méthode retourne true
        // Cette méthode est plus efficace qu'une série de if/else ou un switch pour ce cas
        return "aeiouAEIOU".indexOf(c) != -1;
    }
    
    /**
     * Méthode qui remplace toutes les voyelles d'une phrase par un symbole.
     * 
     * @param phrase La phrase à modifier
     * @param symbol Le symbole de remplacement
     * @return La phrase avec les voyelles remplacées
     */
    public static String remplacerVoyelle(String phrase, char symbol) {
        // Si la phrase est null, on retourne null pour éviter les erreurs
        if (phrase == null) {
            return null;
        }
        
        // Création d'un StringBuilder pour construire la nouvelle chaîne
        // StringBuilder est plus efficace que la concaténation de String pour les modifications répétées
        // C'est similaire à strcat en C, mais plus efficace car il redimensionne automatiquement
        StringBuilder resultat = new StringBuilder();
        
        // Parcours de chaque caractère de la phrase
        for (int i = 0; i < phrase.length(); i++) {
            char c = phrase.charAt(i);
            
            // Si le caractère est une voyelle, on le remplace par le symbole
            if (estVoyelle(c)) {
                resultat.append(symbol);
            } else {
                // Sinon, on ajoute le caractère tel quel
                resultat.append(c);
            }
        }
        
        // Conversion du StringBuilder en String et retour
        return resultat.toString();
    }
    
    /**
     * Méthode qui inverse l'ordre des mots dans une phrase.
     * 
     * @param phrase La phrase à inverser
     * @return La phrase avec les mots dans l'ordre inverse
     */
    public static String inverserPhrase(String phrase) {
        // Si la phrase est null ou vide, on la retourne telle quelle
        if (phrase == null || phrase.trim().isEmpty()) {
            return phrase;
        }
        
        // Division de la phrase en mots
        String[] mots = phrase.trim().split("\\s+");
        
        // Création d'un tableau pour stocker les mots dans l'ordre inverse
        String[] motsInverses = new String[mots.length];
        
        // Inversion de l'ordre des mots
        for (int i = 0; i < mots.length; i++) {
            motsInverses[i] = mots[mots.length - 1 - i];
        }
        
        // Jonction des mots inversés avec des espaces entre eux
        // String.join est une méthode pratique qui n'existe pas en C
        // En C, il faudrait utiliser strcat de manière répétée
        return String.join(" ", motsInverses);
    }
}