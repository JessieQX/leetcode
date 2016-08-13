public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // List<List<Integer>> res = new ArrayList<>();
        // res.add(new ArrayList<>());
        // Arrays.sort(nums);
        // for (int i : nums) {
        //     List<List<Integer>> tmp = new ArrayList<>();
        //     for (List<Integer> sub : res) {
        //         List<Integer> a = new ArrayList<>(sub);
        //         a.add(i);
        //         tmp.add(a);
        //     }
        //     res.addAll(tmp);
        // }
        // return res;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, tempList, nums, 0);
        return list;
    }
    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}