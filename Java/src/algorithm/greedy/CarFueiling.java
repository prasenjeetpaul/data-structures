package algorithm.greedy;

import java.util.Arrays;

public class CarFueiling {

	private static int carFueling(int totalDistance, int carCapacity, int gasStations[]) {
		int noOfRefill = 0;
		int currRefill = 0;
		int currLimit = carCapacity;
		int n = gasStations.length;
		while(currLimit < totalDistance) {
			if(currRefill >= n || gasStations[currRefill] > currLimit) return -1;
			
			while(currRefill < n-1 && gasStations[currRefill + 1] <= currLimit) {
				currRefill++;
			}

			noOfRefill++;
			currLimit = gasStations[currRefill] + carCapacity;
			currRefill++;
		}
		return noOfRefill;
	}
	
	public static void main(String args[]) {
		runTestCases();
	}
	

	private static void runTestCases() {
		int totalDistance[] = {950, 10, 200};
		int carCapacity[] = {400,  3, 250};
		int gasStops[][] = {
				{200, 375, 550, 750},
				{1, 2, 5, 9},
				{100, 150}
		};
		int ans[] = {2, -1, 0};
		
		boolean isPassed = true;
		for(int i=0; i<3; i++) {			
			System.out.println("--------------------");
			System.out.println("Total Distance: " + totalDistance[i]);
			System.out.println("Car Capacity: " + carCapacity[i]);
			System.out.println("Gas Stops: " + Arrays.toString(gasStops[i]));
			System.out.println("Expected Output: " + ans[i]);
			int actualOutput = carFueling(totalDistance[i], carCapacity[i], gasStops[i]);
			System.out.println("Actual Output: " + actualOutput);
			if(actualOutput == ans[i]) {
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
