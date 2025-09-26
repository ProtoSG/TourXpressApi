# TourXpress API

API REST para sistema de gestión de viajes y reservas de autobuses.

## Tecnologías

- **Java 17**
- **Spring Boot 3.5.5**
- **Spring Data JPA**
- **Spring Security**
- **PostgreSQL**
- **Lombok**
- **Docker & Docker Compose**

## Estructura del Proyecto

```
src/
├── main/java/com/TourXpress/TourXpressApi/
│   ├── config/          # Configuraciones (CORS, Seguridad)
│   ├── controller/      # Controladores REST
│   ├── domain/          # Entidades JPA
│   ├── dto/             # Data Transfer Objects
│   ├── repository/      # Repositorios JPA
│   └── service/         # Lógica de negocio
└── main/resources/
    └── application.properties
```

## Funcionalidades

- **Gestión de Rutas**: CRUD de rutas de viaje
- **Gestión de Viajes**: Administración de viajes programados
- **Gestión de Asientos**: Control de disponibilidad y reservas
- **Seguridad**: Configuración de CORS y Spring Security

## Requisitos Previos

- Java 17 o superior
- Maven 3.6+
- Docker y Docker Compose (opcional)

## Instalación y Ejecución

### Con Docker Compose (Recomendado)

1. Clonar el repositorio
2. Construir la aplicación:
   ```bash
   ./mvnw clean package -DskipTests
   ```
3. Ejecutar con Docker Compose:
   ```bash
   docker-compose up -d
   ```

La aplicación estará disponible en `http://localhost:8080/api`

### Ejecución Local

1. Configurar base de datos PostgreSQL
2. Configurar variables de entorno:
   ```bash
   export DATABASE_URL=jdbc:postgresql://localhost:5432/tu_bd
   export DATABASE_USERNAME=tu_usuario
   export DATABASE_PASSWORD=tu_contraseña
   ```
3. Ejecutar la aplicación:
   ```bash
   ./mvnw spring-boot:run
   ```

## Variables de Entorno

| Variable | Descripción | Ejemplo |
|----------|-------------|---------|
| `DATABASE_URL` | URL de conexión a PostgreSQL | `jdbc:postgresql://localhost:5432/api_db` |
| `DATABASE_USERNAME` | Usuario de la base de datos | `postgres` |
| `DATABASE_PASSWORD` | Contraseña de la base de datos | `postgres` |

## Endpoints API

La API estará disponible en `http://localhost:8080/api` con los siguientes endpoints:

- **Rutas**: `/routes`
- **Viajes**: `/trips`  
- **Asientos**: `/seats`

## Archivos de Prueba

En la carpeta `rest/` se encuentran archivos `.rest` para probar los endpoints:
- `route.rest` - Pruebas de rutas
- `trip.rest` - Pruebas de viajes
- `seat.rest` - Pruebas de asientos

## Desarrollo

### Ejecutar Tests
```bash
./mvnw test
```

### Generar JAR
```bash
./mvnw clean package
```

### Detener Servicios Docker
```bash
docker-compose down
```

## Base de Datos

La aplicación utiliza PostgreSQL con configuración automática de esquemas (`spring.jpa.hibernate.ddl-auto=update`).

### Acceso a Base de Datos (Docker)
- Host: `localhost`
- Puerto: `5432`
- Base de datos: `api_db`
- Usuario: `postgres`
- Contraseña: `postgres`