This project is a **microservices-based fitness tracking system** built using **Spring Boot**, with services communicating over **RabbitMQ** and **REST**.

## 📦 Modules

### 1. `activity-service`
- Accepts and processes activity data (running, walking, etc.)
- Sends messages to `activity.queue` via RabbitMQ
- Uses `WebClient` to communicate with `user-service`

### 2. `user-service`
- Manages user information and validation
- Registered with Eureka for service discovery (optional)

### 3. `ai-service`
- Listens to `activity.queue`
- Processes activities using custom logic or ML models
- Sends back personalized recommendations (future scope)

## 🔧 Technologies Used
- **Java 17**
- **Spring Boot**
- **Spring Web & WebClient**
- **Spring AMQP (RabbitMQ)**
- **RabbitMQ**
- **Eureka (Optional)**
- **Gradle**

⚠️ This project is currently under active development.
The README.md and documentation will be updated as features are added.
