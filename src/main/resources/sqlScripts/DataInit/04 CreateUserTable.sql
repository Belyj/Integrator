CREATE TABLE `handbook_schema`.`user_table` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(255) NOT NULL,
  `user_pass` VARCHAR(256) NOT NULL,
  INDEX (user_name), 
  UNIQUE (user_name),
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

