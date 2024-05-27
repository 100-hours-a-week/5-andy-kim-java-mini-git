package com.cli;

public class FileHandler {

    public FileHandler() {}

    public static File makeFile(FileType type, String fileName) {
        File file;
        if (type == FileType.TEXT_FILE) {
            file = new TextFile(fileName);
        } else {
            file = new BinaryFile(fileName);
        }
        return file;
    }
}
