

--
USE GESTIONCOM
GO

CREATE TABLE E_TITRE(
TITRE 		VARCHAR(25) 	NOT NULL,
CONSTRAINT CLE_PRIM_TITRE PRIMARY KEY (TITRE));

CREATE TABLE E_SERVICE(
NO 		INTEGER 		NOT NULL,
NOM 		VARCHAR(50) 		NOT NULL,
CONSTRAINT CLE_PRIM_SERVICE PRIMARY KEY (NO)
);

CREATE TABLE E_EMPLOYE(
NO 		INTEGER 		NOT NULL,
NOM 		VARCHAR(50) 		NOT NULL,
PRENOM 		VARCHAR(25)			,
DT_ENTREE 	DATETIME 		NOT NULL,
TITRE 		VARCHAR(25)			,
SERVICE_NO 	INTEGER				,
COMMENTAIRE 	VARCHAR(200)			,
SALAIRE 	SMALLMONEY			,
PCT_COMMISSION 	REAL				,
CONSTRAINT CLE_PRIM_EMPLOYE PRIMARY KEY (NO),
CONSTRAINT CLE_ETR_EMP_TITRE FOREIGN KEY (TITRE)
REFERENCES E_TITRE(TITRE),
CONSTRAINT CLE_ETR_EMP_SERVICE FOREIGN KEY (SERVICE_NO)
REFERENCES E_SERVICE(NO)
);


CREATE TABLE E_CLIENT(
NO 		INTEGER 		NOT NULL,
NOM 		VARCHAR(25) 		NOT NULL,
PRENOM 		VARCHAR(25)			,
TELEPHONE 	VARCHAR(25)			,
ADRESSE 	VARCHAR(25)			,
VILLE 		VARCHAR(25)			,
PAYS 		VARCHAR(25)			,
CP_POSTAL 	VARCHAR(25)			,
COMMENTAIRE 	VARCHAR(25)			,
CONSTRAINT CLE_PRIM_CLIENT PRIMARY KEY (NO)
);


CREATE TABLE E_PRODUIT(
NO 		INTEGER 		NOT NULL,
NOM 		VARCHAR(25) 		NOT NULL,
DESCRIPTION 	VARCHAR(25)			,
PRIX_CONSEILLE 	SMALLMONEY			,
CONSTRAINT CLE_PRIM_PRODUIT PRIMARY KEY (NO)
);

CREATE TABLE E_ENTREPOT(
NO 		INTEGER 		NOT NULL,
ADRESSE 	VARCHAR(25)			,
VILLE 		VARCHAR(25)			,
PAYS 		VARCHAR(25)			,
CP_POSTAL 	VARCHAR(25)			,
TELEPHONE 	VARCHAR(25)			,
CONSTRAINT CLE_PRIM_ENTREPOT PRIMARY KEY (NO)
);


CREATE TABLE E_STOCK(
NO 		INTEGER 		NOT NULL,
PRODUIT_NO 	INTEGER 		NOT NULL,
ENTREPOT_NO 	INTEGER 		NOT NULL,
QTE_STOCK 	INTEGER				,
STOCK_SECURITE 	INTEGER				,
MAX_STOCK 	INTEGER				,
DT_STOCK 	DATETIME 		NOT NULL,
CONSTRAINT CLE_PRIM_STOCK PRIMARY KEY (NO, PRODUIT_NO, ENTREPOT_NO),
CONSTRAINT CLE_ETR_STOCK_PROD FOREIGN KEY (PRODUIT_NO)
REFERENCES E_PRODUIT(NO),
CONSTRAINT CLE_ETR_STOCK_ENTRE FOREIGN KEY (ENTREPOT_NO)
REFERENCES E_ENTREPOT(NO)
);

CREATE TABLE E_COMMANDE(
NO 		INTEGER 		NOT NULL,
CLIENT_NO 	INTEGER 		NOT NULL,
DATE_COMMANDE 	DATETIME			,
DATE_LIVRAISON 	DATETIME			,
EMPLOYE_NO 	INTEGER				,
TOTAL 		SMALLMONEY			,
CONSTRAINT CLE_PRIM_COMMANDE PRIMARY KEY (NO),
CONSTRAINT CLE_ETR_COMM_CLI FOREIGN KEY (CLIENT_NO)
REFERENCES E_CLIENT(NO),
CONSTRAINT CLE_ETR_COMM_EMP FOREIGN KEY (EMPLOYE_NO)
REFERENCES E_EMPLOYE(NO)
);

CREATE TABLE E_LIGNE(
NO 		INTEGER 		NOT NULL,
COMMANDE_NO 	INTEGER 		NOT NULL,
PRODUIT_NO 	INTEGER 		NOT NULL,
PRIX 		SMALLMONEY			,
QUANTITE 	INTEGER				,
CONSTRAINT CLE_PRIM_LIGNE PRIMARY KEY (NO,COMMANDE_NO, PRODUIT_NO),
CONSTRAINT CLE_ETR_LIGN_COMM FOREIGN KEY (COMMANDE_NO)
REFERENCES E_COMMANDE(NO),
CONSTRAINT CLE_ETR_LIGN_PROD FOREIGN KEY (PRODUIT_NO)
REFERENCES E_PRODUIT(NO)
);


insert into E_TITRE 
values('Grade A');
insert into E_TITRE 
values('Grade B');
insert into E_TITRE 
values('Grade C');
insert into E_TITRE 
values('Ingénieur');



insert into E_SERVICE 
values(1, 'Achat');
insert into E_SERVICE 
values(2, 'Vente');
insert into E_SERVICE 
values(3, 'Comptabilité');
insert into E_SERVICE 
values(4, 'Entretien');

insert into E_EMPLOYE
Values(1,'Alaoui','Said','01/01/1995','Grade A',1,'Très efficace',4500.50,99.67);
insert into E_EMPLOYE
Values(2,'Filali','Mohammed','11/01/1995','Grade A',1,'Bon rendement',4000.50,80.67);
insert into E_EMPLOYE
Values(3,'Hayani','Mourad','13/02/1997','Grade B',1,'Efficace',4500.50,98.65);
insert into E_EMPLOYE
Values(4,'Ansari','Zouhair','25/01/1996','Grade C',1,'Très efficace',4300.98,97.67);
insert into E_EMPLOYE
Values(5,'Naciri','Abdallah','01/11/1996','Grade A',1,'Bon',4350.50,66.67);
insert into E_EMPLOYE
Values(6,'Rabii','Khalid','09/01/1995','Grade B',1,'rendement moyen',3500.98,45.67);
insert into E_EMPLOYE
Values(7,'Touzani','Said','06/01/1996','Grade A',2,'Très efficace',5400.50,99.00);
insert into E_EMPLOYE
Values(8,'ElBasri','Samir','11/01/1998','Grade A',1,'Moyen',3000.50,47.67);
insert into E_EMPLOYE
Values(9,'Bahja','SalahEddine','01/01/2003','Grade A',2,'Bon',4000.50,89.67);
insert into E_EMPLOYE
Values(10,'Bahja','Brahim','19/01/1995','Grade C',2,'Très efficace',6000.34,98.60);



insert into E_CLIENT
Values(1,'Idrissi','Mohammed','O60000000','Rue 1, N° 23','Rabat','Maroc','5000','Pas de commentaire');
insert into E_CLIENT
Values(2,'Soufiani','Mohammed','O60000001','Rue 45, N° 78','Rabat','Maroc','5000','Pas de commentaire');
insert into E_CLIENT
Values(3,'Miliani','NasrEddine','O60000002','Rue 56, N° 98','Casa','Maroc','5004','Pas de commentaire');
insert into E_CLIENT
Values(4,'Zamouri','Hicham','O60000003','Rue 678, N° 223','Casa','Maroc','5005','Pas de commentaire');
insert into E_CLIENT
Values(5,'Saidi','Rachid','O60000004','Rue 43, N° 324','Fes','Maroc','5045','Pas de commentaire');
insert into E_CLIENT
Values(6,'Doukkali','Badr','O60000005','Rue 45, N° 456','Rabat','Maroc','5000','Pas de commentaire');
insert into E_CLIENT
Values(7,'Idrissi','Mohammed','O60000006','Rue 23, N° 567','Casa','Maroc','50089','Pas de commentaire');
insert into E_CLIENT
Values(8,'Zahraoui','Mostapha','O60000007','Rue 56, N° 45','Rabat','Maroc','50800','Pas de commentaire');
insert into E_CLIENT
Values(9,'Andaloussi','Iliass','O60000008','Rue 34, N° 89','Tanger','Maroc','50056','Pas de commentaire');
insert into E_CLIENT
Values(10,'Redouani','Mohammed','O60000009','Rue 3, N° 3','Marrakech','Maroc','50057','Pas de commentaire');
insert into E_CLIENT
Values(11,'Meknassi','Reda','O60000010','Rue 12, N° 9','Rabat','Maroc','50034','Pas de commentaire');
insert into E_CLIENT
Values(12,'Charel','Bernard','O600000021','Rue 20, N° 23','Paris','France','61000','Pas de commentaire');
insert into E_CLIENT
Values(13,'Jouve','Michel','O600000056','Rue 1, N° 23','Toulouse','France','65000','Pas de commentaire');



Insert into E_ENTREPOT
values(1,'Ain Sbaa' ,'Casa','Maroc','50236','060000012');
Insert into E_ENTREPOT
values(2,'Cartier Industriel' ,'Rabat','Maroc','50054','060000011');
Insert into E_ENTREPOT
values(3,'Hay Riad' ,'Rabat','Maroc','50006','060000013');


Insert into E_PRODUIT
values(1,'Onduleur X400','Pas de description',11000);
Insert into E_PRODUIT
values(2,'Onduleur X405','Pas de description',12000);
Insert into E_PRODUIT
values(3,'Onduleur X415','Pas de description',15000);
Insert into E_PRODUIT
values(4,'Onduleur X489','Pas de description',16000);
Insert into E_PRODUIT
values(5,'Onduleur X400','Pas de description',11050);
Insert into E_PRODUIT
values(6,'PC P4','Pas de description',10000);
Insert into E_PRODUIT
values(7,'Macintosh','Pas de description',16000);
Insert into E_PRODUIT
values(8,'Satation Sun','Pas de description',50000);
Insert into E_PRODUIT
values(9,'Station HP','Pas de description',60000);
Insert into E_PRODUIT
values(10,'Hub','Pas de description',1000);
Insert into E_PRODUIT
values(11,'Retour','Pas de description',40000);
Insert into E_PRODUIT
values(12,'Switch','Pas de description',1500);
Insert into E_PRODUIT
values(13,'Carte réseau','Pas de description',100);
Insert into E_PRODUIT
values(14,'Carte graphique','Pas de description',400);


Insert into E_STOCK
values(1,1,1,100,50, 250,'01/01/2003');
Insert into E_STOCK
values(2,1,2,111,50, 300,'01/01/2002');
Insert into E_STOCK
values(3,2,1,150,60, 450,'01/12/2003');
Insert into E_STOCK
values(4,2,2,105,40, 150,'01/11/2003');
Insert into E_STOCK
values(5,2,3,175,30, 200,'11/11/2002');
Insert into E_STOCK
values(6,3,1,100,20, 460,'01/10/2003');
Insert into E_STOCK
values(7,3,2,105,40, 150,'01/11/2003');
Insert into E_STOCK
values(8,3,3,175,20, 210,'01/11/2001');
Insert into E_STOCK
values(9,4,1,110,20, 400,'25/10/2002');
Insert into E_STOCK
values(10,4,2,78,40, 180,'01/11/2003');
Insert into E_STOCK
values(11,4,3,195,60, 250,'16/11/2002');
Insert into E_STOCK
values(12,5,1,180,100, 490,'19/11/2003');
Insert into E_STOCK
values(13,5,2,115,40, 150,'21/11/2003');

Insert into E_COMMANDE
values(1,1,'11/11/2001','12/11/2001',1,50000);
Insert into E_COMMANDE
values(2,1,'11/12/2001','12/02/2002',2,60000);
Insert into E_COMMANDE
values(3,2,'10/11/2001','12/11/2001',1,40500);
Insert into E_COMMANDE
values(4,3,'11/11/2002','12/11/2002',1,50030);
Insert into E_COMMANDE
values(5,1,'12/11/2003','01/01/2004',2,71000);
Insert into E_COMMANDE
values(6,4,'15/11/2003','19/11/2003',3,80100);
Insert into E_COMMANDE
values(7,6,'11/11/2003','01/01/2004',4,410000);
Insert into E_COMMANDE
values(8,6,'02/01/2004','12/01/2004',1,55000);
Insert into E_COMMANDE
values(9,8,'10/01/2004','15/01/2004',5,69000);
Insert into E_COMMANDE
values(10,13,'11/01/2004','16/01/2004',1,150800);

--remplissage de la table e_ligne
insert into e_ligne values (1,1,1, 1000, 10);
insert into e_ligne values (2,1,3, 10, 100); 
insert into e_ligne values (3,1,4, 1000, 100);
insert into e_ligne values (4,7,1, 1000, 10); 
insert into e_ligne values (5,7,3, 10, 100); 
insert into e_ligne values (6,7,4, 1000, 100);
insert into e_ligne values (7,6,5, 1000, 10);
insert into e_ligne values (8,6,5, 10, 100); 
insert into e_ligne values (9,6,8, 1000, 100);



