

# Proyecto de Desarrollo de Software

Aplicación REST desarrollada como parte de una evaluación de Desarrollo de Software. El objetivo es desarrollar una aplicación en Java utilizando spring-boot cumpliendo las siguientes condiciones:

- Crear la logica de negocio para ingresar datos de una empresa cuyos campos son (idempresa, ruc, razon social, direccion, estado) 
- Crear una base de datos en H2 o H2 o alguna implementación como Map o Collection para almacenar los datos en memoria.
- Realizar un servicio rest que devuelva una lista con los 3 últimos registros de empresas.
- Segurizar los servicios rest anteriores utilizando spring-security 


## Características

- [Característica 1]: Servicios Rest utilizando metodos POST GET DELETE PUT.
- [Característica 2]: Tratamiento de errores 500.
- [Característica 3]: Seguridad con Spring Security, uso de JWT para acceso, encriptación.
- [Característica 4]: Registro y obtencion de datos de empresa.
- [Característica 5]: Uso de JPA y H2 para persistencia de datos.
- [Característica 6]: Validaciones.
- [Característica 7]: Uso de Auth0 para autenticación.

## Requisitos del sistema

- [Requisito 1]: Java 17.
- [Requisito 2]: Spring Boot 3.1.0.
- [Requisito 3]: Maven .
- Postman
- ...

## Instalación

1. Clona este repositorio en tu máquina local.
2. [Paso 2]: Instalar drivers h2.
3. [Paso 3]: Instalar dependencias.
4. [Paso 4]: Ejecutar.


## Uso

1. El puerto que se utiliza en esta aplicación es el puerto por defecto 8080, en localhost
2. El usuario y contraseña para el login y generacion de token es "usuarioname" : "arkezam", "clave": "1234"
3. las URL son:
   - http://localhost:8080/empresa
   - http://localhost:8080/empresa/ultimos
   - http://localhost:8080/empresa/ultimos


## Contacto

- [Kevin Arnold Paye Zamata]: [arkezam@gmail.com]

