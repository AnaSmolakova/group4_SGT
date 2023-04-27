CREATE TABLE login(
sid int NOT NULL PRIMARY KEY,
name text NOT NULL
);

CREATE TABLE questions(
tid int NOT NULL PRIMARY KEY,
name text NOT NULL
);

CREATE TABLE results (
loginInfo int NOT NULL REFERENCES usersName(login),
questionsInfo int NOT NULL REFERENCES question(qustions),
answerUser int NOT NULL REFERENCES answer(questions),
answerUser int NOT NULL,
PRIMARY KEY (studentID, teacherID, subjectID)
);

