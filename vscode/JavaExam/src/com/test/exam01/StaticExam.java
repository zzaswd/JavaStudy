package com.test.exam01;

class Number{
    // static 변수와 일반 변수
    int a = 0;
    int b = 0;

    // static 메소드와 일반 메소드
    void print(){
        System.out.println("static method test!!!!");
    }

    void print1(){
        System.out.println("instance method test!!!");
    }

}


public class StaticExam {
    
    public void main(String[] args) {
        Number number1 = new Number(); // number1이라는 클래스변수(객체) 생성
        Number number2 = new Number();  // number2라는 클래스변수(객체) 생성

        number1.a = 1; //a라는 객체변수에 1
        number1.b = 1; //b라는 객체변수에 1
        
        System.out.println(number2.a + " " + number2.b); // 1 0  why? 
                                                         // static을 선언하면서 a라는 변수는 메모리에 주소가 고정되는데
                                                         // static을 선언하지 않은 b라는 변수는 생성자마다 새로운 주소값이 생성되어서 다른 값이 나오는 것.

        
       // Number.print(); // 객체를 생성하지않고 바로 메소드 실행
        number1.print();   // 객체를 통하여 메소드 실행
        //Number.print1();  error. 
        // number1.print1() // instance 
        
        
    }
}
