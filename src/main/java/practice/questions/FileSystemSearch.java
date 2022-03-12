package practice.questions;

import practice.common.common.File;
import practice.common.common.FileValidator;

import java.util.ArrayList;
import java.util.List;

public class FileSystemSearch {

    /**
     * Given a filesystem, return all files that meet a certain criteria.
     * For example, if I want to return all files > 10MB, return [f1.tx, f3.txt]
     *
     *                             /root
     *                               |
     *                     ------------------------
     *                     |         |            |
     *            (12mb)f1.txt  (8mb)f2.txt    (20mb)f3.txt
     *
     *
     */
    public List<File> findFiles(File root, FileValidator fileValidator) {
        List<File> results = new ArrayList<>();
        findFilesHelper(root, fileValidator, results);
        return results;
    }

    private void findFilesHelper(File file, FileValidator fileValidator, List<File> results) {
        if (file == null) {
            return;
        }
        if (file.isDirectory()) {
            List<File> children = file.getChildren();
            for (int i = 0; i < children.size(); i++) {
                findFilesHelper(children.get(i), fileValidator, results);
            }
        }
        else {
            if (fileValidator.isValid(file)) {
                results.add(file);
            }
        }
    }

}
