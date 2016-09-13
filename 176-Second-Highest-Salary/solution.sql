# Write your MySQL query statement below
select (select distinct Salary from Employee Order by Salary DESC limit 1 offset 1) as second

select max(Salary) from Employee where Salary < (select max(Salary) from Employee)