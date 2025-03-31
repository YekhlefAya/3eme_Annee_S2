# nbr=int(input("donner un nmbr :1"))
# if (nbr<0):
#     print("le nombre est negatif")
# elif (nbr>0):
#     print("le nombre est positif")
# else:
#     print("le nombre est nul")

# nbr=int(input("donner un nmbr :"))
# if nbr%2==0:
#     print("le nombre est pair")
# else :
#     print("le nombre est impair")

# nbr=int(input("donner un nmbr :"))
# message="le nombre est pair" if nbr%2==0 else "nombre est impair"
# print(message)

# nbr=int(input("donner un nmbr :"))
# message="le nombre est positif" if nbr>0 else "nombre est negatif" if nbr<0 else "nombre est nul" 
# print(message)

# age=int(input("Entrer votre age :"))
# if age<14:
#     tarif=20
# elif age>=65 :
#     tarif=40
# else :
#     tarif=50

# print("Tarif :", tarif)

# tarif="20 dh" if age<14 else "50 dh" if age>=65 else "40 dh"
# nbrs=[2,7,6,3]
# for nbr in nbrs :
#     print(nbr *2, end=" | ")
# modules=["java", "python","sql"]
# for i in range(len(modules)):
#     print(modules[i])
# modules=["java", "python","sql"]
# notes=[14,15,19]
# for i in range(len(notes)):
#     print(modules[i] ,":", notes[i])     
# modules=["java", "python","sql"]
# notes=[14,15,19]   
# for module , note in zip(modules,notes):
#     print(module , ":" , note)  
# div=[] 
# nbr=int(input("enter un nombre :"))
# for i in range(1,nbr+1):
#     if nbr%i==0 :
#         div.append(i)
# print (div)

# chaine="Le prix de 10 lots de 5 vaut 50"
# i=0
# d=0
# while i<len(chaine):
#     if chaine[i].isdigit():
#         d+=1
#     i+=1
# print(d)


def parite ():
    return nbr%2==0

nbr =int(input("Entrer le nombre"))
print(parite())