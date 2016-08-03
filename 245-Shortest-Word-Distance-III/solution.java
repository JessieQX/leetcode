public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        List<Integer> index1 = new ArrayList<>();
        List<Integer> index2 = new ArrayList<>();
        int distance = words.length - 1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1.add(i);
            }
        }
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word2)) {
                index2.add(i);
            }
        }
        for (int i : index1) {
            for (int j : index2) {
                if (i == j) {
                    continue;
                } else {
                    distance = Math.min(distance, Math.abs(i - j));
                }
            }
        }
        return distance;
    }
}