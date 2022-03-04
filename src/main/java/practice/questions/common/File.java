package practice.questions.common;

import java.util.List;

public class File {

    private String name;
    private double size;
    private boolean isDirectory;
    private List<File> children;

    public File() {

    }

    public File(String name, double size) {
        this.name = name;
        this.size = size;
        this.isDirectory = false;
    }

    public File(String name, double size, List<File> children) {
        this.name = name;
        this.size = size;
        this.isDirectory = true;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    public void setDirectory(boolean directory) {
        isDirectory = directory;
    }

    public List<File> getChildren() {
        return children;
    }

    public void setChildren(List<File> children) {
        this.children = children;
    }
}
