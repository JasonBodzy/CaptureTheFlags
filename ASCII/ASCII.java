public class ASCII{
	public static void main(String[] args){
		int[] input = {99, 114, 121, 112, 116, 111, 123, 65, 83, 67, 73, 73, 95, 112, 114, 49, 110, 116, 52, 98, 108, 51, 125}; //ASCII Input

		for(int i : input){
			System.out.print((char) i); //Casts ASCII to Char
		}

	}



}
