DELIMITER // 
CREATE PROCEDURE `getContactByName` (IN contactName VARCHAR(256)) 
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'searching contact info
		@param contact name'
BEGIN 
    SELECT * FROM handbook_schema.contact_table WHERE contact_name = contactName; 
END// 