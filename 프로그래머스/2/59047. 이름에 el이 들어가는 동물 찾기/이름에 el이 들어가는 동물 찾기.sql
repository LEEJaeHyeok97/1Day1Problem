SELECT animal_id, name
FROM ANIMAL_INS
WHERE LOWER(name) like '%el%' AND animal_type = 'Dog'
ORDER BY name, animal_id