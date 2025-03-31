USE GestComs
GO

-- modification du format de la date pour inserer des dates de la forme DD/MM/YYYY
-- Set date format to day/month/year.  
SET DATEFORMAT dmy;  
GO

-- création du schéma de la BD

CREATE TABLE Titres(
	TITRE 		VARCHAR(25)  		constraint NN_TIT_TITS NOT NULL		,
	CONSTRAINT CLE_PRIM_TITRE PRIMARY KEY (TITRE)
);

CREATE TABLE SERVICES(
	NO 		INTEGER 														,
	NOM 	VARCHAR(50) 			constraint NN_NOM_SERS NOT NULL		,
	CONSTRAINT PK_SERVICES PRIMARY KEY (NO)
);

CREATE TABLE EMPLOYES(
	NO 			INTEGER 											,
	NOM 		VARCHAR(50) 	constraint NN_NOM_EMPS NOT NULL		,
	PRENOM 		VARCHAR(25)										,
	DT_ENTREE 	DATE 			constraint NN_DT_ENT_EMPS NOT NULL	,
	TITRE 		VARCHAR(25)										,
	SERVICE_NO 	INTEGER											,
	COMMENTAIRE VARCHAR(200)										,
	SALAIRE 	DECIMAL(11,2)										,
	PCT_COMMISSION 	DECIMAL(4,2)										,
	CONSTRAINT PK_EMPS PRIMARY KEY (NO)					
);

CREATE TABLE CLIENTS(
	NO 			INTEGER 											,
	NOM 		VARCHAR(50) 	constraint NN_NOM_CLS NOT NULL		,
	PRENOM 		VARCHAR(25)										,
	TELEPHONE 	VARCHAR(25)										,
	ADRESSE 	VARCHAR(200) 										,
	VILLE 		VARCHAR(30)										,
	PAYS 		VARCHAR(30)										,
	CP_POSTAL 	VARCHAR(5)											,
	COMMENTAIRE 	VARCHAR(200)									,
	CONSTRAINT PK_CLS PRIMARY KEY (NO)
);


CREATE TABLE PRODUITS(
	NO 				INTEGER 												,
	NOM 			VARCHAR(50) 	constraint NN_NOM_PRODS NOT NULL		,
	DESCRIPTION 	VARCHAR(200)											,
	PRIX_CONSEILLE 	DECIMAL(11,2)											,
	CONSTRAINT PK_PRODS PRIMARY KEY (NO)
);

CREATE TABLE ENTREPOTS(
	NO 			INTEGER 					,
	ADRESSE 	VARCHAR(200) 				,
	VILLE 		VARCHAR(30)				,
	PAYS 		VARCHAR(30)				,
	CP_POSTAL 	VARCHAR(5)					,
	TELEPHONE 	VARCHAR(25)				,
	CONSTRAINT PK_ENTRS PRIMARY KEY (NO)
);


CREATE TABLE STOCKS(
	NO 				INTEGER 												,
	PRODUIT_NO 		INTEGER 												,
	ENTREPOT_NO 	INTEGER 												,
	QTSTOCKS 		DECIMAL(9,2)												,
	STOCK_SECURITE 	DECIMAL(9,2)												,
	MAX_STOCK 		DECIMAL(9,2)												,
	DT_STOCK 		DATE 		constraint NN_DT_STCK_STOCKS NOT NULL,
	CONSTRAINT PK_STOCKS PRIMARY KEY (NO, PRODUIT_NO, ENTREPOT_NO)
);


CREATE TABLE COMMANDES(
	NO 				INTEGER 											,
	CLIENT_NO 		INTEGER 	constraint NN_CL_CLS NOT NULL 			,
	DATE_COMMANDE 	DATE 		constraint NN_DT_COM_COMS NOT NULL		,
	DATE_LIVRAISON 	DATE  		constraint NN_DT_LIV_COMS NOT NULL		,
	EMPLOYE_NO 		INTEGER											,
	CONSTRAINT PK_COMMANDE PRIMARY KEY (NO)								,
  	CONSTRAINT CV_DTCOM_DTLIV_COMS CHECK (DATE_LIVRAISON>DATE_COMMANDE)
);

CREATE TABLE LIGNES(
	COMMANDE_NO 	INTEGER 												,
	PRODUIT_NO 		INTEGER 												,
	PRIX 			DECIMAL(11,2)  	constraint NN_PRIX_LIGNES NOT NULL		,
	QUANTITE 		DECIMAL(9,2)  		constraint NN_QTE_LIGNES NOT NULL		,
	CONSTRAINT PK_LIGNES PRIMARY KEY (COMMANDE_NO, PRODUIT_NO)				,
	CONSTRAINT CV_PRIX_LIGNES CHECK (PRIX > 0)  							,
	CONSTRAINT CV_QTE_LIGNES CHECK (QUANTITE >0)
);

-- AJOUT DES CONTRAINTES D'INTEGRITE REFERENTIELLE PAR MODIFICATION DU SCHEMA

-- entre la table EMPLOYES et la table SERVICES
ALTER TABLE EMPLOYES
 ADD CONSTRAINT FK_EMPS_SERVICES FOREIGN KEY (SERVICE_NO) REFERENCES SERVICES(NO);

-- entre la table EMPLOYES et la table TITRES
ALTER TABLE EMPLOYES
  ADD CONSTRAINT FK_EMPS_TITRES FOREIGN KEY (TITRE) REFERENCES Titres(TITRE);

-- entre la table STOCKS et la table PRODUITS
ALTER TABLE STOCKS
  ADD CONSTRAINT FK_STOCKS_PRODS FOREIGN KEY (PRODUIT_NO) REFERENCES PRODUITS(NO);

-- entre la table STOCKS et la table ENTREPOTS
ALTER TABLE STOCKS
  ADD CONSTRAINT FK_STOCKS_ENTRS FOREIGN KEY (ENTREPOT_NO) REFERENCES ENTREPOTS(NO);

-- entre la table COMMANDES et la table CLIENTS
ALTER TABLE COMMANDES
  ADD CONSTRAINT FK_COMS_CLS FOREIGN KEY (CLIENT_NO) REFERENCES CLIENTS(NO);

-- entre la table COMMANDES et la table EMPLOYES
ALTER TABLE COMMANDES
  ADD CONSTRAINT FK_COMS_EMPS FOREIGN KEY (EMPLOYE_NO) REFERENCES EMPLOYES(NO);

-- entre la table LIGNES et la table COMMANDES
ALTER TABLE LIGNES
  ADD CONSTRAINT FK_LIGNS_COMS FOREIGN KEY (COMMANDE_NO) REFERENCES COMMANDES(NO);

-- entre la table LIGNES et la table PRODUITS
ALTER TABLE LIGNES
  ADD CONSTRAINT FK_LIGNS_PRODS FOREIGN KEY (PRODUIT_NO) REFERENCES PRODUITS(NO);

-- PEUPLEMENT DE LA BD POUR LES TESTS

insert into Titres values('Grade A');
insert into Titres values('Grade B');
insert into Titres values('Grade C');
insert into Titres values('Ing nieur');



insert into SERVICES values(1, 'Achat');
insert into SERVICES values(2, 'Vente');
insert into SERVICES values(3, 'Comptabilit ');
insert into SERVICES values(4, 'Entretien');

insert into EMPLOYES
Values(1,'Alaoui','Said','01/01/1995','Grade A',1,'Tr s efficace',4500.50,9.67);
insert into EMPLOYES
Values(2,'Filali','Mohammed','11/01/1995','Grade A',1,'Bon rendement',4000.50,0.67);
insert into EMPLOYES
Values(3,'Hayani','Mourad','13/02/1997','Grade B',1,'Efficace',4500.50,8.65);
insert into EMPLOYES
Values(4,'Ansari','Zouhair','25/01/1996','Grade C',1,'Tr s efficace',4300.98,7.67);
insert into EMPLOYES
Values(5,'Naciri','Abdallah','01/11/1996','Grade A',1,'Bon',4350.50,66.67);
insert into EMPLOYES
Values(6,'Rabii','Khalid','09/01/1995','Grade B',1,'rendement moyen',3500.98,5.67);
insert into EMPLOYES
Values(7,'Touzani','Said','06/01/1996','Grade A',2,'Tr s efficace',5400.50,9.00);
insert into EMPLOYES
Values(8,'ElBasri','Samir','11/01/1998','Grade A',1,'Moyen',3000.50,7.67);
insert into EMPLOYES
Values(9,'Bahja','SalahEddine','01/01/2003','Grade A',2,'Bon',4000.50,8.67);
insert into EMPLOYES
Values(10,'Bahja','Brahim','19/01/1995','Grade C',2,'Tr s efficace',6000.34,8.60);



insert into CLIENTS
Values(1,'Idrissi','Mohammed','O60000000','Rue 1, N  23','Rabat','Maroc','5000','Pas de commentaire');
insert into CLIENTS
Values(2,'Soufiani','Mohammed','O60000001','Rue 45, N  78','Rabat','Maroc','5000','Pas de commentaire');
insert into CLIENTS
Values(3,'Miliani','NasrEddine','O60000002','Rue 56, N  98','Casa','Maroc','5004','Pas de commentaire');
insert into CLIENTS
Values(4,'Zamouri','Hicham','O60000003','Rue 678, N  223','Casa','Maroc','5005','Pas de commentaire');
insert into CLIENTS
Values(5,'Saidi','Rachid','O60000004','Rue 43, N  324','Fes','Maroc','5045','Pas de commentaire');
insert into CLIENTS
Values(6,'Doukkali','Badr','O60000005','Rue 45, N  456','Rabat','Maroc','5000','Pas de commentaire');
insert into CLIENTS
Values(7,'Idrissi','Mohammed','O60000006','Rue 23, N  567','Casa','Maroc','50089','Pas de commentaire');
insert into CLIENTS
Values(8,'Zahraoui','Mostapha','O60000007','Rue 56, N  45','Rabat','Maroc','50800','Pas de commentaire');
insert into CLIENTS
Values(9,'Andaloussi','Iliass','O60000008','Rue 34, N  89','Tanger','Maroc','50056','Pas de commentaire');
insert into CLIENTS
Values(10,'Redouani','Mohammed','O60000009','Rue 3, N  3','Marrakech','Maroc','50057','Pas de commentaire');
insert into CLIENTS
Values(11,'Meknassi','Reda','O60000010','Rue 12, N  9','Rabat','Maroc','50034','Pas de commentaire');
insert into CLIENTS
Values(12,'Charel','Bernard','O600000021','Rue 20, N  23','Paris','France','61000','Pas de commentaire');
insert into CLIENTS
Values(13,'Jouve','Michel','O600000056','Rue 1, N  23','Toulouse','France','65000','Pas de commentaire');



Insert into ENTREPOTS
values(1,'Ain Sbaa' ,'Casa','Maroc','50236','060000012');
Insert into ENTREPOTS
values(2,'Cartier Industriel' ,'Rabat','Maroc','50054','060000011');
Insert into ENTREPOTS
values(3,'Hay Riad' ,'Rabat','Maroc','50006','060000013');


Insert into PRODUITS
values(1,'Onduleur X400','Pas de description',11000);
Insert into PRODUITS
values(2,'Onduleur X405','Pas de description',12000);
Insert into PRODUITS
values(3,'Onduleur X415','Pas de description',15000);
Insert into PRODUITS
values(4,'Onduleur X489','Pas de description',16000);
Insert into PRODUITS
values(5,'Onduleur X400','Pas de description',11050);
Insert into PRODUITS
values(6,'PC P4','Pas de description',10000);
Insert into PRODUITS
values(7,'Macintosh','Pas de description',16000);
Insert into PRODUITS
values(8,'Satation Sun','Pas de description',50000);
Insert into PRODUITS
values(9,'Station HP','Pas de description',60000);
Insert into PRODUITS
values(10,'Hub','Pas de description',1000);
Insert into PRODUITS
values(11,'Retour','Pas de description',40000);
Insert into PRODUITS
values(12,'Switch','Pas de description',1500);
Insert into PRODUITS
values(13,'Carte r seau','Pas de description',100);
Insert into PRODUITS
values(14,'Carte graphique','Pas de description',400);


Insert into STOCKS
values(1,1,1,100,50, 250,'01/01/2003');
Insert into STOCKS
values(2,1,2,111,50, 300,'01/01/2002');
Insert into STOCKS
values(3,2,1,150,60, 450,'01/12/2003');
Insert into STOCKS
values(4,2,2,105,40, 150,'01/11/2003');
Insert into STOCKS
values(5,2,3,175,30, 200,'11/11/2002');
Insert into STOCKS
values(6,3,1,100,20, 460,'01/10/2003');
Insert into STOCKS
values(7,3,2,105,40, 150,'01/11/2003');
Insert into STOCKS
values(8,3,3,175,20, 210,'01/11/2001');
Insert into STOCKS
values(9,4,1,110,20, 400,'25/10/2002');
Insert into STOCKS
values(10,4,2,78,40, 180,'01/11/2003');
Insert into STOCKS
values(11,4,3,195,60, 250,'16/11/2002');
Insert into STOCKS
values(12,5,1,180,100, 490,'19/11/2003');
Insert into STOCKS
values(13,5,2,115,40, 150,'21/11/2003');

Insert into COMMANDES values(1,1,'11/11/2001','12/11/2001',1);
Insert into COMMANDES
values(2,1,'11/12/2001','12/02/2002',2);
Insert into COMMANDES
values(3,2,'10/11/2001','12/11/2001',1);
Insert into COMMANDES
values(4,3,'11/11/2002','12/11/2002',1);
Insert into COMMANDES
values(5,1,'12/11/2003','01/01/2004',2);
Insert into COMMANDES
values(6,4,'15/11/2003','19/11/2003',3);
Insert into COMMANDES
values(7,6,'11/11/2003','01/01/2004',4);
Insert into COMMANDES
values(8,6,'02/01/2004','12/01/2004',1);
Insert into COMMANDES
values(9,8,'10/01/2004','15/01/2004',5);
Insert into COMMANDES
values(10,13,'11/01/2004','16/01/2004',1);

insert into commandes 
	(no, client_no, date_commande, date_livraison, employe_no)
values (14, 5,'11/12/2022', '12/1/2023', 10);  
insert into commandes 
	(no, client_no, date_commande, date_livraison, employe_no)
values (15, 5,'15/12/2022', '12/02/2023', 10);

insert into lignes values ( 14, 1, 125.50, 10);
insert into lignes values ( 14, 2, 1750.65, 20);
insert into lignes values ( 14, 5, 800, 8);
insert into lignes values ( 14, 8, 300.50, 35);
insert into lignes values ( 15, 1, 125.50, 17);
insert into lignes values ( 15, 2, 1750.65, 23);
insert into lignes values ( 15, 5, 800, 18);
insert into lignes values ( 15, 8, 300.50, 68);

insert into LIGNES values(1, 1, 10900, 5);
insert into LIGNES values(1, 2, 12000, 8);
insert into LIGNES values(1, 3, 14900, 3);
insert into LIGNES values(1, 7, 15900, 2);

insert into LIGNES values(2, 8, 10900, 5);
insert into LIGNES values(2, 7, 49900, 9);

insert into LIGNES values(3, 7, 50000, 2);

insert into LIGNES values(4, 14, 398, 13);
insert into LIGNES values(4, 13, 100, 21);
insert into LIGNES values(4, 12,1450, 33);
insert into LIGNES values(4, 7, 15900, 5);
insert into LIGNES values(4, 3, 14900, 6);
insert into LIGNES values(4, 2, 11900, 4);

insert into LIGNES values(5, 8, 1900, 6);
insert into LIGNES values(5, 1, 1400, 10);
insert into LIGNES values(5, 2, 11900, 5);

insert into LIGNES values(6, 7, 1000, 15);
insert into LIGNES values(6, 1, 1400, 10);
insert into LIGNES values(6, 2, 11900, 5);
insert into LIGNES values(6, 3, 10900, 5);

insert into LIGNES values(7, 4, 1000, 10);
insert into LIGNES values(7, 1, 500, 10);
insert into LIGNES values(7, 3, 11900, 5);

insert into LIGNES values(8, 7, 1300, 6);
insert into LIGNES values(8, 11, 1800, 10);
insert into LIGNES values(8, 12, 1100, 7);
insert into LIGNES values(8, 13, 1700, 7);

insert into LIGNES values(9, 4, 1600, 6);
insert into LIGNES values(9, 10, 1900, 10);
insert into LIGNES values(9, 11, 1400, 7);
insert into LIGNES values(9, 9, 1200, 7);
insert into LIGNES values(9, 8, 1200, 7);

-- validation
commit;