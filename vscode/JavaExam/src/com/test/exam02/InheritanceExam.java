package com.test.exam02;

class Animal{

    int weight;
    int height; // 두개의 전역변수
    
    void pop(){ System.out.println("동물이당.");}
}

class Dog extends Animal{
    
}




public class InheritanceExam {
    
    public static void main(String[] args) {
        Dog ksh = new Dog(); //Dog 변수 메소드
        ksh.pop();

    }
}
