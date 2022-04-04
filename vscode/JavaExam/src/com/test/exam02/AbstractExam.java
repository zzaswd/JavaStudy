package com.test.exam02;


abstract class SalesPlan {
    public void companyGoal(){
        System.out.println("2022년 전체 부서 300억 목표 달성!");
    }
    abstract public void departGoal();
    abstract public void product();
}

class ATeam extends SalesPlan{
    public void manager(){
        System.out.println("A팀 팀장 : 강시형");
    }
    
    public void departGoal(){
        System.out.println("A팀 목표 70억");
    }
    
    public void product(){
        System.out.println("A팀 주력 상품은 TV입니다.");
    }
}

class BTeam extends SalesPlan{
    public void manager(){
        System.out.println("B팀 팀장 : 장문석");
    }
    
    public void departGoal(){
        System.out.println("B팀 목표 100억");
    }
    
    public void product(){
        System.out.println("B팀 주력 상품은 냉장고입니다.");
    }
}

public class AbstractExam { 
    // public AbstractExam{}
    public static void main(String[] args) {
        ATeam ATeamSalesPlan = new ATeam();
        ATeamSalesPlan.manager();
        ATeamSalesPlan.companyGoal();
        ATeamSalesPlan.departGoal();
        ATeamSalesPlan.product();
        System.out.println("");
        
        BTeam BTeamSalesPlan = new BTeam();
        BTeamSalesPlan.manager();
        BTeamSalesPlan.companyGoal();
        BTeamSalesPlan.departGoal();
        BTeamSalesPlan.product();


    }
}