create temporary table qwerty ( SELECT COUNT(DISTINCT contact_id) as count, user_id FROM handbook_schema.link_table GROUP BY user_id);
SELECT AVG(count), user_id FROM qwerty;
drop temporary table qwerty;