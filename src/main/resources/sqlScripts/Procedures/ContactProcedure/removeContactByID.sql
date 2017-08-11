DELIMITER // 
CREATE PROCEDURE `removeContactByID` (IN contactID int) 
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'seek and remove contact
		@param contact id'
BEGIN 
    DELETE FROM handbook_schema.contact_table WHERE contact_id = contactID; 
END// 
