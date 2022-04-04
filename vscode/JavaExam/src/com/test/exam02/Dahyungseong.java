package com.test.exam02;

class Animal{
    public void Move(){   }
}

class Human extends Animal{
    public void Move(){
        System.out.println("사람이 두발로 걷습니다.");
    }

}

class Tiger extends Animal{
    public void Move(){
        System.out.println("호랑이는 네발로 걷습니다.");
    }

}
class Eagle extends Animal{
    public void Move(){
        System.out.println("독수리가 하늘을 납니다.");
    }

}

public class Dahyungseong {

    public static void main(String[] args) {
        
        Dahyungseong Test = new Dahyungseong(); // Dahyungseong이라는 class의 moveAnimal이라는 method를 사용할거니깐 객체 생성해줘야 함.
        Animal human= new Human(); // Human이라는 class내부의 Move라는 메소드만 쓰기 위해 이렇게 사용. Animal class에는 가상메소드(Move)를 만들어줘야 함.
        Animal tiger = new Tiger(); // 동일
        Animal eagle = new Eagle(); // 동일
        Test.moveAnimal(human); // moveAnimal 메소드 사용하면서 매개변수로 Animal class 변수를 사용. 즉 human.move()가 되는데 human은 Animal 클래스변수지만 Human class 생성자로 만들었기 때문에 Human class의 Move 실행.
        Test.moveAnimal(tiger);
        Test.moveAnimal(eagle);
        
    }

    public void moveAnimal(Animal animal){
        animal.Move();
    }
}
