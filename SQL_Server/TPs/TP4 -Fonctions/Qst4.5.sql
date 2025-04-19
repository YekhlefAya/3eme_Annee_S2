CREATE OR ALTER FUNCTION Obtenir_Prix_TTC_Produits()
RETURNS TABLE
AS
RETURN
(
    SELECT *, dbo.Calculer_Prix_TTC_Categorie(PRIX_CONSEILLE, NOM) Prix_TTC
    FROM PRODUITS
);
GO

SELECT * from dbo.Obtenir_Prix_TTC_Produits();