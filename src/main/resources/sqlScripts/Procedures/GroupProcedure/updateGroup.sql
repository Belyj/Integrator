DELIMITER // 
CREATE PROCEDURE `updateGroup` (IN groupID int, newGroupName VARCHAR(255))
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'seek and update group info
		@param group id, new Group Name'
BEGIN 
    UPDATE handbook_schema.group_table 
		SET group_name = newGroupName
		WHERE group_id = groupID;
END// 