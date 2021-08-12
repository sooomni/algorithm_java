select Name as Employee
from Employee
inner join (select id,salary from Employee) tmp
 on tmp.id = Employee.ManagerId
where tmp.salary < Employee.salary