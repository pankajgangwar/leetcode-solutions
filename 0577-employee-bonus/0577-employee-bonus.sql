# Write your MySQL query statement below
SELECT emp.name, b.bonus FROM Employee AS emp
LEFT JOIN Bonus AS b
ON emp.empId = b.empId
WHERE b.bonus < 1000 OR b.bonus IS NULL