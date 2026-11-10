SELECT os1.user_id, os1.product_id
FROM online_sale os1
LEFT JOIN online_sale os2
ON os1.user_id = os2.user_id and os1.product_id = os2.product_id
GROUP BY os1.user_id, os1.product_id
HAVING COUNT(os1.user_id) >= 2
ORDER BY os1.user_id ASC, os1.product_id DESC;