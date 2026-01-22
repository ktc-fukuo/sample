SELECT
      a.`SAIKI_ID`
    , a.`SAIKI_MEI`
    , a.`REF_ID`
    , (SELECT r0.`REF_MEI` FROM MB4_ID r0 WHERE r0.`REF_ID` = a.`REF_ID`) AS `REF_MEI`
    , TRIM(TRAILING ' ' FROM a.`REF_CD`) AS `REF_CD`
    , (SELECT r1.`REF_MEI` FROM MB4_CD r1 WHERE r1.`REF_CD` = a.`REF_CD`) AS `REF_MEI`
    , TRIM(TRAILING ' ' FROM a.`REF_NO`) AS `REF_NO`
    , (SELECT r2.`REF_MEI` FROM MB4_NO r2 WHERE r2.`REF_NO` = a.`REF_NO`) AS `REF_MEI`
    , a.`REF_BN`
    , a.`EX_REF_ID`
    , (SELECT r3.`REF_MEI` FROM MB4_ID r3 WHERE r3.`REF_ID` = a.`EX_REF_ID`) AS `EX_REF_MEI`
    , a.`EX_REF_BN`
    , a.`OYA_SAIKI_ID`
    , (SELECT r4.`SAIKI_MEI` FROM TB4_SAIKI r4 WHERE r4.`SAIKI_ID` = a.`OYA_SAIKI_ID`) AS `OYA_SAIKI_MEI`
    , a.`INSERT_TS` AS `INSERT_TS`
    , a.`INSERT_USER_ID`
    , (SELECT r5.`USER_SEI` FROM MHR_USER r5 WHERE r5.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`
    , a.`UPDATE_TS` AS `UPDATE_TS`
    , a.`UPDATE_USER_ID`
    , (SELECT r6.`USER_SEI` FROM MHR_USER r6 WHERE r6.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`
FROM
    TB4_SAIKI a 
WHERE
    1 = 1 
    AND a.`SAIKI_ID` = :saiki_id 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`SAIKI_MEI`)) LIKE UPPER (CONCAT ('%', :saiki_mei, '%')) 
    AND a.`REF_ID` = :ref_id 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`REF_CD`)) LIKE UPPER (CONCAT ('%', :ref_cd, '%')) 
    AND UPPER (TRIM(TRAILING ' ' FROM a.`REF_NO`)) LIKE UPPER (CONCAT ('%', :ref_no, '%')) 
    AND a.`REF_BN` = :ref_bn 
    AND a.`EX_REF_ID` = :ex_ref_id 
    AND a.`EX_REF_BN` = :ex_ref_bn 
    AND a.`OYA_SAIKI_ID` = :oya_saiki_id 
    AND a.`INSERT_TS` = :insert_ts 
    AND a.`INSERT_TS` >= :insert_ts_1 
    AND a.`INSERT_TS` <= :insert_ts_2 
    AND a.`INSERT_USER_ID` = :insert_user_id 
    AND a.`UPDATE_TS` = :update_ts 
    AND a.`UPDATE_TS` >= :update_ts_1 
    AND a.`UPDATE_TS` <= :update_ts_2 
    AND a.`UPDATE_USER_ID` = :update_user_id 
ORDER BY
    a.`SAIKI_ID`
