DELIMITER // 
CREATE PROCEDURE `updateContact` (IN contactID int, newContactName VARCHAR(255), newPhone INT, newSkype VARCHAR(256), newMail VARCHAR(256))
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'seek and update contact info
		@param contact id, new Contact Name, phone, skype, mail'
BEGIN 
    UPDATE handbook_schema.contact_table 
		SET contact_name = newContactName,
			phone = newPhone,
			skype = newSkype,
			mail = newMail
		WHERE contact_id = contactID;
END// 