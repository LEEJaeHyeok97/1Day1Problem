SELECT SUM(HG.SCORE) AS SCORE, HE.EMP_NO, MAX(HE.EMP_NAME) AS EMP_NAME, MAX(HE.POSITION) AS POSITION, MAX(HE.EMAIL) AS EMAIL
FROM HR_EMPLOYEES HE
LEFT JOIN HR_GRADE HG ON HE.EMP_NO = HG.EMP_NO
WHERE HG.YEAR = '2022'
GROUP BY HE.EMP_NO
ORDER BY SUM(HG.SCORE) DESC
LIMIT 1

