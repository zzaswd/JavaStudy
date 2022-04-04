package com.test.exam01;


class CarFactory {
	static int Num = 1000;
	int carNum;
	static CarFactory instance = new CarFactory();
	
	private CarFactory() {
		Num = Num+1;
		this.carNum = Num;	
	}
	
	public static CarFactory getInstance() {
		
		if(instance == null) {
			
		}
		
		return instance;
		
	}
	
}



public class SingletonExam {

	public static void main(String[] args) {
	
		CarFactory factory = 
		
		
		
	}
	
	
}
