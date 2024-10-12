SELECT F2.CATEGORY, MAX_PRICE, PRODUCT_NAME
FROM FOOD_PRODUCT F1 JOIN (
    SELECT CATEGORY, MAX(PRICE) AS MAX_PRICE
    FROM FOOD_PRODUCT
    GROUP BY CATEGORY) AS F2
ON F1.CATEGORY = F2.CATEGORY
WHERE F1.PRICE = MAX_PRICE 
AND F2.CATEGORY IN('과자', '국', '김치', '식용유')
ORDER BY MAX_PRICE DESC;