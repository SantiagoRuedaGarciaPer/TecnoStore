# TecnoStore

Sistema de gestión para una tienda de celulares desarrollado en **Java** utilizando **Maven** y **MySQL**.

El proyecto permite administrar información relacionada con celulares, marcas, sistemas operativos, clientes y ventas mediante una aplicación de consola. La aplicación utiliza una arquitectura organizada por capas, separando los modelos de datos, acceso a la base de datos, lógica de control y presentación.

## Tecnologías utilizadas

* **Java 17**
* **Maven**
* **MySQL**
* **JDBC**
* **MySQL Connector/J 8.0.33**
* Arquitectura por capas
* Programación Orientada a Objetos

La configuración de Maven y las dependencias del proyecto se encuentran en `pom.xml`.

---

## 📋 Descripción del proyecto

**TecnoStore** es un sistema de gestión para una tienda de celulares que permite realizar diferentes operaciones sobre los datos de la tienda.

Entre sus principales funcionalidades se encuentran:

* Gestión de celulares.
* Gestión de marcas.
* Gestión de sistemas operativos.
* Gestión de clientes.
* Registro y consulta de ventas.
* Gestión del detalle de las ventas.
* Generación de reportes.
* Consulta de información almacenada en MySQL.

El sistema funciona mediante un menú principal desde el cual el usuario puede acceder a las diferentes funcionalidades de la aplicación.

La clase principal `TecnoStore` inicia la aplicación y posteriormente ejecuta el menú principal.

---

## Estructura del proyecto

```text
TecnoStore/
│
├── src/
│   └── main/
│       └── java/
│           │
│           ├── CONEXION_DB/
│           │   └── Conexion.java
│           │
│           ├── CONTROLADOR/
│           │   ├── Controller.java
│           │   ├── CelularController.java
│           │   ├── ClienteController.java
│           │   ├── MarcaController.java
│           │   ├── SistemaOperativoController.java
│           │   ├── VentasController.java
│           │   └── VentasDetalleController.java
│           │
│           ├── DAO/
│           │   ├── CelularDAO.java
│           │   ├── ClienteDAO.java
│           │   ├── MarcaDAO.java
│           │   ├── SistemaOperativoDAO.java
│           │   ├── VentasDAO.java
│           │   └── VentasDetalleDAO.java
│           │
|           ├── Utils/
|           |   ├── ReporteArchivo.java
|           |   ├── ReporteFunciones
|           |   └── ReporteController
|           | 
│           ├── MODELO/
│           │   ├── Celular.java
│           │   ├── Cliente.java
│           │   ├── Detalle_ventas.java
│           │   ├── Gama.java
│           │   ├── Marca.java
│           │   ├── Sistema_operativo.java
│           │   ├── Tipo_identificacion.java
│           │   ├── Ventas.java
│           │   └── VentasDetalle.java
│           │
│           ├── VISTA/
│           │   ├── MenuPrincipal.java
│           │   ├── MenuCelulares.java
│           │   ├── MenuClientes.java
│           │   ├── MenuMarcas.java
│           │   ├── MenuSistemasOperativos.java
│           │   ├── MenuVentas.java
│           │   ├── MenuReportes.java
│           │   ├── MenuInterface.java
│           │   └── Validaciones.java
│           │
│           └── cp/
│               └── integrador/
│                   └── tecnostore/
│                       └── TecnoStore.java
│
├── tecnostore.sql
├── pom.xml
└── .gitignore
```

La estructura anterior corresponde a los paquetes actualmente presentes en el repositorio.

---

## Estructura de clases

El proyecto está organizado principalmente en las siguientes capas:

###  MODELO

Contiene las clases que representan las entidades utilizadas por el sistema.
Cada clase representa una tabla en la base de datos

| Clase                 | Función                                                  |
| --------------------- | -------------------------------------------------------- |
| `Celular`             | Modelo de los celulares disponibles en la tienda.        |
| `Cliente`             | Modelo de los clientes registrados.                      |
| `Marca`               | Modelo de las marcas de celulares.                       |
| `Sistema_operativo`   | Modelo de los sistemas operativos disponibles.           |
| `Ventas`              | Modelo de una venta realizada.                           |
| `VentasDetalle`       | Modelo de los productos asociados a una venta.           |
| `Detalle_ventas`      | Modelo relacionado con el detalle de las ventas.         |
| `Gama`                | Enum utilizado para clasificar la gama de los celulares. |
| `Tipo_identificacion` | Enum utilizado para los tipos de identificación.         |

Estas clases se encuentran dentro del paquete `MODELO`.

###  DAO

Las clases DAO se encargan del acceso y manipulación de los datos almacenados en MySQL.

| Clase                 | Función                                                  |
| --------------------- | -------------------------------------------------------- |
| `CelularDAO`          | Operaciones relacionadas con celulares.                  |
| `ClienteDAO`          | Operaciones relacionadas con clientes.                   |
| `MarcaDAO`            | Operaciones relacionadas con marcas.                     |
| `SistemaOperativoDAO` | Operaciones relacionadas con sistemas operativos.        |
| `VentasDAO`           | Operaciones relacionadas con ventas.                     |
| `VentasDetalleDAO`    | Operaciones relacionadas con los detalles de las ventas. |

La capa DAO permite separar las consultas SQL y el acceso a la base de datos del resto de la aplicación.

### 🎮 CONTROLADOR

Los controladores conectan las opciones de la interfaz con las operaciones realizadas sobre los datos.

Entre ellos se encuentran:

| Clase                       | Función                                                              |
| ----------------------------| ---------------------------------------------------------------------|
| `Controller`                | Interfaz que brinda la estructura necesaria para un controlador.     |
| `CelularController`         | Controla operaciones relacionadas con clientes.                      |
| `ClienteController`         | Controla operaciones relacionadas con marcas.                        | 
| `MarcaController`           | Controla operaciones relacionadas con sistemas operativos.           |
| `VentasDAO`                 | Controla operaciones relacionadas con ventas.                        |
| `VentasDetalleDAO`          | Controla operaciones relacionadas con los detalles de las ventas.    |
| `SistemaOperativoController`| Controla operaciones relacionadas con los sistemas operativos        |
| `VentasController`          | Controla operaciones relacionadas con las ventas                     |
| `VentasDetalleController`   | Controla operaciones relacionadas con los detalles de una venta      |


### 🖥️ VISTA

La capa de vista contiene los menús de interacción con el usuario.

Entre las principales clases se encuentran:

* `MenuPrincipal`
* `MenuCelulares`
* `MenuClientes`
* `MenuMarcas`
* `MenuSistemasOperativos`
* `MenuVentas`
* `MenuReportes`
* `Validaciones`
* `MenuInterfaze`

Cada menu hereda de la interfaz `MenuInterfaze` la funcion menu, en la que interactua con el usuario.
El menu llama las funciones del controlador respectivo

`Validaciones` es un archivo para validar informacion ingresada por el usuario



### CONEXION_DB

Contiene la clase:

```text
Conexion.java
```

Esta clase se encarga de establecer la conexión JDBC entre Java y MySQL.

### Clase principal

La ejecución comienza en:

```text
cp.integrador.tecnostore.TecnoStore
```

Su método `main()` obtiene la instancia de `MenuPrincipal` y ejecuta el menú de la aplicación.

---

## ▶️ Ejemplo de ejecución

Al iniciar el programa se muestra el menú principal de TecnoStore.

Un ejemplo del flujo de ejecución sería:

```text
=================================
          TECNOSTORE
=================================

1. Gestión de celulares
2. Gestión de clientes
3. Gestión de marcas
4. Gestión de sistemas operativos
5. Gestión de ventas
6. Reportes
0. Salir

Seleccione una opción:
```

Por ejemplo, al ingresar a la sección de celulares, el usuario puede consultar y administrar los registros disponibles.

Un flujo de venta puede ser:

```text
Seleccione una opción: 5

========== VENTAS ==========

1. Registrar venta
2. Listar ventas
3. Buscar venta
4. Reportes de ventas
0. Regresar

Seleccione una opción: 1

Ingrese el ID del cliente:
1

Ingrese el ID del celular:
3

Venta registrada correctamente.
```

> **Nota:** El texto exacto de los menús puede variar dependiendo de los datos existentes en la base de datos y la version.

---

## Conexión con MySQL

### 1. Instalar MySQL

Se necesita tener instalado y ejecutándose un servidor **MySQL**.

El proyecto utiliza:

```text
Host: localhost
Puerto: 3306
Base de datos: tecnostore_db
```

### 2. Crear la base de datos

El repositorio incluye el archivo:

```text
tecnostore.sql
```

Este archivo contiene la estructura necesaria para crear la base de datos `tecnostore_db`, incluyendo tablas como:

* `Marcas`
* `Sistemas_operativos`
* `Celulares`
* `Clientes`
* Ventas y sus detalles

Para instalarla, desde MySQL Workbench, DBeaver o la consola de MySQL se debe ejecutar el contenido del archivo `tecnostore.sql`.

Por ejemplo:

```sql
SOURCE ruta/del/proyecto/tecnostore.sql;
```

O simplemente abrir `tecnostore.sql` desde el cliente MySQL y ejecutar el script.

### 3. Configuración de conexión

La conexión se encuentra en:

```text
src/main/java/CONEXION_DB/Conexion.java
```
Se debe modificar `Conexion.java`:

```java
DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/tecnostore_db",
    "[tuUsuario]",
    "[tuContraseña]"
);
```
Para ingresar a la base de datos con tus credenciales

### 4. Verificar la conexión

Antes de ejecutar la aplicación, comprobar que:

* MySQL Server esté iniciado.
* La base de datos `tecnostore_db` exista.
* El usuario tenga permisos sobre la base de datos.
* MySQL esté utilizando el puerto `3306`.
* Los datos de conexión de `Conexion.java` sean correctos.

---

## Instalación y ejecución

### Clonar el repositorio

```bash
git clone https://github.com/SantiagoRuedaGarciaPer/TecnoStore.git
```

Entrar al proyecto:

```bash
cd TecnoStore
```

### Configurar la base de datos

Ejecutar:

```text
tecnostore.sql
```

en MySQL.

### Compilar el proyecto

Al ser un proyecto Maven, se puede compilar utilizando:

```bash
mvn clean install
```

### Ejecutar

La clase principal configurada en Maven es:

```text
cp.integrador.tecnostore.TecnoStore
```

También puede ejecutarse desde el IDE seleccionando la clase `TecnoStore.java` y ejecutando su método `main()`.

---

## Dependencias

El proyecto utiliza **MySQL Connector/J 8.0.33** para realizar la conexión mediante JDBC. La dependencia se encuentra configurada en `pom.xml`.

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.0.33</version>
</dependency>
```

---

## Autor

**Santiago Rueda García**

Proyecto desarrollado como parte del proceso de formación en programación y desarrollo de software.
