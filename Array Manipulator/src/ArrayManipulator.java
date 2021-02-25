import java.util.ArrayList;
import java.util.Arrays;

public class ArrayManipulator {
	
	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(1,2));
		reversalAlgorithm(arrList);
		
		System.out.println(arrList);
	}
	
	@SuppressWarnings("unused")
	private static <E> boolean equalCheck(final ArrayList<E> arrListOne, final ArrayList<E> arrListTwo) {
		
		if (arrListOne.size() != arrListTwo.size()) {
			return false;
		}
		
		for (int i=0; i < arrListOne.size(); i++) {
			if (!(arrListOne.get(i).equals(arrListTwo.get(i)))) {
				return false;
			}
		}
		return true;
	}
	
	private static <E> ArrayList<E> reversalAlgorithm(ArrayList<E> arrList){
		int i = 0;
		int j = arrList.size() - 1; 
		E holder;
		
		while (i < j) {
			holder = arrList.get(i);
			arrList.set(i, arrList.get(j));
			arrList.set(j, holder);
			i++;
			j--;
		}
		
		return arrList;	
	}
}
