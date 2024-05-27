package com.cli;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import static com.cli.DateConstants.NO_DATE;

public class MiniGit extends VersionControlSystem {
    private final List<Repository> repositories;
    private List<File> files;
    private List<Commit> commits;

    public MiniGit(String name) {
        super(name);
        this.repositories = new ArrayList<>();
        this.files = new ArrayList<>();
        this.commits = new ArrayList<>();
        initializeReposAndFiles();
    }

    private void initializeReposAndFiles() {
        // 미리 파일 추가
        files.add(FileHandler.makeFile(FileType.TEXT_FILE, "README.md"));
        files.add(FileHandler.makeFile(FileType.BINARY_FILE, "logo.png"));

        // 첫 번째 레포지토리 생성 및 초기화
        Repository repo1 = new Repository("Repo1");
        repositories.add(repo1);
        repo1.push(new Commit("Initial commit", files), NO_DATE);

        // 두 번째 레포지토리 생성 및 초기화
        Repository repo2 = new Repository("Repo2");
        repositories.add(repo2);
        List<File> repo2Files = new ArrayList<>();
        repo2Files.add(FileHandler.makeFile(FileType.TEXT_FILE, "index.html"));
        repo2Files.add(FileHandler.makeFile(FileType.TEXT_FILE, "style.css"));
        repo2.push(new Commit("Initial commit", repo2Files), NO_DATE);
        repo2.push(new Commit("Added more styles", repo2Files), NO_DATE);
    }

    @Override
    public void init(String name) {
        repositories.add(new Repository(name));
        System.out.println("빈 레포지토리가 생성되었습니다. 레포지토리 주소 : " + name);
    }

    @Override
    public void add(FileType type, String file) {
        files.add(FileHandler.makeFile(type, file));
        System.out.println("Added file: " + file);
    }

    @Override
    public void commit(String message) {
        Commit commit = CommitHandler.makeCommit(message, files);
        commits.add(commit);
        System.out.println("commit success when " + commit.getTimestamp());
    }

    @Override
    public void push(String repoName) {
        Repository repo = findRepositoryByName(repoName);
        if (repo != null) {
            if (commits.isEmpty()) {
                System.out.println("No commits to push.");
            } else {
                if (commits.size() > 1) {
                    Date lastCommitDate = commits.get(commits.size() - 2).getTimestamp();
                    repo.push(commits.get(commits.size() - 1), lastCommitDate);
                }
                else {
                    repo.push(commits.get(0), NO_DATE);
                }
            }
        } else {
            System.out.println("레포지토리가 존재하지 않습니다. : " + repoName);
        }
    }

    public void show() {
        for (Repository repo : repositories) {
            repo.visualize();
        }
    }

    private Repository findRepositoryByName(String repoName) {
        for (Repository repo : repositories) {
            if (repo.getName().equals(repoName)) {
                return repo;
            }
        }
        return null;
    }

    public List<String> getRepositoryNames() {
        return new ArrayList<>(repositories.stream().map(Repository::getName).toList());
    }
}
