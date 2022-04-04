package com.test.exam05;

class G{
    static class GG{
        int i = 0;
        void gg(){
            System.out.println("GG내부 클래스");
        }
    }
}

public class Exam05 {
    public static void main(String[] args) {
        G.GG g = new G.GG();
        g.gg();
    }
}
