package com.cli;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import static com.cli.DateConstants.NO_DATE;

public class Repository {
    private final String name;
    private final List<Commit> commits;

    public Repository(String name) {
        this.name = name;
        this.commits = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void push(Commit commit, Date lastCommitDate) {
        if (lastCommitDate != NO_DATE && commits.get(commits.size() - 1).getTimestamp() != lastCommitDate) {
            System.out.println("conflict in last commit. please check your commit date.");
            return ;
        }
        commits.add(commit);
        System.out.println("Pushing " + name + " to " + commits.size() + " commits");
    }

    public void visualize() {
        List<Thread> threads = new ArrayList<>();
        List<StringBuilder> buffers = new ArrayList<>();

        System.out.println("Repository: " + name);
        System.out.println("Number of commits: " + commits.size());

        for (int i = 0; i < commits.size(); i++) {
            Commit commit = commits.get(i);
            StringBuilder buffer = new StringBuilder();
            buffers.add(buffer);
            Thread thread = new Thread(new CommitVisualizer(i, commit, buffer));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("A thread was interrupted.");
            }
        }

        // 모든 스레드의 출력을 모아서 출력
        for (StringBuilder buffer : buffers) {
            System.out.print(buffer.toString());
        }
    }
}
