# Biblioteca Be The One
Evaluación Spring Boot - Semana 3

## Presentación ##
Mi nombre es Kevin Castillo, soy desarrollador web y este es mi primer proyecto realizado en Java con la utilización de el framework Spring Boot y base de datos MySQL. El proyecto consta de una API RestFull para el manejo de libros y prestamos a distintos clientes de la **Biblioteca Be The One**

### Necesidad ###
Se necesita tener control de todos los libros pertenecientes a una biblioteca
- CRUD de Libros(Crear, actualizar, eliminar)
- Se necesita poder listar los libros por estado (PRESTAMO, INACTIVO, RESTAURACION, DISPONIBLE) o Todos
- Se podrá modifica el estado de un libro
- Se podrá prestar un libro a un USUARIO
- Se podrá listar todos los libros prestados a un USUARIO, entre la información debe contener la fecha del préstamo
- No se podra prestar un libro a un usuario si el usuario ya posee mas de tres libro en prestamo
- No se podra prestar un libro si ya esta en prestamo para otro usuario
- Solo se podran prestar libros si esta en estado DISPONIBLE

### Consideraciones ###
- Usar un response Único para cada petición
- Hacer uso de manejo de excepciones
- La BD debe ser MYSQL
- La BD debe llamarse BeTheOne
- Los métodos del CRUD deben contener autenticación Básica
- Agregar documentación con swagger
- La aplicación debe correr en el puerto 7000
- El formato de las fechas debe ser dd-MM-YYYY HH:mm (al mostrarla en la respuesta)
- Agregar insert necesarios para correr la aplicación sin problema
- Debe crear una rama con su nombre y apellido ej. (MarioArias)
- Cualquier extra es bienvenido
## Solución ##

### DOCUMENTACION APIs: ###
http://localhost:7000/swagger-ui/

### INSTRUCCIONES MySQL ###
MOTOR: MySQL
CREAR BASE DE DATOS: betheone
EJECUTAR EL PROYECTO PARA QUE CREE LAS TABLAS DE LAS ENTIDADES.

**REALIZAR LAS INSERCIONES:**

TblUsuario

INSERT INTO `usuario` (`usuario_id`, `apellido_Usuario`, `email_usuario`, `nombre_usuario`, `telefono_usuario`) VALUES
(1, 'Castillo', 'kevin@gmail.com', 'Kevin', '71717171'),
(2, 'Hernandez', 'hector@gmail.com', 'Hector', '72727272'),
(3, 'Callejas', 'esperanza@gmail.com', 'Esperanza', '73737373'),
(4, 'Blanco', 'jazmin@gmail.com', 'Jazmin', '74747474');

TblLibros

INSERT INTO `libro` (`libro_id`, `autor`, `estado`, `titulo`) VALUES 
('1', 'Dante Alighieri', 'Disponible', 'Divina comedia'), 
('2', 'Jane Austen', 'Disponible', 'Orgullo y prejuicio'), 
('3', 'Honoré de Balzac', 'Inactivo', 'Papá Goriot'), 
('4', 'Hans Christian Andersen', 'Disponible', 'Cuentos infantiles'), 
('5', 'Giovanni Boccaccio', 'Restauración', 'Decamerón'),
('6', 'Miguel de Cervantes', 'Disponible', 'Don Quijote de la Mancha'), 
('7', 'Antón Chéjov', 'Disponible', 'Relatos cortos'), 
('8', 'Gerver Monterrosa', 'Prestamo', 'Matematica 1'), 
('9', 'Rudy', 'Prestamo', 'Matematica 2'), 
('10', 'Gonzalo', 'Prestamo', 'Matematica 3');

TblPrestamo

INSERT INTO `prestamo` (`prestamo_id`, `fecha_prestamo`, `libro_id`, `usuario_id`) VALUES 
('1', '22-08-2021 20:00', '8', '1'), 
('2', '22-08-2021 20:00', '9', '2'), 
('3', '22-08-2021 20:00', '10', '1');

### URIs ###

**RECURSO: Libros**

OBTENER TODOS LOS LIBROS:
GET http://localhost:7000/Libros

OBTENER LIBROS POR ID:
GET http://localhost:7000/Libros/{libroId}

OBTENER LIBROS POR ESTADO(Disponible, Prestamo, Inactivo, Restauracion):
GET http://localhost:7000/Libros/Estado/{estado}

REGISTRAR UN NUEVO LIBRO
POST http://localhost:7000/Libros
JSON BODY: 
{
    "autor": "Melvin",
    "estado": "Disponible",
    "titulo": "Decamerón"
}

ACTUALIZAR ESTADO DE UN LIBRO
PUT http://localhost:7000/Libros
JSON BODY: 
{
    "libroId": 5, 
    "autor": "Giovanni Boccaccio",
    "estado": "Disponible",
    "titulo": "Spring Boot"
}

ELIMINAR UN LIBRO:
DELETE http://localhost:7000/Libros/{libroId}

**RECURSO: PRESTAMOS**

OBTENER TODOS LOS PRESTAMOS:
GET http://localhost:7000/Prestamos

OBTENER PRESTAMOS POR FECHA:
GET http://localhost:7000/Prestamos/{fechaPrestamo}

OBTENER PRESTAMOS POR USUARIO:
GET http://localhost:7000/Prestamos/Usuario/{usuarioId}

REGISTRAR UN NUEVO PRESTAMO
POST http://localhost:7000/Prestamos
JSON BODY: 
{
    "libroId": 2,
    "usuarioId": 3,
    "fechaPrestamo": "2021-08-22T06:00:00.000+00:00"
}

## Agradecimiento ##
Agradecimiento especial a Mario Rene Arias Gomez, instructor del Modulo de Spring Boot dentro del programa de entrenamiento Be The One
