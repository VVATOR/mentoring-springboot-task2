DROP TABLE IF EXISTS user
CREATE TABLE user (id int(11)  AUTO_INCREMENT,name varchar(255) DEFAULT NULL,surname varchar(255) DEFAULT NULL,birth date DEFAULT NULL,  PRIMARY KEY (`id`))
DROP TABLE IF EXISTS friendships
CREATE TABLE friendships (id int(11)  AUTO_INCREMENT,userid1 int(11) NOT NULL,userid2 int(11) NOT NULL,timestamp timestamp DEFAULT CURRENT_TIMESTAMP)