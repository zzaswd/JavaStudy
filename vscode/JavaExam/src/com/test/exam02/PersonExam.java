package com.test.exam02;

public class PersonExam {
    public static void main(String[] args) {
        
        Person ksh = new Person();

        String name = "강시형";
        int age = 26;
        String gender = "male";

        ksh.setName(name);
        ksh.setAge(age);
        ksh.setGender(gender);

        System.out.println(ksh.getName());
        System.out.println(ksh.getAge());
        System.out.println(ksh.getGender());
        

    }
}
