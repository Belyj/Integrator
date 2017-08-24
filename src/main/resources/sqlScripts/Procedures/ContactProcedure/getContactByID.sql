DELIMITER // 
CREATE PROCEDURE `getContactByID` (IN contactID INT, userName VARCHAR(255)) 
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'searching contact info
		@param contact name, user name'
BEGIN 
    SELECT distinct cid, cname, phone, skype, mail
	FROM handbook_schema.contact_table c
	JOIN handbook_schema.link_table l ON c.cid = l.contact_id
	JOIN handbook_schema.user_table u ON u.uid = l.user_id
	WHERE c.cid LIKE contactID AND u.uname = userName;
END//