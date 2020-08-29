DROP SCHEMA IF EXISTS `module` ;
CREATE SCHEMA IF NOT EXISTS `module` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE `module` ;
-- =========================================================================================================================================================
-- =========================================================================================================================================================
DROP TABLE IF EXISTS `module`.`UserDTO` ;
CREATE TABLE IF NOT EXISTS `module`.`UserDTO` (
  `UserName` VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Password` CHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `IsAdmin` TINYINT(1) NULL DEFAULT '1',
  `CreatedDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `UpdatedDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `IsActive` TINYINT(1) NULL DEFAULT '1',
  PRIMARY KEY (`UserName`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;
-- =========================================================================================================================================================
-- =========================================================================================================================================================
DROP TABLE IF EXISTS `module`.`StudentDTO` ;
CREATE TABLE IF NOT EXISTS `module`.`StudentDTO` (
  `Id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `StudentCode` CHAR(10) NOT NULL,
  `StudentName` VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '',
  `Gender` INT(1) UNSIGNED NULL,
  `IdentityNumber` CHAR(15) NULL DEFAULT '',
  `ClassID` INT(10) UNSIGNED NOT NULL,
  `CreatedDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `UpdatedDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `IsActive` TINYINT(1) NULL DEFAULT '1',
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;
-- =========================================================================================================================================================
-- =========================================================================================================================================================
DROP TABLE IF EXISTS `module`.`SubjectDTO` ;
CREATE TABLE IF NOT EXISTS `module`.`SubjectDTO` (
  `Id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `SubjectCode` CHAR(10) NOT NULL,
  `SubjectName` VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `CreatedDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `UpdatedDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `IsActive` TINYINT(1) NULL DEFAULT '1',
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;
-- =========================================================================================================================================================
-- =========================================================================================================================================================
DROP TABLE IF EXISTS `module`.`ClassDTO` ;
CREATE TABLE IF NOT EXISTS `module`.`ClassDTO` (
  `Id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `ClassCode` CHAR(10) NOT NULL,
  `CreatedDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `UpdatedDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `IsActive` TINYINT(1) NULL DEFAULT '1',
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;
-- =========================================================================================================================================================
-- =========================================================================================================================================================
DROP TABLE IF EXISTS `module`.`ScheduleDTO` ;
CREATE TABLE IF NOT EXISTS `module`.`ScheduleDTO` (
  `ClassID` INT(10) UNSIGNED NOT NULL,
  `SubjectID` INT(10) UNSIGNED NOT NULL,
  `ClassRoom` VARCHAR(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `CreatedDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `UpdatedDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `IsActive` TINYINT(1) NULL DEFAULT '1',
  PRIMARY KEY (`ClassID`, `SubjectID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;
-- =========================================================================================================================================================
-- =========================================================================================================================================================
DROP TABLE IF EXISTS `module`.`TranscriptDTO` ;
CREATE TABLE IF NOT EXISTS `module`.`TranscriptDTO` (
  `StudentID` INT(10) UNSIGNED NOT NULL,
  `ClassID` INT(10) UNSIGNED NOT NULL,
  `SubjectID` INT(10) UNSIGNED NOT NULL,
  `ScoresMid` FLOAT(4,2) NOT NULL DEFAULT 0,
  `ScoresEnd` FLOAT(4,2) NOT NULL DEFAULT 0,
  `ScoresOther` FLOAT(4,2) NOT NULL DEFAULT 0,
  `ScoresSum` FLOAT(4,2) NOT NULL DEFAULT 0,
  `CreatedDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `UpdatedDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `IsActive` TINYINT(1) NULL DEFAULT '1',
  PRIMARY KEY (`StudentID`, `ClassID`, `SubjectID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;
-- =========================================================================================================================================================
-- =========================================================================================================================================================
DROP TABLE IF EXISTS `module`.`CheckExaminationScheduleDTO` ;
CREATE TABLE IF NOT EXISTS `module`.`CheckExaminationScheduleDTO` (
  `UserName` VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `ClassID` INT(10) UNSIGNED NOT NULL,
  `SubjectID` INT(10) UNSIGNED NOT NULL,
  `FormDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `ToDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `CreatedDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `UpdatedDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `IsActive` TINYINT(1) NULL DEFAULT '1',
  PRIMARY KEY (`UserName`, `ClassID`, `SubjectID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;
-- =========================================================================================================================================================
-- =========================================================================================================================================================
DROP TABLE IF EXISTS `module`.`CheckExaminationDTO` ;
CREATE TABLE IF NOT EXISTS `module`.`CheckExaminationDTO` (
  `StudentID` INT(10) UNSIGNED NOT NULL,
  `UserName` VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `ClassID` INT(10) UNSIGNED NOT NULL,
  `SubjectID` INT(10) UNSIGNED NOT NULL,
  `ScoresType` VARCHAR(5) NOT NULL DEFAULT '',
  `ScoresWish` FLOAT(4,2) NOT NULL DEFAULT 0,
  `ScoresCheck` FLOAT(4,2) NOT NULL DEFAULT 0,
  `Reason` TEXT,
  `StatusCheck` CHAR(1) NOT NULL DEFAULT '',
  `CreatedDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `UpdatedDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `IsActive` TINYINT(1) NULL DEFAULT '1',
  PRIMARY KEY (`StudentID`, `UserName`, `ClassID`, `SubjectID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;
-- =========================================================================================================================================================
-- =========================================================================================================================================================
-- =========================================================================================================================================================
INSERT INTO `userdto` VALUES ('1','U/Cqtosk2xat5slgQ5ZWyw==',1,'2019-08-23 23:34:58','2019-08-23 23:34:58',1),('giaovu','O/m3jr7GqjOANy2mD9meww==',1,'2019-08-23 23:39:10','2019-08-23 23:39:10',1);
-- =========================================================================================================================================================
INSERT INTO `subjectdto` VALUES (1,'CTT001','Lập trình ứng dụng Java','2019-08-23 23:24:37','2019-08-23 23:24:37',1),(2,'CTT002','Mạng máy tính','2019-08-23 23:24:37','2019-08-23 23:24:37',1),(3,'CTT011','Thiết kế giao diện','2019-08-23 23:24:37','2019-08-23 23:24:37',1),(4,'CTT012','Kiểm chứng phần mềm','2019-08-23 23:24:37','2019-08-23 23:24:37',1),(5,'CTT021','Nhập môn lập trình','2019-08-23 23:24:37','2019-08-23 23:24:37',1),(6,'CTT022','Tin học cơ sở','2019-08-23 23:24:37','2019-08-23 23:24:37',1),(7,'CTT034','Khai thác dữ liệu','2019-08-23 23:24:37','2019-08-23 23:24:37',1),(8,'CTT035','Hệ quản trị cơ sở dữ liệu','2019-08-23 23:24:37','2019-08-23 23:24:37',1);
-- =========================================================================================================================================================
INSERT INTO `classdto` VALUES (1,'15HCB','2019-08-23 23:30:45','2019-08-23 23:30:45',1),(2,'16HCB','2019-08-23 23:30:45','2019-08-23 23:30:45',1),(3,'17HCB','2019-08-23 23:30:45','2019-08-23 23:30:45',1),(4,'18HCB','2019-08-23 23:30:45','2019-08-23 23:30:45',1),(5,'19HCB','2019-08-23 23:30:45','2019-08-23 23:30:45',1),(6,'20HCB','2019-08-23 23:30:45','2019-08-23 23:30:45',1);
