## Spring Boot - start.spring.io

Proyecto Sping Boot con las dependencias / starters:

Starters para persistencia:

* H2 
* Spring Data JPA

Starters para web:

* Spring Web
* Spring Boot Dev Tool

Documentación:

* Realizada con OpenApi
* Url de acceso: http://localhost:8081/swagger-ui/index.html

Aplicación API REST con acceso a base de datos H2 para persistir la información.

El acceso se puede realizar desde Postman o navegador.

## Entidad book

* Creación de la clase book, del objeto book con sus artibutos, constructores y getters y setters
* BookRepository - Permite crear books en la bbdd
* BookController - Permite acceder desde una url
* Operaciones:
  * Buscar todos los libros
  * Buscar un solo libro
  * Crear un nuevo libro
  * Actualizar un libro existente
  * Borrar un libro existente
  * Borrar todos los libros