DELIMITER // 
CREATE PROCEDURE `createGroup` (IN groupName varchar(255)) 
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'create group
		@param group name'
BEGIN 
	INSERT INTO `handbook_schema`.`group_table` (`group_name`) VALUES (groupName);
    SELECT * FROM handbook_schema.group_table WHERE group_name = groupName; 
END// 