DELIMITER // 
CREATE PROCEDURE `updateContact` (IN contactName VARCHAR(256), newContactName VARCHAR(256), newPhone INT, newSkype VARCHAR(256), newMail VARCHAR(256))
LANGUAGE SQL 
DETERMINISTIC 
COMMENT '	seek and update contact info
			@param contact name, newContactName, phone, skype, mail'
BEGIN 
    UPDATE handbook_schema.contact_table 
		SET contact_name = newContactName,
			phone = newPhone,
            skype = newSkype,
            mail = newMail
		WHERE contact_name = contactName;
END// 
