INSERT INTO roles (id, description, role) VALUES (1, 'User has rights to add customers', 'ADMIN');
INSERT INTO roles (id, description, role) VALUES (2, 'User doesnt have rights to add customers', 'NORMAL');
INSERT INTO users (id, login, password, role_id) VALUES (1, 'admin', 'admin', 1);
INSERT INTO users (id, login, password, role_id) VALUES (2, 'user', 'user', 2);