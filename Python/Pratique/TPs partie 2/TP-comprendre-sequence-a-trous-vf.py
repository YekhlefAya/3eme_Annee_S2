'''Opérations sur les séquences (avec une liste). '''

# Initialiser un nom s avec une liste contenant dans l'ordre 9, 1, 5, 2, 1 et 3
s=[9,1,5,2,1,3]
# Obtenir la taille de la liste s (le nombre d'éléments qu'elle contient)
print(len(s))
# Savoir si l'élément 2 est présent dans s.  Idem pour l'élément 4
print(2 in s)
print(4 in s)


# Obtenir le premier élément de s
print(s[0])
# Obtenir le dernier élément de s
print(s[len(s)-1])
# Obtenir la fréquence (nombre d'occurences) de 1 dans s
print(s.count(1))
# Supprimer l'élément à l'indice 2 de s
del s[2]
# Supprimer l'élément 2 de s
s.remove(2)
# Ajouter 7 à la fin de s
s.append(7)
# Ajouter 6 en position 2 dans s
s.insert(2,6)
# Ajouter 0 avant la première occurrence de x dans s (x pourrait être 1 et 3)
#x = 1
#........
x=1
s.insert(s.index(x),0)
#x = 3
#.........
x=3
s.insert(s.index(x),0)