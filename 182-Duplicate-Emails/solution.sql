# Write your MySQL query statement below
select distinct Email from Person group by Email where count(Email) > 1;
