SELECT i.ANIMAL_ID, o.NAME
FROM ANIMAL_INS i
JOIN ANIMAL_OUTS o
ON i.ANIMAL_ID = o.ANIMAL_ID
WHERE i.DATETIME > o.DATETIME
ORDER BY i.DATETIME;