INSERT INTO campus (campus_id, name) VALUES
    (1, 'Seoul'),
    (2, 'Yongin');

INSERT INTO college (college_id, campus_id, name) VALUES
    (1, 1, 'Liberal Arts'),
    (2, 1, 'ICT Convergence'),
    (3, 1, 'Business'),
    (4, 1, 'Social Sciences'),
    (5, 1, 'Humanities'),
    (6, 1, 'Law'),
    (7, 2, 'General Education'),
    (8, 2, 'Engineering'),
    (9, 2, 'Natural Sciences'),
    (10, 2, 'Arts & Physical Education'),
    (11, 2, 'Architecture');

-- Explicitly assigning dept_id to match the line numbers/logic used in lecture inserts
INSERT INTO department (dept_id, college_id, name) VALUES
    (19, 1, 'English Language & Literature'),
    (20, 1, 'Basic Liberal Arts'),
    (21, 1, 'Elective Liberal Arts'),
    (22, 2, 'Digital Contents'),
    (23, 2, 'Convergence Software'),
    (24, 3, 'Business Administration'),
    (25, 3, 'International Trade'),
    (26, 3, 'Management Information Systems'),
    (27, 3, 'Real Estate'),
    (28, 3, 'Business Edu Center'),
    (29, 4, 'Public Administration'),
    (30, 4, 'Economics'),
    (31, 4, 'Political Science'),
    (32, 4, 'Digital Media'),
    (33, 4, 'Child Development'),
    (34, 4, 'Youth Guidance'),
    (35, 4, 'Social Welfare'),
    (36, 5, 'Korean Language & Literature'),
    (37, 5, 'Chinese Language & Literature'),
    (38, 5, 'Japanese Language & Literature'),
    (39, 5, 'English Refined'),
    (40, 5, 'History'),
    (41, 5, 'Library & Info Science'),
    (42, 5, 'Art History'),
    (43, 5, 'Philosophy'),
    (44, 5, 'Arabic'),
    (45, 5, 'Creative Writing'),
    (46, 6, 'Law'),
    (47, 7, 'English (General)'),
    (48, 7, 'Basic (General)'),
    (49, 7, 'Elective (General)'),
    (50, 8, 'Electrical Engineering'),
    (51, 8, 'Computer Engineering'),
    (52, 9, 'Mathematics'),
    (53, 9, 'Physics'),
    (54, 9, 'Chemistry'),
    (55, 9, 'Food & Nutrition'),
    (56, 9, 'Life Science'),
    (57, 10, 'Design'),
    (58, 10, 'Physical Education'),
    (59, 10, 'Music'),
    (60, 10, 'Baduk Studies'),
    (61, 10, 'Film & Musical'),
    (62, 11, 'Architecture'),
    (63, 11, 'Space Design');

INSERT INTO lecture (lecture_id, dept_id, title, professor, credits, capacity, day1, start_time1, end_time1, day2, start_time2, end_time2) VALUES
    -- English (Dept 19)
    (1010, 19, 'English 1', 'Yeo In-wook', 3, 40, 'MON', '10:30:00', '11:45:00', 'WED', '10:30:00', '11:45:00'),
    (1011, 19, 'English Conversation 1', 'Daniel', 2, 40, 'TUE', '10:30:00', '11:45:00', 'THU', '10:30:00', '11:45:00'),
    (1012, 19, 'Advanced English', 'Smith', 3, 30, 'MON', '13:30:00', '14:45:00', 'WED', '13:30:00', '14:45:00'),

    -- Basic Liberal Arts (Dept 20)
    (1020, 20, 'Writing and Discussion', 'Yook Min-su', 3, 40, 'MON', '09:00:00', '10:15:00', 'WED', '09:00:00', '10:15:00'),
    (1021, 20, 'Critical Thinking', 'Joo Min-jae', 3, 40, 'TUE', '13:30:00', '14:45:00', 'THU', '13:30:00', '14:45:00'),

    -- Elective Liberal Arts (Dept 21)
    (1030, 21, 'Modern History', 'Yun Hong-seok', 3, 50, 'FRI', '09:00:00', '11:45:00', NULL, NULL, NULL),
    (1031, 21, 'Philosophy 101', 'Kim Chul-soo', 3, 50, 'WED', '15:00:00', '17:45:00', NULL, NULL, NULL),
    (1032, 21, 'Intro to Psychology', 'Lee Young-hee', 3, 60, 'THU', '10:00:00', '12:45:00', NULL, NULL, NULL),

    -- Public Administration (Dept 29)
    (2010, 29, 'Intro to Public Admin', 'Kim Admin', 3, 40, 'MON', '10:30:00', '11:45:00', 'WED', '10:30:00', '11:45:00'),
    (2011, 29, 'Public Policy', 'Lee Policy', 3, 40, 'TUE', '13:30:00', '14:45:00', 'THU', '13:30:00', '14:45:00'),
    (2012, 29, 'Organizational Theory', 'Park Org', 3, 35, 'FRI', '09:00:00', '11:45:00', NULL, NULL, NULL),

    -- Economics (Dept 30)
    (2020, 30, 'Microeconomics', 'Choi Micro', 3, 50, 'MON', '13:30:00', '14:45:00', 'WED', '13:30:00', '14:45:00'),
    (2021, 30, 'Macroeconomics', 'Jung Macro', 3, 50, 'TUE', '10:30:00', '11:45:00', 'THU', '10:30:00', '11:45:00'),

    -- Digital Media (Dept 32)
    (2030, 32, 'Web Design', 'Kang Web', 3, 30, 'MON', '09:00:00', '11:45:00', NULL, NULL, NULL),
    (2031, 32, 'Interactive Media', 'Song Media', 3, 30, 'WED', '13:00:00', '15:45:00', NULL, NULL, NULL),

    -- Computer Engineering (Dept 51)
    (3010, 51, 'C Programming', 'Jeon Jong-hoon', 3, 40, 'TUE', '18:00:00', '19:50:00', 'THU', '18:00:00', '19:50:00'),
    (3011, 51, 'System Programming', 'Kwon Dong-seop', 4, 40, 'THU', '13:00:00', '14:50:00', 'FRI', '13:00:00', '14:50:00'),
    (3012, 51, 'Data Structures', 'Kim Data', 3, 45, 'MON', '10:30:00', '11:45:00', 'WED', '10:30:00', '11:45:00'),
    (3013, 51, 'Java Programming', 'Lee Java', 3, 45, 'MON', '13:30:00', '14:45:00', 'WED', '13:30:00', '14:45:00'),

    -- Electrical Engineering (Dept 50)
    (3020, 50, 'Circuit Theory 1', 'Han Kook-yeol', 3, 40, 'MON', '09:00:00', '10:15:00', 'WED', '09:00:00', '10:15:00'),
    (3021, 50, 'Electromagnetics', 'Han Kook-yeol', 3, 40, 'TUE', '10:30:00', '11:45:00', 'THU', '10:30:00', '11:45:00'),

    -- Chemistry (Dept 54)
    (4010, 54, 'General Chemistry', 'Kim Sun-kyung', 3, 40, 'MON', '09:00:00', '10:15:00', 'WED', '09:00:00', '10:15:00'),

    -- Mathematics (Dept 52)
    (4020, 52, 'Calculus 1', 'Park Jin-hyung', 3, 40, 'TUE', '13:00:00', '14:15:00', 'THU', '13:00:00', '14:15:00'),
    (4021, 52, 'Number Theory', 'So Sun-tae', 3, 40, 'MON', '13:00:00', '13:50:00', 'WED', '13:00:00', '13:50:00'),

    -- Physics (Dept 53)
    (4030, 53, 'General Physics 1', 'Kim Ju-hak', 3, 40, 'MON', '10:00:00', '11:50:00', NULL, NULL, NULL),
    (4031, 53, 'General Physics 2', 'Kim Ju-hak', 3, 40, 'MON', '12:00:00', '13:50:00', NULL, NULL, NULL);

INSERT INTO student (student_id, password, name, dept_id, max_credits) VALUES
    (0, '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', '관리자', 29, 18),
    (60221123, '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', '칼융', 21, 18),
    (60221330, '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', '조하르', 30, 16),
    (60221331, '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', '박시현', 19, 18),
    (60221332, '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', '박수현', 19, 18),
    (60221333, '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', '박수현', 51, 21),
    (60221334, '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', '황수인', 32, 18),
    (60221335, '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', '조하선', 30, 16),
    (60221336, '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', '덩샤오핑', 29, 16),
    (60221337, '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', '박정희', 31, 16),
    (60221338, '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', '김종필', 31, 16),
    (60221339, '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', '김재익', 30, 16);
