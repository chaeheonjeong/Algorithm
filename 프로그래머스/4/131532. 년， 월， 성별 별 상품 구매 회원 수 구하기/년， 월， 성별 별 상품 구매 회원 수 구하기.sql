SELECT YEAR(o.SALES_DATE) AS YEAR, MONTH(o.SALES_DATE) AS MONTH, 
        u.GENDER, COUNT(DISTINCT o.USER_ID) AS USERS
FROM USER_INFO u
JOIN ONLINE_SALE o
ON u.USER_ID = o.USER_ID
WHERE u.GENDER IS NOT NULL
GROUP BY YEAR, MONTH, GENDER
ORDER BY YEAR, MONTH, GENDER;