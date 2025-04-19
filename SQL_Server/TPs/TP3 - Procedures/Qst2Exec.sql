DECLARE @EmpID INT = 1;
DECLARE @Total DECIMAL(11,2);

-- Execute the procedure
EXEC GetEmployeeTotalOrders @EmpID, @Total OUTPUT;

-- Display the result
PRINT 'Employé ' + CAST(@EmpID AS NVARCHAR) + ': Total Commandes = ' + CAST(@Total AS NVARCHAR);
