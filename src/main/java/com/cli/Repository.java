package com.cli;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private final String name;
    private final List<Commit> commits;
    private final CommitHandler commitHandler;

    public Repository(String name) {
        this.name = name;
        this.commits = new ArrayList<>();
        this.commitHandler = new CommitHandler();
    }

    public String getName() {
        return name;
    }

    public void commit(String message, List<File> files) {
        Commit commit = commitHandler.makeCommit(message, files);
        commits.add(commit);
    }

    public void push() {
        System.out.println("Pushing " + name + " to " + commits.size() + " commits");
    }
}
