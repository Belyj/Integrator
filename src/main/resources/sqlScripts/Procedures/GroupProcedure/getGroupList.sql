DELIMITER // 
CREATE PROCEDURE `getGroupList` (IN userName VARCHAR(255)) 
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'searching all groups info
		@param user name'
BEGIN 
	SELECT DISTINCT group_name
	FROM handbook_schema.group_table c
	JOIN handbook_schema.link_table l ON c.group_id = l.group_id
	JOIN handbook_schema.user_table u ON u.user_id = l.user_id
	WHERE u.user_name = userName;
END//

drop PROCEDURE getGroupList;
call getGroupList("RU");