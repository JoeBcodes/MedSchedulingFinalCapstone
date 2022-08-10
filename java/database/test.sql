SELECT r.review_id, r.reviewer_id, ru.first_name || ' ' || ru.last_name AS reviewer_name, 
                    r.review_date, r.doctor_id, du.first_name || ' ' || du.last_name AS doctor_name, 
                    r.review_desc, r.rating, o.name 
                FROM reviews r 
                JOIN users ru 
                ON r.reviewer_id = ru.user_id 
                JOIN users du 
                ON r.doctor_id = du.user_id 
                JOIN doctors_in_office dio 
                ON r.doctor_id = dio.doctor_id 
                JOIN office o 
                ON dio.office_id = o.office_id 
                WHERE r.doctor_id = 2;