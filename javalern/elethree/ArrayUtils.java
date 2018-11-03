public class ArrayUtils{
	public static int arrayMaxElement(int[] data){
		if(data==null){
			//TODO抛异常
			throw new IllegalArgumentException("data must be not nuLL");
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0;i<data.length;i++){
			
			if(data[i]>max){
				max = data[i];
		    }
		}		
		return max;
	}
	public static int arrayMinElement(int[] data){
		if(data==null){
			//TODO
			throw new IllegalArgumentException("data must be not nuLL");
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0;i<data.length;i++){
			if(data[i]<min){
				min = data[i];
		    }
		}		
		return min;
	}
	public static int arrayElementSum(int[] data){
		if(data==null){
			//TODO
			throw new IllegalArgumentException("data must be not nuLL");
		}
		int sum = 0;
		for(int i = 0;i<data.length;i++){
			sum += data[i];
		}
		return sum;
	}
	public static int[] arrayJoin(int[] a,int[] b){
		if(a==null){
			//TODO
			throw new IllegalArgumentException("a must be not nuLL");
		}
		if(b==null){
			//TODO
		throw new IllegalArgumentException("b must be not nuLL");
		}
		int[] temp = new int[a.length+b.length];
		for(int i = 0;i<a.length;i++){
			temp[i]=a[i];
		}
		for(int i = a.length;i<temp.length;i++){
			temp[i] = b[i-a.length];
		}
		return temp;
	}
	public static int[] arraySub(int[] a,int start,int end){
		if(a==null){
			//TODO
			throw new IllegalArgumentException("a must be not nuLL");
		}
		//TODO需要判断start和end
		if(start<0||end<0){
			throw new IllegalArgumentException("start or end must >0");
		}
		if(end<start){
			throw new IllegalArgumentException("end must > start");
		}
		if(start>=a.length){
			throw new IllegalArgumentException("start must be < a.length");
		}
		int count = end -  start;
		if(count>a.length){
			throw new IllegalArgumentException("sub length must <= a.length ");
		}
		int[] temp = new int [count]; 
		for(int i = start;i < end;i++){
			temp[i-start] = a[i];
		}
		return temp;
	}
	public static void prtArray(int[] a){
		for(int i =0 ;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	public  static void main(String [] args){
		int[] a = new int[]{2,3,5,8,7,6,9};
		int max = arrayMaxElement(a);
		int min = arrayMinElement(a);
		int sum = arrayElementSum(a);
		int[] b = new int[]{1,10,11};
		int[] join = arrayJoin(a,b);
		int[] sub = arraySub(a,2,12);
		System.out.println("最大值:"+max);
		System.out.println("最小值:"+min);
		System.out.println("和值:"+sum);
		System.out.println("连接为:");
		prtArray(join);
		System.out.println("取值为:");
		prtArray(sub);
	}
}