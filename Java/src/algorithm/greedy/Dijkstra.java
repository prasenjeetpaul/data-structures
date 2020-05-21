package algorithm.greedy;

public class Dijkstra {
	
	public static void main(String args[]) {
		int matrix[][] = {
				{0,2,0,6,0},
				{2,0,3,8,5},
				{0,3,0,0,7},
				{6,8,0,0,9},
				{0,5,7,9,0}
		};
		dijkstra(matrix);
	}
	
	private static void dijkstra(int graph[][]) {
		int distance[] = new int[graph.length];
		boolean visited[] = new boolean[graph.length];
		
		for(int  i=0; i<distance.length; i++) distance[i] = Integer.MAX_VALUE;
		
		distance[0] = 0;
		
		for(int count = 0; count < graph.length-1; count++) {
			int curr = getMinDistance(distance, visited);
			visited[curr] = true;
			
			for(int i=0; i<distance.length; i++) {
				if(graph[curr][i] != 0 && !visited[i] && distance[curr] + graph[curr][i] < distance[i]) {
					distance[i] = distance[curr] + graph[curr][i];
				}
			}
		}
		
		printDistance(distance, 0);
	}

	private static int getMinDistance(int distance[], boolean visited[]) {
		int minIndex = 0;
		int minValue = Integer.MAX_VALUE;
		
		for(int i=0; i<distance.length; i++) {
			if(!visited[i] && distance[i] < minValue) {
				minValue = distance[i];
				minIndex = i;
			}
		}
		
		return minIndex;
	}
	
	private static void printDistance(int distance[], int startIndex) {
		for(int i=0; i<distance.length; i++) {
			System.out.println(startIndex + " to " + i + " : " + distance[i]);
		}
	}
}
