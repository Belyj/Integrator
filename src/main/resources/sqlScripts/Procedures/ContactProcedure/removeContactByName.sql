DELIMITER // 
CREATE PROCEDURE `removeContactByName` (IN contactName varchar(256)) 
LANGUAGE SQL 
DETERMINISTIC 
COMMENT '	seek and remove contact
			@param contact name'
BEGIN 
    DELETE FROM handbook_schema.contact_table WHERE contact_name = contactName; 
END// 
