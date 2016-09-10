public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();
	int max_area = 0;
	
	for(int i=0; i<=height.length; ++i){
		int height_bound = (i == height.length) ? 0 : height[i];
		
		while(!stack.isEmpty()){
			int h = height[stack.peek()];
			
			// calculate the area for every ascending slope.
			if(h < height_bound){
				break;
			}
			stack.pop();
			
			// at the end, the area with the height of the minimal element.
			int index_bound = stack.isEmpty() ? -1 : stack.peek();
			max_area = Math.max(max_area, h*((i-1)-index_bound));
		}
		
		stack.push(i);
	}
	
	return max_area;
    }
}