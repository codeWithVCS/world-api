
# 🌍 World API - RESTful Geographic Data Engine

## Introduction

World API is a high-performance, granular RESTful API built with **Spring Boot 3** and **MySQL**.  
It transforms the legacy MySQL `world` database into a modern, searchable, and well-documented discovery engine for global geographical and demographic data.

---

## Tech Stack

- Java 21  
- Spring Boot 3.4.1  
- Spring Data JPA (Hibernate 6)  
- MySQL 8.0  
- SpringDoc OpenAPI (Swagger UI)  
- Lombok  

---

## Features

- 🔍 **Granular Resource Access**: Optimized endpoints for Countries, Cities, and Languages.  
- 🔎 **Intelligent Search**: Case-insensitive, partial matching for countries and cities.  
- 🌐 **Geographical Exploration**: Filter by Continent or Region with support for multi-word values.  
- 🚀 **Performance Optimizations**:
  - JPA `JOIN FETCH` to resolve N+1 queries.  
  - Lazy loading for related data.  
  - Read-only transactions for faster data retrieval.  
- 🧪 **Interactive API Docs**: Real-time testing via Swagger UI.  

---

## Installation

### Prerequisites

- Java 21 and Maven  
- MySQL 8 installed  
- The `world` sample database loaded  
  > Download from: [MySQL World Database](https://dev.mysql.com/doc/index-other.html)

### Clone and Setup

```bash
git clone https://github.com/codeWithVCS/world-api.git
cd world-api
```

### Configure the Database

Update the following in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/world
spring.datasource.username=your_username
spring.datasource.password=your_password
```

---

## Usage

### Run the Application

```bash
./mvnw spring-boot:run
```

## API Documentation

The API is self-documented using **SpringDoc OpenAPI 3.0**.  

After running the application, access the documentation here:

🔗 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## Troubleshooting

- ✅ Ensure the `world` database is loaded in MySQL  
- ⚙️ MySQL should be running on port `3306`  
- 🔐 Verify correct credentials in `application.properties`  

---

## Contributors

- **codeWithVCS** – [GitHub Repository](https://github.com/codeWithVCS/world-api)

---

## License

This project is licensed under the **MIT License** – see the [LICENSE](LICENSE) file for details.
