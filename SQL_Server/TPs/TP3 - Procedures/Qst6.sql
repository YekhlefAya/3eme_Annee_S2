DECLARE @EmpID INT, @Total DECIMAL(11,2);

DECLARE emp_cursor CURSOR FOR
SELECT NO FROM E_EMPLOYE;

OPEN emp_cursor;
FETCH NEXT FROM emp_cursor INTO @EmpID;

WHILE @@FETCH_STATUS = 0
BEGIN
    -- Call the for procedure each employee
    EXEC GetEmployeeTotalOrders @EmpID, @Total OUTPUT;

    -- Display the result
    PRINT 'Employé ' + CAST(@EmpID AS NVARCHAR) + ': Total Commandes = ' + CAST(@Total AS NVARCHAR);

    FETCH NEXT FROM emp_cursor INTO @EmpID;
END;

CLOSE emp_cursor;
DEALLOCATE emp_cursor;
