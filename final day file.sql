create database week3;
use week3;

CREATE TABLE faculty (
    id int PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(255),
    mob VARCHAR(20)
);

CREATE TABLE course (
    id int PRIMARY KEY,
    name VARCHAR(100),
    duration VARCHAR(50)
);

DROP TABLE faculty_course;

CREATE TABLE faculty_course (
    id INT PRIMARY KEY AUTO_INCREMENT,
    faculty_id INT,
    course_id INT,
    FOREIGN KEY (faculty_id) REFERENCES faculty(id),
    FOREIGN KEY (course_id) REFERENCES course(id)
);

INSERT INTO faculty (id, name, email, password, mob) VALUES 
(1, 'Dr Paul', 'sunny@example.com', 'password123', '9876533333'),
(2, 'Prof Sunny', 'srivastava@example.com', 'password456', '9123456789'),
(3, 'Anand', 'esunnny@example.com', 'password789', '9234567891');

INSERT INTO course (id, name, duration) VALUES 
(101, 'Mathematics', '6 months'),
(102, 'Physics', '5 months'),
(103, 'Computer', '8 months'),
(104, 'Chemistry', '4 months');

INSERT INTO faculty_course (faculty_id, course_id) VALUES 
(1, 101),  
(1, 102),  
(2, 103),  
(3, 104),  
(2, 101);  


SELECT * FROM faculty;
SELECT * FROM course;
SELECT * FROM faculty_course;
SELECT f.name AS Faculty, c.name AS Course, c.duration
FROM faculty_course fc
JOIN faculty f ON fc.faculty_id = f.id
JOIN course c ON fc.course_id = c.id
ORDER BY f.name;

