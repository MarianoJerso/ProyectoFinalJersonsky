DROP TABLE CLIENTES IF EXISTS;
DROP TABLE PRODUCTOS IF EXISTS;
DROP TABLE COMPROBANTE IF EXISTS;

CREATE TABLE CLIENTES(
CLIENTEID INT NOT NULL AUTO_INCREMENT,
DNI INT NOT NULL,
NOMBRE VARCHAR(255) NOT NULL,
APELLIDO VARCHAR(255),
PRIMARY KEY(CLIENTEID)
);


CREATE TABLE PRODUCTOS(
PRODUCTOID INT NOT NULL AUTO_INCREMENT,
CODIGO INT NOT NULL,
DESCRIPCION VARCHAR(255) NOT NULL,
CANTIDAD INT NOT NULL,
PRECIO FLOAT NOT NULL,
PRIMARY KEY (PRODUCTOID)
);


CREATE TABLE COMPROBANTES(
COMPROBANTEID INT NOT NULL AUTO_INCREMENT,
FECHA DATETIME,
CANTIDAD INT NOT NULL,
TOTAL FLOAT NOT NULL,
CLIENTEID INT NOT NULL,
PRIMARY KEY (COMPROBANTEID),
CONSTRAINT FK_CLIENTES FOREIGN KEY (CLIENTEID)
REFERENCES CLIENTES(CLIENTEID)
);

CREATE TABLE LINEA (
    LINEAID INT NOT NULL AUTO_INCREMENT,
    DESCRIPCION VARCHAR(255) NOT NULL,
    CANTIDAD INT,
    PRECIO FLOAT,
    COMPROBANTEID INT NOT NULL,
    PRODUCTOID INT NOT NULL,
    PRIMARY KEY (lineaid),
    CONSTRAINT FK_COMPROBANTES FOREIGN KEY (COMPROBANTEID)
    REFERENCES COMPROBANTES(COMPROBANTEID),
    CONSTRAINT FK_PRODUCTOS FOREIGN KEY (PRODUCTOID)
    REFERENCES PRODUCTOS(PRODUCTOID)
);