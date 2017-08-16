CREATE TABLE `handbook_schema`.`contact_table` (
  `cid` INT NOT NULL AUTO_INCREMENT,
  `cname` VARCHAR(255) NOT NULL,
  INDEX (`cname`),
  `phone` VARCHAR(256) NOT NULL DEFAULT '',
  `skype` VARCHAR(256) NOT NULL DEFAULT '',
  `mail` VARCHAR(256) NOT NULL DEFAULT '',
  PRIMARY KEY (`cid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;