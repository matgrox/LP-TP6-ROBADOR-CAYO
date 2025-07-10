# LP 2025 - TP6
## Sistema de Gestión de Trámites Univeristarios

Aplicación cliente-servidor que permite gestionar usuarios y trámites a través de una interfaz Swing conectada a microservicios RESTful. Incluye validaciones, operaciones CRUD completas y consumo de una base de datos MySQL.

## Ejecutar backend (Basado en el TP5 de Matias Robador)
- Requiere JDK 17, Spring Boot y NetBeans IDE 21
- Base de datos MySQL: ver sección **Script de Base de Datos**

## Ejecutar frontend
- Requiere JDK 17 y NetBeans IDE 21
- Ejecutar clase principal `demo.java`

## Script de Base de Datos
Para generar la base de datos, ejecutar el siguiente script:
```sql
CREATE DATABASE demo2;
USE demo2;
CREATE TABLE usuario (
	codUser INT NOT NULL AUTO_INCREMENT,
 	username VARCHAR(40) NOT NULL,
  email VARCHAR(40) NOT NULL,
  PRIMARY KEY (codUser),
  UNIQUE INDEX username_UNIQUE (username ASC) VISIBLE,
  UNIQUE INDEX email_UNIQUE (email ASC) VISIBLE
  );
  
  CREATE TABLE transaction (
  codtransaction INT NOT NULL AUTO_INCREMENT,
  tipo VARCHAR(40) NOT NULL,
  estado VARCHAR(40) NOT NULL,
  PRIMARY KEY (codtransaction)
  );
```

## Desarrollado por:
- Carlos CAYO [@KYU76] (https://github.com/KYU76) (Módulo Usuario)
- Matias ROBADOR [@matgrox] (https://github.com/matgrox) (Módulo Tramite)
