package com.test.thread;

class ExamClass implements Runnable{
    @Override
    public void run() { // Thread.start()하면 run이라는 구문을 찾아서 백그라운드에서 실행시키는 것 같다.
        for(int i = 0; i<30 ; i++){
            try{
            Thread.sleep(1000); // 1초간 선언을 미룬다. 
            System.out.println("Thread1가 실행");
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    

}



public class ThreadExam1 {
    public static void main(String[] args) {
        Thread thread  = new Thread(new ExamClass()); // Thread 생성자의 매개변수로 클래스형을 넣어줘야하나보다.
        thread.start(); // 비동기 시작
        
        for(int i = 0; i<30;i++){
            try{
            Thread.sleep(1000);
            System.out.println("Thread2가 실행");
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
