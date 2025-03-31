'''
TP : Comprendre les ensembles
Compléter le programme comprendre_ensemble.py ci-après pour écrire les instructions Python qui réalisent les actions en commentaire. 
'''
# initialiser une variable nombres avec l'ensemble qui contient 1, 2, 3 et 2.

nbrs=[1,2,3,4]

# obtenir la taille de l'ensemble (le nombre d'éléments qu'il contient)

print(len(nbrs))

# tester si l'élément 2 est présent dans l'ensemble
print(2 in nbrs)

# tester si l'élément 5 n'est pas présent dans l'ensemble

print(5 not in nbrs)

# ajouter 11 dans l'ensemble.  Quelles est la taille de l'ensemble ?

nbrs.append(11)
print(len(nbrs))
# ajouter 2 dans l'ensemble. Quelle est sa taille ?
nbrs.append(2)
print(len(nbrs))

# supprimer l'élément 2 de l'ensemble.

nbrs.remove(2)
# 2 est-il encore dans l'ensemble ?
print(2 in nbrs)

# Quelle est la taille de l'ensemble ?
print(len(nbrs))



