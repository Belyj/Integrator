DELIMITER // 
CREATE PROCEDURE `getUserByName` (IN userName VARCHAR(255), userPass VARCHAR(256)) 
LANGUAGE SQL 
DETERMINISTIC 
COMMENT 'searching user info
		@param user name, user pass'
BEGIN 
    SELECT uid, uname FROM handbook_schema.user_table WHERE uname = userName AND pass = userPass;
END//