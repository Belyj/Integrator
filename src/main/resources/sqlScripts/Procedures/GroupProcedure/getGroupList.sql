DELIMITER // 
CREATE PROCEDURE `getGroupList` () 
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'searching all groups info'
BEGIN 
    SELECT * FROM handbook_schema.group_table; 
END//