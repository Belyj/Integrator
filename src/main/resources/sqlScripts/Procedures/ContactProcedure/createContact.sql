DELIMITER // 
CREATE PROCEDURE `createContact` (IN contactName varchar(255)) 
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'create contact
		@param contact name'
BEGIN 
	INSERT INTO `handbook_schema`.`contact_table` (`contact_name`) VALUES (contactName);
    SELECT * FROM handbook_schema.contact_table WHERE contact_name = contactName; 
END// 