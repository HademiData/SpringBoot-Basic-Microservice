# Microservices Project

This project demonstrates a basic microservices architecture using Spring Boot, Spring Cloud, Eureka, Feign, Lombok, and PostgreSQL. It includes separate services for a **Gateway**, **Student**, **School**, **Discovery (Eureka)**, and **Config**. The services are connected using Spring Cloud technologies and communicate with each other to perform various tasks. Also all the services are connected and stored in this mono repository.

## Project Structure

The project is composed of the following microservices:


1. **Gateway Service**: Acts as a reverse proxy and routes requests to the appropriate microservices.
2. **Student Service**: Manages student-related data and operations.
3. **School Service**: Manages school-related data and operations.
4. **Discovery Service (Eureka)**: Provides service discovery and registration for all the microservices.
5. **Config Service**: Centralized configuration server to manage configuration properties for all microservices.

## Technologies

- **Spring Boot**: For creating stand-alone, production-grade Spring-based applications.
- **Spring Cloud**: Provides tools for building microservices and distributed systems.
- **Eureka (Discovery Server)**: For service discovery and registration.
- **Feign Client**: To simplify HTTP communication between microservices.
- **Spring Cloud Gateway**: Acts as an API gateway for routing requests.
- **Spring Cloud Config**: Manages external configurations for microservices.
- **Lombok**: To reduce boilerplate code by using annotations.
- **PostgreSQL**: The database used for persisting Student and School services data.

## Services Overview

### 1. Gateway Service
- Runs on port `8222`.
- Uses Spring Cloud Gateway to route incoming requests to the appropriate services.
- Configured to route traffic to the **Student Service** and **School Service** based on URL paths.

### 2. Student Service
- Manages student-related operations.
- Connects to PostgreSQL to store and retrieve student data.
- Uses Feign Client to communicate with the School Service.
- Registered with the Eureka Discovery Service for service discovery.

### 3. School Service
- Manages school-related operations.
- Connects to PostgreSQL to store and retrieve school data.
- Uses Feign Client to communicate with the Student Service.
- Registered with the Eureka Discovery Service.

### 4. Discovery Service (Eureka)
- Runs the Eureka server.
- Allows all the microservices to register and discover each other.
- Provides a dashboard for monitoring the status of registered services.

### 5. Config Service
- Manages configuration properties for all microservices.
- Uses Spring Cloud Config Server to serve configuration data from a central repository (e.g., Git).
- Helps in managing configuration across multiple environments (development, testing, production).

## Running the Project

### Prerequisites
- Java 17 or higher
- Maven
- PostgreSQL
- An IDE like IntelliJ or Eclipse

### Steps to Run

1. **Set Up PostgreSQL**: 
   - Create databases for the **Student** and **School** services.
   - Configure the database connection properties in the configuration files.

2. **Start the Config Service**: 
   - Run the `ConfigServiceApplication` to start the configuration server.

3. **Start the Discovery Service**:
   - Run the `DiscoveryServiceApplication` to start the Eureka server.

4. **Start the Gateway Service**:
   - Run the `GatewayApplication` to start the API gateway.

5. **Start the Student Service**:
   - Run the `StudentServiceApplication`.

6. **Start the School Service**:
   - Run the `SchoolServiceApplication`.

7. **Access the Eureka Dashboard**:
   - Open [http://localhost:8761](http://localhost:8761) to view the registered services.

8. **Testing the Application**:
   - Access the Gateway Service at [http://localhost:8222](http://localhost:8222) and test the routes for students and schools.

## Configuration

- **Eureka Configuration**: All services are registered with Eureka using the `application.yml` configuration files.
- **Database Configuration**: Each microservice has a separate database configuration in `application.yml`.
- **Spring Cloud Config**: Configuration files for each microservice are stored in a central Git repository managed by the Config Service.

## Key Features

- **Service Discovery**: Uses Eureka for dynamic service registration and discovery.
- **API Gateway**: Uses Spring Cloud Gateway for routing requests.
- **Centralized Configuration**: Uses Spring Cloud Config for managing external configurations.
- **Inter-Service Communication**: Uses Feign Client for simplified HTTP communication between services.
- **Database Integration**: PostgreSQL is used for data storage in the Student and School services.

## Troubleshooting

- **401 Unauthorized Error**: Make sure that there is no security configuration blocking access to the services. If security is needed, configure authentication and authorization.
- **Connection Refused Error**: Ensure that all services are running on their expected ports.
- **Database Connection Issues**: Verify the PostgreSQL configuration in `application.yml` and ensure the databases are up and running.

## Future Improvements

- Add security with Spring Security and OAuth2.
- Implement Circuit Breaker patterns using Resilience4j.
- Integrate with a messaging queue like RabbitMQ for asynchronous communication.
- Deploy the services using Docker and Kubernetes.

# License

This project is a tutorial code from Alibou Ali's Microservice Tutorials on YouTube [https://youtu.be/KJ0cSvYj41c?si=1FaOoVfJiT8gs-2y](https://youtu.be/KJ0cSvYj41c?si=1FaOoVfJiT8gs-2y)  for educational purposes and does not include a license.
