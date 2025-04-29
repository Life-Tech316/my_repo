-- 副問合せ
-- amountの平均を計算
SELECT 
	AVG(amount)
FROM receipt; 

-- 平均価格以上の商品の購買データを抽出
SELECT 
    * 
FROM receipt
WHERE amount > (
    SELECT 
        AVG(amount)
    FROM receipt
)
;

