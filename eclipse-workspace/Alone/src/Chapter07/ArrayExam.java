package Chapter07;



class Student {
	private int studentID;
	private String name;
	
	
	public void showStudentInfo() {
		System.out.println(studentID + ", "+ name);
	}
	
	public Student(int studentID,String name) {
		this.studentID = studentID;
		this.name = name;
	}
	
	
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}


public class ArrayExam {

	public static void main(String[] args) {

		
		Student[] listStudent = new Student[3];
		listStudent[0] = new Student(1001,"kang");
		listStudent[1] = new Student(1002,"Jang");
		listStudent[2] = new Student(1003,"Lee");
		
		for(int i =0; i<listStudent.length;i++) {
			listStudent[i].showStudentInfo();
		}
		for(int i =0; i<listStudent.length;i++) {
			System.out.println(listStudent[i]);
		}
//		
		
		
		
		
		
	}

}
