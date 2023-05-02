drop table testResults;
CREATE TABLE testResults (
    userID INT NOT NULL,
    choleric INT NOT NULL,
    sanguine INT NOT NULL,
    melancholic INT NOT NULL,
    phlegmatic INT NOT NULL,
    FOREIGN KEY (userID) REFERENCES loginInfo(userID)
);
SELECT * FROM  testResults;

SELECT 
    CASE GREATEST(choleric, sanguine, melancholic, phlegmatic)
        WHEN section2 THEN 'section2'
        WHEN section3 THEN 'section3'
        WHEN section4 THEN 'section4'
    END AS section_with_highest_score,
    GREATEST(section1, section2, section3, section4) AS highest_score
FROM testResults
WHERE userID = 2;
