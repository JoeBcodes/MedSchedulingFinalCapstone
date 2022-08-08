BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

DROP TABLE IF EXISTS doctors;

CREATE TABLE doctors (
        doctor_id SERIAL,
        first_name varchar(50) NOT NULL,
        last_name varchar(50) NOT NULL,
        phone varchar(15) NOT NULL,
        email varchar(100) NOT NULL,
        CONSTRAINT PK_doctor PRIMARY KEY (doctor_id)
        );
        
        
DROP TABLE IF EXISTS patients;

CREATE TABLE patients (

        patient_id SERIAL,
        first_name varchar(50),
        last_name varchar(50),
        phone varchar(50),
        email varchar(50),
        CONSTRAINT PK_patient_id PRIMARY KEY (patient_id)
);


DROP TABLE IF EXISTS office;

CREATE TABLE office (
        office_id SERIAL,
        name varchar(50) NOT NULL UNIQUE,
        address varchar(100) NOT NULL,
        phone varchar(15) NOT NULL,
        email varchar(50) NOT NULL,
        start_hours TIME NOT NULL,
        end_hours TIME NOT NULL,
        speciality varchar(50),
        hourly_rate DECIMAL,
        CONSTRAINT PK_office PRIMARY KEY (office_id)
);

DROP TABLE IF EXISTS appointments;

CREATE TABLE appointments (

	appt_id SERIAL,
	doctor_id int NOT NULL UNIQUE,
	patient_id int NOT NULL UNIQUE,
	appt_time TIMESTAMP NOT NULL,
	purpose_of_visit varchar(50) NOT NULL,
	is_completed boolean NOT NULL,
	is_available boolean NOT NULL,
	
	CONSTRAINT PK_appt_id PRIMARY KEY (appt_id),
	CONSTRAINT FK_doctor_id FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id),
	CONSTRAINT FK_patient_id FOREIGN KEY (patient_id) REFERENCES patients(patient_id)
);


DROP TABLE IF EXISTS doctors_in_office;

CREATE TABLE doctors_in_office (
        office_id int,
        doctor_id int,
        CONSTRAINT FK_office_id FOREIGN KEY (office_id) REFERENCES office(office_id),
        CONSTRAINT FK_doctor_id FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id)
        );

DROP TABLE IF EXISTS calendar;

CREATE TABLE calendar (
        doctor_id int NOT NULL UNIQUE,
        day_of_the_week varchar(10) NOT NULL,
        start_time time NOT NULL,
        end_time time NOT NULL,
        
        CONSTRAINT FK_doctor_id FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id)
        );


COMMIT TRANSACTION;


















































