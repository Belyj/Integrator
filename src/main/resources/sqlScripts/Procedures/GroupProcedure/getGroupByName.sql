DELIMITER // 
CREATE PROCEDURE `getGroupByName` (IN groupName varchar(255), userName VARCHAR(256)) 
LANGUAGE SQL 
DETERMINISTIC 
COMMENT '	searching groupName info
			@param group name, user name'
BEGIN 
    SELECT contact_name, group_name
	FROM handbook_schema.contact_table c
	JOIN handbook_schema.link_table l ON c.contact_id = l.contact_id
	JOIN handbook_schema.group_table g ON g.group_id = l.group_id
	JOIN handbook_schema.user_table u ON u.user_id = l.user_id
	WHERE g.group_name LIKE groupName AND u.user_name = userName;
END// 

