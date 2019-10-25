CREATE DATABASE IF NOT EXISTS `challenge`;

USE `challenge`;

DROP TABLE IF EXISTS `organization`;

CREATE TABLE `organization` (
  `OrganizationID` int(11) NOT NULL auto_increment UNIQUE,
  `Name` varchar(255) NOT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `Phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`OrganizationID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
    `UserID` int(11) NOT NULL auto_increment UNIQUE,
    `FirstName` varchar(255) NOT NULL,
    `LastName` varchar(255) NOT NULL,
    `Email` varchar(255) NOT NULL,
    `Address` varchar(255) DEFAULT NULL,
    `Phone` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user_organization`;

CREATE TABLE `user_organization` (
    `UserID` int(11) NOT NULL,
    `OrganizationID` int(11) NOT NULL,
    PRIMARY KEY (`UserID`, `OrganizationID`),
    KEY `fk_user_org_org_id` (`OrganizationID`),
    KEY `fk_user_org_user_id` (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `organization` (Name, Address, Phone) 
VALUES ('Academic', '123 Fake Street', '323-555-0123'), ('Sports', '456 Fake Street', '323-555-0456'), ('Cinema', '789 Fake Street', '323-555-0789')
;

INSERT INTO `user` (FirstName, LastName, Email, Address, Phone)
VALUES ('Joe','Schmoe','joe.schmoe@fakemail.net','123 Unreal Street','909-555-0123'),
('Johnny','Cook','johnny.cook@fakemail.net','456 Unreal Street','909-555-0456'),
('Jane','Peck','jane.peck@fakemail.net','789 Unreal Street','909-555-0789'),
('Jess','Flowers','jess.flowers@fakemail.net','918 Unreal Street','909-555-1123')
;

INSERT INTO `user_organization` (UserID, OrganizationID)
VALUES (1, 1), (1, 3), (3, 1), (3, 2), (3, 3), (4, 3)
;