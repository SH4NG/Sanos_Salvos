CREATE DATABASE IF NOT EXISTS usuarios_db;
CREATE DATABASE IF NOT EXISTS mascotas_db;
CREATE DATABASE IF NOT EXISTS reportes_db;
CREATE DATABASE IF NOT EXISTS notificaciones_db;

GRANT ALL PRIVILEGES ON usuarios_db.* TO 'myuser'@'%';
GRANT ALL PRIVILEGES ON mascotas_db.* TO 'myuser'@'%';
GRANT ALL PRIVILEGES ON reportes_db.* TO 'myuser'@'%';
GRANT ALL PRIVILEGES ON notificaciones_db.* TO 'myuser'@'%';

FLUSH PRIVILEGES;