select count(*) as fish_count, max(len) as max_length, fish_type
from (select id, fish_type, 
    CASE
        WHEN length is null THEN 10
        ELSE length
    END AS len
from fish_info) info
group by fish_type
having max_length >= 33
order by fish_type;