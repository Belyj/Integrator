DELIMITER // 
CREATE PROCEDURE `getContactList` (IN userName VARCHAR(255)) 
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'searching all contacts info
		@param user name'
BEGIN 
	SELECT DISTINCT cid, cname, phone, skype, mail
	FROM handbook_schema.contact_table c
	JOIN handbook_schema.link_table l ON c.cid = l.contact_id
	JOIN handbook_schema.user_table u ON u.uid = l.user_id
	WHERE u.uname = userName;
END// 