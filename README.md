# Biblioteca

Evaluación Spring Boot - Semana 3
### Necesidad ###

Se necesita tener control de todos los libros pertenecientes a una biblioteca

- CRUD de Libros(Crear, actualizar, eliminar)
- Se necesita porder listar los libros por estado (PRESTAMO, INACTIVO, RESTAURACION, DISPONIBLE) o Todos
- Se podra modifica el estado de un libro
- Se podra prestar un libro a un USUARIO
- Se podra listar todos los libros prestados a un USUARIO,entre la informacion  debe contener la fecha del prestamo 
- No se podra prestar un libro a un usuario si el usuario ya posee mas de tres libro en prestamo
- No se podra prestar un libro si ya esta en prestamo para otro usuario
- Solo se podran prestar libros si esta en estado DISPONIBLE

### Consideraciones ###

- Usar un response Unico para cada peticion 
- Hacer uso de manejo de excepciones
- La BD debe ser MYSQL
- La BD debe llamarse BeTheOne
- Los metodos del CRUD deben contener autenticacion Basica
- El Usario y Contraseña debe validarse contra BD
- Agregar documentacion con swagger
- La aplicacion debe correr en el puerto 7000
- El formato de las fechas debe ser dd-MM-YYYY HH:mm (al mostrarla en la respuesta)
- Agregar insert ncecesarios para correr la aplicacion sin problema
- Debe crear una rama con su nombre y apellido ej. (MarioArias)
- Cualquier extra es bienvenido
