DROP database tecnostore_db;
CREATE Database tecnostore_db;
Use tecnostore_db;

CREATE TABLE Marcas( 
	id int primary key auto_increment,
	nombre varchar(50) not null
);

CREATE TABLE Sistemas_operativos(
	id int primary key auto_increment,
	nombre varchar(50) not null
);

CREATE TABLE Celulares(
	id int primary key auto_increment,
	id_marca int not null,
	modelo varchar(50) not null,
	id_sistema_operativo int not null,
	gama ENUM("Baja", "Media", "Alta") not null,
	precio double not null,
	stock int not null,
	foreign key (id_marca) references Marcas(id),
	FOREIGN	KEY (id_sistema_operativo) references Sistemas_operativos(id)
);

CREATE TABLE Clientes(
	id int primary key auto_increment,
	nombre varchar(50) not null,
	tipo_identificacion Enum("Cedula", "TargetaIdentidad", "Pasaporte"),
	identificacion varchar(20) not null unique,
	correo varchar(50) not null unique,
	telefono int not null unique
);

CREATE TABLE Ventas(
	id int primary key auto_increment,
	id_cliente int not null,
	fecha TIMESTAMP default current_timestamp,
	total double not null,
	foreign key (id_cliente) references Clientes(id)
);

CREATE TABLE Detalles_venta(
	id int primary key auto_increment,
	id_venta int not null,
	id_celular int not null,
	foreign key (id_venta) references Ventas(id),
	foreign key (id_celular) references Celulares(id)
);

CREATE TABLE Credito(
	id int primary key auto_increment,
	id_cliente int not null,
	id_venta int not null,
	abonado double not null default 0,
	foreign key (id_cliente) references Clientes(id),
	foreign key (id_venta) references Ventas(id)
);



/*======================================== INSERCION DE DATOS INMUTABLES ========================================*/

INSERT INTO Sistemas_operativos(nombre)
values
("IOS"), ("Android"), ("HarmonyOS");
