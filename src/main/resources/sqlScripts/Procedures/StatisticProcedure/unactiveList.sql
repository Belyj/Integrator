DELIMITER // 
CREATE PROCEDURE `unactiveList`()
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'Serchin unactive users, unactive user have count contacts less than 10'
BEGIN 
    CREATE TEMPORARY TABLE t SELECT COUNT(DISTINCT contact_id) as count, user_id FROM handbook_schema.link_table GROUP BY user_id;
	SELECT*FROM t WHERE count < 10;
	DROP TEMPORARY TABLE t;
END// 