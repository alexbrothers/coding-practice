package leetcode.questions;

import java.util.HashSet;
import java.util.Set;

public class IsPangram {

    public boolean checkIfPangram(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException();
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < sentence.length(); i++) {
            set.add(sentence.charAt(i));
        }
        return set.size() == 26;
    }

}
