# Campus Manager

Campus Manager is a console application for managing campus students, instructors, and courses. It can register and remove students and courses, assign instructors, enroll students, and display course and member lists.

## OOP structure

- `Member` is the abstract base class containing shared member details and the `addCourse` contract.
- `Student` and `Instructor` extend `Member` and implement their course relationships.
- `Course` stores course information, enrolled students, and its instructor.
- `CampusManager` contains the interactive menu and application entry point.

## Compile and run from `src/`

From the project root:

```text
cd src
javac -d ../build main/java/com/mycompany/campusmanager/*.java
java -cp ../build com.mycompany.campusmanager.CampusManager
```

Java 17 or newer is required.
