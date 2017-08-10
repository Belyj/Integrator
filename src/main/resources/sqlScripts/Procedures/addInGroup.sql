DELIMITER // 
CREATE PROCEDURE `addInGroup` (IN contactName VARCHAR(256), groupName VARCHAR(256)) 
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'add contact in group
		@param contact name, group name'
BEGIN 
    INSERT INTO handbook_schema.link_table 
	VALUES ((SELECT group_id FROM handbook_schema.group_table WHERE group_name = groupName),
			(SELECT contact_id FROM handbook_schema.contact_table WHERE contact_name = contactName));
END// 