package com.mycompany.campusmanager;

import java.util.*;

public class CampusManager {

    static ArrayList<Course> allCourses = new ArrayList<>();
    static ArrayList<Student> allStudents = new ArrayList<>();
    static ArrayList<Instructor> allInstructors = new ArrayList<>();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("1. Add Student");
            System.out.println("2. Add Instructor");
            System.out.println("3. Add Course");
            System.out.println("4. Remove Student from Campus");
            System.out.println("5. Remove a Course from List");
            System.out.println("6. Change the teacher Of Course");
            System.out.println("7. Print List Of all Courses");
            System.out.println("8. Print CourseList a Student is enrolled in");
            System.out.println("9. Print List of Courses a Teacher is Taking");
            System.out.println("10. Print all Courses List");
            System.out.println("11. Print All Students' list");
            System.out.println("12. Exit Application"); 

            System.out.print("enter choice: ");
            
            try {
               
                choice = Integer.parseInt(input.nextLine());
                System.out.println("\n");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid menu number.\n");
                continue; 
            }

            switch (choice) {

                case 1: {
                    System.out.println("enter name , city , Department , age");
                    String name = input.nextLine();
                    String city = input.nextLine();
                    String Department = input.nextLine();
                    int age = Integer.parseInt(input.nextLine());

                    Student s = new Student(name, city, Department, age);
                    CampusManager.allStudents.add(s);
                    System.out.println("your student object's attributes :" + s.toString());
                    
                    System.out.println("enter the course code student is studying ");
                    int code = Integer.parseInt(input.nextLine()); 
                    
                    boolean hasCourse = false;
                    for (Course c : CampusManager.allCourses) {
                        if (c.getCode() == code) {
                            s.addCourse(c);
                            System.out.println("course added to student's list of courses");
                            hasCourse = true;
                            break;
                        }
                    }
                    if (!hasCourse) {
                        System.out.println("course doesnot exist");
                    }
                    break;
                }

                case 2: {
                    System.out.println(" enter name  , city and age ");
                    String name = input.nextLine();
                    String city = input.nextLine();
                    int age = Integer.parseInt(input.nextLine()); 

                    Instructor I = new Instructor(name, age, city);
                    CampusManager.allInstructors.add(I);
                    System.out.println("your instructor's attributes are " + I.toString());

                    System.out.println("Add course name and course code this instructor is teaching ");
                    String courseName = input.nextLine();
                    int courseCode = Integer.parseInt(input.nextLine()); 
                    
                    Course c = new Course(courseName, courseCode);
                    I.addCourse(c);

                    System.out.println("Course registered and Instructor added ! ");
                    System.out.println("your Instructor object's attributes :" + I.toString());
                    break;
                }

                case 3: {
                    System.out.println("Add course name and code ");
                    String name = input.nextLine();
                    int code = Integer.parseInt(input.nextLine()); 

                    Course c = new Course(name, code);
                    c.createAndRegister(name, code);
                    System.out.println("New course registered");
                    break;
                }

                case 4: {
                    if (CampusManager.allStudents.isEmpty()) {
                        System.out.println("Error: No students in the system to remove.");
                        break;
                    }

                    System.out.print("Enter the Roll Number of the student to remove: ");
                    int targetRoll = Integer.parseInt(input.nextLine()); 

                    boolean studentFound = false;
                    for (int i = 0; i < CampusManager.allStudents.size(); i++) {
                        Student currentStudent = CampusManager.allStudents.get(i);

                        if (currentStudent.getID() == targetRoll) {
                            CampusManager.allStudents.remove(i);
                            System.out.println("Student '" + currentStudent.getName() + "' removed successfully.");
                            studentFound = true;
                            break;
                        }
                    }

                    if (!studentFound) {
                        System.out.println("Error: Student with Roll Number " + targetRoll + " not found.");
                    }
                    break;
                }

                case 5: {
                    if (CampusManager.allCourses.isEmpty()) {
                        System.out.println("the course list is empty");
                        break;
                    }

                    System.out.print("Enter the Course code of the course to remove: ");
                    int targetCode = Integer.parseInt(input.nextLine()); 

                    boolean courseFound = false;
                    for (int i = 0; i < CampusManager.allCourses.size(); i++) {
                        Course currentCourse = CampusManager.allCourses.get(i);

                        if (currentCourse.getCode() == targetCode) {
                            CampusManager.allCourses.remove(i);
                            System.out.println("Course '" + currentCourse.getCourse() + "' removed successfully.");
                            courseFound = true;
                            break;
                        }
                    }

                    if (!courseFound) {
                        System.out.println("Error: Course with code " + targetCode + " not found.");
                    }
                    break;
                }

                case 6: {
                    System.out.print("Enter the Course Code you want to change the teacher for: ");
                    int targetCourseCode = Integer.parseInt(input.nextLine()); 

                    Course foundCourse = null;
                    for (Course c : CampusManager.allCourses) {
                        if (c.getCode() == targetCourseCode) {
                            foundCourse = c;
                            break;
                        }
                    }

                    if (foundCourse == null) {
                        System.out.println("Error: Course code " + targetCourseCode + " not found!");
                        break;
                    }

                    System.out.print("Enter the ID of the New Instructor: ");
                    int targetInstructorID = Integer.parseInt(input.nextLine()); 

                    Instructor foundInstructor = null;
                    for (Instructor inst : CampusManager.allInstructors) {
                        if (inst.getID() == targetInstructorID) {
                            foundInstructor = inst;
                            break;
                        }
                    }

                    if (foundInstructor == null) {
                        System.out.println("Error: Instructor with ID " + targetInstructorID + " not found!");
                        break;
                    }
                    
                    foundCourse.changeTeacher(foundCourse, foundInstructor);

                    System.out.println("Successfully assigned Instructor " + foundInstructor.getName() +
                            " to teach " + foundCourse.getCourse());
                    break;
                }

                case 7: {
                    if (CampusManager.allCourses.isEmpty()) {
                        System.out.println("Error: Course list is empty");
                    } else {
                        for (Course c : CampusManager.allCourses) {
                            System.out.println(c.toString());
                        }
                    }
                    break;
                }

                
                
                
                case 8: {
    
                 if (CampusManager.allStudents.isEmpty()) {
                      System.out.println("Error: No students registered in the campus database yet.");
                   break;
            }

                 System.out.print("Enter Student ID to view enrolled courses: ");
                    int targetID = Integer.parseInt(input.nextLine()); // Safely processed without buffer errors
    
                      boolean studentFound = false;

   
                        for (int i = 0; i < CampusManager.allStudents.size(); i++) {
                           Student currentStudent = CampusManager.allStudents.get(i);

                  if (currentStudent.getID() == targetID) {
                        studentFound = true;
                          System.out.println("\n Course List for  " + currentStudent.getName() + " (ID: " + targetID + ") ");
            
           
                  if (currentStudent.enrolledCourses.isEmpty()) {
                    System.out.println("This student is not currently enrolled in any courses.");
            } else {
               
                for (Course c : currentStudent.enrolledCourses) {
                   
                    System.out.println("Course Code: " + c.getCode() + " | Course Name: " + c.getCourse());
                }
            }
            break;
        }
    }

  
           if (!studentFound) {
                System.out.println("Error: Student with ID " + targetID + " not found.");
            }
    
             break;
          }
                
               
                case 9: {
                    if (CampusManager.allInstructors.isEmpty()) {
                       System.out.println("Error: No instructors registered in the system yet.");
                         break;
                   }

                        System.out.print("Enter Instructor ID: ");
                            int targetID = Integer.parseInt(input.nextLine());
    
                       boolean instructorFound = false;
 
               for (int i = 0; i < CampusManager.allInstructors.size(); i++) {
                   Instructor inst = CampusManager.allInstructors.get(i);

                 if (inst.getID() == targetID) {
                       instructorFound = true;
                       System.out.println("\n- Courses Taught by " + inst.getName() + " ");
            
            
                     if (inst.teaching.isEmpty()) {
                            System.out.println("This instructor is not assigned to any courses yet.");
            }    else {
                    for (Course c : inst.teaching) {
                    System.out.println("Course Code: " + c.getCode() + " | Course Name: " + c.getCourse());
                }
            }
                    break; 
                 }
        }
 
                    if (!instructorFound) {
                      System.out.println("Error: Instructor with ID " + targetID + " not found.");
            } 
               break;
           }
                
                
                case 10:{
                    
                    for(Course c : CampusManager.allCourses){
                        System.out.println(c.toString());
                    }
                    
                    break;}
                
                
                case 11:{
                    
                    for(Student s : CampusManager.allStudents){
                        System.out.println(s.toString());
                    }
                    
                    break;}
                   
                case 12:
                    System.out.println("Exiting Application. Goodbye!");
                    break;

                default: {
                    System.out.println("Invalid Choice! Please pick a number from the menu.");
                    break;
                }
            }

        } while (choice != 12);
        
        input.close();
    }
}