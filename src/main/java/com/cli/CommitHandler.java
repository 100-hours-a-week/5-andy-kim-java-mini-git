package com.cli;
import java.util.List;

public class CommitHandler {
    public CommitHandler() {}

    public static Commit makeCommit(String message, List<File> files ) {
        Commit commit;
        commit = new Commit(message,files);
        return commit;
    }
}
