DELIMITER // 
CREATE PROCEDURE `getGroupList` (IN userName VARCHAR(255)) 
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'searching all groups info
		@param user name'
BEGIN 
	SELECT DISTINCT group_id, gname
	FROM handbook_schema.group_table g
	JOIN handbook_schema.link_table l ON g.gid = l.group_id
	JOIN handbook_schema.user_table u ON u.uid = l.user_id
	WHERE u.uname = userName;
END//