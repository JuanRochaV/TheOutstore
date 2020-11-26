DROP DATABASE theoutstore;
CREATE DATABASE theoutstore;
USE theoutstore;

CREATE TABLE venta(
clave bigint AUTO_INCREMENT NOT NULL,
fecha datetime NOT NULL,
id_usuario bigint NOT NULL,
total decimal(16,2),
PRIMARY KEY (clave)
);

CREATE TABLE concepto(
clave bigint AUTO_INCREMENT NOT NULL,
id_venta bigint NOT NULL,
cantidad int NOT NULL,
precioUnitario decimal(16,2) NOT NULL,
importe decimal(16,2) NOT NULL,
id_producto bigint NOT NULL,
PRIMARY KEY (clave)
);

CREATE TABLE productos(
clave bigint AUTO_INCREMENT NOT NULL,
nombre varchar(50) NOT NULL,
precioUnitario decimal(16,2) NOT NULL,
id_proveedor bigint NOT NULL,
costo decimal(16,2) NOT NULL,
PRIMARY KEY (clave)
);

CREATE TABLE usuarios(
clave bigint AUTO_INCREMENT NOT NULL,
nombre varchar(50) NOT NULL,
email varchar(50) NOT NULL,
ciudad varchar(50) NOT NULL,
rfc varchar(50) NOT NULL,
usuario varchar(50) NOT NULL,
PRIMARY KEY (clave)
);

CREATE TABLE proveedores(
clave bigint AUTO_INCREMENT NOT NULL,
nombre varchar(50) NOT NULL,
direccion varchar(50) NOT NULL,
email varchar(50) NOT NULL,
paginaWeb varchar(50) NOT NULL,
PRIMARY KEY (clave)
);

CREATE TABLE carrito(
clave bigint AUTO_INCREMENT NOT NULL,
id_usuario bigint NOT NULL,
id_producto bigint NOT NULL,
cantidad int NOT NULL,
PRIMARY KEY (clave)
);

ALTER TABLE concepto
ADD FOREIGN KEY (id_venta) REFERENCES venta(clave),
ADD FOREIGN KEY (id_producto) REFERENCES productos(clave);

ALTER TABLE venta
ADD FOREIGN KEY (id_usuario) REFERENCES usuarios(clave);

ALTER TABLE productos
ADD FOREIGN KEY (id_proveedor) REFERENCES proveedores(clave);

ALTER TABLE carrito
ADD FOREIGN KEY (id_usuario) REFERENCES usuarios(clave),
ADD FOREIGN KEY (id_producto) REFERENCES productos(clave);



