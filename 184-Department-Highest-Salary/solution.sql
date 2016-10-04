# Write your MySQL query statement below


select New.Name as Department, New.Name as Employee, max(New.Salary) as Salary
from (select Employee.Id, Employee.Name as Name, Employee.Salary as Salary, Department.Name as Name from Employee, Department
    where Employee.DepartmentId = Department.Id) New
group by New.Salary;