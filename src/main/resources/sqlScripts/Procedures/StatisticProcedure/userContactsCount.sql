DELIMITER // 
CREATE PROCEDURE `userContactsCount`()
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'Counting every user contacts'
BEGIN 
    SELECT COUNT(DISTINCT contact_id), user_id FROM handbook_schema.link_table GROUP BY user_id;
END// 