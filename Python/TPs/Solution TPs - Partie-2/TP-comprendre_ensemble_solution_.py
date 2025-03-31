'''Comprendre les ensembles.'''

# initialiser une variable nombres avec l'ensemble qui contient 1, 2, 3 et 2.
nombres = {1, 2, 3, 2}
print(nombres)

# obtenir la taille de l'ensemble (le nombre d'éléments qu'il contient)
print (len(nombres))

# tester si l'élément 2 est présent dans l'ensemble
print (2 in nombres)    

# tester si l'élément 5 n'est pas présent dans l'ensemble
print (5 not in nombres)  

# ajouter 11 dans l'ensemble.  Quelles est la taille de l'ensemble ?
nombres.add(11)
print (len(nombres))

# ajouter 2 dans l'ensemble. Quelle est sa taille ?
nombres.add(2)
print (len(nombres))

# supprimer l'élément 2 de l'ensemble.
nombres.remove(2)   # l'élément doit être dans l'ensemble sinon KeyError

# 2 est-il encore dans l'ensemble ?
print (2 not in nombres)

# Quelle est la taille de l'ensemble ?
print (len(nombres))

