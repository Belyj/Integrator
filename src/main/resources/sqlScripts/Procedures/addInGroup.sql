DELIMITER // 
CREATE PROCEDURE `addInGroup` (IN contactID INT, groupID INT, userName VARCHAR(255)) 
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'add contact in group
		@param contact id, group id, user id, user name' 
BEGIN 
    INSERT INTO handbook_schema.link_table 
	VALUES ((SELECT group_id FROM handbook_schema.group_table WHERE group_id = groupID),
			(SELECT contact_id FROM handbook_schema.contact_table WHERE contact_id = contactID),
            (SELECT user_id FROM handbook_schema.user_table WHERE user_name = userName));
END//