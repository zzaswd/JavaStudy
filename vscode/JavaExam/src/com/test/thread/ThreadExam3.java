package com.test.thread;


public class ThreadExam3 {
    public static void main(String[] args) { // anonymous 형

        new Thread(new Runnable(){  // a(){} 보통의 생성자 구성
            
            @Override
            public void run(){
                for(int i = 0 ; i < 30 ; i ++){
                    try {
                        Thread.sleep(1000);
                        System.out.println("Thread1이 수행");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        for(int i = 0; i < 30 ; i++){
                try {
                    Thread.sleep(1000);
                    System.out.println("Thread2이 수행");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }
    }
}
