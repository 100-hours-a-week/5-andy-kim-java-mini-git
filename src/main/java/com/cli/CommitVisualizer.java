package com.cli;

public class CommitVisualizer implements Runnable {
    private int index;
    private Commit commit;
    private StringBuilder buffer;

    CommitVisualizer(int index, Commit commit, StringBuilder buffer) {
        this.index = index;
        this.commit = commit;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        visualizeCommit();
    }

    private void visualizeCommit() {
        buffer.append("Commit ").append(index + 1).append(": ").append(commit.getMessage()).append("\n");
        buffer.append("Files:\n");
        for (File file : commit.getFiles()) {
            buffer.append("  - ").append(file.getName()).append("\n");
        }
    }
}
