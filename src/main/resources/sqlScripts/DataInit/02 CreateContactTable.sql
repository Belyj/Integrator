CREATE TABLE `handbook_schema`.`contact_table` (
  `contact_id` INT NOT NULL AUTO_INCREMENT,
  `contact_name` VARCHAR(256) NOT NULL,
  `phone` INT NOT NULL DEFAULT 0,
  `skype` VARCHAR(256) NOT NULL DEFAULT '',
  `mail` VARCHAR(256) NOT NULL DEFAULT '',
  PRIMARY KEY (`contact_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;