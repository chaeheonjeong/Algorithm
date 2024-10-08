WITH TEMP AS(
    SELECT b.AUTHOR_ID, b.CATEGORY, SUM(s.SALES * b.PRICE) AS TOTAL
    FROM BOOK b
    JOIN BOOK_SALES s
    ON b.BOOK_ID = s.BOOK_ID
    WHERE s.SALES_DATE LIKE '2022-01-%'
    GROUP BY b.AUTHOR_ID, b.CATEGORY
)

SELECT t.AUTHOR_ID, a.AUTHOR_NAME, t.CATEGORY, t.TOTAL AS TOTAL_SALES
FROM TEMP t
JOIN AUTHOR a
ON t.AUTHOR_ID = a.AUTHOR_ID
ORDER BY t.AUTHOR_ID, t.CATEGORY DESC;