WITH VAR AS
(
SELECT COUNT(*), HOST_ID
FROM PLACES
GROUP BY HOST_ID HAVING COUNT(*) >= 2
)

SELECT P.ID, P.NAME, P.HOST_ID
FROM PLACES P
JOIN VAR V ON P.HOST_ID = V.HOST_ID
ORDER BY ID ASC