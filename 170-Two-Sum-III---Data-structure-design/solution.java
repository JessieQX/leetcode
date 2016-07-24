public class TwoSum {
    Map<Integer, Integer> map = new HashMap<>();
    int count = 0;
    // Add the number to an internal data structure.
	public void add(int number) {
	    count++;
	    map.put(count, number);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (int i = 0; i < count; i++) {
	        int value1 = map.get(i);
	        if (map.containsValue(value - value1)) {
	            return true;
	        }
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);