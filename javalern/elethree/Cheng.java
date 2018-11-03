public class Cheng{
	public static void main(String[] args){
		int col = 0;
	int row = 0;
		for(row = 1;row < 10;row++){
			for(col = 1;col <= row;col++){
				System.out.print(row +"*"+col+"="+(row*col)+"\t");
			}
			System.out.println( );
		}
	}
}