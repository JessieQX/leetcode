# Write your MySQL query statement below
select distinct Email from Person  where count(Email) > 1
group by Email;
