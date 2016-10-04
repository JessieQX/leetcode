# Write your MySQL query statement below
select Department.Name as Department, Employee.Name as Employee, Employee.Salary 
from Department, Employee, (select Employee.DepartmentId, max(Employee.Salary) as max from Employee group by Employee.DepartmentId) New
where Employee.DepartmentId = Department.Id
AND New.max = Employee.Salary
and New.DepartmentId = Department.Id;