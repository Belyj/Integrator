CREATE TABLE `handbook_schema`.`group_table` (
  `gid` INT NOT NULL AUTO_INCREMENT,
  `gname` VARCHAR(255) NOT NULL,
  INDEX (`gname`),
  PRIMARY KEY (`gid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;