DELIMITER // 
CREATE PROCEDURE `groupContactsCount`(IN groupName VARCHAR(255), userName VARCHAR(255))
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'Counting contacts in group'
BEGIN 
    SELECT COUNT(DISTINCT contact_id) as count, user_id FROM handbook_schema.link_table 
		WHERE group_id = 
		(SELECT gid FROM handbook_schema.group_table WHERE gname = groupName)
		AND user_id = 
		(SELECT uid FROM handbook_schema.user_table WHERE uname = userName);
END// 

SELECT COUNT(DISTINCT contact_id) as count, user_id FROM handbook_schema.link_table 
		WHERE group_id = 
		(SELECT gid FROM handbook_schema.group_table WHERE gname = "G")
		AND user_id = 
		(SELECT uid FROM handbook_schema.user_table WHERE uname = "RU");