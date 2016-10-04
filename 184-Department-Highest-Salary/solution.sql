# Write your MySQL query statement below


select Department.name as Department, NEW.Name as Employee, NEW.Salary
from Department, (select Employee.DepartmentId as NEWID, Employee.Name as Name, max(Employee.Salary) as Salary from Employee group by Employee.DepartmentId) New
where Department.Id = NEW.NEWID;

