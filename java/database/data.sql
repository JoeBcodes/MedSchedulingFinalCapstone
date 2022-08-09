BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role, first_name, last_name, phone, email) 
VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'Larry', 'Lobster', '555-555-5555', 'larry@gmail.com');

INSERT INTO users (username, password_hash, role, first_name, last_name, phone, email) VALUES ('joshbernardino', '', '', 'Josh', 'Bernardino', '111-111-1111', 'josh.bernardino@gmail.com');
INSERT INTO users (username, password_hash, role, first_name, last_name, phone, email) VALUES ('joebaca', '', '', 'Joe', 'Baca', '222-222-2222', 'joe.baca@gmail.com');
INSERT INTO users (username, password_hash, role, first_name, last_name, phone, email) VALUES ('joywang', '', '', 'Joy', 'Wang', '333-333-3333', 'joy.wang@gmail.com');
INSERT INTO users (username, password_hash, role, first_name, last_name, phone, email) VALUES ('rickprentice', '', '', 'Rick', 'Prentice', '444-444-4444', 'rick.prentice@gmail.com');


SELECT * FROM users;

INSERT INTO calendar (doctor_id, day_of_the_week, start_time, end_time) 
VALUES (1, 'Monday', '08:00:00', '17:00:00');

INSERT INTO calendar (doctor_id, day_of_the_week, start_time, end_time) 
VALUES (1, 'Tuesday', '08:00:00', '17:00:00');

SELECT * FROM calendar;

INSERT INTO office (name, address, phone, email, start_hours, end_hours, specialty, hourly_rate) 
VALUES ('Med Elevator', '5960 Berkshire ln, Dallas, TX 75225', '877-606-3203', 'office@medelevator.com', '07:00:00', '17:00:00', 'General', 50000.0);

SELECT * FROM office;

INSERT INTO reviews (reviewer_id, doctor_id, review_date, review_desc, rating)
VALUES (1, 2, '2022-08-01', 'Very Professional. Good diagnosis. I DID have a quarter stuck up there. 10/10.', 5);
INSERT INTO reviews (reviewer_id, doctor_id, review_date, review_desc, rating)
VALUES (1, 3, '2022-08-03', 'It was alright.', 4);
INSERT INTO reviews (reviewer_id, doctor_id, review_date, review_desc, rating)
VALUES (1, 2, '2022-08-05', 'Doctor Bozo was not funny. I was expecting a funny doctor, ya know, because of the name.', 3);
INSERT INTO reviews (reviewer_id, doctor_id, review_date, review_desc, rating)
VALUES (1, 3, '2022-08-07', 'Would not eat here again!', 1);

SELECT * FROM reviews;

INSERT INTO appointments (doctor_id, patient_id, appt_date, appt_time, purpose_of_visit, is_completed, is_available)
VALUES (1, 3, '2022-09-12', '07:00:00', 'flu symptoms', false, true);
INSERT INTO appointments (doctor_id, patient_id, appt_date, appt_time, purpose_of_visit, is_completed, is_available)
VALUES (2, 4, '2022-09-12', '07:30:00', 'runny nose', true, false);
INSERT INTO appointments (doctor_id, patient_id, appt_date, appt_time, purpose_of_visit, is_completed, is_available)
VALUES (1, 3, '2022-09-12', '08:00:00', 'hypochondriac', false, false);

SELECT * FROM appointments;


COMMIT TRANSACTION;


