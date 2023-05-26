select * from employees;

select department_name,location_id,first_name,last_name
from  departments
inner join employees on departments.manager_id=employees.manager_id;