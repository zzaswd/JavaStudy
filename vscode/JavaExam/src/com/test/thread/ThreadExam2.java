package com.test.thread;

class ExamClass2 extends Thread{

    @Override
    public void run(){
        try {
            for(int i = 0; i < 30 ; i ++){
                Thread.sleep(1000);
                System.out.println("Thread1이 실행");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


public class ThreadExam2 {
    
    public static void main(String[] args) {
        ExamClass2 examClass2 = new ExamClass2();
        examClass2.start();

        for(int i = 0 ; i < 30 ; i ++){
            try {
                Thread.sleep(100);

                System.out.println(i);
                
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
      }
    }
}
