package functionalinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoFunctionalInterface {
	public static void main(String[] args) {
		MathFunction<String, String> concatinate = (x,y) -> x.concat(y);
		System.out.println(concatinate.MathOperation("abc", "def"));
		
		MathFunction<Integer, Integer> addition = (x,y) -> (x+y);
		System.out.println(addition.MathOperation(10, 50));
		
		MathFunction<List<Integer>, List<Integer>> addList = (listA,listB) -> {
			List<Integer> finalList = new ArrayList<>();
			finalList.addAll(listA);
			finalList.addAll(listB);
			return finalList;
		};
		List<Integer> listA = Arrays.asList(10,20, 30, 40 );
		List<Integer> listB = Arrays.asList(50,60,70,80);
		List<Integer> finalList = addList.MathOperation(listA, listB);
		System.out.println("finalList "+finalList);
	}
}