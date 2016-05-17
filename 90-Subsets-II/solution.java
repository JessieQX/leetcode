public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        Arrays.sort(nums);
        for (int i : nums) {
            List<List<Integer>> tmp = new ArrayList<>();
            for (List<Integer> sub : res) {
                List<Integer> a = new ArrayList<>(sub);
                a.add(i);
                if (res.contains(a)) {
                    //System.out.println(a);
                    continue;
                }
                tmp.add(a);
            }
            res.addAll(tmp);
        }
        return res;
    }
}