CREATE TABLE `handbook_schema`.`user_table` (
  `uid` INT NOT NULL AUTO_INCREMENT,
  `uname` VARCHAR(255) NOT NULL,
  `pass` VARCHAR(256) NOT NULL,
  INDEX (`uname`), 
  UNIQUE (`uname`),
  PRIMARY KEY (`uid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;