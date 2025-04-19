CREATE OR ALTER FUNCTION dbo.Calculer_Prix_TTC_Categorie
(
    @prix_vente DECIMAL(10,2),
    @description VARCHAR(200)
)
RETURNS DECIMAL(10,2)
AS
BEGIN
    DECLARE @tva DECIMAL(5,2);

    -- Déterminer la TVA en fonction de la description du produit
    IF @description LIKE '%Onduleur%'
        SET @tva = 10;
    ELSE IF @description LIKE '%Hub%' OR 
            @description LIKE '%Retour%' OR 
            @description LIKE '%Switch%' OR 
            @description LIKE '%Carte réseau%'
        SET @tva = 5;
    ELSE IF @description LIKE '%PC P4%' OR 
            @description LIKE '%Macintosh%' OR 
            @description LIKE '%Station Sun%' OR 
            @description LIKE '%Station HP%'
        SET @tva = 30;
    ELSE
        SET @tva = 20;  -- Valeur par défaut si aucune catégorie ne correspond

    -- Calcul du prix TTC
    RETURN dbo.Calculer_Prix_TTC(@prix_vente, @tva);
END;
