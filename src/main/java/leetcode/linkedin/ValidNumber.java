package leetcode.linkedin;

public class ValidNumber {

    public boolean isNumber(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        if (s.length() == 0) {
            return false;
        }
        int split1 = s.indexOf('e');
        int split2 = s.indexOf('E');
        if (split1 == -1 && split2 == -1) {
            return isDecimal(s) || isInteger(s);
        }
        if (split1 != -1 && split1 == s.length() - 1 || split2 != -1 && split2 == s.length() - 1) {
            return false;
        }
        String first = split1 != -1 ? s.substring(0, split1) : s.substring(0, split2);
        String second = split1 != -1 ? s.substring(split1 + 1) : s.substring(split2 + 1);
        return (isDecimal(first) || isInteger(first)) && isInteger(second);
    }

    private boolean isDecimal(String s) {
        if (s.length() > 0 && isSign(s.charAt(0))) {
            s = removeSign(s);
        }
        if (s.length() == 0) {
            return false;
        }
        int split = s.indexOf('.');
        if (split == -1) {
            return isDigits(s);
        }
        if (split == s.length() - 1) {
            return s.length() > 1 && isDigits(s.substring(0, split));
        }
        String first = s.substring(0, split);
        String second = s.substring(split + 1);
        return isDigits(first) && isDigits(second);
    }

    private boolean isSplitEmpty(String[] split) {
        for (int i = 0; i < split.length; i++) {
            if (split[i].length() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isInteger(String s) {
        if (s.length() > 0 && isSign(s.charAt(0))) {
            s = removeSign(s);
        }
        if (s.length() == 0) {
            return false;
        }
        return isDigits(s);
    }

    private boolean isDigits(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isSign(Character character) {
        return character == '+' || character == '-';
    }

    private String removeSign(String s) {
        return s.substring(1);
    }

    private boolean isDigit(Character character) {
        return character >= '0' && character <= '9';
    }

}
