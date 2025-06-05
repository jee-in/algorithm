select gb.author_id, a.author_name, gb.category, gb.total_sales
from
(
select b.author_id, b.category, sum(b.price * bs.sales) as total_sales
from book b
join book_sales bs on b.book_id = bs.book_id
where date_format(bs.sales_date, '%Y-%m') = '2022-01'
group by b.author_id, b.category
) gb
join author a on gb.author_id = a.author_id
order by gb.author_id, gb.category desc;
