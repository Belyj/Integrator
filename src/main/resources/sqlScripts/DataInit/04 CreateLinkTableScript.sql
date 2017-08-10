CREATE TABLE `handbook_schema`.`link_table` (
  `group_id` INT NOT NULL,
  `contact_id` INT NOT NULL,
  PRIMARY KEY (`group_id`, `contact_id`),
  CONSTRAINT FK1 FOREIGN KEY (contact_id) 
        REFERENCES contact_table(contact_id) on delete cascade,
  CONSTRAINT FK2 FOREIGN KEY (group_id) 
        REFERENCES group_table(group_id) on delete cascade)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;