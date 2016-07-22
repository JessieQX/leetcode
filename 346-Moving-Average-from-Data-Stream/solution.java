public class MovingAverage {
    private int size;
    private double previousSum = 0.0;
    Queue<Integer> queue;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        queue = new LinkedList<>();
    }
    
    public double next(int val) {
        if (queue.size() == size) {
            previousSum -= queue.poll();
        }
        previousSum += val;
        queue.offer(val);
        return previousSum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */