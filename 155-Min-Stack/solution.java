public class MinStack {
    private Stack stack1;
    private Stack stack2;
    /** initialize your data structure here. */
    public MinStack() {
        stack1 = new Stack();
        stack2 = new Stack();
    }
    
    public void push(int x) {
        stack1.push(x);
        if (stack2 == null) {
            stack2.push(x);
        } else {
            if (x < (int)stack2.peek()) {
                stack2.pop();
                stack2.push(x);
            } 
        }
    }
    
    public void pop() {
        stack1.pop();
    }
    
    public int top() {
        return (int)stack1.peek();
    }
    
    public int getMin() {
        return (int)stack2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */