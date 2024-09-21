SELECT i.ANIMAL_ID, i.NAME
FROM ANIMAL_INS  i
JOIN ANIMAL_OUTS o
ON i.ANIMAL_ID = o.ANIMAL_ID
ORDER BY DATEDIFF(o.DATETIME, i.DATETIME) DESC
limit 2;