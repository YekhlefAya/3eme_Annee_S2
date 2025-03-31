'''Opérations sur les dictionnaires '''

# Initialiser un dictionnaire "etudiant" avec les clés "nom", "age", "matiere_preferee" et "notes"
# et les valeurs respectives "Alice", 20, "Mathématiques" et [15, 16, 18] (une liste de notes)
etudiant={"nom":"Alice","age":20,"matiere_preferee":"Mathématiques","notes":[15, 16, 18]}
# Afficher le dictionnaire "etudiant"
print(etudiant)
# Obtenir le nombre de paires clé-valeur dans le dictionnaire "etudiant"
print(len(etudiant))
# Vérifier si la clé "nom" existe dans le dictionnaire "etudiant"
print("nom" in etudiant)
# Obtenir la valeur associée à la clé "age"
print(etudiant["age"])
# Obtenir la valeur associée à la clé "ville", en utilisant une valeur par défaut de "Inconnu" si la clé n'existe pas
print(etudiant.get("ville","Inconnu"))
# Ajouter une nouvelle paire clé-valeur au dictionnaire "etudiant" : "ville": "Paris"
etudiant["ville"]="Paris"
# Modifier la valeur associée à la clé "age" pour la mettre à 21
etudiant["age"]=21
# Ajouter une note (17) à la liste de notes existante dans la clé "notes" (sans boucle)
etudiant["notes"].append(17)
# Supprimer la clé "matiere_preferee" du dictionnaire "etudiant"
del etudaint["matiere_preferee"]
# Obtenir la liste de toutes les clés du dictionnaire "etudiant"
cles=liste(etudiant.keys())
print(cles)
# Obtenir la liste de toutes les valeurs du dictionnaire "etudiant"
val=liste(etudiant.values())
#Créer un nouveau dictionnaire "adresse" avec les clés "rue" et "code_postal" et les valeurs de votre choix, puis fusionner le dictionnaire "adresse" dans le dictionnaire "etudiant"
adresse={"rue":"rue de la paix","code_postal":"75001"}
etudiant.update(adresse)
print(etudiant)
