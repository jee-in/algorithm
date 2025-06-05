WITH g as (
    select emp_no, 
        case 
            when avg(score) >= 96 then 'S'
            when avg(score) >= 90 then 'A'
            when avg(score) >= 80 then 'B'
            else 'C'
    end as grade
    from hr_grade
    group by emp_no
)

select e.emp_no, emp_name, grade, (
    case
        when grade = 'S' then sal * 0.2
        when grade = 'A' then sal * 0.15
        when grade = 'B' then sal * 0.1
        else 0
    end) as bonus
from HR_EMPLOYEES e
join g
on e.emp_no = g.emp_no
order by e.emp_no;