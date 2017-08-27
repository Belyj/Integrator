DELIMITER // 
CREATE PROCEDURE `removeFromGroup` (IN contactID INT, groupID INT, userName VARCHAR(255)) 
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'remove contact from group
		@param contact id, group id, userName'
BEGIN 
    DELETE FROM handbook_schema.link_table WHERE 
		contact_id = (SELECT cid FROM handbook_schema.contact_table WHERE cid = contactID) AND
		group_id = (SELECT gid FROM handbook_schema.group_table WHERE gid = groupID) AND
        user_id = (SELECT uid FROM handbook_schema.user_table WHERE uname = userName);
END//