-- Bases de datos de los microservicios
CREATE DATABASE usuarios_db;
CREATE DATABASE mascotas_db;
CREATE DATABASE reportes_db;
CREATE DATABASE notificaciones_db;

-- Usuario de la aplicación
CREATE USER 'myuser'@'%' IDENTIFIED BY 'password';

GRANT ALL ON usuarios_db.* TO 'myuser'@'%';
GRANT ALL ON mascotas_db.* TO 'myuser'@'%';
GRANT ALL ON reportes_db.* TO 'myuser'@'%';
GRANT ALL ON notificaciones_db.* TO 'myuser'@'%';

FLUSH PRIVILEGES;