public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        // List<Integer> index1 = new ArrayList<>();
        // List<Integer> index2 = new ArrayList<>();
        // int distance = words.length - 1;
        // for (int i = 0; i < words.length; i++) {
        //     if (words[i].equals(word1)) {
        //         index1.add(i);
        //     }
        // }
        // for (int i = 0; i < words.length; i++) {
        //     if (words[i].equals(word2)) {
        //         index2.add(i);
        //     }
        // }
        // for (int i : index1) {
        //     for (int j : index2) {
        //         if (i == j) {
        //             continue;
        //         } else {
        //             distance = Math.min(distance, Math.abs(i - j));
        //         }
        //     }
        // }
        // return distance;
        // int distance = Integer.MAX_VALUE;
        // int start = distance, end = -distance;
        // for (int i = 0; i < words.length; i++) {
        //     if (words[i].equals(word1)) {
        //         start = i;
        //     }
        //     if (words[i].equals(word2)) {
        //         if (word1.equals(word2)) {
        //             start = end;
        //         }
        //         end = i;
        //     }
        //     distance = Math.min(distance, Math.abs(start - end));
        // }
        // return (int)distance;
        long dist = Integer.MAX_VALUE, i1 = dist, i2 = -dist;
    for (int i=0; i<words.length; i++) {
        if (words[i].equals(word1))
            i1 = i;
        if (words[i].equals(word2)) {
            if (word1.equals(word2))
                i1 = i2;
            i2 = i;
        }
        dist = Math.min(dist, Math.abs(i1 - i2));
    }
    return (int) dist;
    }
}