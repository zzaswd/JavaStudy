package Chapter07;



public class TwoDimention {

	public static void main(String[] args) {

		char ch = 'a';
		
		char[][] array = new char[2][13];
		int count = 0;

		for(int i = 0 ; i < array.length; i++) {
			
			for(int j = 0 ; j < array[i].length;j++) {
				
				array[i][j] = ch++;
			
			}
			
		}

		
		for(int i = 0 ; i < array.length; i++) {
			
			for(int j = 0 ; j < array[i].length;j++) {
				
				System.out.print(array[i][j] + " ");  
				
			}
			
			System.out.println();
			
		}
		
		
		
		
		
	}

}
