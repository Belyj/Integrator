DELIMITER // 
CREATE PROCEDURE `getContactList` () 
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'searching all contacts info'
BEGIN 
    SELECT * FROM handbook_schema.contact_table; 
END// 