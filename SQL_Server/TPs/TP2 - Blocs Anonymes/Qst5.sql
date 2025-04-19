CREATE PROCEDURE UpdateEmployeeCommission
AS
BEGIN
    -- Update employees with sales <= 200,000 DH (5% commission)
    UPDATE E_EMPLOYE
    SET PCT_COMMISSION = 5
    WHERE NO IN (
        SELECT EMPLOYE_NO
        FROM E_COMMANDE
        GROUP BY EMPLOYE_NO
        HAVING SUM(TOTAL) <= 200000
    );

    -- Update employees with sales > 200,000 DH (10% commission)
    UPDATE E_EMPLOYE
    SET PCT_COMMISSION = 10
    WHERE NO IN (
        SELECT EMPLOYE_NO
        FROM E_COMMANDE
        GROUP BY EMPLOYE_NO
        HAVING SUM(TOTAL) > 200000
    );
END;
