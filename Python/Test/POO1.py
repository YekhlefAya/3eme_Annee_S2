class Point :

    def __init__(self,x=0,y=0,couleur="")->None:
        self.__x = x
        self.__y = y
        self.__couleur=couleur
    def afficher(self)->None:
        print("je suis un point",self.__x,self.__y,self.__couleur)
    
    def __str__(self)->str:
        return f"point({self.get_x()},{self.get_y()})"
    def __eq__(self,value):
        return self.__x == value.__x and self.__y == value.__y 
    
    def __lt__(self,value):
        return self.__x<value.__x and self.__y<value.__y
    def get_x(self):
        return self.__x
    def get_y(self):
        return self.__y
    def set_x(self,x):
        self.__x=x
    def set_y(self,y):
        self.__y=y

p1= Point(5,5,"orange")
p1.afficher()  
p2= Point(2,4,"noir")
p2.afficher() 
p3= Point(2,4,"jaune")

print(p1) 
print(p2)
print(p2==p3)
print(p1>p3)
print(p1<p3)
p1.set_x(7)
print(p1) 
# print(type(p1))
# print(isinstance(p1,Point))
