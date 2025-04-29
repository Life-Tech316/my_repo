-- case句による年代作成
SELECT
    customer_name
    , gender
    , birth_day
    , age
    , CASE
        WHEN age < 20 THEN 'under20'
        WHEN age >= 20 AND age < 30 THEN '20-30'
        WHEN age >= 30 AND age < 40 THEN '30-40'
        WHEN age >= 40 AND age < 50 THEN '40-50'
        WHEN age >= 50 AND age < 60 THEN '50-60'
        WHEN age >60 THEN 'over60'
        ELSE NULL
    END AS "年代"
FROM customer
;

-- 年代の数を調べる（caseをさらにgroup byに入れる）
SELECT
    CASE
        WHEN age < 20 THEN 'under20'
        WHEN age >= 20 AND age < 30 THEN '20-30'
        WHEN age >= 30 AND age < 40 THEN '30-40'
        WHEN age >= 40 AND age < 50 THEN '40-50'
        WHEN age >= 50 AND age < 60 THEN '50-60'
        WHEN age >= 60 THEN 'over60'
        ELSE NULL
    END AS "年代"
    , COUNT(*) as "カウント"
FROM customer
GROUP BY   
        CASE
            WHEN age < 20 THEN 'under20'
            WHEN age >= 20 AND age < 30 THEN '20-30'
            WHEN age >= 30 AND age < 40 THEN '30-40'
            WHEN age >= 40 AND age < 50 THEN '40-50'
            WHEN age >= 50 AND age < 60 THEN '50-60'
            WHEN age >= 60 THEN 'over60'
            ELSE NULL
        END
;

