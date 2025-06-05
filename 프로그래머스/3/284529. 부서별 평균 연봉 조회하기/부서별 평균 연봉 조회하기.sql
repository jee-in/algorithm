select em.dept_id, dept_name_en, avg_sal
from 
(
select dept_id, round(avg(sal)) as avg_sal
from hr_employees
group by dept_id
) em
join
(
select dept_id, dept_name_en
from hr_department
) dept
on em.dept_id = dept.dept_id
order by avg_sal desc;