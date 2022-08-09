BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO users (username, password_hash, role, first_name, last_name, phone, email) VALUES ('joshbernardino', '', '', 'Josh', 'Bernardino', '111-111-1111', 'josh.bernardino@gmail.com');
INSERT INTO users (username, password_hash, role, first_name, last_name, phone, email) VALUES ('joebaca', '', '', 'Joe', 'Baca', '222-222-2222', 'joe.baca@gmail.com');
INSERT INTO users (username, password_hash, role, first_name, last_name, phone, email) VALUES ('joywang', '', '', 'Joy', 'Wang', '333-333-3333', 'joy.wang@gmail.com');
INSERT INTO users (username, password_hash, role, first_name, last_name, phone, email) VALUES ('rickprentice', '', '', 'Rick', 'Prentice', '444-444-4444', 'rick.prentice@gmail.com');

INSERT INTO calendar (doctor_id, day_of_the_week, start_time, end_time)
VALUES (3, 'Monday', '2022-08-09 08:00:00', '2022-08-09 17:00:00');
INSERT INTO calendar (doctor_id, day_of_the_week, start_time, end_time)
VALUES (4, 'Tuesday', '2022-08-10 08:00:00', '2022-08-10 17:00:00');

INSERT INTO office (office_name, address, phone, email, start_hours, end_hours, specialty, hourly_rate) VALUES ('Med Elevator', '5960 Berkshire ln, Dallas, TX 75225', '877-606-3203', 'office@medelevator.com', '07:00:00', '17:00:00', 'General', 50000);

INSERT INTO reviews (reviewer_id, doctor_id, review_date, review_desc, rating)
VALUES (2, 3, '2022-08-01 09:00:00', 'Very Professional. Good diagnosis. I DID have a quarter stuck up there. 10/10.', 5);
INSERT INTO reviews (reviewer_id, doctor_id, review_date, review_desc, rating)
VALUES (2, 4, '2022-08-03 10:00:00', 'It was alright.', 4);
INSERT INTO reviews (reviewer_id, doctor_id, review_date, review_desc, rating)
VALUES (2, 3, '2022-08-05 11:30:00', 'Doctor Bozo was not funny. I was expecting a funny doctor, ya know, because of the name.', 3);
INSERT INTO reviews (reviewer_id, doctor_id, review_date, review_desc, rating)
VALUES (2, 4, '2022-08-07 12:34:00', 'Would not eat here again!', 1);

COMMIT TRANSACTION;
