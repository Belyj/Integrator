DELIMITER // 
CREATE PROCEDURE `getGroupList` (userName VARCHAR(256)) 
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'searching all groups info'
BEGIN 
    SELECT contact_name, group_name
	FROM handbook_schema.contact_table c
	JOIN handbook_schema.link_table l ON c.contact_id = l.contact_id
	JOIN handbook_schema.group_table g ON g.group_id = l.group_id
	JOIN handbook_schema.user_table u ON u.user_id = l.user_id
	WHERE u.user_name = userName;
END//