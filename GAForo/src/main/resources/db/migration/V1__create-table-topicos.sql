CREATE TABLE topicos (
     id BIGINT NOT NULL AUTO_INCREMENT,
     titulo VARCHAR(100) NOT NULL,
     mensaje VARCHAR(200) NOT NULL,
     fecha_de_creacion datetime NOT NULL,
     status VARCHAR (10) NOT NULL,
     nombre VARCHAR(1000) NOT NULL,
     edad VARCHAR(100) NOT NULL,
     correo VARCHAR(100) NOT NULL,
     curso VARCHAR(100) NOT NULL,
     PRIMARY KEY (id)
);