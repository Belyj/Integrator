DELIMITER // 
CREATE PROCEDURE `removeFromGroup` (IN contactName VARCHAR(256), groupName VARCHAR(256)) 
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'remove contact from group
		@param contact name, group name'
BEGIN 
    DELETE FROM handbook_schema.link_table WHERE 
		group_id = (SELECT group_id FROM handbook_schema.group_table WHERE group_name = contactName) AND
		contact_id = (SELECT contact_id FROM handbook_schema.contact_table WHERE contact_name = groupName);
END// 