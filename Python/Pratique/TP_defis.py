# Defi 1
def MaxEl(liste):
    maxN = liste[0]
    for nombre in liste:
        if nombre > maxN:
            maxN = nombre
    return maxN

liste1 = [32, 5, 12, 8, 3, 75, 2, 15]
print(MaxEl(liste1))  

# Defi 2
def Sep(liste):
    pairs = []
    impairs = []
    for nombre in liste:
        if nombre % 2 == 0:
            pairs.append(nombre)
        else:
            impairs.append(nombre)
    return pairs, impairs

liste2 = [32, 5, 12, 8, 3, 75, 2, 15]
pairs, impairs = Sep(liste2)
print("Pairs:", pairs)  
print("Impairs:", impairs)  

# Defi 3
def IndexMax(liste):
    Maxx = MaxEl(liste)  
    return liste.index(Maxx)  

liste2 = [32, 5, 12, 8, 3, 75, 2, 15]
print(IndexMax(liste2))  

# Defi 4

def inverserChaine(chaine):
    longueur = len(chaine)
    index = longueur - 1
    chaine_inverse = ""
    while index >= 0:
        chaine_inverse += chaine[index]
        index -= 1
    return chaine_inverse

chaine = "Bonjour"
print(inverserChaine(chaine))  