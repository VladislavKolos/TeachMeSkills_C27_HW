CREATE TABLE "employees"
(
    employee_id    INTEGER,
    first_name     VARCHAR(20),
    last_name      VARCHAR(25) NOT NULL,
    email          VARCHAR(25) NOT NULL UNIQUE,
    phone_number   VARCHAR(20),
    hire_date      DATE        NOT NULL,
    salary         NUMERIC(8, 2),
    commission_pct NUMERIC(2, 2),
    department_id  INTEGER,
    PRIMARY KEY (employee_id)
);

INSERT INTO "employees"
VALUES (1, 'Vladislav', 'Kolos', 'vladislav.y@gmail.com', '+375 (29) 123.45.67', 'July 14, 1999', 50000.55, 0.11, 10),
       (2, 'Vladislav2', 'Kolos2', 'vladislav.x@gmail.com', '+375 (29) 234.56.78', 'July 15, 1998', 40000.45, 0.09, 20),
       (3, 'Vladislav3', 'Kolos3', 'vladislav.p@gmail.com', '+375 (29) 345.67.89', 'July 16, 1997', 30000.55, 0.13, 30),
       (4, 'Vladislav4', 'Kolos4', 'vladislav.u@gmail.com', '+375 (29) 123.66.77', 'May 14, 1999', 10000.99, 0.99, 50),
       (5, 'Vladislav5', 'Kolos5', 'vladislav.i@gmail.com', '+375 (29) 110.45.67', 'April 25, 1997', 80000.55, 0.01,
        50),
       (6, 'Vladislav6', 'Kolos6', 'vladislav.t@gmail.com', '+375 (29) 123.00.12', 'December 19, 1996', 90000.00, 0.20,
        80);

INSERT INTO "employees"(employee_id, first_name, last_name, email, phone_number, hire_date, salary, department_id)
VALUES (7, 'Vladislava', 'Kolos7', 'vladislav.n@gmail.com', '+375 (29) 121-05-67', 'October 11, 1997', 50000.55, 10),
       (8, 'Vladislava', 'Kolos8', 'vladislav.q@gmail.com', '+375 (29) 122-54-00', 'January 8, 1999', 71699.55, 50),
       (9, 'Vladislava', 'Kolos9', 'vladislav.l@gmail.com', '+375 (29) 222-54-11', 'June 9, 1993', 70080.55, 80);

SELECT *
FROM "employees"
WHERE department_id = 50
  AND salary > 4000;

SELECT *
FROM "employees"
WHERE first_name LIKE '%a';

SELECT *
FROM "employees"
WHERE (department_id = 50 OR department_id = 80)
  AND commission_pct IS NOT NULL;

SELECT *
FROM "employees"
WHERE salary >= 8000
  AND salary <= 9000;

SELECT employee_id,
       first_name,
       last_name,
       email,
       REPLACE(phone_number, '.', '-') AS phone_number,
       hire_date,
       salary,
       commission_pct,
       department_id
FROM "employees";

SELECT department_id, salary, COUNT(*) AS number_of_employees
FROM "employees"
GROUP BY department_id, salary;
SELECT department_id, salary, COUNT(*) AS number_of_employees
FROM "employees"
GROUP BY department_id, salary
HAVING COUNT(*) > 1;

SELECT *
FROM "employees"
WHERE LENGTH(first_name) = (SELECT MAX(LENGTH(first_name)) FROM "employees");

