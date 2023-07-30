## Spring Boot - start.spring.io

Proyecto Sping Boot con las dependencias / starters:

Starters para persistencia:
* H2 
* Spring Data JPA

Starters para web:

* Spring Web
* Spring Boot Dev Tool

Aplicación API REST con acceso a base de datos H2 para persistir la información.

El acceso se puede realizar desde Postman o navegador.

## Entidad book

* Crear la clase book
* BookRepository - Permitirá crear books en la bbdd
* BookController - Para acceder desde una url
  * Buscar todos los libros
  * Buscar un solo libro
  * Crear un nuevo libro
  * Actualizar un libro existente
  * Borrar un libro existente
  * Borrar todos los libros