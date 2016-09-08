public class Solution {
    public int numTrees(int n) {
        //G[n] means the number of unique BST with value = n.
        //F[i, n] means the number of unique BST where the root is i.
        //G[n] = F[1, n] + F[2, n] + ... + F[n, n].
        //F[i, n] = G[i - 1] * G[n - i].
        int[] G = new int[n + 1];
        G[0] = G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}