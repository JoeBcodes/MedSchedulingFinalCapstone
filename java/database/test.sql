SELECT a.doctor_id, du.first_name ||''|| du.last_name AS doctor_name, 
                a.patient_id, pu.first_name ||''|| pu.last_name AS patient_name, 
                a.appt_date, a.appt_time, a.purpose_of_visit, a.is_read, a.is_available 
                FROM appointments a 
                JOIN users du 
                ON a.doctor_id = du.user_id 
                JOIN users pu 
                ON a.patient_id = pu.user_id 
                WHERE is_available = true;