SELECT m.MEMBER_NAME, r.REVIEW_TEXT, DATE_FORMAT(r.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM REST_REVIEW r
JOIN MEMBER_PROFILE m
ON r.MEMBER_ID = m.MEMBER_ID
WHERE r.MEMBER_ID = (
    SELECT MEMBER_ID
    FROM REST_REVIEW
    GROUP BY MEMBER_ID
    ORDER BY COUNT(MEMBER_ID) DESC
    LIMIT 1
)
ORDER BY r.REVIEW_DATE ASC, r.REVIEW_TEXT ASC;