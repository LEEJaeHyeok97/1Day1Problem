-- 
SELECT f.flavor
FROM FIRST_HALF f
LEFT JOIN (SELECT flavor, SUM(total_order) as total_order FROM JULY GROUP BY flavor) j
ON f.flavor = j.flavor
ORDER BY (f.total_order + j.total_order) DESC
limit 3;