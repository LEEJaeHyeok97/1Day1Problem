-- 입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물의 id, 이름을 id순으로 조회
SELECT o.animal_id, o.name
FROM (
SELECT o1.animal_id, o1.name
FROM animal_outs o1
LEFT JOIN animal_ins i1
ON o1.animal_id = i1.animal_id
) o
LEFT JOIN animal_ins i
ON o.animal_id = i.animal_id
WHERE i.intake_condition IS NULL
ORDER BY o.animal_id ASC