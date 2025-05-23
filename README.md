# Proyecto Firma de Contratos - Día 5

Este proyecto es una API REST en Java (Spring Boot) para la gestión y firma de contratos digitales. Incluye endpoints para clientes y administración (rol ROOT), junto con tests automatizados.

## 📁 Estructura

- `/contrato/view/{id}`: Visualiza contrato PDF simulado.
- `/contrato/datos`: Guarda los datos del cliente.
- `/contrato/firmar`: Recibe la firma (JSON/SVG) del cliente.
- `/root/contratos`: Lista contratos firmados con filtros.
- `/root/contrato/{id}`: Visualiza contrato firmado.
- `/root/contrato/edit`: Permite editar metadatos de un contrato.

## ▶️ Requisitos

- Java 17+
- Maven 3.8+
- Spring Boot

## 🚀 Ejecución

```bash
mvn spring-boot:run
```

La aplicación se inicia en `http://localhost:8080`.

## 🧪 Ejecutar tests

```bash
mvn test
```

Se ejecutarán tests con `MockMvc` simulando peticiones a los endpoints clave.

## 🧩 Tecnologías

- Spring Boot (Web + Test)
- JUnit 5
- MockMvc
- Maven

## 📬 Contacto

Desarrollado como parte del proyecto FCT - Firma de Contratos (Día 5).
