package hash_tables;

public class CanConstruct_383_BruteForce {
    static class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            boolean[] used = new boolean[magazine.length()];

            for (int i = 0; i < ransomNote.length(); i++) {
                for (int j = 0; j < magazine.length(); j++) {
                    if (ransomNote.charAt(i) == magazine.charAt(j)) {
                        if (used[j] == true) {
                            continue;
                        }
                        used[j] = true;
                        break;
                    } else if (j == magazine.length() - 1) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
