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
            MessagePrinter.printLoopInitMessage(myGit.getRepositoryNames());
            String command = scanner.nextLine();
            String repoName;
            String fileName;
            FileType type;
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
                    type = promptFileType();
                    if (type == null) {
                        continue; // 루프의 다음 반복으로 건너뜁니다.
                    }
                    MessagePrinter.printAddFileNamePrompt();
                    fileName = scanner.nextLine();
                    myGit.add(type, fileName);
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
    private FileType promptFileType() {
        MessagePrinter.printAddFileTypePrompt();
        MessagePrinter.printFileTypeOptions();
        try {
            int typeInput = Integer.parseInt(scanner.nextLine());
            if (typeInput == 1) {
                return FileType.TEXT_FILE;
            } else if (typeInput == 2) {
                return FileType.BINARY_FILE;
            } else {
                throw new IllegalArgumentException("Invalid file type");
            }
        } catch (NumberFormatException e) {
            MessagePrinter.printInvalidInputMessage();
        } catch (IllegalArgumentException e) {
            MessagePrinter.printInvalidFileTypeMessage();
        }
        return null;
    }
}
