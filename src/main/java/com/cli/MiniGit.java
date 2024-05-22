package com.cli;

import java.util.ArrayList;
import java.util.List;

public class MiniGit extends VersionControlSystem {
    private final List<Repository> repositories;
    private FileHandler fileHandler;
    private List<File> files;

    public MiniGit(String name) {
        super(name);
        this.repositories = new ArrayList<>();
        this.fileHandler = new FileHandler();
        this.files = new ArrayList<>();
        initializeReposAndFiles();
    }

    private void initializeReposAndFiles() {
        // 미리 파일 추가
        files.add(fileHandler.makeFile(FileType.TEXT_FILE, "README.md"));
        files.add(fileHandler.makeFile(FileType.BINARY_FILE, "logo.png"));

        // 첫 번째 레포지토리 생성 및 초기화
        Repository repo1 = new Repository("Repo1");
        repositories.add(repo1);
        repo1.commit("Initial commit", files);

        // 두 번째 레포지토리 생성 및 초기화
        Repository repo2 = new Repository("Repo2");
        repositories.add(repo2);
        List<File> repo2Files = new ArrayList<>();
        repo2Files.add(fileHandler.makeFile(FileType.TEXT_FILE, "index.html"));
        repo2Files.add(fileHandler.makeFile(FileType.TEXT_FILE, "style.css"));
        repo2.commit("Initial commit", repo2Files);
        repo2.commit("Added more styles", repo2Files);
    }

    @Override
    public void init(String name) {
        repositories.add(new Repository(name));
        System.out.println("빈 레포지토리가 생성되었습니다. 레포지토리 주소 : " + name);
    }

    @Override
    public void add(FileType type, String file) {
        files.add(fileHandler.makeFile(type, file));
        System.out.println("Added file: " + file);
    }

    @Override
    public void commit(String repoName, String message) {
        Repository repo = findRepositoryByName(repoName);
        if (repo != null) {
            repo.commit(message, files);
            System.out.println("Committed to " + repoName + " with message : " + message);
        } else {
            System.out.println("레포지토리가 존재하지 않습니다. : " + repoName);
        }
    }

    @Override
    public void push(String repoName) {
        Repository repo = findRepositoryByName(repoName);
        if (repo != null) {
            repo.push();
        } else {
            System.out.println("레포지토리가 존재하지 않습니다. : " + repoName);
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
