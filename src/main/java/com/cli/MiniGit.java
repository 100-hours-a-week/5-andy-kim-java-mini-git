package com.cli;
import java.util.ArrayList;
import java.util.List;

public class MiniGit extends VersionControlSystem{
    private final List<Repository> repositories;
    private FileHandler fileHandler;
    private List<File> files;

    public MiniGit(String name) {
        super(name);
        this.repositories = new ArrayList<>();
        this.fileHandler = new FileHandler();
        this.files = new ArrayList<>();
    }

    @Override
    public void init(String name) {
        repositories.add(new Repository(name));
        System.out.println("빈 레포지토리가 생성되었습니다. 레포지토리 주소 : " + name);
    }

    @Override
    public void add(String repoName, int type, String file) {
        for (Repository repo : repositories) {
            if (repo.getName().equals(repoName)) {
                files.add(fileHandler.makeFile(type, file));
                System.out.println("Added file: " + file);
                return;
            }
        }
        System.out.println("레포지토리가 존재하지 않습니다. : " + repoName);
    }

    @Override
    public void commit(String repoName, String message) {
        for (Repository repo : repositories) {
            if (repo.getName().equals(repoName)) {
                repo.commit(message, files);
                System.out.println("Committed to " + repoName + "with message : " + message);
                return;
            }
        }
        System.out.println("레포지토리가 존재하지 않습니다. : " + repoName);
    }

    @Override
    public void push(String repoName){
        for (Repository repo : repositories) {
            if (repo.getName().equals(repoName)) {
                repo.push();
                return;
            }
        }
        System.out.println("레포지토리가 존재하지 않습니다. : " + repoName);
    }

    public List<String> getRepositoriyNames() {
        return new ArrayList<>(repositories.stream().map(Repository::getName).toList());
    }
}
