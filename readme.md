

# Proyecto de Desarrollo de Software

Aplicación REST desarrollada como parte de una evaluación de Desarrollo de Software. El objetivo es desarrollar una aplicación en Java utilizando spring-boot cumpliendo las siguientes condiciones:

- Crear la logica de negocio para ingresar datos de una empresa cuyos campos son (idempresa, ruc, razon social, direccion, estado) 
- Crear una base de datos en H2 o H2 o alguna implementación como Map o Collection para almacenar los datos en memoria.
- Realizar un servicio rest que devuelva una lista con los 3 últimos registros de empresas.
- Segurizar los servicios rest anteriores utilizando spring-security 


## Características

-  Servicios Rest utilizando metodos POST GET DELETE PUT.
-  Tratamiento de errores 500.
-  Seguridad con Spring Security, uso de JWT para acceso, encriptación.
-  Registro y obtencion de datos de empresa.
-  Uso de JPA y H2 para persistencia de datos.
-  Validaciones.
-  Uso de Auth0 para autenticación.

## Requisitos del sistema

-  Java 17.
-  Spring Boot 3.1.0.
-  Maven .
-  Postman

## Instalación

1. Clona este repositorio en tu máquina local.
2. Instalar drivers para la base de datos H2.
3.  Instalar dependencias.
4. Ejecutar.


## Uso

1. El puerto que se utiliza en esta aplicación es el puerto por defecto 8080, en localhost
2. Para poder utilizar 
3. Para tener accero al REST de EMPRESAS el cliente debe iniciar sesion y enviar el token por los headers.
   - El JSON para generar el token es:
   ```
   {"usuarioname" : "arkezam", "clave": "1234"}
   ```
   debe ingresarse en     http://localhost:8080/login
4. Una vez generado el token se debe utilizar el token en Authorization



5. la url para el REST de empresa son:
   - http://localhost:8080/empresa
   - http://localhost:8080/empresa/ultimos


## Contacto

- [Kevin Arnold Paye Zamata]: [arkezam@gmail.com]

