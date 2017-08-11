CREATE TABLE `handbook_schema`.`link_table` (
  `contact_id` INT NOT NULL,
  `group_id` INT NOT NULL DEFAULT 0,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`contact_id`, `group_id`, `user_id`),
  CONSTRAINT FK1 FOREIGN KEY (contact_id) 
        REFERENCES contact_table(contact_id) on delete cascade,
  CONSTRAINT FK2 FOREIGN KEY (group_id) 
        REFERENCES group_table(group_id) on delete cascade,
  CONSTRAINT FK3 FOREIGN KEY (user_id) 
        REFERENCES user_table(user_id) on delete cascade)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;