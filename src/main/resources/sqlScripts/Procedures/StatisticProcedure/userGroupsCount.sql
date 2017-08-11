DELIMITER // 
CREATE PROCEDURE `userGroupsCount` (userName VARCHAR(256)) 
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'Counting user contacts
		@param user name'
BEGIN 
    SELECT COUNT(DISTINCT group_id), user_id FROM handbook_schema.link_table GROUP BY user_id;
END// 