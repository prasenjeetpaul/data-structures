package ds.stack;

public class Solution {
    
	private static int deleteMiddleHelper(CustomStack stack, int currPos) {
		if(stack.empty()) return 0;
		
		int val = stack.pop();
		int indexFromBack = deleteMiddleHelper(stack, currPos+1) + 1;
		//Going up in recursion
		if(indexFromBack != currPos && currPos-1 != indexFromBack) {
			stack.push(val);
		}
		return indexFromBack;
	}
	
	
    public static CustomStack deleteMiddle(CustomStack stack) {
    	deleteMiddleHelper(stack, 1);
    	return stack;
    }
    
    public static void printStack(CustomStack stack) {
        if(stack.empty()) System.out.print("Empty Stack");
        else while(!stack.empty()) System.out.print(stack.pop()+" ");
    }
}
