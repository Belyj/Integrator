DELIMITER // 
CREATE PROCEDURE `avgCountOfContacts`()
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'Calculate average number of contacts users has'
BEGIN 
    CREATE TEMPORARY TABLE t ( SELECT COUNT(DISTINCT contact_id) as count, user_id FROM handbook_schema.link_table GROUP BY user_id);
	SELECT AVG(count) as count, user_id FROM t;
	drop temporary table t;
END// 