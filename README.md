# 📚 QuizApp

A simple **Spring Boot-based Quiz Application** that allows users to take quizzes on various topics. It demonstrates core Spring Boot concepts like RESTful APIs, layered architecture (Controller → Service → Repository), and JPA-based database access.

---

## 🚀 Features

* Create quizzes with multiple questions
* Fetch quizzes by quiz ID
* Submit answers and get calculated score
* Layered architecture (Controller → Service → Repository)
* RESTful APIs using Spring Boot
* PostgreSQL for database management

---

## 🛠️ Tech Stack

* **Backend**: Java, Spring Boot, Spring Web, Spring Data JPA
* **Database**: PostgreSQL
* **Build Tool**: Maven
* **IDE**: IntelliJ / VS Code / Eclipse

---

## 📬 API Documentation (Swagger)

Swagger UI is enabled for API testing and documentation.

* Run the app
* Go to: `http://localhost:8080/swagger-ui.html`

### Example Endpoints

| Method | Endpoint     | Description         |
| ------ | ------------ | ------------------- |
| GET    | /quiz/all    | Get all quizzes     |
| GET    | /quiz/{id}   | Get quiz by ID      |
| POST   | /quiz/create | Create a new quiz   |
| POST   | /quiz/submit | Submit quiz answers |

---

## 🗃️ Database Schema (ER Diagram)

```
[Quiz] ---< [Question] ---< [Option]
```

* **Quiz**: id, title, description
* **Question**: id, quiz\_id (FK), question\_text
* **Option**: id, question\_id (FK), option\_text, is\_correct

> You can use [dbdiagram.io](https://dbdiagram.io) or tools like MySQL Workbench / pgModeler to visualize ER diagrams.

---

## 🐳 Docker Support

> Make sure Docker is installed before proceeding.

### 🧱 Steps:

1. Create a `Dockerfile` for Spring Boot App:

```dockerfile
FROM openjdk:17
COPY target/quizapp.jar quizapp.jar
ENTRYPOINT ["java", "-jar", "quizapp.jar"]
```

2. Create a `docker-compose.yml` to run app + PostgreSQL:

```yaml
version: "3.8"
services:
  postgres:
    image: postgres
    restart: always
    environment:
      POSTGRES_USER: quizuser
      POSTGRES_PASSWORD: quizpass
      POSTGRES_DB: quizdb
    ports:
      - "5432:5432"

  quizapp:
    build: .
    depends_on:
      - postgres
    ports:
      - "8080:8080"
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://postgres:5432/quizdb
      SPRING_DATASOURCE_USERNAME: quizuser
      SPRING_DATASOURCE_PASSWORD: quizpass
```

3. Run the app with:

```bash
docker-compose up --build
```

---

## 🌐 Frontend Integration

This backend can be connected to any frontend framework. Recommended stacks:

### ✅ React Example:

* **Frontend**: React with Axios
* **API Base URL**: `http://localhost:8080`
* Use `GET /quiz/all` to fetch quizzes
* Use `POST /quiz/submit` to send answers and get scores

> You can use Bootstrap or Material-UI for styling the frontend quiz UI.

---

## 📄 License

This project is open-source under the [MIT License](LICENSE).

---
