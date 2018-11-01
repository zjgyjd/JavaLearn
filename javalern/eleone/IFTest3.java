class FixedStack implements InStack{
	private int stck[];
	private int tos;
	FixedStack(int size){
		stck = new int[size];
		tos = -1;
	}
	public void push(int item){
		if(tos==stck.length - 1)
			System.out.println("Stack is full.");
		else
			stck[++tos] = item;
	}
	public int pop(){
		if(tos < 0){
			System.out.println("Stack underflow");
			return 0;
		}
		else
			return stck[tos--];
	}
}
class DynStack implements InStack{
	private int stck[];
	private int tos;
	DynStack(int size){
		stck = new int[size];
		tos = -1;
	}
	public void push(int item){
		if(tos==stck.length - 1){
			int temp[]= new int[stck.length * 2];
			for(int i = 0;i < stck.length;i++){temp[i] = stck[i];}
			stck = temp;
			stck[++tos] = item;
		} 
		else{
			stck[++tos] = item;
		}
	}
	public int pop(){
		if(tos < 0){
			System.out.println("Stack underflow.");
			return 0;
		}else{
			return stck[tos--];
		}
	}
}
public class IFTest3{
	public static void main(String[] args){
		InStack mystack;
		DynStack ds = new DynStack(5);
		FixedStack fs = new FixedStack(8);
		mystack = ds;
		for(int i = 0;i < 12;i++){mystack.push(i);}
		mystack = fs;
		for(int i = 0;i < 8;i++){mystack.push(i);}
		
		mystack = ds;
		for(int i = 0;i < 12;i++){System.out.print(mystack.pop()+" ");}
		System.out.println();
		mystack = fs;
		for(int i = 0;i < 8;i++){System.out.print(mystack.pop()+" ");}
	}
}