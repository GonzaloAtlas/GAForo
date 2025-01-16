# GAForo

Este proyecto forma parte de los desafíos asignados en la ruta de especialización para Backend del programa **ONE (Oracle Next Education)**. El objetivo del challenge es crear un foro donde los participantes de la plataforma puedan publicar temas sobre determinados asuntos. La finalidad es consolidar conocimientos sobre cómo funciona internamente un foro, incluyendo el almacenamiento y manejo de datos, así como la relación entre los tópicos, respuestas y usuarios.

## Descripción del Proyecto

El objetivo principal del challenge es consolidar conocimientos sobre cómo funciona un foro a nivel backend:
- Cómo se almacenan los datos.
- Cómo se relacionan los datos (tópicos, respuestas y usuarios).
- Cómo se gestiona la autenticación y autorización.

## Tecnologías utilizadas

### Configuración del entorno de desarrollo:

- **Java**: Versión 17
- **Maven**: Versión 4 (utilizada por Spring Initializr)
- **Spring Boot**
- **MySQL**: Versión 8 en adelante
- **Insomnia**: Para realizar pruebas de consumo de la API.

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

## Instalación y Configuración

1. **Clonar el Repositorio:**
   ```bash
   git clone <https://github.com/GonzaloAtlas/GAForo.git>
   cd <GAForo>
   ```

2. **Configurar la Base de Datos:**
   - Asegúrate de tener MySQL 8 o superior instalado.
   - Crea una base de datos con el nombre `gaforo` (o el que definas en tu archivo `application.properties`).
   - Actualiza el archivo `src/main/resources/application.properties` con las credenciales de tu base de datos.
   
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/nombre=_de_la_base_de_datos
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=validate
   spring.flyway.enabled=true
   ```

## Uso de la API

Las rutas principales del foro incluyen:
- **Tópicos**:
  - `GET /topicos`: Listar todos los tópicos.
  - `POST /topicos`: Crear un nuevo tópico.
  - `PUT /topicos/{id}`: Actualizar un tópico.
  - `DELETE /topicos/{id}`: Eliminar un tópico.
- **Autenticación**:
  - `POST /login`: Generar un JWT para autenticación.

## Contribución

1. Realiza un fork del repositorio.
2. Crea una nueva rama con tu mejora o corrección.
   ```bash
   git checkout -b feature/nueva-funcionalidad
   ```
3. Envía un pull request describiendo los cambios realizados.

## Contacto
Si tienes dudas o sugerencias, no dudes en contactarme.
