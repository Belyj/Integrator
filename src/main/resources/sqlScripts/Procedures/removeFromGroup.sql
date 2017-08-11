DELIMITER // 
CREATE PROCEDURE `removeFromGroup` (IN contactID INT, groupID INT, userName VARCHAR(255)) 
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'remove contact from group
		@param contact id, group id, userName'
BEGIN 
    DELETE FROM handbook_schema.link_table WHERE 
		group_id = (SELECT group_id FROM handbook_schema.group_table WHERE group_id = contactID) AND
		contact_id = (SELECT contact_id FROM handbook_schema.contact_table WHERE contact_id = groupID) AND
        user_id = (SELECT user_id FROM handbook_schema.user_table WHERE user_name = userName);
END// 