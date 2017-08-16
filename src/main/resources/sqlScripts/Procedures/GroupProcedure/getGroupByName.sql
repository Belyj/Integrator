DELIMITER // 
CREATE PROCEDURE `getGroupByName` (IN groupName varchar(255), userName VARCHAR(255)) 
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'searching groupName info
		@param group name, user name'
BEGIN 
    SELECT group_id, gname, cid, cname
	FROM handbook_schema.contact_table c
	JOIN handbook_schema.link_table l ON c.cid = l.contact_id
	JOIN handbook_schema.group_table g ON g.gid = l.group_id
	JOIN handbook_schema.user_table u ON u.uid = l.user_id
	WHERE g.gname LIKE groupName AND u.uname = userName;
END// 

drop PROCEDURE getGroupByName;

call getGroupByName("G", "RU");