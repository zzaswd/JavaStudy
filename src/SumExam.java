package com.test.exam01;

public class SumExam{ // 파일이랑 class이름이랑 똑같아야 함

	public static void main(String[] argv){

		int sum = 0;
		
		for(int i = 0; i<=100; i++){		
			sum = sum + i ;
		}

		System.out.println("계산 결과 = " + sum);
	}

}