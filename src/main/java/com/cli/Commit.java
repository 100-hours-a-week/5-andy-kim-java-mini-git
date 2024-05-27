package com.cli;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Commit {
    private final String message;
    private final Date timestamp;
    private final List<File> files;

    public Commit(String message, List<File> files) {
        this.message = message;
        this.timestamp = new Date();
        this.files = new ArrayList<>(files);
    }

    public String getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public List<File> getFiles() {
        return files;
    }
}
