package dailybyte.questions;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {

    private Set<Character> vowels;

    public ReverseVowels() {
        vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
    }

    /**
     * This question is asked by Facebook. Given a string, reverse the vowels of it.
     * Note: In this problem y is not considered a vowel.
     *
     * Ex: Given the following strings s…
     *
     * s = "computer", return "cemputor"
     * Ex: Given the following strings s…
     *
     * s = "The Daily Byte", return "The Dialy Byte"
     */
    public String reverseVowels(String str) {
        if (str == null) {
            return null;
        }
        char[] characters = str.toCharArray();
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            boolean leftIsVowel = vowels.contains(characters[left]);
            boolean rightIsVowel = vowels.contains(characters[right]);
            if (leftIsVowel && rightIsVowel) {
                swapCharacters(characters, left, right);
                left++;
                right--;
                continue;
            }
            if (!leftIsVowel) {
                left++;
            }
            if (!rightIsVowel) {
                right--;
            }
        }
        return new String(characters);
    }

    private void swapCharacters(char[] characters, int left, int right) {
        char temp = characters[left];
        characters[left] = characters[right];
        characters[right] = temp;
    }

}
