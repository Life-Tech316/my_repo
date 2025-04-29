-- 集計
SELECT 
    COUNT(*) 
FROM customer;

SELECT 
    COUNT(customer_id) 
FROM customer;

SELECT 
    MIN(age) as "最低年齢"
FROM customer;

SELECT 
    MAX(age) as "最高年齢"
FROM customer;

SELECT 
    AVG(age) as "平均年齢"
FROM customer;


