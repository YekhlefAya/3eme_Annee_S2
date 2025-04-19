DECLARE @TotalOrders DECIMAL(11,2);

SELECT @TotalOrders = SUM(TOTAL) 
FROM E_COMMANDE 
WHERE EMPLOYE_NO = 1;

PRINT 'Total des commandes gérées par l’employé 1: ' + CAST(ISNULL(@TotalOrders, 0) AS NVARCHAR);
