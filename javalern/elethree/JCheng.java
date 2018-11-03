public class JCheng{//英文Factorial阶乘
	public static double diGu(int a){
		if(a == 1||a == 0){
			return 1.0;
		}
		return a*diGu(a-1);
	}
	public static void main(String[] args){
		System.out.println("60! = "+diGu(60));
	}
}  