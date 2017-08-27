DELIMITER // 
CREATE PROCEDURE `addInGroup` (IN contactID INT, groupID INT, userName VARCHAR(255)) 
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'add contact in group
		@param contact id, group id, user id, user name' 
BEGIN 
    INSERT INTO handbook_schema.link_table 
    (contact_id, group_id, user_id)
	VALUES ((SELECT cid FROM handbook_schema.contact_table WHERE cid = contactID),
			(SELECT gid FROM handbook_schema.group_table WHERE gid = groupID),
            (SELECT uid FROM handbook_schema.user_table WHERE uname = userName));
END//