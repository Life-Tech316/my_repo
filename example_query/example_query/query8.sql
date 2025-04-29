-- WITH句、WINDOW関数

-- 日毎の累計売り上げ１（最初からの累計）
WITH tbl1 AS(
    SELECT 
        sales_ymd
        , SUBSTRING(sales_ymd, 1, 6) as yyyymm
        , SUM(amount) as sum_amount
    FROM receipt
    GROUP BY sales_ymd
    ORDER BY sales_ymd asc
)
SELECT
    sales_ymd
    , yyyymm
    , sum_amount as amount_per_day
    , SUM(sum_amount) over (order by sales_ymd rows between UNBOUNDED PRECEDING AND CURRENT ROW) as cumsum_amount
FROM tbl1
;


-- 日毎の累計売り上げ2（月ごとに累計）
WITH tbl1 AS(
    SELECT 
        sales_ymd
        , SUBSTRING(sales_ymd, 1, 6) as yyyymm
        , SUM(amount) as sum_amount
    FROM receipt
    GROUP BY sales_ymd
    ORDER BY sales_ymd asc
)
SELECT
    sales_ymd
    , yyyymm
    , sum_amount as amount_per_day
    , SUM(sum_amount) over (partition by yyyymm order by sales_ymd rows between UNBOUNDED PRECEDING AND CURRENT ROW) as cumsum_amount
FROM tbl1
;


