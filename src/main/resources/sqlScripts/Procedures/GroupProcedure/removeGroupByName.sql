DELIMITER // 
CREATE PROCEDURE `removeGroupByName` (IN groupName varchar(256)) 
LANGUAGE SQL 
DETERMINISTIC 
COMMENT '	seek and remove group
			@param group name'
BEGIN 
    DELETE FROM handbook_schema.group_table WHERE group_name = groupName; 
END// 