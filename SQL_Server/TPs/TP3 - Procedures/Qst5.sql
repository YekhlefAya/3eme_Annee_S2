DECLARE @EmpID INT;
DECLARE @Total DECIMAL(11,2);

DECLARE employee_cursor CURSOR FOR
SELECT NO FROM E_EMPLOYE

OPEN employee_cursor;

FETCH NEXT FROM employee_cursor INTO @EmpID;

WHILE @@FETCH_STATUS = 0
BEGIN
	-- Execute the procedure
	EXEC GetEmployeeTotalOrders @EmpID, @Total OUTPUT;

	-- Display the result
	PRINT 'Employé ' + CAST(@EmpID AS NVARCHAR) + ': Total Commandes = ' + CAST(@Total AS NVARCHAR);

	FETCH NEXT FROM employee_cursor INTO @EmpID;
END;

CLOSE employee_cursor;
DEALLOCATE employee_cursor;