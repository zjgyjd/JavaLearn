import java.util.*;
public class GuessNum{
	public static void main(String[] args){
		while(true){
			System.out.println("游戏开始");
		new GameStart().start();
		System.out.println("游戏开始,输入1继续,输入q退出");
		Scanner scan = new Scanner(System.in);
		String scanner = scan.nextLine();
		if(scanner.equals("q")){
			System.out.println("游戏结束!!!");
			break;
		}
		}
	}
}
class GameStart{
	Random random = new Random(); 
	private final int value = random.nextInt(100);
	Scanner scan = new Scanner(System.in);
	public void start(){
		int count = 0;
	while(true){
	System.out.println("Please Enter a number(0~99)");
	int scanner = scan.nextInt();
	if(scanner < value){
		System.out.println("太小");
	}
	if(scanner == value){
		System.out.println("猜对了,一共猜了 "+count+"次!");
		break;
	}
	if(scanner >= value){
		System.out.println("太大了");
	}
	count++;
	}
	}
}