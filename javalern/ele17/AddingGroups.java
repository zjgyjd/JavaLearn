import java.util.*;
public class AddingGroups{
	public static void main(String[] args){
		Collection<Integer> colletion = 
		new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		Integer[] moreInts = {6,7,8,9,10};
		colletion.addAll(Arrays.asList(moreInts));
		Collection.addAll(colletion,11,12,13,14,15);
		Collection.addAll(colletion,moreInts);
		List<Integer> list = Arrays.asList(16,17,18,19,20);
		List.set(1,99);
	}
}