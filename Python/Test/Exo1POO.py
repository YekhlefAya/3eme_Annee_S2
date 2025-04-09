from datetime import datetime
class Personne :
    def __init__(self,Num=0, Nom="", Prenom="" , dateN=""):
        self.set_Num(Num)  ,      
        self.Nom = Nom,
        self.Prenom=Prenom,
        self.dateN=dateN


    def __str__(self)->str:
        return f"Num {str(self.Num)} Nom {self.Nom} Prenom {self.Prenom} Date de Naissance {self.dateN}"
    def get_Num(self):
        return self.Num
    def get_Nom(self):
        return self.Nom
    def get_Prenom(self):
        return self.Prenom
    def get_dateN(self):
        return self.dateN
    def set_Num(self,Num):
        if Num>=0 :
            self.Num = Num
    def set_Nom(self,Nom):
        self.Nom = Nom
    def set_Prenom(self,Prenom):
        self.Prenom=Prenom
    def set_dateN(self,dateN):
        self.dateN=dateN
    def calculer_age(self):
        dateAujourdui=datetime.now().date()
        dateValide=datetime.strptime(self.dateN,"%d-%m-%Y").date()
        return dateAujourdui.year-dateValide.year
    def est_majeur(self):
        age=self.calculer_age()
        return age>=18
    def __eq__(self,other):
        if(type(other)==Personne):
            return self.Num==other.Num

P1=Personne(1,"yekhlef","aya","05-01-2005")  
P2=Personne(2,"yekhlef","nour","13-06-2009")  
P1.set_Nom("yekhleff")
print(P1)
age=P1.calculer_age()
maj=P1.est_majeur
print(P1==P2)
