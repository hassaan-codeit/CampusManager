
package com.mycompany.campusmanager;


public abstract class Member {
 private   String name ; 
    private int age;
    private String city;
    private static int ID =1;
    private final int serialNo;
    
    public Member(String name , int age , String city ){
         if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or above.");}
         
        this.name=name;
        this.age=age;
        this.city=city;
        serialNo =ID;
        ID++;
    }
        
     public  int getAge(){return this.age ;}
     
      
    public  String getCity(){ return city;}
    
      
    public  String getName(){return name;}
    
    public  int getID(){return this.serialNo;}
    
    
     public  void setAge(int age){this.age = age;}
      
    public  void setCity(String city){this.city = city;}
    
    
    public  void setName(String name){ this.name = name;}
     

   public abstract void addCourse(Course c);
   
    public String toString(){
        return (" Name is  " + name + " age is   "+ age + "  City is  "+ city + " ID is  " + serialNo);
    }
  
    
    
    
    
}
