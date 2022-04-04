package com.test.exam01;

class Student{
	static int numberOfStudent = 1000;
	String student;
	int card;
	int studentNumber;
	
	public Student(){
		studentNumber = numberOfStudent;
		numberOfStudent =numberOfStudent + 1;
		card = studentNumber + 100;
	}
	
	
}



public class StaticExam {

	public static void main(String[] args) {
		
		Student a = new Student();
		System.out.println(Student.numberOfStudent);
		System.out.println(a.studentNumber);
		System.out.println(a.card);
		
		Student b = new Student();
		System.out.println(Student.numberOfStudent);
		System.out.println(b.studentNumber);
		System.out.println(b.card);
		
		
		
		
		
	}

}
