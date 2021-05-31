package algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MaxSalary {

	private static String largestNumber(String arr[]) {
		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String o1, String o2) {
				String a = o1 + o2;
				String b = o2 + o1;
				return b.compareTo(a);
			};
		});
		String ans = "";
		for(int i=0; i<arr.length; i++) {
			ans = ans + arr[i];
		}
		return ans;
	}
	
	
	public static void main(String args[]) {
        runTestCases();
	}
	
	
	private static void runTestCases() {
		String input[][] = {
				{"57", "51", "5"},
				{"34", "344"},
				{"433", "43", "34", "344"},
				{"41", "4142"},
				{"797", "79", "7"},
				{"85", "858"},
				{"9", "8", "1", "100", "110"},
		};
		
		String output[] = {
				"57551",
				"34434",
				"4343334434",
				"414241",
				"797977",
				"85885",
				"981110100"
		};
		
		boolean isPassed = true;
		for(int i=0; i<input.length; i++) {			
			System.out.println("--------------------");
			System.out.println("Test case " + (i+1) + ": " + Arrays.toString(input[i]));
			System.out.println("Expected Output: " + output[i]);
			String actualAns = largestNumber(input[i]);
			System.out.println("Actual Output: " + actualAns);
			if(actualAns.equals(output[i])) {
				System.out.println("Passed");
			} else {
				System.out.println("Failed");
				isPassed = false;
			}
			System.out.println("--------------------");
		}
		
		System.out.println("--------------------");
		System.out.println("--------------------");
		System.out.println("Final Verdict: " + (isPassed ? "PASSED" : "FAILED"));
		System.out.println("--------------------");
		System.out.println("--------------------");
	}
}
