package ds.stack;

public class Main {

	public static void main(String[] args) {
		MinStack stack = new MinStack();
		
		stack.push(13);		
		System.out.println("Min Value: " + stack.getMin());
		stack.push(10);
		stack.push(1);
		System.out.println("Min Value: " + stack.getMin());
		stack.pop();
		System.out.println("Min Value: " + stack.getMin());
	}

}
