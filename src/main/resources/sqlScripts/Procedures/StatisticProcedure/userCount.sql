DELIMITER // 
CREATE PROCEDURE `userCount` () 
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'Countig users on DB'
BEGIN 
    SELECT COUNT(*) as user_count FROM handbook_schema.user_table;
END// 