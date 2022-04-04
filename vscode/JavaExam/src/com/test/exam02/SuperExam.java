package com.test.exam02;


class Point{
    int x,y;

    Point(){
        System.out.println(" 부모 클래스 인자 X");
    }
    Point(int x,int y){
        this.x = x;
        this.y = y;
        System.out.println(" 부모 클래스 인자 O");
    }

}

class Point3D extends Point{
    int z = 30;
    
    Point3D(){
        this(100,200,300);
        System.out.println("자식 클래스");
    }

    Point3D(int x,int y, int z){ 
        System.out.println("자식 클래스 인자 O");
    }
}

class  Point4D extends Point3D{
    
    Point4D(){
        super(1,2,3);
        System.out.println("손주 클래스");
    }
    Point4D(int x,int y){
        System.out.println("손주 클래스 인자 O");
    }

}

public class SuperExam {
    public static void main(String[] args) {
        Point4D p = new Point4D();
        System.out.println(p.x + "    " + p.y + " " + p.z);
    }


}
