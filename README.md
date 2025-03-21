Spring Boot CRUD API with Third-Party Integration
-------------------------------------------------


This project is a Spring Boot CRUD application that integrates with a third-party API, includes database operations, and follows best coding practices. It provides RESTful endpoints to fetch, store, update, and delete tasks while ensuring efficiency, scalability, and maintainability.


Features
  - Retrieve and display data from JSONPlaceholder API
  - Store tasks in a MySQL database
  - CRUD operations on stored tasks
  - Group tasks by completion status
  - Pagination for stored tasks
  - Exception handling and validation


Tech Stack
  - Backend: Java 17, Spring Boot 3.4.3
  - Database: MySQL
  - Dependencies: Spring Web, Spring Data JPA, Lombok, HikariCP
  - Tools: Eclipse/IntelliJ IDEA, Postman, Git/GitHub

Prerequisites
  - Java 17+
  - MySQL Server
  - Maven
  - Git


Database Schema :

  CREATE TABLE tasks (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    task_id INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    completed BOOLEAN NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  );



Task Management APIs

 Get all stored tasks (Paginated) :
   -  GET --- http://localhost:8080/api/tasks/paginated?page=0&size=3
   -  Response
     {
          "content": [
              {
                  "id": 1,
                  "title": "delectus aut autem",
                  "completed": false,
                  "createdAt": "2025-03-21T18:37:24",
                  "updatedAt": "2025-03-21T18:37:24"
              },
              {
                  "id": 2,
                  "title": "quis ut nam facilis et officia qui",
                  "completed": false,
                  "createdAt": "2025-03-21T18:37:30",
                  "updatedAt": "2025-03-21T18:37:30"
              },
              {
                  "id": 3,
                  "title": "fugiat veniam minus",
                  "completed": false,
                  "createdAt": "2025-03-21T18:37:35",
                  "updatedAt": "2025-03-21T18:37:35"
              }
          ],
          "pageable": {
              "pageNumber": 0,
              "pageSize": 3,
              "sort": {
                  "empty": true,
                  "unsorted": true,
                  "sorted": false
              },
              "offset": 0,
              "unpaged": false,
              "paged": true
          },
          "last": false,
          "totalPages": 2,
          "totalElements": 5,
          "size": 3,
          "number": 0,
          "sort": {
              "empty": true,
              "unsorted": true,
              "sorted": false
          },
          "first": true,
          "numberOfElements": 3,
          "empty": false
      }

 Get all task
   - GET --- http://localhost:8080/api/tasks
   - Response
      [
        {
            "id": 1,
            "title": "delectus aut autem",
            "completed": false,
            "createdAt": "2025-03-21T18:37:24",
            "updatedAt": "2025-03-21T18:37:24"
        },
        {
            "id": 2,
            "title": "quis ut nam facilis et officia qui",
            "completed": false,
            "createdAt": "2025-03-21T18:37:30",
            "updatedAt": "2025-03-21T18:37:30"
        },
        {
            "id": 3,
            "title": "fugiat veniam minus",
            "completed": false,
            "createdAt": "2025-03-21T18:37:35",
            "updatedAt": "2025-03-21T18:37:35"
        },
        {
            "id": 4,
            "title": "et porro tempora",
            "completed": true,
            "createdAt": "2025-03-21T18:37:40",
            "updatedAt": "2025-03-21T18:37:40"
        },
        {
            "id": 8,
            "title": "quo adipisci enim quam ut ab",
            "completed": true,
            "createdAt": "2025-03-21T16:48:55",
            "updatedAt": "2025-03-21T16:48:55"
        }
    ]

 Get task by ID :
   -  GET --- http://localhost:8080/api/tasks/8
   -  Response
    {
        "id": 8,
        "title": "quo adipisci enim quam ut ab",
        "completed": true,
        "createdAt": "2025-03-21T16:48:55",
        "updatedAt": "2025-03-21T16:48:55"
    }
  
 Create a new task (Fetch from third-party API & store in DB) :
   -  POST --- http://localhost:8080/api/tasks/4
   -  Response
     {
      "id": 4,
      "title": "et porro tempora",
      "completed": true,
      "createdAt": "2025-03-21T18:37:40",
      "updatedAt": "2025-03-21T18:37:40"
    }
  
 Update a task :
   -  PUT --- http://localhost:8080/api/tasks/1
   -  Response
     {
          "id": 1,
          "title": "delectus aut autem",
          "completed": false,
          "createdAt": "2025-03-21T18:37:24",
          "updatedAt": "2025-03-21T18:37:24"
      }
  
 Delete a task by ID :
   -  DELETE --- http://localhost:8080/api/tasks/5
   -  Response
     Task deleted successfully
  
 Get tasks grouped by completion status :
   -  GET --- http://localhost:8080/api/tasks/grouped
   -  Response
     {
            "Completed": [
                {
                    "id": 4,
                    "title": "et porro tempora",
                    "completed": true,
                    "createdAt": "2025-03-21T18:37:40",
                    "updatedAt": "2025-03-21T18:37:40"
                },
                {
                    "id": 8,
                    "title": "quo adipisci enim quam ut ab",
                    "completed": true,
                    "createdAt": "2025-03-21T16:48:55",
                    "updatedAt": "2025-03-21T16:48:55"
                }
            ],
            "Pending": [
                {
                    "id": 1,
                    "title": "delectus aut autem",
                    "completed": false,
                    "createdAt": "2025-03-21T18:37:24",
                    "updatedAt": "2025-03-21T18:37:24"
                },
                {
                    "id": 2,
                    "title": "quis ut nam facilis et officia qui",
                    "completed": false,
                    "createdAt": "2025-03-21T18:37:30",
                    "updatedAt": "2025-03-21T18:37:30"
                },
                {
                    "id": 3,
                    "title": "fugiat veniam minus",
                    "completed": false,
                    "createdAt": "2025-03-21T18:37:35",
                    "updatedAt": "2025-03-21T18:37:35"
                }
            ]
        }

