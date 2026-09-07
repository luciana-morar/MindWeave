# MindWeave
MindWeave is a full-stack cognitive organization and decision-support system designed to help neurodivergent individuals, particularly people with ADHD and autism, transform mental chaos into clear and actionable workflows.

Instead of treating organization, decision-making, and focus as separate problems, MindWeave connects them into a single continuous flow:

- Ideas & Mental Chaos
- Visual Organization
- Knowledge Graph
- Decision Support
- Clear Priority
- Real-Time Focus & Accountability
- Task Completion

Neurodivergent individuals often face three common cognitive barriers:

- **Information Overload** — too many thoughts and tasks at once
- **Decision Paralysis** — feeling stuck when choosing between options
- **Lack of Sustained Focus** — difficulty maintaining attention on a single task

Most existing tools treat these problems in isolation and impose a rigid structure that doesn't align with how neurodivergent minds work. MindWeave tackles all three challenges in one integrated flow.

### 1. Visual Organization

Users freely dump their ideas and tasks onto an interactive screen. The backend automatically organizes them into a logical graph of connections, preventing visual overwhelm and revealing hidden relationships between thoughts.

### 2. Decision Support 

When the user gets stuck between multiple options, the application isolates the problematic choices. Through a short series of simple binary comparisons, it mathematically calculates (using the AHP algorithm) a single clear priority — removing emotional bias and decision fatigue.

### 3. Real-Time Accountability 

Once a priority is set, the user enters a live "body doubling" session. Through a real-time connection (WebSockets), a focus partner (or the system itself) provides accountability. The server monitors progress and helps maintain attention until the goal is completed.
## Architecture

The project is structured as a monorepo with two primary components:

*   **`backend/`**: A Spring Boot application that serves a REST API. It handles business logic, user management, and data persistence.
*   **`frontend/`**: A React single-page application built with Vite. It provides the user interface for interacting with and visualizing the knowledge graph.


### Backend

*   **Java & Spring Boot**: Core framework for building the REST API.
*   **Gradle**: Dependency management and build automation.
*   **PostgreSQL**: Used for relational data, such as user information.
*   **Neo4j**: A graph database used for storing and querying the core note and relationship data.
*   **Flyway**: Manages database schema migrations for PostgreSQL.

### Frontend

*   **React**: A JavaScript library for building the user interface.
*   **Vite**: A modern frontend build tool that provides a fast development experience.
*   **Zustand**: A small, fast, and scalable state-management solution.
*   **Oxlint**: A high-performance linter for JavaScript and TypeScript.

## Getting Started

Follow these instructions to get a local copy of the project up and running for development and testing.

### Prerequisites

*   Java Development Kit (JDK) 17 or later
*   Node.js and npm
*   A running PostgreSQL instance
*   A running Neo4j instance

### Backend Setup

1.  **Configure Databases**:
    *   Create a PostgreSQL database named `mindweave_db`.
    *   Ensure your Neo4j server is running.
    *   Update the database credentials in `backend/src/main/resources/application.yml` to match your local setup:
        ```yaml
        spring:
          # ...
          datasource:
            url: jdbc:postgresql://localhost:5432/mindweave_db
            username: YOUR_POSTGRES_USERNAME
            password: YOUR_POSTGRES_PASSWORD
          # ...
          flyway:
            url: jdbc:postgresql://localhost:5432/mindweave_db
            user: YOUR_POSTGRES_USERNAME
            password: YOUR_POSTGRES_PASSWORD
          # ...
          neo4j:
            uri: bolt://localhost:7687
            authentication:
              username: YOUR_NEO4J_USERNAME
              password: YOUR_NEO4J_PASSWORD
        ```

2.  **Run the application**:
    *   Navigate to the `backend` directory.
    *   Execute the following command to start the Spring Boot server:
        ```bash
        ./gradlew bootRun
        ```
    *   The backend will be available at `http://localhost:8080`.

### Frontend Setup

1.  **Install dependencies**:
    *   Navigate to the `frontend` directory.
    *   Run the following command to install the required packages:
        ```bash
        npm install
        ```

2.  **Run the development server**:
    *   Execute the command:
        ```bash
        npm run dev
        ```
    *   The frontend application will be available at `http://localhost:5173`.

## API

The backend exposes a REST API for the frontend to consume. An initial test endpoint is available to verify the connection.

*   **`GET /api/test`**
    *   Description: Checks the connectivity between the frontend and backend.
    *   Success Response (200 OK):
        ```json
        {
          "status": "Activ",
          "mesaj": "Conexiunea dintre React și Spring Boot funcționează perfect!"
        }
