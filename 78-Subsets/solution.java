public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    // Arrays.sort(nums);
    // int totalNumber = 1 << nums.length;
    // List<List<Integer>> collection = new ArrayList<List<Integer>>(totalNumber);
    // for (int i=0; i<totalNumber; i++) {
    //     List<Integer> set = new LinkedList<Integer>();
    //     for (int j=0; j<nums.length; j++) {
    //         if ((i & (1<<j)) != 0) {
    //             set.add(nums[j]);
    //         }
    //     }
    //     collection.add(set);
    // }
    // return collection;
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());

        Arrays.sort(nums);
        for(int i : nums) {
            List<List<Integer>> tmp = new ArrayList<>();
            for(List<Integer> sub : res) {
                List<Integer> a = new ArrayList<>(sub);
                a.add(i);
                tmp.add(a);
            }
            res.addAll(tmp);
        }
        return res;
    }
}