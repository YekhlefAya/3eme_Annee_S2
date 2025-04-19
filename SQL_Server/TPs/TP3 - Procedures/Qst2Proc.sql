-- Create or replace the procedure
CREATE OR ALTER PROCEDURE GetEmployeeTotalOrders
    @EmpID INT,
    @Total DECIMAL(11,2) OUTPUT
AS
BEGIN
    -- Calculate total orders for the given employee
    SELECT @Total = ISNULL(SUM(TOTAL), 0)
    FROM E_COMMANDE
    WHERE EMPLOYE_NO = @EmpID;
END;