WITH temp AS(
    SELECT CART_ID, NAME
    FROM CART_PRODUCTS
    WHERE NAME IN ('Yogurt', 'Milk')
)

SELECT CART_ID
FROM temp
GROUP BY CART_ID
HAVING COUNT(DISTINCT(NAME)) = 2;