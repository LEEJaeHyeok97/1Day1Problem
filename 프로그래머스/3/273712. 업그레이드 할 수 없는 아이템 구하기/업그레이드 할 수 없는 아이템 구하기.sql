-- 더 이상 업그레이드할 수 없는 아이템..
-- A -> B
-- A -> C
-- B -> D
-- B -> E
-- 나 자신을 PARENT로 갖는 아이템이 없는 것들
SELECT info.item_id, info.item_name, info.rarity
FROM ITEM_INFO info
LEFT JOIN ITEM_TREE tree
ON info.item_id = tree.parent_item_id
WHERE tree.item_id is null
ORDER BY info.item_id DESC