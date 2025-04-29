-- 表示（アスタリスク、LIMIT表示）
SELECT * FROM receipt LIMIT 30;

SELECT
	customer_id
	, age
	, customer_name
	, gender
	, age 
FROM customer 
LIMIT 30

-- 列の選択
SELECT 
	customer_id as "ID"
    , customer_name as "名前"
FROM customer;

SELECT 
	c.customer_id as "ID"
    , c.customer_name as "名前"
FROM customer c;

-- WHERE
SELECT 
    * 
FROM customer
WHERE gender_cd = '0';

SELECT 
    * 
FROM customer
WHERE age < 30;

SELECT 
    * 
FROM customer
WHERE age >= 10;

SELECT 
    * 
FROM customer
WHERE age >= 10 AND age <= 20;

SELECT 
    * 
FROM customer
WHERE age <= 20 OR age >= 80;



