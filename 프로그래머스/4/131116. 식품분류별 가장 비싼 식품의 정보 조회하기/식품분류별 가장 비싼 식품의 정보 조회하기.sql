with max_price_product_per_category as
(
select *
from food_product
where (category, price) in
    (
        select category, max(price) as max_price
        from food_product
        group by category
    )
)

select category, price as max_price, product_name
from max_price_product_per_category
where category in ('과자', '국', '김치', '식용유')
order by max_price desc;
