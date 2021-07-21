SET search_path = ers,public;

CREATE TABLE reimbursement_status(
	reimb_status_id SERIAL PRIMARY KEY,
	reimb_status VARCHAR(10) NOT NULL UNIQUE
);

CREATE TABLE reimbursement_type(
	reimb_type_id SERIAL PRIMARY KEY,
	reimb_type VARCHAR(10) NOT NULL UNIQUE
);

CREATE TABLE user_roles(
	user_role_id SERIAL PRIMARY KEY,
	user_role VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE users(
	ers_users_id SERIAL PRIMARY KEY,
	ers_username VARCHAR(50) NOT NULL UNIQUE,
	ers_password VARCHAR(50) NOT NULL,
	user_first_name VARCHAR(100) NOT NULL,
	user_last_name VARCHAR(100) NOT NULL,
	user_email VARCHAR(150) NOT NULL,
	user_role_id INT REFERENCES user_roles(user_role_id)
);

CREATE TABLE reimbursements(
	reimb_id SERIAL PRIMARY KEY,
	reimb_amount INT NOT NULL,
	reimb_submitted TEXT NOT NULL,
	reimb_resolved TEXT,
	reimb_description VARCHAR(250),
	reimb_author INT REFERENCES users(ers_users_id) NOT NULL,
	reimb_resolver INT REFERENCES users(ers_users_id) NOT NULL,
	reimb_status_id INT REFERENCES reimbursement_status(reimb_status_id) NOT NULL,
	reimb_type_id INT REFERENCES reimbursement_type(reimb_type_id) NOT NULL
	);

DROP TABLE reimbursements;

INSERT INTO reimbursement_status(reimb_status) VALUES ('PENDING');
INSERT INTO reimbursement_status(reimb_status) VALUES ('APPROVED');
INSERT INTO reimbursement_status(reimb_status) VALUES ('DENIED');

SELECT * FROM reimbursement_status;

INSERT INTO reimbursement_type(reimb_type) VALUES ('LODGING');
INSERT INTO reimbursement_type(reimb_type) VALUES ('TRAVEL');
INSERT INTO reimbursement_type(reimb_type) VALUES ('FOOD');
INSERT INTO reimbursement_type(reimb_type) VALUES ('OTHER');

SELECT * FROM reimbursement_type;

INSERT INTO user_roles (user_role) VALUES ('MANAGER');
INSERT INTO user_roles (user_role) VALUES ('EMPLOYEE');

SELECT * FROM user_roles;

INSERT INTO users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES('jidelson', 'jojo123', 'Joe', 'Idelson', 'joeidelson@gmail.com', 1);
INSERT INTO users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES('dfischer', 'fishman90', 'Danny', 'Fischer', 'dfischer@gmail.com', 1);
INSERT INTO users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES('chames', 'kitkit9100', 'Chris', 'Haman', 'chrissyglord@aol.com', 1);
INSERT INTO users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES('klinares85', 'burra4l503', 'Kenny', 'Linares', 'kennyclinares@gmail.com', 1);
INSERT INTO users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES('jairolin', 'liljonak13', 'Bairon', 'Linares', 'blinares@hotmail.com', 1);
INSERT INTO users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES('drjeff', 'trainguy46', 'Jeffrey', 'Louis', 'drjeff1946@gmail.com', 1);
INSERT INTO users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES('mimers', 'rhodeymimez123', 'Miriam', 'Schaffer', 'memeschafes@gmail.com', 1);
INSERT INTO users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES('samjose', 'rossmoor5150', 'Joe', 'Ptarmigan', 'amijomd@aol.com', 1);
INSERT INTO users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES('joeylev', 'windyCity2333', 'Joey', 'Levine', 'chitownspitta@yahoo.com', 1);
INSERT INTO users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES('alexRog', 'reemdoggyoms925', 'Alex', 'Rogers', 'elcerritokid@hotmail.com', 1);
INSERT INTO users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES('macdre', '3czdown707', 'Andre', 'Hicks', 'furlyghost@gmail.com', 2);
INSERT INTO users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES('jaytee', 'vtown4eversev07', 'Jaime', 'Trujillo', 'jaimetrago@aol.com', 2);
INSERT INTO users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES('kingNicky', 'dreDog4fifteenP', 'Andre', 'Nickatina', 'nickytpisces@yahoo.com', 2);

SELECT * FROM users;

INSERT INTO reimbursements(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES (155.19, '2020-10-22', '2020-10-28', 'motel', 5, 13, 2, 1); 
INSERT INTO reimbursements(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES (50.48, '2020-05-12', '2020-05-23', 'gas', 3, 11, 2, 2); 
INSERT INTO reimbursements(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES (80.94, '2020-12-14', '2020-01-05', 'sushi', 6, 12, 2, 3); 
INSERT INTO reimbursements(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES (29.99, '2020-01-28', '2020-02-01', 'itunes', 2, 11, 3, 4); 
INSERT INTO reimbursements(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES (31.02, '2020-02-16', null, 'burgers', 7, 11, 1, 3); 
INSERT INTO reimbursements(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES (50.62, '2020-11-05', '2020-11-23', 'shoes', 4, 13, 3, 4); 
INSERT INTO reimbursements(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES (17.69, '2020-03-15', '2020-03-27', 'coolant', 1, 12, 2, 2);

SELECT * FROM reimbursements;

SHOW search_path;

