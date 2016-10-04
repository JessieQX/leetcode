# Write your MySQL query statement below
select Department.Name as Department, Employee.Name as Employee, Employee.Salary 
from Department, Employee, (select Employee.DepartmentId, max(Employee.Salary) as max from Employee group by Employee.DepartmentId) New
where Employee.DepartmentId = Department.Id
AND New.max = Employee.Salary
and New.DepartmentId = Department.Id;

select Department.name as Department, NEW.Name as Employee, NEW.Salary as Salary
from Department, (select Employee.DepartmentId as NEWID, Employee.Name as Name, max(Employee.Salary) as Salary from Employee group by Employee.DepartmentId) NEW
where Department.Id = NEW.NEWID;

select New.name as Department, New.Name as Employee, max(New.Salary) as Salary
from (select Employee.Id, Employee.Name as Name, Employee.Salary as Salary, Department.Name from Employee, Department
    where Employee.DepartmentId = Department.Id) New
group by New.Salary;