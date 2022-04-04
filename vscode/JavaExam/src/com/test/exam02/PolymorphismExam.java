package com.test.exam02;

class Family{
    void hello(){ System.out.println("안녕하세요 Kim입니다.");    }
    void dinner(){ System.out.println("식사나 한번 하시죠");    }
    void drink(){ System.out.println("술 한잔 ...");    }
  }



class KimFamily extends Family{
    void hello(){ System.out.println("안녕하세요 Kim입니다.");    }
}

class ParkFamily extends Family{
    void hello(){ System.out.println("안녕하세요 Park입니다.");    }
    void dinner(){ System.out.println("배가고파용");    }
    void drink(){ System.out.println("커피 한잔 ...");    }
}

public class PolymorphismExam {
    public static void main(String[] args) {
        
        Family KimF = new KimFamily();

        KimF.hello();

        Family ParkJ = new ParkFamily();
        
        ParkJ.hello();
    
    }
}
