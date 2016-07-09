public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // for(int num: nums){
        //     map.put(num, map.containsKey(num)? map.get(num) + 1 : 1);
        // }
        // PriorityQueue<Map.Entry<Integer, Integer>> queue = 
        // new PriorityQueue<Map.Entry<Integer, Integer>>(k, (o1, o2) -> o2.getValue() - o1.getValue());
        // queue.addAll(map.entrySet());
        // List<Integer> res = new ArrayList<Integer>();
        // for(int i = 0; i < k; i++){
        //     res.add(queue.poll().getKey());
        // }
        // return res;
        List<Integer>[] bucket = new List[nums.length + 1];
	    Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

	    for (int n : nums) {
		    frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
	    }

	    for (int key : frequencyMap.keySet()) {
		    int frequency = frequencyMap.get(key);
		    if (bucket[frequency] == null) {
			    bucket[frequency] = new ArrayList<>();
		    }
		    bucket[frequency].add(key);
	    }

	    List<Integer> res = new ArrayList<>();

	    for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
		    if (bucket[pos] != null) {
			    res.addAll(bucket[pos]);
		    }
	    }
	    return res;
    }
}