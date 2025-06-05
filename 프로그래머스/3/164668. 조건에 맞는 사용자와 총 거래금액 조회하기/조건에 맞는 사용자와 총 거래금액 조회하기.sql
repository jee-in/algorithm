select user_id, nickname, total_sales
from USED_GOODS_USER goods
join (
select writer_id, sum(price) as total_sales
from used_goods_board
where status = 'done'
group by writer_id
having sum(price) >= 700000
order by total_sales
) board
on goods.user_id = board.writer_id