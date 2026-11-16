
package com.mycompany.campusmanager;
import java.util.* ;
import java.math.*;

public class Instructor extends Member {
    ArrayList <Course> teaching = new ArrayList<>();
    
    public Instructor(String name , int age , String city ){
       super(name , age , city);
    }
    
 
   
    @Override
    public void addCourse(Course c){
        CampusManager.allCourses.add(c);
        teaching.add(c);
    }
    
    public void removeCourse(Course c , Instructor I){
        teaching.remove(c);
        c.changeTeacher( c , I);
    }
}
