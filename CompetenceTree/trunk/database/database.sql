SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `mydb` ;
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`competences`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`competences` ;

CREATE TABLE IF NOT EXISTS `mydb`.`competences` (
  `competence_id` INT NOT NULL AUTO_INCREMENT,
  `competence_name` VARCHAR(255) NOT NULL,
  `competence_wiki_link` VARCHAR(255) NULL,
  PRIMARY KEY (`competence_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `mydb`.`competences_relations`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`competences_relations` ;

CREATE TABLE IF NOT EXISTS `mydb`.`competences_relations` (
  `competence_id` INT NOT NULL,
  `competence_parent_id` INT NOT NULL,
  PRIMARY KEY (`competence_id`, `competence_parent_id`),
  INDEX `fk_competence_parent_id_idx` (`competence_parent_id` ASC),
  CONSTRAINT `fk_competence_id_rl`
    FOREIGN KEY (`competence_id`)
    REFERENCES `mydb`.`competences` (`competence_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_competence_parent_id_rl`
    FOREIGN KEY (`competence_parent_id`)
    REFERENCES `mydb`.`competences` (`competence_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `mydb`.`user_competences`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`user_competences` ;

CREATE TABLE IF NOT EXISTS `mydb`.`user_competences` (
  `user_id` INT NOT NULL,
  `competence_id` INT NOT NULL,
  PRIMARY KEY (`user_id`),
  INDEX `fk_competence_id_idx` (`competence_id` ASC),
  CONSTRAINT `fk_competence_id_uc`
    FOREIGN KEY (`competence_id`)
    REFERENCES `mydb`.`competences` (`competence_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
