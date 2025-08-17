This project is a **microservices-based fitness tracking system** built using **Spring Boot**, with services communicating over **RabbitMQ** and **REST**.

## 📦 Modules

### 1. `user-service`
- Manages user information and validation.

### 2. `activity-service`
- Accepts and processes activity data (running, walking, etc.)
- Sends messages to `activity.queue` via RabbitMQ
- Uses `WebClient` to communicate with `user-service`

### 3. `ai-service`
- Listens to `activity.queue` from RabbitMq
- Sends back personalized recommendations after inteacting with GEMINI API using the WebClient.

### 4. `gateway-service`
- Which act like front door to all the services.
- Instead of exposing each service directly, we expose gateway. which act as a single entry point for extenral client calls.

### - Every service (user, activity, ai, gateway) is registered with Eureka for service discovery.
  
## 🔧 Technologies Used
- **Java 17**
- **Spring Boot**
- **Spring Web & WebClient**
- **Spring AMQP - Advanced Message Queuing protocol (RabbitMQ)**

- **Eureka server** as service discovery
- **Gradle Build Tool**

⚠️ This project is currently under active development.
The README.md and documentation will be updated as features are added.
