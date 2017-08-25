DELIMITER // 
CREATE PROCEDURE `getGroupByID` (IN goupID INT, userName VARCHAR(255)) 
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'searching contact info
		@param contact name, user name'
BEGIN 
    SELECT distinct gid, gname
	FROM handbook_schema.group_table g
	JOIN handbook_schema.link_table l ON g.gid = l.group_id
	JOIN handbook_schema.user_table u ON u.uid = l.user_id
	WHERE g.gid LIKE goupID AND u.uname = userName;
END//