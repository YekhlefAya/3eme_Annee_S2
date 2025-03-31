'''Opérations sur les dictionnaires.'''

# Initialiser un dictionnaire "etudiant" avec les clés "nom", "age", "matiere_preferee" et "notes"
# et les valeurs respectives "Alice", 20, "Mathématiques" et [15, 16, 18] (une liste de notes)
etudiant = {"nom": "Alice", "age": 20, "matiere_preferee": "Mathématiques", "notes": [15, 16, 18]}

# Afficher le dictionnaire "etudiant"
print(etudiant)
# Output: {'nom': 'Alice', 'age': 20, 'matiere_preferee': 'Mathématiques', 'notes': [15, 16, 18]}

# Obtenir le nombre de paires clé-valeur dans le dictionnaire "etudiant"
print(len(etudiant))
# Output: 4

# Vérifier si la clé "nom" existe dans le dictionnaire "etudiant"
print("nom" in etudiant)
# Output: True

# Obtenir la valeur associée à la clé "age"
print(etudiant["age"])
# Output: 20

# Obtenir la valeur associée à la clé "ville", en utilisant une valeur par défaut de "Inconnu" si la clé n'existe pas
print(etudiant.get("ville", "Inconnu"))
# Output: Inconnu

# Ajouter une nouvelle paire clé-valeur au dictionnaire "etudiant" : "ville": "Paris"
etudiant["ville"] = "Paris"
print(etudiant)
# Output: {'nom': 'Alice', 'age': 20, 'matiere_preferee': 'Mathématiques', 'notes': [15, 16, 18], 'ville': 'Paris'}

# Modifier la valeur associée à la clé "age" pour la mettre à 21
etudiant["age"] = 21
print(etudiant)
# Output: {'nom': 'Alice', 'age': 21, 'matiere_preferee': 'Mathématiques', 'notes': [15, 16, 18], 'ville': 'Paris'}

# Ajouter une note (17) à la liste de notes existante dans la clé "notes" (sans boucle)
etudiant["notes"].append(17)
print(etudiant)
# Output: {'nom': 'Alice', 'age': 21, 'matiere_preferee': 'Mathématiques', 'notes': [15, 16, 18, 17], 'ville': 'Paris'}

# Supprimer la clé "matiere_preferee" du dictionnaire "etudiant"
del etudiant["matiere_preferee"]
print(etudiant)
# Output: {'nom': 'Alice', 'age': 21, 'notes': [15, 16, 18, 17], 'ville': 'Paris'}

# Obtenir la liste de toutes les clés du dictionnaire "etudiant"
print(list(etudiant.keys()))
# Output: ['nom', 'age', 'notes', 'ville']

# Obtenir la liste de toutes les valeurs du dictionnaire "etudiant"
print(list(etudiant.values()))
# Output: ['Alice', 21, [15, 16, 18, 17], 'Paris']

#Créer un nouveau dictionnaire "adresse" avec les clés "rue" et "code_postal" et les valeurs de votre choix, puis fusionner le dictionnaire "adresse" dans le dictionnaire "etudiant"
adresse = {"rue": "Rue de la Paix", "code_postal": "75002"}
etudiant.update(adresse)
print(etudiant)
# Output: {'nom': 'Alice', 'age': 21, 'notes': [15, 16, 18, 17], 'ville': 'Paris', 'rue': 'Rue de la Paix', 'code_postal': '75002'}