/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int total = 0, sum = 0;
        while (!nestedList.isEmpty()) {
            List<NestedInteger> level = new ArrayList<>();
            for (NestedInteger element : nestedList) {
                if (element.isInteger()) {
                    sum += element.getInteger();
                } else {
                    level.addAll(element.getList());
                }
            }
            total += sum;
            nestedList = level;
        }
        return total;
    }
}