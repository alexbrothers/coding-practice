package leetcode.questions;

public class WonderfulSubstrings {

    class WonderfulString {
        int odds;
        int[] counts;

        WonderfulString(char[] word, int start, int end) {
            counts = new int[10];
            for (int i = start; i < end; i++) {
                int letter = word[i] - 'a';
                if (counts[letter] == 0 || counts[letter] % 2 == 0) {
                    odds++;
                }
                else {
                    odds--;
                }
                counts[letter]++;
            }
        }

        void update(char remove, char add) {
            int removed = remove - 'a';
            if (counts[removed] % 2 == 0) {
                odds++;
            }
            else {
                odds--;
            }
            counts[removed]--;
            int added = add - 'a';
            if (counts[added] % 2 == 0) {
                odds++;
            }
            else {
                odds--;
            }
            counts[added]++;
        }

    }

    public long wonderfulSubstrings(String word) {
        if (word == null || word.length() == 0) {
            throw new IllegalArgumentException();
        }
        char[] wordArray = word.toCharArray();
        long count = word.length();
        for (int size = 2; size <= word.length(); size++) {
            WonderfulString wonderfulString = new WonderfulString(wordArray, 0, size);
            if (wonderfulString.odds <= 1) {
                count++;
            }
            for (int i = size; i < wordArray.length; i++) {
                wonderfulString.update(wordArray[i - size], wordArray[i]);
                if (wonderfulString.odds <= 1) {
                    count++;
                }
            }
        }
        return count;
    }

}
