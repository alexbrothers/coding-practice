package leetcode.google;

public class NextClosestTime {

    public String nextClosestTime(String time) {
        if (time == null) {
            throw new IllegalArgumentException();
        }
        String[] sorted = sortDigits(time);
        StringBuilder result = new StringBuilder(time);
        if (nextClosestTimeHelper(result, time.length() - 1, sorted, time, false)) {
            return result.toString();
        }
        return createSmallestTime(sorted);
    }

    private String createSmallestTime(String[] digits) {
        StringBuilder hours = new StringBuilder();
        StringBuilder minutes = new StringBuilder();
        createSmallestHours(digits, hours);
        createSmallestMinutes(digits, minutes);
        return hours + ":" + minutes;
    }

    private boolean createSmallestHours(String[] digits, StringBuilder current) {
        if (current.length() == 2) {
            if (current.charAt(0) == '0') {
                current.deleteCharAt(0);
            }
            int hours = Integer.valueOf(current.toString());
            if (hours >= 0 && hours < 60) {
                if (current.length() == 1) {
                    current.insert(0, "0");
                }
                return true;
            }
            return false;
        }
        for (int i = 0; i < digits.length; i++) {
            current.append(digits[i]);
            if (createSmallestHours(digits, current)) {
                return true;
            }
            current.deleteCharAt(current.length() - 1);
        }
        return false;
    }

    private boolean createSmallestMinutes(String[] digits, StringBuilder current) {
        if (current.length() == 2) {
            int mins = Integer.valueOf(current.toString());
            return mins >= 0 && mins < 60;
        }
        for (int i = 0; i < digits.length; i++) {
            current.append(digits[i]);
            if (createSmallestMinutes(digits, current)) {
                return true;
            }
            current.deleteCharAt(current.length() - 1);
        }
        return false;
    }

    private boolean nextClosestTimeHelper(StringBuilder time, int index, String[] digits, String originalTime, boolean goingLeft) {
        if (index >= time.length()) {
            return true;
        }
        if (index < 0) {
            return false;
        }
        if (index == 2) {
            if (goingLeft) {
                return nextClosestTimeHelper(time, index + 1, digits, originalTime, goingLeft);
            }
            else {
                return nextClosestTimeHelper(time, index - 1, digits, originalTime, goingLeft);
            }
        }
        Character currentDigit = time.charAt(index);
        for (int i = 0; i < digits.length; i++) {
            if (!goingLeft && digits[i].charAt(0) <= currentDigit) {
                continue;
            }
            time.replace(index, index + 1, digits[i]);
            if (isValidTime(time.toString()) && isAfter(time.toString(), originalTime) && nextClosestTimeHelper(time, index + 1, digits, originalTime, true)) {
                return true;
            }
        }
        time.replace(index, index + 1, "" + currentDigit);
        return nextClosestTimeHelper(time, index - 1, digits, originalTime, false);
    }

    private boolean isAfter(String time1, String time2) {
        return time1.compareTo(time2) > 0;
    }

    private String[] sortDigits(String time) {
        int[] counts = new int[10];
        for (int i = 0; i < time.length(); i++) {
            if (time.charAt(i) == ':') {
                continue;
            }
            counts[time.charAt(i) - '0']++;
        }
        String[] result = new String[time.length() - 1];
        int resultIndex = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                for (int j = 0; j < counts[i]; j++) {
                    result[resultIndex] = String.valueOf((i));
                    resultIndex++;
                }
            }
        }
        return result;
    }

    private boolean isValidTime(String time) {
        String[] split = time.split(":");
        if (split.length != 2) {
            return false;
        }
        int hours = Integer.valueOf(split[0]);
        int minutes = Integer.valueOf(split[1]);
        return hours >= 0 && hours < 24 && minutes >= 0 && minutes < 60;
    }

}
