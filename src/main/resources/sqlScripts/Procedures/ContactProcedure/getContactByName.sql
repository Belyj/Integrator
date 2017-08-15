DELIMITER // 
CREATE PROCEDURE `getContactByName` (IN contactName VARCHAR(255), userName VARCHAR(255)) 
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'searching contact info
		@param contact name, user name'
BEGIN 
    SELECT distinct contact_name, phone, skype, mail
	FROM handbook_schema.contact_table c
	JOIN handbook_schema.link_table l ON c.contact_id = l.contact_id
	JOIN handbook_schema.group_table g ON g.group_id = l.group_id
	JOIN handbook_schema.user_table u ON u.user_id = l.user_id
	WHERE c.contact_name LIKE contactName AND u.user_name = userName;
END// 