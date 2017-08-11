DELIMITER // 
CREATE PROCEDURE `avgContactsInGroups`()
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'Calculate average number of contacts users has'
BEGIN 
    CREATE TEMPORARY TABLE t ( SELECT COUNT(DISTINCT contact_id) as count, group_id FROM handbook_schema.link_table GROUP BY group_id);
	SELECT AVG(count), group_id FROM t;
	drop temporary table t;
END// 

