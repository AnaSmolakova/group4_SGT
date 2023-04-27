CREATE TABLE loginInfo (
userID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
password varchar(45) NOT NULL,
fullName varchar(100) NOT NULL,
username varchar(100) NOT NULL,
email varchar(45)
);
DROP TABLE logininfo;

INSERT INTO logininfo (password, fullName, email, username) VALUES ('111','Janis','Rikis','janis@gmail.com');

SELECT * FROM loginInfo;