CREATE DATABASE IF NOT EXISTS course_register;
USE course_register;

CREATE TABLE campus (
    campus_id   INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(20) NOT NULL
);

CREATE TABLE college (
    college_id  INT AUTO_INCREMENT PRIMARY KEY,
    campus_id   INT NOT NULL,
    name        VARCHAR(30) NOT NULL,
    FOREIGN KEY (campus_id) REFERENCES campus(campus_id)
);

CREATE TABLE department (
    dept_id     INT AUTO_INCREMENT PRIMARY KEY,
    college_id  INT NOT NULL,
    name        VARCHAR(30) NOT NULL,
    FOREIGN KEY (college_id) REFERENCES college(college_id)
);

CREATE TABLE student (
    student_id  INT PRIMARY KEY,
    password    CHAR(64) NOT NULL,
    name        VARCHAR(20) NOT NULL,
    dept_id     INT NOT NULL,
    max_credits INT NOT NULL DEFAULT 21,
    FOREIGN KEY (dept_id) REFERENCES department(dept_id)
);

CREATE TABLE lecture (
    lecture_id  INT PRIMARY KEY,
    dept_id     INT NOT NULL,
    title       VARCHAR(50) NOT NULL,
    professor   VARCHAR(20) NOT NULL,
    credits     INT NOT NULL,
    capacity    INT NOT NULL DEFAULT 40,
    day1        ENUM('MON','TUE','WED','THU','FRI'),
    start_time1 TIME,
    end_time1   TIME,
    day2        ENUM('MON','TUE','WED','THU','FRI'),
    start_time2 TIME,
    end_time2   TIME,
    FOREIGN KEY (dept_id) REFERENCES department(dept_id)
);

CREATE TABLE basket (
    student_id  INT NOT NULL,
    lecture_id  INT NOT NULL,
    created_at  DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (student_id, lecture_id),
    FOREIGN KEY (student_id) REFERENCES student(student_id),
    FOREIGN KEY (lecture_id) REFERENCES lecture(lecture_id)
);

CREATE TABLE enrollment (
    student_id  INT NOT NULL,
    lecture_id  INT NOT NULL,
    enrolled_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (student_id, lecture_id),
    FOREIGN KEY (student_id) REFERENCES student(student_id),
    FOREIGN KEY (lecture_id) REFERENCES lecture(lecture_id)
);
