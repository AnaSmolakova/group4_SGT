CREATE TABLE result (
userIDInfo int NOT NULL REFERENCES loginInfo(userID),
questionIDInfo int NOT NULL REFERENCES psychologytest(questionID),
PRIMARY KEY (userIDInfo, questionIDInfo)
);

DROP TABLE result;

INSERT INTO result (userIDInfo, questionIDInfo) VALUES (1, 1);

SELECT * FROM result;

