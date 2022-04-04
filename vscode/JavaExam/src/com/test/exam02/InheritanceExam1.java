package com.test.exam02;


class Parent{
    
    // 생성자는 클래스의 전역변수(멤버변수)를 초기화시킨다.
    // 생성자는 클래스의 인스턴스가 생성될 때 가장 먼저 실행되어 
    // 생성자 내에 기술된 명령문을 실행한다.

    // this, super --> 지시어, 명령어, 예약어, 키워드라고 불림.

    Parent(){
        this(1); // this는 위치한 클래스의 생성자를 의미하며 인자 하나를 넣은 것.
        System.out.println("인자가 없는 Parent 클래스의 생성자");
    }

    Parent(int i){
        System.out.println("인자가 1개인 Parent 클래스의 생성자");
    }

    int a;
}


class Child extends Parent{
    int c1;
    int c2;
    Child(){
        super(); // super()는 기본적으로 자식클래스의 생성자에 추가되기 때문에
                  // super()가 있던 없던 동일하게 부모 클래스의 생성자도 실행된다.
                  // 다만 부모클래스의 매개변수가 있는 생성자만 실행시키고 싶을 때
                  // super(1)처럼 실행하면 된다.
        
                  // super()는 항상 생성자의 첫번째에 위치해야 한다.
        
        System.out.println("인자가 없는 Child 클래스의 생성자");
        
    }
    
    Child(int i){
        System.out.println("adas");
    }

    Child(int c1, int c2){
        
        this(1);
        System.out.println("변수 초기화");
        this.c1 = c1;
        this.c2 = c2;
    }

}

class Gchild extends Child{
    Gchild(){
    System.out.println("Gchild");
    }

}

public class InheritanceExam1 {

    public static void main(String[] args) {
 
        //Gchild ksh = new Gchild();
        Child child = new Child(1,2);
        System.out.println("Child Class의 전역변수 :" + child.c1 + "    "+child.c2);
    }
    
}
