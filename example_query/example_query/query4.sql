-- GROUP BY
SELECT
    gender as "性別"
    , SUM(CUSTOMER_ID) as "ID数"
FROM CUSTOMER
GROUP BY gender
;

SELECT 
	sales_ymd
    , SUM(amount) as "合計売り上げ"
FROM receipt
GROUP BY sales_ymd
;

SELECT 
	SUBSTRING(sales_ymd, 1, 6) as "年月"
    , SUM(amount) as "合計売り上げ"
FROM receipt
GROUP BY SUBSTRING(sales_ymd, 1, 6)
;

-- ORDER BY
SELECT 
	SUBSTRING(sales_ymd, 1, 6) as "年月"
    , SUM(amount) as "合計売り上げ"
FROM receipt
GROUP BY SUBSTRING(sales_ymd, 1, 6)
ORDER BY SUBSTRING(sales_ymd, 1, 6) desc
;

SELECT 
    store_cd
	, SUBSTRING(sales_ymd, 1, 6) as "年月"
    , SUM(amount) as "合計売り上げ"
FROM receipt
GROUP BY store_cd, SUBSTRING(sales_ymd, 1, 6)
ORDER BY store_cd, SUBSTRING(sales_ymd, 1, 6) desc
;

-- HAVING
SELECT 
    store_cd
	, SUBSTRING(sales_ymd, 1, 6) as "年月"
    , SUM(amount) as "合計売り上げ"
FROM receipt
GROUP BY store_cd, SUBSTRING(sales_ymd, 1, 6)
HAVING SUM(amount) > 10000
ORDER BY store_cd, SUBSTRING(sales_ymd, 1, 6) desc
;

