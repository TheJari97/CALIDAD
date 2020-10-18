CREATE DATABASE Proyecto_ANALISIS;

USE Proyecto_ANALISIS;

CREATE TABLE LOGIN(
usuario nvarchar(15) primary key,
contrasenia nvarchar(20) not null
);

CREATE TABLE PROVEEDOR(
idProveedor	int AUTO_INCREMENT primary key,
Nombre		nvarchar(20) not null
);

CREATE TABLE CLIENTE(
idCLiente	int AUTO_INCREMENT primary key,
nombre		varchar(35) not null,
apellido	varchar(35)	not null,
telefono	nchar(9)
);

CREATE TABLE EMPLEADO(
codEmpleado		int AUTO_INCREMENT primary key,
nombre		varchar(35) not null,
apellido	varchar(35)	not null
);

CREATE TABLE PRODUCTO(
codProducto	int AUTO_INCREMENT primary key,
descripcion	nvarchar(50)	not null,
precioUni	decimal(6,2) not null,
Stock		int not null,
idProveedor int REFERENCES PROVEEDOR
);

CREATE TABLE VENTA(
NumVenta		int AUTO_INCREMENT primary key,
precioT		decimal(6,2),
fechaE		date not null,
idCliente	int REFERENCES CLIENTE,
codEmpleado	int REFERENCES EMPLEADO
);

CREATE TABLE DET_VENTA(
NumVenta		int REFERENCES VENTA,
codProducto	int REFERENCES PRODUCTO,
cantidad	int not null,
precioN		decimal(6,2)
);

INSERT INTO LOGIN (usuario,contrasenia) VALUES ('Administrador','admin'),('User01','12345'),
					('User02','123456'),('User03','1234567');
                    
INSERT INTO EMPLEADO (nombre,apellido) VALUES ('Miguel','Castillo'),
											('Anna','Herrera');
                                            
INSERT INTO PROVEEDOR (Nombre) VALUES ('HP'),
										('Razer'),
										('CoolBox'),
										('College'),
										('Vans'),
										('Apple'),
										('DC'),
										('VERO MODA');
                                        
INSERT INTO PRODUCTO(descripcion,precioUni,Stock,idProveedor) VALUES ('Mouse',50.35,708,2),
													   ('Laptop',4235.86,1689,1),
													   ('Teclado',50.35,599,2),
													   ('Cuaderno',5.25,1885,4),
													   ('USB 8GB',20.25,556,1),
													   ('USB 16GB',35.45,672,3),
													   ('USB 32GB',48.95,1242,3),
													   ('USB 64GB',60.45,152,3),
													   ('Cargador Iphone',80.50,261,6),
													   ('Cartuchera',5.68,5263,4),
													   ('Cargador',65.15,578,3),
													   ('Bateria portatil',58.51,141,3),
													   ('Memoria 1TB',199.99,354,1),
													   ('Memoria 2TB',299.99,452,6),
													   ('Memoria 5TB',399.99,95,6),
													   ('Regla 20cm',1.35,5489,4),
													   ('Agenda 2019',26.46,1556,4),
													   ('Goma',3.35,845,4),
													   ('Zapatillas',89.99,989,5),
													   ('Zapatos',89.99,979,5),
													   ('Camisa',99.99,1664,7),
													   ('Pantalon',99.99,1945,7),
													   ('Labial',5.00,456,3),
													   ('Corbata',28.98,103,5),
													   ('Iphone X',4559.99,979,7);
                                                       
INSERT INTO CLIENTE (nombre,apellido,telefono) VALUES ('Alex','Sierra',null);

SELECT * FROM LOGIN;
SELECT * FROM EMPLEADO;
SELECT * FROM PRODUCTO;
SELECT * FROM CLIENTE;
SELECT * FROM PROVEEDOR;
SELECT * FROM DET_VENTA;
SELECT * FROM VENTA;