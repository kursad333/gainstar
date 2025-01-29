CREATE USER 'PMA'@'%' IDENTIFIED BY 'pma-pw';
GRANT ALL ON *.* TO 'PMA'@'%';

CREATE USER 'gainstar'@'%' IDENTIFIED BY 'gainstar-pw';
CREATE DATABASE IF NOT EXISTS `gainstar` CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
GRANT ALL ON `gainstar`.* TO 'gainstar'@'%';
