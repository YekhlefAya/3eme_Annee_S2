CREATE OR ALTER FUNCTION dbo.Calculer_Prix_TTC
(
    @prix_vente DECIMAL(10,2),
    @tva DECIMAL(5,2)
)
RETURNS DECIMAL(10,2)
AS
BEGIN
    -- Calcul du prix TTC : Prix HT + (Prix HT * TVA)
    RETURN @prix_vente * (1 + @tva / 100);
END;
GO

SELECT dbo.Calculer_Prix_TTC(100, 20) AS Prix_TTC;
