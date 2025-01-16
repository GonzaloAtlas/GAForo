# Challenge - Foro Backend

Este proyecto forma parte de los desafíos asignados en la ruta de especialización para Backend del programa **ONE (Oracle Next Education)**. El objetivo del challenge es crear un foro donde los participantes de la plataforma puedan publicar temas sobre determinados asuntos. La finalidad es consolidar conocimientos sobre cómo funciona internamente un foro, incluyendo el almacenamiento y manejo de datos, así como la relación entre los tópicos, respuestas y usuarios.

## Tecnologías utilizadas

### Configuración del entorno de desarrollo:

- **Java**: Versión 17
- **Maven**: Versión 4 (utilizada por Spring Initializr)
- **Spring Boot**
- **MySQL**: Versión 8 en adelante

### Dependencias:

El proyecto hace uso de las siguientes dependencias:

- **Lombok**: Para simplificar el código, eliminando la necesidad de escribir getters, setters, constructores, etc.
- **Spring Web**: Para la creación de la API REST.
- **Spring Boot DevTools**: Para mejorar la experiencia de desarrollo, con características como recarga automática de clases.
- **Spring Data JPA**: Para la integración con bases de datos y el manejo de la persistencia de datos.
- **Flyway Migration**: Para aplicar migraciones de bases de datos.
- **MySQL Driver**: Para conectar la base de datos MySQL con la aplicación.
- **Validation**: Para la validación de datos en el backend.
- **Spring Security**: Para la implementación de medidas de seguridad en el proyecto.
- **Auth0**: Para la implementación de autenticación y autorización, mediante la generación de JSON Web Tokens (JWT).

## Funcionalidades del proyecto

El proyecto tiene como resultado una **API REST** con las siguientes funcionalidades:

1. **API RESTful**: Las rutas de la API están implementadas siguiendo las mejores prácticas del modelo REST y utilizando los métodos HTTP estándar:
   - `GET`: Para obtener información.
   - `POST`: Para crear nuevos recursos.
   - `PUT`: Para actualizar recursos existentes.
   - `DELETE`: Para eliminar recursos.

2. **Base de datos**: La persistencia de la información se maneja a través de una base de datos MySQL, y las migraciones de la base de datos se aplican mediante **Flyway** desde el IDE IntelliJ.

3. **Autenticación y Autorización**: Implementación de un servicio de autenticación y autorización utilizando **JWT** generado con la dependencia **Auth0**, lo que permite restringir el acceso a la información y asegurar que solo los usuarios autenticados y autorizados puedan acceder a los recursos.

## Estructura de la base de datos

El modelo de datos para este foro incluye las siguientes entidades y relaciones:

- **Usuarios**: La entidad de usuario permite la creación de cuentas, inicio de sesión y seguimiento de la actividad del usuario en el foro.
- **Tópicos**: Los participantes pueden crear nuevos temas o tópicos.
- **Respuestas**: Los usuarios pueden responder a los tópicos y generar una interacción en el foro.
- **Relaciones**:
  - Un **usuario** puede tener múltiples **respuestas**.
  - Un **tópico** puede tener múltiples **respuestas** asociadas.
  - Las **respuestas** se relacionan con un **usuario** y un **tópico** específico.
