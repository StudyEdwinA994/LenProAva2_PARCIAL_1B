# 📦 Proyecto Edwin Alzate - Gestión de Productos Tecnologicos.

Este es un proyecto desarrollado con **Spring Boot**, **Java 17**, **Maven** y **MySQL**, que permite gestionar productos mediante una API REST.

## 🚀 Tecnologías

- Java 17
- Spring Boot 3.4.4
- Spring Data JPA
- MySQL
- Maven
- JUnit 5
- Mockito
- GitHub Actions (CI/CD)

## 📁 Estructura del Proyecto

- `Model`: Entidades JPA
- `Repository`: Acceso a datos
- `Controller`: Endpoints REST
- `Test`: Pruebas unitarias y de integración

## 🔧 Configuración

En `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/db_productec
spring.datasource.username=root
spring.datasource.password=123456789
spring.jpa.hibernate.ddl-auto=update
```

## 🧪 Pruebas Unitarias

Este proyecto tiene pruebas unitarias las cuales aseguran un adecuado funcionamiento de los controladores y la interacción con el repositorio de productos tecnologicos. Usa **JUnit 5** y **Mockito** para hacer toda la simulación de dependencias y validar como es el comportamiento de la API.  

### `ProductosControllerTest`

Esta clase se enfoca en validar los métodos `ProductosController`:

- **`getProductos()`**: La prueba simula la interacción con el repositorio para asegurar que se devuelvan los productos correctos.
- **`eliminarProducto()`**: La prueba simula la eliminación de un producto y asegura que el repositorio sea llamado correctamente.

### `ProductosControllerUnitTest`️

En esta clase se prueban escenarios de eliminación de productos `ProductosController`:

- **Eliminación exitosa**: Simula la eliminación de un producto existente en el repositorio, y se verifica que el método de eliminación funcione correctamente.
- **Producto no encontrado**: Se simula el caso en que se elimina un producto que no existe.

### `CrearProductosControllerTest` 

Esta clase verifica el comportamiento de `CrearProductosController`:

- **`crearProducto()`**: Al intentar crear un producto, el controlador interactúa correctamente con el repositorio para guardar el nuevo producto.

### `EliminarProductosControllerTest`

Prueba el controlador `EliminarProductosController` para validar su comportamiento al eliminar:

- **Eliminación exitosa**: Se verifica que el controlador elimine un producto cuando este existe en la base de datos de MySQL. 
- **Producto no encontrado**: Simula el caso en que un producto no encontrado al intentar eliminarlo.
