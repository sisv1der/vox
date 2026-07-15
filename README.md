# Vox

A real-time messaging platform with asynchronous message processing,
external identity management and event-driven architecture.

---

## Overview

Vox is a messaging platform that allows users to communicate 
through real-time conversations. The project explores backend
architecture approaches including WebSocket communication,
OAuth2/OpenID Connect authentication and asynchronous processing.

---

## Features

### Authentication
- OAuth2/OpenID Connect authentication
- User identity management
- Role-based access control

### Messaging
- Private conversations
- Real-time message delivery
- Message history
- Message delivery status

### Asynchronous Processing
- Event-driven message handling
- Background workers
- Notification processing

### Testing
- Unit tests
- Integration tests
- Container-based testing environment

### Future Features
- File attachments
- Message search
- Online status
- Read receipts

---

## Architecture

The application follows a modular backend architecture with
separated responsibilities for authentication, messaging and
asynchronous processing.

High-level architecture (temporarily):
```
                Client
                  |
                  v
          Backend Application
                  |
    +-------------+-------------+
    |             |             |
    v             v             v
    PostgreSQL Keycloak Message Broker
                  |
                  v 
          Background Workers
```

Main components:

### Web Client
A browser-based client application responsible for user interaction.

Responsible for:
- user interface;
- conversation management;
- real-time message communication;
- displaying message history and notifications.

### Backend Application
Responsible for:
- REST API;
- WebSocket communication;
- business logic;
- message processing.

### Identity Provider
Authentication and authorization are handled through OAuth2/OpenID Connect.

### Database
Stores application data:
- conversations;
- messages;
- user-related information.

### Message Broker
Provides asynchronous communication between system components.

### Background Workers
Process background tasks such as notifications and event handling.

---

## Technologies

### Backend
- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- WebSocket

### Frontend
- TypeScript
- React

### Database
- PostgreSQL

### Authentication
- OAuth2 / OpenID Connect
- Keycloak

### Infrastructure
- Docker
- Docker Compose

### Asynchronous Processing
- Apache Kafka
- Background Workers

### Testing
- JUnit
- Testcontainers

### Development Environment
The project is designed to run locally using Docker Compose.

---

## Project Structure

The project is organized as a monorepository containing the
backend, frontend and infrastructure components.

```
Vox
├── backend
├── frontend
├── infrastructure
└── docs
```

---

## Getting Started

### Prerequisites

Before running the project, make sure the following tools are installed:

- Java
- Node.js
- Docker
- Docker Compose

### Running the Application

Clone the repository:

```bash
git clone https://github.com/sisv1der/vox
cd vox
```

Start the application:

```bash
docker compose up -d
```

The application will be available at:

Frontend: `https://localhost:80`  
Backend: `https://localhost:80/api`

---

## API Documentation

The application provides two types of communication interfaces:

- REST API for client-server requests.
- WebSocket API for real-time communication.

### REST API

REST API is used for:

- user-related operations;
- conversation management;
- message history retrieval;
- application data operations.

API documentation is available through OpenAPI/Swagger.

Example:

`GET /api/conversations`    
`GET /api/messages/{id}`    
`POST /api/messages`    

### WebSocket API

WebSocket is used for real-time message exchange.

Main events:

#### Client Events

`SEND_MESSAGE`    
`READ_MESSAGE`    
`TYPING_STATUS`

#### Server Events

`NEW_MESSAGE`     
`MESSAGE_STATUS_UPDATED`    
`USER_STATUS_CHANGED`


---

## Testing

TODO

---

## Roadmap

### Phase 1 — Project Foundation
- [x] Setup backend and frontend applications
- [x] Configure local development environment
- [x] Setup database and migrations

### Phase 2 — Authentication

#### Keycloak Setup
- [x] Run Keycloak locally
- [x] Create realm and configure client
- [x] Create test users and roles

#### Frontend Authentication
- [ ] Configure OpenID Connect client
- [ ] Implement login flow
- [ ] Implement logout flow
- [ ] Handle access and refresh tokens

#### Backend Security
- [ ] Configure Spring Security OAuth2 Resource Server
- [ ] Validate JWT tokens issued by Keycloak
- [ ] Extract user identity from JWT claims

#### Application Users
- [ ] Create domain User on first login
- [ ] Link application User with Keycloak identity
- [ ] Implement current user endpoint (`/me`)

#### Authorization
- [ ] Configure application roles
- [ ] Implement role-based access control
- [ ] Protect endpoints based on permissions

### Phase 3 — Messaging
- [ ] Implement conversations
- [ ] Implement message storage
- [ ] Add WebSocket communication
- [ ] Add message delivery status

### Phase 4 — Asynchronous Processing
- [ ] Introduce message broker
- [ ] Implement background workers
- [ ] Add asynchronous notification processing

### Phase 5 — Reliability and Quality
- [ ] Add integration tests
- [ ] Improve error handling
- [ ] Add monitoring and logging

### Phase 6 — Additional Features
- [ ] File attachments
- [ ] Message search
- [ ] User presence status
- [ ] Read receipts

---

## License

This project is licensed under the MIT License.
See the `LICENSE` file for details.