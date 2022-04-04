package com.test.exam01;

class ErrorTest{
    public void errormaking() throws ArithmeticException{
        int a = 4/0;
        System.out.println("a = " + a);
    }

}

class FoolException extends Exception{

}


public class ExceptionExam {
   

    public void sayNickname(String nickname){
        if(nickname.equals("fool"))
            try {
                throw new FoolException(); //강제적으로 에러 발생시키는 방법.
            } catch (FoolException e) {
                System.err.println("FoolException이 발생했습니다.");
            }
        System.out.println("당신의 별명은 " + nickname + "입니다.");
    }
    
    
    public static void main(String[] args) {
        int c ;
        
        try{ // error가 날 것 같은 곳을 묶어줌.
            c= 4/0;
            System.out.println("다행이다..1");
        }catch(ArithmeticException e){ // 괄호 안에 예외처리를 해줄 class를 넣어줌. e는 클래스 변수임.
            // 예외발생 시 조치할 부분.
            c= - 1;
        }finally{ // 옵션. 예외가 발생하더라도 실행시켜야 할 부분
            System.out.println("다행이다..2");
        }
        System.out.println(c);
        // ErrorTest errorTest = new ErrorTest();
        // errorTest.errormaking();
        
        ExceptionExam exam = new ExceptionExam();
        exam.sayNickname("fool");
        exam.sayNickname("genius");
    
    
    }
    // case(c=4/1) 다행이다..1 다행이다..2 4
    // case(C=4/0) 다행이다..2 -1

}
