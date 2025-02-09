CREATE TABLE IF NOT EXISTS analytics_config (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    type VARCHAR(50) NOT NULL,
    data_type VARCHAR(50) NOT NULL
);


CREATE TABLE IF NOT EXISTS analytics_data (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id VARCHAR(255) NOT NULL,
    value VARCHAR(255) NOT NULL,
    analytic_id INT NOT NULL,
    activity_id VARCHAR(255) NOT NULL,
    FOREIGN KEY (analytic_id) REFERENCES analytics_config(id)
);


CREATE TABLE IF NOT EXISTS config_params (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    type VARCHAR(50) NOT NULL
);


INSERT INTO analytics_config (name, type, data_type)
VALUES
    ('access_info_before_answering', 'qualitative', 'boolean'),
    ('participation_in_quiz', 'qualitative', 'boolean'),
    ('accessed_activity', 'quantitative', 'boolean'),
    ('activity_completion_time', 'quantitative', 'integer'),
    ('correct_answers_quiz', 'quantitative', 'integer'),
    ('incorrect_answers_quiz', 'quantitative', 'integer'),
    ('accuracy_percentage', 'quantitative', 'number'),
    ('reward_level_achieved', 'quantitative', 'integer'),
    ('reaction_time', 'quantitative', 'integer'),
    ('feedback_received', 'quantitative', 'boolean'),
    ('certificate_issued', 'quantitative', 'boolean');


INSERT INTO analytics_data (id, student_id, value, analytic_id, activity_id) VALUES
    (1, 'student_1', 'true', 1, 'activity-12345'),
    (2, 'student_1', 'false', 2, 'activity-12345'),
    (3, 'student_1', 'true', 3, 'activity-12345'),
    (4, 'student_1', '120', 4, 'activity-12345'),
    (5, 'student_1', '8', 5, 'activity-12345'),
    (6, 'student_1', '2', 6, 'activity-12345'),
    (7, 'student_1', '80', 7, 'activity-12345'),
    (8, 'student_1', '2', 8, 'activity-12345'),
    (9, 'student_1', '500', 9, 'activity-12345'),
    (10, 'student_1', 'true', 10, 'activity-12345'),
    (11, 'student_1', 'true', 11, 'activity-12345'),
    (12, 'student_2', 'false', 1, 'activity-12345'),
    (13, 'student_2', 'true', 2, 'activity-12345'),
    (14, 'student_2', 'true', 3, 'activity-12345'),
    (15, 'student_2', '140', 4, 'activity-12345'),
    (16, 'student_2', '7', 5, 'activity-12345'),
    (17, 'student_2', '3', 6, 'activity-12345'),
    (18, 'student_2', '70', 7, 'activity-12345'),
    (19, 'student_2', '1', 8, 'activity-12345'),
    (20, 'student_2', '550', 9, 'activity-12345'),
    (21, 'student_2', 'false', 10, 'activity-12345'),
    (22, 'student_2', 'false', 11, 'activity-12345');



INSERT INTO config_params (name, type)
VALUES ('activity_info_url', 'url'),
       ('question_1', 'text/plain'),
       ('question_1_option_1', 'text/plain'),
       ('question_1_option_2', 'text/plain'),
       ('question_1_option_3', 'text/plain'),
       ('question_1_option_4', 'text/plain'),
       ('question_1_correct_answer', 'integer'),
       ('question_2', 'text/plain'),
       ('question_2_option_1', 'text/plain'),
       ('question_2_option_2', 'text/plain'),
       ('question_2_option_3', 'text/plain'),
       ('question_2_option_4', 'text/plain'),
       ('question_2_correct_answer', 'integer'),
       ('reward_level_1', 'text/plain'),
       ('reward_level_2', 'text/plain'),
       ('certificate_url', 'url'),
       ('feedback_material_intermediate', 'text/plain'),
       ('support_material_repeat', 'text/plain');