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
	appt_date date NOT NULL,
	appt_time time NOT NULL,
	purpose_of_visit varchar(50) NOT NULL,
	is_completed boolean NOT NULL,
	is_available boolean NOT NULL,
	
	CONSTRAINT PK_appt_id PRIMARY KEY (appt_id),
	CONSTRAINT FK_doctor_id FOREIGN KEY (doctor_id) REFERENCES users(user_id),
	CONSTRAINT FK_patient_id FOREIGN KEY (patient_id) REFERENCES users(user_id)
);

CREATE TABLE doctors_in_office (
        office_id int,
        doctor_id int,
        CONSTRAINT FK_office_id FOREIGN KEY (office_id) REFERENCES office(office_id),
        CONSTRAINT FK_doctor_id FOREIGN KEY (doctor_id) REFERENCES users(user_id)
);

CREATE TABLE calendar (
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
        CONSTRAINT PK_review_id PRIMARY KEY (review_id),
        CONSTRAINT FK_doctor_id FOREIGN KEY (doctor_id) REFERENCES users(user_id),
        CONSTRAINT FK_reviewer_id FOREIGN KEY (reviewer_id) REFERENCES users(user_id)
);

COMMIT TRANSACTION;


