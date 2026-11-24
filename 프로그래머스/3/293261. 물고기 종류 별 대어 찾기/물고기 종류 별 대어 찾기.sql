SELECT f1.id, n.fish_name, f1.length
FROM fish_info f1
LEFT JOIN fish_name_info n
ON f1.fish_type = n.fish_type
JOIN (SELECT MAX(length) length, fish_type
FROM fish_info
GROUP BY fish_type) f2
ON f1.LENGTH = f2.LENGTH AND f1.FISH_TYPE = f2.FISH_TYPE
ORDER BY f1.id ASC
# HAVING MAX(length)
# select * from fish_info i left join fish_name_info n
# on i.fish_type = n.fish_type

-- bass -> 60, snapper 73, anchovy 73, 