CREATE TABLE loginInfo (
userID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
password varchar(45) NOT NULL,
fullName varchar(100) NOT NULL,
email varchar(45),
PRIMARY KEY (userID)
);

SELECT * FROM logininfo;
