DELIMITER // 
CREATE PROCEDURE `removeContactByName` (IN contactName varchar(256)) 
LANGUAGE SQL 
DETERMINISTIC 
COMMENT '	seek and remove contact
			@param contact name'
BEGIN 
    DELETE FROM handbook_schema.contact_table WHERE contact_name = contactName; 
    DELETE FROM handbook_schema.link_table WHERE contact_id = (SELECT contact_id FROM handbook_schema.contact_table WHERE contact_name = contactName);
END// 


DROP procedure if exists removeContactByName;

CALL removeContactByName('D');