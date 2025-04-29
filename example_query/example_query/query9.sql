
-- スコアカード
select 
    *
from customer
;

select 
    *
from receipt
;

-- 折れ線グラフ（日毎の売上）
with tbl1 as(
    select
        sales_ymd
        , sum(amount) as "合計売上"
    from receipt
    group by sales_ymd
    order by sales_ymd
)
select
    to_date(cast(sales_ymd as varchar), 'YYYYMMDD')
    -- , to_date(to_varchar(sales_ymd), 'YYYYMMDD')
    , "合計売上"
    , sum("合計売上") over (order by sales_ymd rows between unbounded preceding and current row ) as "累積売上"
from tbl1
;

-- 棒グラフ（月別の売上）
上の事例を使う


-- 散布図（年齢と売上）
select
    r.customer_id
    , sum(amount) as sum_amount
    , min(c.age) as age
from receipt r
left join customer c
    on r.customer_id = c.customer_id
where r.customer_id != 'ZZ000000000000'
group by r.customer_id
;

-- ヒートグリッド（年代×性別の合計売上とか店舗×性別の合計売上とか）
select
    *
    , case
        when c.age < 20 then 'under20'
        when c.age >= 20 and c.age < 30 then '20代'
        when c.age >= 30 and c.age < 40 then '30代'
        when c.age >= 40 and c.age < 50 then '40代'
        when c.age >= 50 and c.age < 60 then '50代'
        when c.age >= 60 then 'over60'
        else null
    end as "年代"
from receipt r
left join customer c
    on r.customer_id = c.customer_id
where r.customer_id != 'ZZ000000000000'
;

