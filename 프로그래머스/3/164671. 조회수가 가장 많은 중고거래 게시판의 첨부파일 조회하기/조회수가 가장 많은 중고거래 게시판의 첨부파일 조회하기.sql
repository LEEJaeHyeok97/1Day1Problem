-- 코드를 입력하세요
-- 조회수가 가장 높은 중고거래 게시물에 대한 첨부파일 경로를 조회
SELECT CONCAT("/home/grep/src/", b.board_id, "/", f.file_id, f.file_name, f.file_ext) AS FILE_PATH
FROM USED_GOODS_BOARD b LEFT JOIN USED_GOODS_FILE f
ON b.board_id = f.board_id
WHERE b.views = (SELECT MAX(views) FROM USED_GOODS_BOARD)
ORDER BY f.file_id DESC