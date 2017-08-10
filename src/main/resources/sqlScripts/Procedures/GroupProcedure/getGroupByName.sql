DELIMITER // 
CREATE PROCEDURE `getGroupByName` (IN groupName varchar(256)) 
LANGUAGE SQL 
DETERMINISTIC 
COMMENT '	searching groupName info
			@param groupName name'
BEGIN 
    SELECT * FROM handbook_schema.group_table WHERE group_name = groupName; 
END// 
