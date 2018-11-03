import java.util.Arrays;//java提供的排序包等
public class ArrayUtil{
	public static void prtArrays(int[] a){
		for(int i =0;i < a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	public static void sort(int[] a){
		//sort排序
		System.out.println("排序之前");
		Arrays.sort(a);
		prtArrays(a);
		System.out.println("排序之后");
		prtArrays(a);
	}
	// public static void copy1{//可选择从哪个下标开始
		// int[] src = new int[]{1,2,3,4,5,6,7,8};
		// int[] dest = new int[3];//进行拷贝
		// prtArrays(src);
		// prtArrays(dest);
		// System.arraycopy(src,2,dest,0,3);
		// prtArrays(src);
		// prtArrays(dest);
	// }
	public static int[] computeStatics(int[] data){
				int max = Integer.MIN_VALUE,min = Integer.MAX_VALUE,avg = 0,sum = 0;
		for(int i = 0 ;i< data.length;i++){
			if(data [i]>max){
				max= data[i];
			}
			if(data[i] <min){
				min = data[i];
			}
			sum+=sum+data[i];
		}
		avg = sum/ data.length;
		return new int[]{max,min,avg,sum};
	}
	public static void main(String[] args){
		int[] data = new int[]{11,23,44,32,87};
		//最大值 最小值 平均值 总和
		int[] result =computeStatics(data);
		System.out.println("最大值:"+result[0]);
		System.out.println("最小值:"+result[1]);
		System.out.println("平均值:"+result[2]);
		System.out.println("总和:"+result[3]);
	}
}