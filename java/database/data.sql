BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role, first_name, last_name, phone, email) 
VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'Larry', 'Lobster', '555-555-5555', 'larry@gmail.com');

INSERT INTO users (username, password_hash, role, first_name, last_name, phone, email) VALUES ('joshbernardino', '$2a$10$dYI9MPWnZQjWyiR8KQdp8e35o4Bh4eil/UmcWtjMD9s35FxyLX3G.', 'DOCTOR', 'Josh', 'Bernardino', '111-111-1111', 'josh.bernardino@gmail.com');
INSERT INTO users (username, password_hash, role, first_name, last_name, phone, email) VALUES ('joebaca', '$2a$10$bXqGw2RQ2XaihhIwe5lxkeSE08Sreg9AbVZCWRowx1/u79Hywkq/W', 'DOCTOR', 'Joe', 'Baca', '222-222-2222', 'joe.baca@gmail.com');
INSERT INTO users (username, password_hash, role, first_name, last_name, phone, email) VALUES ('joywang', '$2a$10$UYqu4oyUTFnkPXbwHuoy2ONXvoJDmV2zIiiu7VtaSK04uguy.Jevm', 'PATIENT', 'Joy', 'Wang', '333-333-3333', 'joy.wang@gmail.com');
INSERT INTO users (username, password_hash, role, first_name, last_name, phone, email) VALUES ('rickprentice', '$2a$10$dYI9MPWnZQjWyiR8KQdp8e35o4Bh4eil/UmcWtjMD9s35FxyLX3G.', 'PATIENT', 'Rick', 'Prentice', '444-444-4444', 'rick.prentice@gmail.com');


SELECT * FROM users;

INSERT INTO calendar (doctor_id, day_of_the_week, start_time, end_time) 
VALUES (2, 'Monday', '08:00:00', '17:00:00');
INSERT INTO calendar (doctor_id, day_of_the_week, start_time, end_time) 
VALUES (2, 'Tuesday', '08:00:00', '17:00:00');
INSERT INTO calendar (doctor_id, day_of_the_week, start_time, end_time) 
VALUES (2, 'Wednesday', '08:00:00', '17:00:00');
INSERT INTO calendar (doctor_id, day_of_the_week, start_time, end_time) 
VALUES (2, 'Thursday', '08:00:00', '17:00:00');
INSERT INTO calendar (doctor_id, day_of_the_week, start_time, end_time) 
VALUES (2, 'Friday', '08:00:00', '17:00:00');
INSERT INTO calendar (doctor_id, day_of_the_week, start_time, end_time) 
VALUES (3, 'Monday', '08:00:00', '17:00:00');
INSERT INTO calendar (doctor_id, day_of_the_week, start_time, end_time) 
VALUES (3, 'Tuesday', '08:00:00', '17:00:00');
INSERT INTO calendar (doctor_id, day_of_the_week, start_time, end_time) 
VALUES (3, 'Wednesday', '08:00:00', '17:00:00');
INSERT INTO calendar (doctor_id, day_of_the_week, start_time, end_time) 
VALUES (3, 'Thursday', '08:00:00', '17:00:00');
INSERT INTO calendar (doctor_id, day_of_the_week, start_time, end_time) 
VALUES (3, 'Friday', '08:00:00', '17:00:00');

SELECT * FROM calendar;

INSERT INTO office (name, address, phone, email, start_hours, end_hours, specialty, hourly_rate) 
VALUES ('Med Elevator', '5960 Berkshire Ln, Dallas, TX 75225', '877-606-3203', 'office@medelevator.com', '07:00:00', '17:00:00', 'General', 50000.0);
INSERT INTO office (name, address, phone, email, start_hours, end_hours, specialty, hourly_rate)
VALUES ('Test Med Dental', '1234 New Rd, Los Angeles, CA 92541', '123-456-7890', 'office@testmeddental.com', '07:00:00', '17:00:00', 'Dental', 900000.0);

SELECT * FROM office;

INSERT INTO doctors_in_office (office_id, doctor_id)
VALUES (1, 2);
INSERT INTO doctors_in_office (office_id, doctor_id)
VALUES (1, 3);

INSERT INTO reviews (reviewer_id, doctor_id, review_date, review_desc, rating)
VALUES (1, 2, '2022-08-01', 'Very Professional. Good diagnosis. I DID have a quarter stuck up there. 10/10.', 5);
INSERT INTO reviews (reviewer_id, doctor_id, review_date, review_desc, rating)
VALUES (1, 3, '2022-08-03', 'It was alright.', 4);
INSERT INTO reviews (reviewer_id, doctor_id, review_date, review_desc, rating)
VALUES (1, 2, '2022-08-05', 'Doctor Bozo was not funny. I was expecting a funny doctor, ya know, because of the name.', 3);
INSERT INTO reviews (reviewer_id, doctor_id, review_date, review_desc, rating)
VALUES (1, 3, '2022-08-07', 'Would not eat here again!', 1);

SELECT * FROM reviews;

INSERT INTO appointments (doctor_id, patient_id, appt_date, appt_time, purpose_of_visit, is_read, is_available)
VALUES (2, 4, '2022-09-12', '07:00:00', 'flu symptoms', false, true);
INSERT INTO appointments (doctor_id, patient_id, appt_date, appt_time, purpose_of_visit, is_read, is_available)
VALUES (2, 5, '2022-09-12', '07:30:00', 'runny nose', true, false);
INSERT INTO appointments (doctor_id, patient_id, appt_date, appt_time, purpose_of_visit, is_read, is_available)
VALUES (2, 4, '2022-09-12', '08:00:00', 'hypochondriac', false, false);
INSERT INTO appointments (doctor_id, patient_id, appt_date, appt_time, purpose_of_visit, is_read, is_available)
VALUES (3, 4, '2022-09-12', '07:00:00', 'flu symptoms', false, true);
INSERT INTO appointments (doctor_id, patient_id, appt_date, appt_time, purpose_of_visit, is_read, is_available)
VALUES (3, 5, '2022-09-12', '07:30:00', 'runny nose', true, false);
INSERT INTO appointments (doctor_id, patient_id, appt_date, appt_time, purpose_of_visit, is_read, is_available)
VALUES (3, 5, '2022-09-12', '08:00:00', 'hypochondriac', false, false);

SELECT * FROM appointments;

SELECT a.doctor_id, du.first_name ||' '|| du.last_name AS doctor_name, a.patient_id, pu.first_name ||' '|| pu.last_name AS patient_name, a.appt_date, a.appt_time, a.purpose_of_visit, a.is_read, a.is_available
FROM appointments a
JOIN users du
ON a.doctor_id = du.user_id
JOIN users pu
ON a.patient_id = pu.user_id
WHERE doctor_id = 1 AND is_available = false;

SELECT appt_id, doctor_id, patient_id, appt_date, appt_time, purpose_of_visit, is_read, is_available
FROM appointments 
WHERE appt_id = 1;

SELECT a.appt_id, a.doctor_id, du.first_name ||' '|| du.last_name AS doctor_name, 
                a.patient_id, pu.first_name ||' '|| pu.last_name AS patient_name, 
                a.appt_date, a.appt_time, a.purpose_of_visit, a.is_read, a.is_available 
                FROM appointments a 
                JOIN users du 
                ON a.doctor_id = du.user_id 
                JOIN users pu 
                ON a.patient_id = pu.user_id 
                WHERE is_read = false;
                
           

COMMIT TRANSACTION;


