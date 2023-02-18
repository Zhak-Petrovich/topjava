DELETE FROM meals;
DELETE FROM user_role;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('Vasia', 'user@yandex.ru', 'password'),
       ('Petia', 'admin@gmail.com', 'admin'),
       ('Vova', 'guest@gmail.com', 'guest');

INSERT INTO user_role (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001);

INSERT INTO meals (user_id, date_time, description, calories)
VALUES (100000, '2022-08-08 12:15:00', 'Завтрак', 1000),
       (100000, '2022-08-08 16:30:00', 'Обед', 600),
       (100000, '2022-08-08 20:45:00', 'Ужин', 500),
       (100001, '2022-08-08 12:15:00', 'Завтрак', 1000),
       (100001, '2022-08-08 16:30:00', 'Обед', 500),
       (100001, '2022-08-08 20:45:00', 'Ужин', 500);