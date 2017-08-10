DELIMITER // 
CREATE PROCEDURE `updateGroup` (IN groupName VARCHAR(256), newGroupName VARCHAR(256))
LANGUAGE SQL 
DETERMINISTIC 
COMMENT '	seek and update group info
			@param group name, newGroupName'
BEGIN 
    UPDATE handbook_schema.group_table 
		SET group_name = newGroupName
		WHERE group_name = groupName;
END// 