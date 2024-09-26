WITH raw AS (
    SELECT c.CAR_ID, c.DAILY_FEE, h.HISTORY_ID, c.CAR_TYPE,
            DATEDIFF(END_DATE, START_DATE)+1 AS PERIOD,
            CASE 
            WHEN DATEDIFF(end_date, start_date) + 1 >= 90 THEN '90일 이상'
            WHEN DATEDIFF(end_date, start_date) + 1 >= 30 THEN '30일 이상'
            WHEN DATEDIFF(end_date, start_date) + 1 >= 7 THEN '7일 이상'
            ELSE 'NONE' 
            END AS DU_TYPE
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY h
    JOIN CAR_RENTAL_COMPANY_CAR c
    ON h.CAR_ID = c.CAR_ID
    WHERE CAR_TYPE = '트럭'
)

SELECT raw.HISTORY_ID,
        ROUND(raw.DAILY_FEE * raw.PERIOD * 
          (1.0 - IFNULL(p.DISCOUNT_RATE, 0.0) * 0.01)) AS FEE
FROM raw
LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS p
ON raw.DU_TYPE = p.DURATION_TYPE
AND p.CAR_TYPE = raw.CAR_TYPE
ORDER BY 2 DESC, 1 DESC;