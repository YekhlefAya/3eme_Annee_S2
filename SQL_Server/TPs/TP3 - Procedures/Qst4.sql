-- Create or replace the procedure
CREATE OR ALTER PROCEDURE GetEmployeeTotalOrders
    @EmpID INT,
    @Total DECIMAL(11,2) OUTPUT
AS
BEGIN
    -- Calculate total orders for the given employee
    SELECT @Total = SUM(TOTAL)
    FROM E_COMMANDE
    WHERE EMPLOYE_NO = @EmpID;
	-- Question 4
	IF @Total IS NULL
		SET @Total = 0
	-- Fin Question 4
END;
GO

DECLARE @EmpID INT = 1;
DECLARE @Total DECIMAL(11,2);

-- Execute the procedure
EXEC GetEmployeeTotalOrders @EmpID, @Total OUTPUT;

-- Display the result
PRINT 'Employé ' + CAST(@EmpID AS NVARCHAR) + ': Total Commandes = ' + CAST(@Total AS NVARCHAR);