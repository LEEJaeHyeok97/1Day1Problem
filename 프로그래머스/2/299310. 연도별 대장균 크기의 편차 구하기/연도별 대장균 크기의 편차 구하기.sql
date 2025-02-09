SELECT YEAR(ED.DIFFERENTIATION_DATE) AS YEAR, K.SOC - ED.SIZE_OF_COLONY AS YEAR_DEV , ED.ID AS ID
FROM ECOLI_DATA ED
LEFT JOIN (SELECT MAX(ED2.SIZE_OF_COLONY) AS SOC, YEAR(DIFFERENTIATION_DATE) AS YD FROM ECOLI_DATA AS ED2
          GROUP BY YEAR(ED2.DIFFERENTIATION_DATE)
          ) AS K
          ON YEAR(ED.DIFFERENTIATION_DATE) = K.YD
ORDER BY YEAR(ED.DIFFERENTIATION_DATE) ASC, YEAR_DEV ASC