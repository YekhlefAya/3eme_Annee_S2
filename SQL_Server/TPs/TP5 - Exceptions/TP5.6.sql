USE GestComs;
GO

CREATE OR ALTER FUNCTION uFpGetTotalComs(@CommandeNo INT)
RETURNS DECIMAL(11, 2)
AS
BEGIN
	DECLARE @Total DECIMAL(11, 2);
	SELECT @Total = SUM(PRIX * QUANTITE)
	FROM LIGNES
	WHERE COMMANDE_NO = @CommandeNo;

	IF @Total IS NULL
		SET @Total = -1;
	RETURN @Total;
END;

GO

SELECT dbo.uFpGetTotalComs(10);

--SELECT * FROM LIGNES;