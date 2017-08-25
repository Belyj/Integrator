DELIMITER // 
CREATE PROCEDURE `updateGroup` (IN groupID int, newGroupName VARCHAR(255))
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'seek and update group info
		@param group id, new Group Name'
BEGIN 
    UPDATE handbook_schema.group_table 
		SET gname = newGroupName
		WHERE gid = groupID;
	SELECT * FROM handbook_schema.group_table WHERE gid = groupID;
END// 