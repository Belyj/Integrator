DELIMITER // 
CREATE PROCEDURE `getContactList` (userName VARCHAR(256)) 
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'searching all contacts info
		@param user name'
BEGIN 
	SELECT DISTINCT contact_name, phone, skype, mail
	FROM handbook_schema.contact_table c
	JOIN handbook_schema.link_table l ON c.contact_id = l.contact_id
	JOIN handbook_schema.user_table u ON u.user_id = l.user_id
	WHERE u.user_name = userName;
END// 
