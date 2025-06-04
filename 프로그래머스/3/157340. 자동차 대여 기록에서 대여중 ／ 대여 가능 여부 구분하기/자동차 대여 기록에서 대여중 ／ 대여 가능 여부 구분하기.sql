SELECT car_id, 
    CASE
        WHEN sum(cnt) = 0 THEN '대여 가능'
        ELSE '대여중'
    END AS AVAILABILITY
FROM (SELECT car_id, 
    CASE 
        WHEN DATE('2022-10-16') >= START_DATE  AND DATE('2022-10-16') <= END_DATE THEN 1
        ELSE 0
    END AS cnt
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
) renting
GROUP BY car_id
ORDER BY car_id desc;