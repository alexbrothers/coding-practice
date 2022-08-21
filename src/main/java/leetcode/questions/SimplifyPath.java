package leetcode.questions;

import java.util.ArrayList;
import java.util.List;

public class SimplifyPath {

    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            throw new IllegalArgumentException();
        }
        List<String> result = new ArrayList<>();
        simplifyPath(path.split("/"), 0, result);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('/');
        for (int i = 0; i < result.size(); i++) {
            stringBuilder.append(result.get(i));
            if (i != result.size() - 1) {
                stringBuilder.append('/');
            }
        }
        return stringBuilder.toString();
    }

    private void simplifyPath(String[] splitPath, int index, List<String> result) {
        if (index >= splitPath.length) {
            return;
        }
        String current = splitPath[index];
        if (current == null || current.length() == 0 || current.equals(".")) {
            simplifyPath(splitPath, index + 1, result);
        }
        else if (current.equals("..")) {
            if (!result.isEmpty()) {
                result.remove(result.size() - 1);
            }
            simplifyPath(splitPath, index + 1, result);
        }
        else {
            result.add(current);
            simplifyPath(splitPath, index + 1, result);
        }
    }

}
