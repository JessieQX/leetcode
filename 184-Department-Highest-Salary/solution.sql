# Write your MySQL query statement below


select Department.name as Department, NEW.Name as Employee, NEW.Salary
from Department, (select Employee.DepartmentId as NEWID, max(Employee.Salary) as max from Employee group by Employee.DepartmentId) New
where Department.Id = NEW.NEWID;

