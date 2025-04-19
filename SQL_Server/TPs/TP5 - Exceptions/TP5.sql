CREATE OR ALTER PROCEDURE uspAddEmploye(
@num INT,
@nom varchar(50),
@prenom varchar(50),
@dateentree date=NULL
)
AS
BEGIN
	IF @dateentree IS NULL
		SET @dateentree = GETDATE();
	INSERT INTO EMPLOYES (NO, NOM, PRENOM, DT_ENTREE) VALUES (@num, @nom, @prenom,@dateentree);
END;

GO

--select * from EMPLOYES
--EXEC uspAddEmploye 16, WXYZ, ABC;

CREATE OR ALTER FUNCTION uFpGetTotalCom(@no INT)
RETURNS DECIMAL(10, 2)
AS
BEGIN
	DECLARE @total DECIMAL(10,2);
	SELECT @total=SUM(PRIX * QUANTITE) FROM LIGNES WHERE COMMANDE_NO = @no;
	IF @total IS NULL
		SET @total = -1;
	RETURN @total;
END;

GO

SELECT dbo.uFpGetTotalCom(10) Prix_Commande;