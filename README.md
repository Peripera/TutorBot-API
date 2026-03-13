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

The following screenshot demostrate the fuction of the project, using Postman.


### 1. Manage student list
* **Listar todos los estudiantes:**
![List of all students](TutorBot-APIt/getStudents.png)

* **Get student by Id:**
![Student by ID](TutorBot-APIt/getStudenId.png)

* **Register new student:**
![New student](TutorBot-APIt/addNew.png)

### 2. Exercises and scores
* **List all the exercises in the repository:**
![List of exercises](TutorBot-APIt/exercisesGet.png)

* **Filter by difficulty e.g(Easy, Medium, Hard):**
![Filter by difficulty](TutorBot-APIt/difficultyEx.png)

* **Send an answer and recieve feedback:**
![Submmit answer](TutorBot-APIt/feedbackstudent.png)

* **Recorded of answers with feedback by student:**
![Recorded feedback](TutorBot-APIt/studentFeedbacks.png)

* **Error message for students not found (404):**
![Error 404](TutorBot-APIt/studentMessage.png)