DELIMITER // 
CREATE PROCEDURE `removeGroupByID` (IN groupID int) 
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'seek and remove group
		@param group id'
BEGIN 
    DELETE FROM handbook_schema.group_table WHERE gid = groupID; 
END// 