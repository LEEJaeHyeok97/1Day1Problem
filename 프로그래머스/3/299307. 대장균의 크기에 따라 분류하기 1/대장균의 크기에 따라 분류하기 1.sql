-- 대장균 개체의 크기가 100 이하 -> LOW
-- 100 초과 1000 이하 -> MEDIUM
-- 1000초과 -> HIGH
SELECT e.id, 
CASE
WHEN e.size_of_colony <= 100 THEN 'LOW'
WHEN e.size_of_colony > 100 AND e.size_of_colony <= 1000 THEN 'MEDIUM'
ELSE 'HIGH'
END
FROM ECOLI_DATA e
ORDER BY e.id ASC