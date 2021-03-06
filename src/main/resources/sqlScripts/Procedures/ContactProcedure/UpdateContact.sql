DELIMITER // 
CREATE PROCEDURE `updateContact` (IN contactID int, newContactName VARCHAR(255), newPhone VARCHAR(256), newSkype VARCHAR(256), newMail VARCHAR(256))
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'seek and update contact info
		@param contact id, new Contact Name, phone, skype, mail'
BEGIN 
    UPDATE handbook_schema.contact_table 
		SET cname = newContactName,
			phone = newPhone,
			skype = newSkype,
			mail = newMail
		WHERE cid = contactID;
	SELECT * FROM handbook_schema.contact_table WHERE cid = contactID;
END// 