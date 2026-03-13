# How to run tutor Api Bot


## Requirements

- Java version 22 or superior 
- Maven
- Postmen extension in VsCode


## How to run

1. Clone the repository or unzip the project.
2. Open an integrated terminal in the root directory of the repository (tutorbot-api).
3. execute the coomand: `mvn spring-boot:run` or `/mvnw spring-boot:run`
** NOTE THE SERVER ITS CONFIGURED TO INITIALIZE IN PORT 8080, this is an example of how the URL its goint to look like:  `http://localhost:8080/api...`

## Main endpoints

* **GET** `/api/students` - List of all studnets.
* **POST** `/api/students` - Register a new student.
* **GET** `/api/exercises` - List all exercises in the repository.
* **POST** `/api/exercises/submit` - Sen an answer for feedback.

## Demostration