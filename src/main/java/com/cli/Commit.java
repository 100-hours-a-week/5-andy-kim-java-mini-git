package com.cli;
import java.util.Date;
import java.util.List;

public class Commit {
    private final String message;
    private final Date timestamp;
    private final List<File> files;

    public Commit(String message, List<File> files) {
        this.message = message;
        this.timestamp = new Date();
        this.files = files;
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
