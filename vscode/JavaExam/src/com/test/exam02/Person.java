package com.test.exam02;



public class Person {
    
    private String name;
    private int age=15;
    private String gender; 

    public Person(){   }
    public Person(String name,int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    
    //getter method
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getGender(){
        return gender;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public void smile(){
        System.out.println(name + " 웃어요");
    }

    public void angry(){
        System.out.println(name + " 화내지 말아요");
    }


}
