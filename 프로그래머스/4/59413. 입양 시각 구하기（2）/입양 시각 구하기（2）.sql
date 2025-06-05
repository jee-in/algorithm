WITH RECURSIVE hours AS (
    SELECT 0 AS hour
    UNION ALL
    SELECT hour + 1 FROM hours WHERE hour < 23
)

select hours.hour, ifnull(ao.count, 0)
from hours
left join
(
select hour(datetime) as hour, count(*) as count
from animal_outs
group by hour(datetime)
) ao
on hours.hour = ao.hour
order by hour;