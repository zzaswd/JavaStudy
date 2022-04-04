package com.test.exam03;



interface Sales{

    public void manage(); // abstract와 유사하게 선언부만 사용.
    public void goal();
    public void product();

}

class ATeam implements Sales{

    @Override
    public void manage() {
        System.out.println("A팀장입니다. 열심히 하겠습니다.");
    }

    @Override
    public void goal() {
        System.out.println("A팀은 올해 70억을 달성해보겠습니다.");
    }

    @Override
    public void product() {
        System.out.println("A팀의 주력상품은 TV입니다..");
    }
    
}

class BTeam implements Sales{

    @Override
    public void manage() {
        System.out.println("B팀장입니다. 열심히 하겠습니다.");
    }

    @Override
    public void goal() {
        System.out.println("B팀은 올해 100억을 달성해보겠습니다.");
    }

    @Override
    public void product() {
        System.out.println("B팀의 주력상품은 냉장고입니다..");
    }
    
}


public class InterfaceExam {
    public static void main(String[] args) {
        ATeam aSalePlan = new ATeam();
        aSalePlan.manage();
        aSalePlan.goal();
        aSalePlan.product();

        BTeam bSalePlan = new BTeam();
        bSalePlan.manage();
        bSalePlan.goal();
        bSalePlan.product();
    }
}
