# 🔍 Cliente API - Sistema de Gestión de Campeonatos de Fútbol

**Aplicación Cliente que consume API REST**

---

## 📚 Descripción

Aplicación web independiente que consume la API REST del **Sistema de Gestión de Campeonatos de Fútbol**. Permite realizar búsquedas de equipos mediante formularios HTML y muestra los resultados obtenidos desde la API.

### Funcionalidades

- ✅ Formulario de búsqueda de equipos
- ✅ Búsqueda por nombre
- ✅ Búsqueda por ciudad
- ✅ Búsqueda por campeonato
- ✅ Listado de todos los equipos
- ✅ Consumo de API REST mediante **WebClient** (Spring WebFlux)
- ✅ Interfaz web con Bootstrap 5

---

## 🏗️ Arquitectura

### Arquitectura Cliente-Servidor

```text
┌─────────────────────────────┐         HTTP/JSON        ┌─────────────────────────────┐
│     APLICACIÓN CLIENTE      │  ←─────────────────────→ │    APLICACIÓN PRINCIPAL     │
│     localhost:8081          │                          │    localhost:8080           │
│                             │                          │                             │
│  ClienteController          │                          │  EquipoRestController       │
│  ApiService (WebClient)     │                          │  /api/equipos/*             │
│  Vistas Thymeleaf           │                          │  Base de Datos MySQL        │
└─────────────────────────────┘                          └─────────────────────────────┘
```

### Flujo de Comunicación

1. **Usuario** llena el formulario en `buscarEquipos.html`.
2. **ClienteController** recibe la petición `POST`.
3. **ApiService** usa `WebClient` para llamar a la API REST.
4. Se realiza una petición HTTP GET a:

   ```http
   GET http://localhost:8080/api/equipos/buscarPorNombre?nombre=X
   ```

5. **Servidor** procesa la solicitud y retorna una respuesta en formato JSON.
6. **ApiService** recibe el JSON y lo convierte a objetos Java.
7. **ClienteController** envía los datos a la vista `resultadoEquipos.html`.
8. **Usuario** ve los resultados en una tabla HTML.

---

## 🛠️ Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.2.5**
- **Spring Web**: controladores MVC
- **Spring WebFlux**: `WebClient` para consumo de API
- **Thymeleaf**: vistas HTML
- **Bootstrap 5**: estilos CSS
- **Maven**: gestión de dependencias

---

## 📁 Estructura del Proyecto

```text
src/main/java/com/cliente/cliente_campeonato/
├── ClienteCampeonatoApplication.java    # Clase principal
├── controllers/
│   └── ClienteController.java           # Controlador de búsquedas
├── models/
│   └── EquipoDTO.java                   # DTO para recibir datos de la API
└── services/
    └── ApiService.java                  # Servicio que consume la API REST

src/main/resources/
├── application.properties               # Configuración, puerto 8081
└── templates/
    ├── index.html                       # Página principal del cliente
    ├── buscarEquipos.html               # Formulario de búsqueda
    └── resultadoEquipos.html            # Tabla de resultados
```

---

## 🔗 Endpoints de la API que consume

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/equipos/listar` | Lista todos los equipos |
| GET | `/api/equipos/buscarPorNombre?nombre=` | Busca por nombre |
| GET | `/api/equipos/buscarPorCiudad?ciudad=` | Busca por ciudad |
| GET | `/api/equipos/buscarPorCampeonato?idCampeonato=` | Busca por campeonato |

---

## 🚀 Instalación y Ejecución

### Requisitos Previos

- Java JDK 17 o superior
- Maven, incluido con `mvnw`
- **Aplicación principal ejecutándose en el puerto 8080**

### Pasos para Ejecutar

#### 1. Asegurar que la API principal esté corriendo

En otra terminal, ejecutar el proyecto principal:

```bash
cd C:\proyectos\gestioncampeonato
./mvnw spring-boot:run
```

#### 2. Clonar este repositorio

```bash
git clone https://github.com/softhamck/cliente-campeonato-api.git
cd cliente-campeonato-api
```

#### 3. Ejecutar la aplicación cliente

```bash
./mvnw spring-boot:run
```

#### 4. Abrir en el navegador

```text
http://localhost:8081/cliente/
```

---

## 🧪 Probar las Búsquedas

### Rutas principales

- Página principal: `http://localhost:8081/cliente/`
- Formulario de búsqueda: `http://localhost:8081/cliente/buscar`
- Listar todos los equipos: `http://localhost:8081/cliente/listarTodos`

### Búsquedas disponibles

| # | Tipo | Ejemplo |
|---|------|---------|
| 1 | Por nombre | `Nacional` |
| 2 | Por ciudad | `Medellín` |
| 3 | Por campeonato | `ID: 1` |

---

## 📊 Diagrama de Arquitectura

Ver archivo:

```text
evidencias/diagrama-api-rest.md
```

En el proyecto principal:

```text
https://github.com/softhamck/gestion-campeonatos-futbol
```

---

## 📄 Licencia

Este proyecto fue desarrollado con fines académicos para la asignatura de **Arquitectura de Software**.

---

## 🔗 Repositorios Relacionados

| Proyecto | URL |
|----------|-----|
| Aplicación Principal + API REST | `gestion-campeonatos-futbol` |
| Cliente API | `cliente-campeonato-api` |
