-- 結合
-- left join

select 
    c.gender
    , sum(r.amount) as "合計売上"
from receipt r
left join customer c
    on r.customer_id = c.customer_id
group by c.gender
;


