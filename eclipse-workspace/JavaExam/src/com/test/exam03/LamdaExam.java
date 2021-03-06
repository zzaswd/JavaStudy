package com.test.exam03;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface
interface MyLamdaFunction{
	int sum(int a,int b);
}

@FunctionalInterface
interface MyPrint{
	String printLamda();
}

public class LamdaExam {

	public static void main(String[] args) {
		MyLamdaFunction lamdaFunction = (int a, int b) -> a+b; // 함수형 생략했고, return대신 -> 사용.
		System.out.println(lamdaFunction.sum(3, 4));	
		
		MyPrint myPrint = ()->"Hello World 1"; // 인자가 없어서 빈칸
		System.out.println(myPrint.printLamda());
		
		//Supplier : 매개변수 없이 반환값만을 갖는 함수형 인터페이스
		Supplier<String> supplier = ()->"Hello world 2";
		System.out.println(supplier.get());
		
		//Consumer : 객체 T를 매개변수로 받아서 사용. 반환값이 없는 함수형 인터페이스
		
		Consumer<String> consumer = (str)->System.out.println(str.split(" ")[0]); //split이 스페이스바를 기준으로 나누는 것을 의미.
		consumer.andThen(System.out::println).accept("Hello World 3");
		
		//Function 객체 T를 매개변수로 받아서 처리한 후 R로 반환하는 함수형 인터페이스.
		Function<String, Integer> function = str->str.length(); // <T,R>
		System.out.println(function.apply("Hello World")); 

		//Predicate : 객체 T를 매개변수로 받아서 처리한 후 Boolean형으로 반환하는 함수형 인터페이스
		Predicate<String> predicate = (str) -> str.equals("Hello World");
		System.out.println(predicate.test("Hi World")); // Hello World를 넣으면 True
		
		
		// 즉, 코드의 길이를 줄이고 가독성을 높이는 것이 람다의 목적.
		// 일반 참조형,메소드 참조형, 생성자 참조형.... 줄일 수 있는 건 다 줄이는 것.
		// 1. 일반참조형
		Function<String,Integer> function2 = String::length;
		System.out.println(function2.apply("Hello world"));
		
		// 2. 메서드 참조형
		Consumer<String> consumer2 = System.out::println; // System이 외부 클래스, out이 내부클래스
		consumer2.accept("Hello World 4");
		
		// 3 . 생성자 참조형
		
		//Supplier<String> supplier1 = String::new
		
		
		
		
		
		
		
		
	}

}
