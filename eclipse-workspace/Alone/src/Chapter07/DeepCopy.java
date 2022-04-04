package Chapter07;


public class DeepCopy {

	public static void main(String[] args) {

		Student[] array1 = new Student[3];
		Student[] array2 = new Student[3];
		
		
		array1[0] = new Student(1001,"kang");
		array1[1] = new Student(1002,"Jang");
		array1[2] = new Student(1003,"Lee");
		
		
		array2[0] = new Student(11251,"asdsasd");
		array2[1] = new Student(123123,"asdads");
		array2[2] = new Student(12312,"ASdads");
		
		for ( int i = 0; i < array1.length; i++) {
 			array2[i].showStudentInfo();
 			
 		}
		System.out.println("---------------");


		for(int i = 0; i<array1.length;i++) {
			array2[i].setStudentID(array1[i].getStudentID());
			array2[i].setName(array1[i].getName());
			
		}
 		
		for ( int i = 0; i < array1.length; i++) {
 			array2[i].showStudentInfo();
 			
 		}

		System.out.println("---------------");
		array1[0].setName("lms");
		
		for ( int i = 0; i < array1.length; i++) {
 			array1[i].showStudentInfo();
 			
 		}

		System.out.println("---------------");
		
		for ( int i = 0; i < array1.length; i++) {
 			array2[i].showStudentInfo();
 			
 		}
		

		System.out.println("---------------");
		
	}

}
