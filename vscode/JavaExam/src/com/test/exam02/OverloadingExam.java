package com.test.exam02;

class A{

    public void a(){
        System.out.println("파라미터가 없음");
    }


    public void a(int i, int j){
        System.out.println("파라미터가 있음");
    }


}



public class OverloadingExam {
    public static void main(String[] args) {
        A test = new A();
        test.a();
    //    test.a(1,2);

    }
}
