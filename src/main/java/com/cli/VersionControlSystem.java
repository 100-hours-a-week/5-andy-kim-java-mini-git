package com.cli;

public abstract class VersionControlSystem extends Software{
    public VersionControlSystem(String name) {
        super(name);
    }

    public abstract void init(String name);
    public abstract void add(FileType type, String file);
    public abstract void commit(String message);
    public abstract void push(String repoName);
}
