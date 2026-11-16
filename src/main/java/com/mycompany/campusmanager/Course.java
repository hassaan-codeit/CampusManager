
package com.mycompany.campusmanager;

import java.util.* ;
import java.math.*; 
public class Course {
   private ArrayList <Student> enrolledStudents = new ArrayList<>();
   private Instructor [] teacherOfCourse = new Instructor[1];
   
    private String courseName;
    private int courseCode;
    public Course(String name , int code ){
        courseName = name;
         courseCode=code;
         
         
    }
    
    
    public static Course createAndRegister(String name, int code) {
        
        Course newCourse = new Course(name, code);
        
        CampusManager.allCourses.add(newCourse);
        
        return newCourse;
    }
    
    public String getCourse(){
        return courseName;
    }
    public int getCode(){return courseCode;}
    
    public void setCourse(String name ){
        courseName = name;
    }
    
    public void setCode(int code){
         courseCode=code;
    }
    
   public void enrollStudentToCourse(Student s){
       enrolledStudents.add(s);
   }
    
   public void removeStudentFromCourse(Student s){
       enrolledStudents.remove(s);
   }
   
   public void changeTeacher(Course c , Instructor I){
       teacherOfCourse[0] = I;
       
       I.teaching.add(c);
   }
   
   public Instructor[] getTeacher(){
       return teacherOfCourse;
   }
   
   public String toString(){
       return (" Course name " + courseName + " course code is " + courseCode);
   }
}
