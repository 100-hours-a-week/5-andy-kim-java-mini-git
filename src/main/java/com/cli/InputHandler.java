package com.cli;
import java.util.Scanner;
import java.util.List;

public class InputHandler {
    private final MiniGit myGit;
    private final Scanner scanner;

    public InputHandler(MiniGit myGit) {
        this.myGit = myGit;
        scanner = new Scanner(System.in);
    }

    public void handleInput() {

        System.out.println("MiniGithub에 오신 것을 환영합니다!");

        while (true) {
            List<String> repositoryNames = myGit.getRepositoriyNames();
            printInitMessage(repositoryNames);
            String command = scanner.nextLine();
            String repoName;
            String fileName;
            int type;
            if (command.equals("exit")) {
                break;
            }
            switch (command) {
                case "init":
                    System.out.println("추가할 레포지토리 이름을 입력해 주세요.");
                    repoName = scanner.nextLine();
                    myGit.init(repoName);
                    break;
                case "add":
                    System.out.println("파일을 추가할 레포지토리 이름을 입력해 주세요.");
                    repoName = scanner.nextLine();
                    System.out.println("추가할 파일 타입을 선택해 주세요.");
                    System.out.println("1 : TextFile, 2 : BinaryFile");
                    type = Integer.parseInt(scanner.nextLine()); // 개행 처리를 위해 nextInt() 대신 nextLine() 사용 후 파싱
                    System.out.println("추가할 파일 이름을 입력해 주세요.");
                    fileName = scanner.nextLine();
                    myGit.add(repoName, type, fileName);
                    break;
                case "commit":
                    System.out.println("커밋할 레포지토리 이름을 입력해 주세요.");
                    repoName = scanner.nextLine();
                    System.out.println("커밋 메세지를 입력해 주세요.");
                    String message = scanner.nextLine();
                    myGit.commit(repoName, message);
                    break;
                case "push":
                    System.out.println("커밋할 레포지토리 이름을 입력해 주세요.");
                    repoName = scanner.nextLine();
                    myGit.push(repoName);
                    break;
                default:
                    System.out.println("올바른 명령어 형식이 아닙니다.");
                    System.out.println("ex) init, exit, add, commit, push");
            }
        }
    }

    private void printInitMessage(List<String> repositoryNames) {
        System.out.println("원하시는 명령어를 입력해 주세요.");
        System.out.println("현재 레포지토리 : ");
        System.out.println(repositoryNames);
        System.out.println("> ");
    }
}
