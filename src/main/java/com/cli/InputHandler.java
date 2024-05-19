package com.cli;
import java.util.Scanner;

public class InputHandler {
    private final MiniGit myGit;
    private final Scanner scanner;

    public InputHandler(MiniGit myGit) {
        this.myGit = myGit;
        scanner = new Scanner(System.in);
    }

    public void handleInput() {
        MessagePrinter.printWelcomeMessage();
        while (true) {
            MessagePrinter.printLoopInitMessage(myGit.getRepositoriyNames());
            String command = scanner.nextLine();
            String repoName;
            String fileName;
            int type;
            if (command.equals("exit")) {
                break;
            }
            switch (command) {
                case "init":
                    MessagePrinter.printAddRepoPrompt();
                    repoName = scanner.nextLine();
                    myGit.init(repoName);
                    break;
                case "add":
                    MessagePrinter.printAddFileRepoPrompt();
                    repoName = scanner.nextLine();
                    MessagePrinter.printAddFileTypePrompt();
                    MessagePrinter.printFileTypeOptions();
                    type = Integer.parseInt(scanner.nextLine()); // 개행 처리를 위해 nextInt() 대신 nextLine() 사용 후 파싱
                    MessagePrinter.printAddFileNamePrompt();
                    fileName = scanner.nextLine();
                    myGit.add(repoName, type, fileName);
                    break;
                case "commit":
                    MessagePrinter.printCommitRepoPrompt();
                    repoName = scanner.nextLine();
                    MessagePrinter.printCommitMessagePrompt();
                    String message = scanner.nextLine();
                    myGit.commit(repoName, message);
                    break;
                case "push":
                    MessagePrinter.printCommitRepoPrompt();
                    repoName = scanner.nextLine();
                    myGit.push(repoName);
                    break;
                default:
                    MessagePrinter.printInvalidCommandMessage();
                    MessagePrinter.printCommandExamples();
            }
        }
    }
}
