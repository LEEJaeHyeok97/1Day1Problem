SELECT 
CASE 
WHEN 01 <= MONTH(ED.DIFFERENTIATION_DATE) AND MONTH(ED.DIFFERENTIATION_DATE) <= 03 THEN '1Q'
WHEN 04 <= MONTH(ED.DIFFERENTIATION_DATE) AND MONTH(ED.DIFFERENTIATION_DATE) <= 06 THEN '2Q'
WHEN 07 <= MONTH(ED.DIFFERENTIATION_DATE) AND MONTH(ED.DIFFERENTIATION_DATE) <= 09 THEN '3Q'
WHEN 10 <= MONTH(ED.DIFFERENTIATION_DATE) AND MONTH(ED.DIFFERENTIATION_DATE) <= 12 THEN '4Q'
END AS QUARTER,
COUNT(*) AS ECOLI_COUNT
FROM ECOLI_DATA ED
GROUP BY QUARTER
ORDER BY QUARTER ASC