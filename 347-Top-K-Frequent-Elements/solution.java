public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num: nums){
            map.put(num, map.containsKey(num)? map.get(num) + 1 : 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = 
        new PriorityQueue<Map.Entry<Integer, Integer>>(map.size(), (o1, o2) -> o2.getValue() - o1.getValue());
        queue.addAll(map.entrySet());
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < k; i++){
            res.add(queue.poll().getKey());
        }
        return res;
    }
    public static void main(String[] args) {
        TopK topK = new TopK();
        int[] nums = {1,1,2,3,4,3,2,2};
        System.out.println(topK.topKFrequent(nums, 3));
    }
}