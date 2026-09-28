# Fitness AI Microservices

A Spring Boot microservices project for a fitness application. This repository is currently a work in progress and is intended to provide a modular backend architecture for managing users, tracking activity data, and registering services through Eureka.

## Overview

This project contains multiple independent services that work together to support a fitness platform:

- `userservice` - manages user-related business logic and persistence
- `activityservice` - handles activity tracking and event-driven processing
- `eureka` - service discovery server for the microservices ecosystem

The services communicate through a Spring Cloud setup and use a distributed architecture for easier scaling and maintenance.

## Architecture

```text
+-----------------+        +------------------+        +-------------------+
|   userservice   | ----> |   activityservice | ----> |   MongoDB / MQ    |
+-----------------+        +------------------+        +-------------------+
        |                           |
        |                           |
        +----------- Eureka -----------+
```

## Services

### 1. User Service
- user profile and account handling
- persistent data storage via PostgreSQL / JPA
- service registration with Eureka
- exposed on port `8081`

### 2. Activity Service
- activity tracking and fitness-related data processing
- MongoDB-based persistence
- RabbitMQ integration for messaging
- service registration with Eureka
- exposed on port `8082`

### 3. Eureka Server
- Netflix Eureka service registry
- central discovery point for microservices
- exposed on port `8761`

## Tech Stack

- Java 17
- Spring Boot 3 / Spring Cloud
- Spring Data JPA
- Spring Data MongoDB
- PostgreSQL
- MongoDB
- RabbitMQ
- Netflix Eureka
- Maven

## Repository Structure

```text
Fitness_AI-Microservices-
├── eureka/
│   ├── pom.xml
│   └── src/
├── userservice/
│   ├── pom.xml
│   └── src/
├── activityservice/
│   ├── pom.xml
│   └── src/
├── .project
├── README.md
└── .gitignore
```

## Prerequisites

Before running the project, make sure you have:

- Java 17+
- Maven
- PostgreSQL installed and running
- MongoDB installed and running
- RabbitMQ installed and running
- Local network access for service discovery

## Configuration

Each service has its own `application.properties` file with service-specific settings.

### Eureka
- port: `8761`
- registers no peer instances by default for local standalone mode

### User Service
- application name: `userservice`
- port: `8081`
- PostgreSQL database connection configured in `application.properties`

### Activity Service
- application name: `activityservice`
- port: `8082`
- MongoDB URI configured for `fitnessactivity`
- RabbitMQ host and queue configuration defined in `application.properties`

## Running the Project

### 1. Start Eureka

```bash
cd eureka
./mvnw spring-boot:run
```

### 2. Start User Service

```bash
cd userservice
./mvnw spring-boot:run
```

### 3. Start Activity Service

```bash
cd activityservice
./mvnw spring-boot:run
```

After all services are running, you can access the Eureka dashboard at:

```text
http://localhost:8761
```

## Notes

This README is a draft and the project is still under development. Parts of the architecture, configurations, and APIs may change as the application evolves.

## Future Improvements

- add API documentation with Swagger/OpenAPI
- implement authentication and authorization
- add Docker and Docker Compose support
- introduce gateway service for centralized routing
- improve event-driven workflows and monitoring
- add CI/CD and automated tests

## License

This project is currently for development and learning purposes. Update this section later if you decide to publish it with a specific license.
