DELIMITER // 
CREATE PROCEDURE `userGroupsCount` () 
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'Counting every user groups'
BEGIN 
CREATE TEMPORARY TABLE t SELECT COUNT(DISTINCT group_id) as count, user_id FROM handbook_schema.link_table GROUP BY user_id;
	SELECT user_id, uname, count  
    FROM t
    JOIN handbook_schema.user_table u ON u.uname = (select uname FROM handbook_schema.user_table WHERE uid = user_id);
	DROP TEMPORARY TABLE t;
END// 