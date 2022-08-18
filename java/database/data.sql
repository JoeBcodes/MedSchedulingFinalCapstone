BEGIN TRANSACTION;
DROP TABLE IF EXISTS doctors_in_office, office, appointments, calendar, reviews, users CASCADE;
CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	first_name varchar(50) NOT NULL,
        last_name varchar(50) NOT NULL,
        phone varchar(15) NOT NULL,
        email varchar(100) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);
CREATE TABLE office (
        office_id SERIAL,
        name varchar(50) NOT NULL UNIQUE,
        address varchar(100) NOT NULL,
        phone varchar(15) NOT NULL,
        email varchar(50) NOT NULL,
        start_hours TIME NOT NULL,
        end_hours TIME NOT NULL,
        specialty varchar(50),
        hourly_rate DECIMAL,
        CONSTRAINT PK_office PRIMARY KEY (office_id)
);
CREATE TABLE appointments (
	appt_id SERIAL,
	doctor_id int NOT NULL,
	patient_id int NOT NULL,
	appt_date varchar(10) NOT NULL,
	appt_time time NOT NULL,
	purpose_of_visit varchar(50) NOT NULL,
	is_read boolean NOT NULL,
	is_available boolean NOT NULL,
	
	CONSTRAINT PK_appt_id PRIMARY KEY (appt_id),
	CONSTRAINT FK_doctor_id FOREIGN KEY (doctor_id) REFERENCES users(user_id),
	CONSTRAINT FK_patient_id FOREIGN KEY (patient_id) REFERENCES users(user_id)
);
CREATE TABLE doctors_in_office (
        office_id int,
        doctor_id int UNIQUE,
        CONSTRAINT FK_office_id FOREIGN KEY (office_id) REFERENCES office(office_id),
        CONSTRAINT FK_doctor_id FOREIGN KEY (doctor_id) REFERENCES users(user_id)
);
CREATE TABLE calendar (
        calendar_id SERIAL,
        doctor_id int NOT NULL,
        day_of_the_week varchar(10) NOT NULL,
        start_time time NOT NULL,
        end_time time NOT NULL,
        CONSTRAINT FK_doctor_id FOREIGN KEY (doctor_id) REFERENCES users(user_id)
);
CREATE TABLE reviews (
        review_id SERIAL,
        reviewer_id int NOT NULL,
        doctor_id int NOT NULL,
        review_date date,
        review_desc varchar(200),
        rating int NOT NULL,
        doctor_reply varchar(200),
        CONSTRAINT PK_review_id PRIMARY KEY (review_id),
        CONSTRAINT FK_doctor_id FOREIGN KEY (doctor_id) REFERENCES users(user_id),
        CONSTRAINT FK_reviewer_id FOREIGN KEY (reviewer_id) REFERENCES users(user_id),
        CONSTRAINT FK_doctor_office FOREIGN KEY (doctor_id) REFERENCES doctors_in_office(doctor_id)
);
COMMIT TRANSACTION;
-----------------------------------------------------------------------------------------------------------------------
GRANT ALL
ON ALL TABLES IN SCHEMA public
TO final_capstone_owner;
GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO final_capstone_owner;
GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO final_capstone_appuser;
GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO final_capstone_appuser;
-----------------------------------------------------------------------------------------------------------------------
BEGIN TRANSACTION;
INSERT INTO users (username, password_hash, role, first_name, last_name, phone, email)
VALUES ('joshbernardino', '$2a$10$dYI9MPWnZQjWyiR8KQdp8e35o4Bh4eil/UmcWtjMD9s35FxyLX3G.', 'DOCTOR', 'Josh', 'Bernardino', '111-111-1111', 'josh.bernardino@gmail.com');
INSERT INTO users (username, password_hash, role, first_name, last_name, phone, email)
VALUES ('joebaca', '$2a$10$bXqGw2RQ2XaihhIwe5lxkeSE08Sreg9AbVZCWRowx1/u79Hywkq/W', 'DOCTOR', 'Joe', 'Baca', '222-222-2222', 'joe.baca@gmail.com');
INSERT INTO users (username, password_hash, role, first_name, last_name, phone, email)
VALUES ('joywang', '$2a$10$UYqu4oyUTFnkPXbwHuoy2ONXvoJDmV2zIiiu7VtaSK04uguy.Jevm', 'PATIENT', 'Joy', 'Wang', '333-333-3333', 'joy.wang@gmail.com');
INSERT INTO users (username, password_hash, role, first_name, last_name, phone, email)
VALUES ('rickprentice', '$2a$10$dYI9MPWnZQjWyiR8KQdp8e35o4Bh4eil/UmcWtjMD9s35FxyLX3G.', 'PATIENT', 'Rick', 'Prentice', '444-444-4444', 'rick.prentice@gmail.com');
INSERT INTO users (username, password_hash, role, first_name, last_name, phone, email)
VALUES ('kevinbatchelor', '$2a$10$dYI9MPWnZQjWyiR8KQdp8e35o4Bh4eil/UmcWtjMD9s35FxyLX3G.', 'PATIENT', 'Kevin', 'Batchelor', '555-555-5555', 'kevin.batchelor@gmail.com');
INSERT INTO users (username, password_hash, role, first_name, last_name, phone, email)
VALUES ('jaywu', '$2a$10$dYI9MPWnZQjWyiR8KQdp8e35o4Bh4eil/UmcWtjMD9s35FxyLX3G.', 'DOCTOR', 'Jay', 'Wu', '666-666-6666', 'jay.wu@gmail.com');
SELECT * FROM users;
INSERT INTO calendar (doctor_id, day_of_the_week, start_time, end_time)
VALUES (1, 'Monday', '08:00:00', '17:00:00');
INSERT INTO calendar (doctor_id, day_of_the_week, start_time, end_time)
VALUES (1, 'Tuesday', '08:00:00', '17:00:00');
INSERT INTO calendar (doctor_id, day_of_the_week, start_time, end_time)
VALUES (1, 'Wednesday', '08:00:00', '17:00:00');
INSERT INTO calendar (doctor_id, day_of_the_week, start_time, end_time)
VALUES (1, 'Thursday', '08:00:00', '17:00:00');
INSERT INTO calendar (doctor_id, day_of_the_week, start_time, end_time)
VALUES (1, 'Friday', '08:00:00', '17:00:00');
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
VALUES (6, 'Monday', '08:00:00', '17:00:00');
INSERT INTO calendar (doctor_id, day_of_the_week, start_time, end_time)
VALUES (6, 'Tuesday', '08:00:00', '17:00:00');
INSERT INTO calendar (doctor_id, day_of_the_week, start_time, end_time)
VALUES (6, 'Wednesday', '08:00:00', '17:00:00');
INSERT INTO calendar (doctor_id, day_of_the_week, start_time, end_time)
VALUES (6, 'Thursday', '08:00:00', '17:00:00');
INSERT INTO calendar (doctor_id, day_of_the_week, start_time, end_time)
VALUES (6, 'Friday', '08:00:00', '17:00:00');
SELECT * FROM calendar;
INSERT INTO office (name, address, phone, email, start_hours, end_hours, specialty, hourly_rate)
VALUES ('Med Elevator', '5960 Berkshire Ln, Dallas, TX 75225', '877-606-3203', 'office@medelevator.com', '07:00:00', '17:00:00', 'General Practice', 300.0);
INSERT INTO office (name, address, phone, email, start_hours, end_hours, specialty, hourly_rate)
VALUES ('Med Dental', '1234 New Rd, Los Angeles, CA 92541', '123-456-7890', 'office@meddental.com', '07:00:00', '17:00:00', 'Dental', 150.0);
SELECT * FROM office;
INSERT INTO doctors_in_office (office_id, doctor_id)
VALUES (1, 1);
INSERT INTO doctors_in_office (office_id, doctor_id)
VALUES (1, 2);
INSERT INTO doctors_in_office (office_id, doctor_id)
VALUES (2, 6);
SELECT * FROM doctors_in_office;
INSERT INTO reviews (reviewer_id, doctor_id, review_date, review_desc, rating)
VALUES (3, 1, '2022-08-01', 'Doctor made me feel that I was in good hands.', 5);
INSERT INTO reviews (reviewer_id, doctor_id, review_date, review_desc, rating)
VALUES (4, 2, '2022-08-03', 'It was alright. The doctor made me wait for a long time.', 3);
INSERT INTO reviews (reviewer_id, doctor_id, review_date, review_desc, rating)
VALUES (5, 1, '2022-08-05', 'The food was great!', 5);
INSERT INTO reviews (reviewer_id, doctor_id, review_date, review_desc, rating)
VALUES (4, 2, '2022-08-07', 'I really like the online check-in', 4);
SELECT * FROM reviews;
INSERT INTO appointments (doctor_id, patient_id, appt_date, appt_time, purpose_of_visit, is_read, is_available)
VALUES (1, 3, '2022-09-12', '02:00:00', 'flu symptoms', false, true);
INSERT INTO appointments (doctor_id, patient_id, appt_date, appt_time, purpose_of_visit, is_read, is_available)
VALUES (2, 4, '2022-10-17', '08:30:00', 'runny nose', true, false);
INSERT INTO appointments (doctor_id, patient_id, appt_date, appt_time, purpose_of_visit, is_read, is_available)
VALUES (1, 4, '2022-09-07', '08:00:00', '', false, false);
INSERT INTO appointments (doctor_id, patient_id, appt_date, appt_time, purpose_of_visit, is_read, is_available)
VALUES (2, 5, '2022-07-24', '09:00:00', 'flu symptoms', false, true);
INSERT INTO appointments (doctor_id, patient_id, appt_date, appt_time, purpose_of_visit, is_read, is_available)
VALUES (1, 3, '2022-04-30', '03:30:00', 'runny nose', true, false);
INSERT INTO appointments (doctor_id, patient_id, appt_date, appt_time, purpose_of_visit, is_read, is_available)
VALUES (2, 5, '2022-08-16', '08:00:00', 'my stomache hurts', false, false);
INSERT INTO appointments (doctor_id, patient_id, appt_date, appt_time, purpose_of_visit, is_read, is_available)
VALUES (1, 5, '2022-11-09', '09:00:00', 'allergies', false, false);
INSERT INTO appointments (doctor_id, patient_id, appt_date, appt_time, purpose_of_visit, is_read, is_available)
VALUES (2, 4, '2022-12-14', '11:00:00', 'I just want someone to talk to', false, false);
INSERT INTO appointments (doctor_id, patient_id, appt_date, appt_time, purpose_of_visit, is_read, is_available)
VALUES (6, 4, '2022-12-14', '11:00:00', 'root canal appointment', false, false);
INSERT INTO appointments (doctor_id, patient_id, appt_date, appt_time, purpose_of_visit, is_read, is_available)
VALUES (6, 4, '2022-08-01', '11:00:00', 'root canal appointment', false, false);
INSERT INTO appointments (doctor_id, patient_id, appt_date, appt_time, purpose_of_visit, is_read, is_available)
VALUES (6, 4, '2022-08-05', '11:00:00', 'root canal appointment', false, false);
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
ORDER BY appt_date ASC, appt_time ASC;
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