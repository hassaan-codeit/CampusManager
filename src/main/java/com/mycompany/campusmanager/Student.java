
package com.mycompany.campusmanager;
import java.util.* ;
import java.math.*;

public class Student extends Member{
    ArrayList <Course> enrolledCourses = new ArrayList<>();
    
   private String Department;
    public Student(String name , String city , String Department , int age) {
       
        super(name , age  ,city);
        this.Department  =Department;
        
    }
    
       
       public String getDepartment(){
          return Department;
       }
       
        
        public void setDept(String s){
            this.Department = s;
        }
    
    @Override
    public String toString(){
        
      return ("department is " + this.Department + super.toString() );
    }
    @Override
    public void addCourse(Course c){
         CampusManager.allCourses.add(c);
        enrolledCourses.add(c);
       c.enrollStudentToCourse(this);
    }
    
    
    public void removeCourse(Course c){
        enrolledCourses.remove(c);
        c.removeStudentFromCourse(this);
        
    }
}
