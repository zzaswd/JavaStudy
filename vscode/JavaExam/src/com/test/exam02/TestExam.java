package com.test.exam02;

class TestExam1{

    void TestOut(){
        System.out.println("부모");
    }
}

class TestExam2 extends TestExam1{

    void TestOut(){
        System.out.println("애기");
    }
}

class TestExam3{

    void TestOut(){
        System.out.println("애기");
    }
}

public class TestExam {
    public static void main(String[] args) {
        TestExam2 a = new TestExam2();
        a.TestOut();
        TestExam1 b = new TestExam1();
        b.TestOut();
        
    }
}
