use happyhouse;

CREATE TABLE IF NOT EXISTS `user` (
  `userid` VARCHAR(50) NOT NULL,
  `pwd` VARCHAR(50) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `email` VARCHAR(50) NULL,
  `tel` VARCHAR(20) NULL,
  PRIMARY KEY (`userid`))
ENGINE = InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `happyhouse`.`notice` (
  `articleno` INT NOT NULL AUTO_INCREMENT,
  `userid` VARCHAR(16) NULL DEFAULT NULL,
  `subject` VARCHAR(100) NULL DEFAULT NULL,
  `content` VARCHAR(2000) NULL DEFAULT NULL,
  `hit` INT NULL DEFAULT 0,
  `regtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`articleno`),
  INDEX `notice_to_member_fk` (`userid` ASC) VISIBLE,
  CONSTRAINT `notice_to_member_fk`
    FOREIGN KEY (`userid`)
    REFERENCES `happyhouse`.`user` (`userid`) on delete cascade)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `happyhouse`.`qna` (
  `articleno` INT NOT NULL AUTO_INCREMENT,
  `userid` VARCHAR(16) NULL DEFAULT NULL,
  `subject` VARCHAR(100) NULL DEFAULT NULL,
  `content` VARCHAR(2000) NULL DEFAULT NULL,
  `hit` INT NULL DEFAULT 0,
  `regtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`articleno`),
  INDEX `qna_to_member_fk` (`userid` ASC) VISIBLE,
  CONSTRAINT `qna_to_member_fk`
    FOREIGN KEY (`userid`)
    REFERENCES `happyhouse`.`user` (`userid`) on delete cascade)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;