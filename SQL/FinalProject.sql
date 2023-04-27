CREATE TABLE psychologytest (
questionID int (45) NOT NULL auto_increment,
section int (45) NOT NULL,
question varchar (400) NOT NULL,
PRIMARY KEY (questionID)
);

INSERT INTO psychologytest (section, question)
VALUES ('3', 'I am detailed');

<<<<<<< HEAD
INSERT INTO psychologytest (section, question)
VALUES ('3', 'I am consistent');

INSERT INTO psychologytest (section, question)
VALUES ('3', 'I am reserved');

INSERT INTO psychologytest (section, question)
VALUES ('3', 'I am practical');

INSERT INTO psychologytest (section, question)
VALUES ('3', 'I am factual');

INSERT INTO psychologytest (section, question)
VALUES ('3', 'I am perfectionist');

INSERT INTO psychologytest (section, question)
VALUES ('3', 'I am enjoys instructions');

INSERT INTO psychologytest (section, question)
VALUES ('3', 'I am inquisitive');

INSERT INTO psychologytest (section, question)
VALUES ('3', 'I am persistent');

INSERT INTO psychologytest (section, question)
VALUES ('3', 'I am sensitive');

INSERT INTO psychologytest (section, question)
VALUES ('3', 'I am accurate');

INSERT INTO psychologytest (section, question)
VALUES ('3', 'I am controlled');

INSERT INTO psychologytest (section, question)
VALUES ('3', 'I am predictable');

INSERT INTO psychologytest (section, question)
VALUES ('3', 'I am orderly');

INSERT INTO psychologytest (section, question)
VALUES ('3', 'I am conscientious');

INSERT INTO psychologytest (section, question)
VALUES ('3', 'I am discerning');

INSERT INTO psychologytest (section, question)
VALUES ('3', 'I am analytical');

INSERT INTO psychologytest (section, question)
VALUES ('3', 'I am precise');

INSERT INTO psychologytest (section, question)
VALUES ('3', 'I am organised');

INSERT INTO psychologytest (section, question)
VALUES ('3', 'I am deliberate');



INSERT INTO psychologytest (section, question)
VALUES ('4', 'I am sensitive');

INSERT INTO psychologytest (section, question)
VALUES ('4', 'I am calm');

INSERT INTO psychologytest (section, question)
VALUES ('4', 'I am easy-going');

INSERT INTO psychologytest (section, question)
VALUES ('4', 'I am avoids confrontation');

INSERT INTO psychologytest (section, question)
VALUES ('4', 'I am enjoys routine');

INSERT INTO psychologytest (section, question)
VALUES ('4', 'I am warm');

INSERT INTO psychologytest (section, question)
VALUES ('4', 'I am adaptable');

INSERT INTO psychologytest (section, question)
VALUES ('4', 'I am thoughtful');

INSERT INTO psychologytest (section, question)
VALUES ('4', 'I am patient');

INSERT INTO psychologytest (section, question)
VALUES ('4', 'I am good listener');

INSERT INTO psychologytest (section, question)
VALUES ('4', 'I am loyal');

INSERT INTO psychologytest (section, question)
VALUES ('4', 'I am well-balanced');

INSERT INTO psychologytest (section, question)
VALUES ('4', 'I am gives in easily');

INSERT INTO psychologytest (section, question)
VALUES ('4', 'I am indecisive');

INSERT INTO psychologytest (section, question)
VALUES ('4', 'I am dislikes changes');

INSERT INTO psychologytest (section, question)
VALUES ('4', 'I am dry humor');

INSERT INTO psychologytest (section, question)
VALUES ('4', 'I am sympathetic');

INSERT INTO psychologytest (section, question)
VALUES ('4', 'I am nurturing');

INSERT INTO psychologytest (section, question)
VALUES ('4', 'I am tolerant');

INSERT INTO psychologytest (section, question)
VALUES ('4', 'I am peace maker');
=======
CREATE TABLE results (
loginInfo int NOT NULL REFERENCES usersName(login),
questionsInfo int NOT NULL REFERENCES question(qustions),
answerUser int NOT NULL REFERENCES answer(questions),
answerUser int NOT NULL,
PRIMARY KEY (studentID, teacherID, subjectID)
);

>>>>>>> f4364eb1bea303d98c78073a3b17c6f9774b7b9a
