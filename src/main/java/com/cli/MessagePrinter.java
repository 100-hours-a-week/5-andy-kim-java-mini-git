package com.cli;

import java.util.List;
import static com.cli.MessageConstants.*;

public class MessagePrinter {

    // 환영 메시지를 출력하는 메서드
    public static void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    // 초기 루프 메시지와 레포지토리 이름 목록을 출력하는 메서드
    public static void printLoopInitMessage(List<String> repositoryNames) {
        System.out.println(ENTER_COMMAND_MESSAGE);
        System.out.println(CURRENT_REPOSITORIES_MESSAGE);
        if (repositoryNames.isEmpty()) {
            System.out.println(NO_REPOSITORIES_MESSAGE);
        } else {
            for (String name : repositoryNames) {
                System.out.println(name);
            }
        }
        System.out.print(PROMPT);
    }

    // 다양한 메시지를 출력하는 메서드 추가
    public static void printAddRepoPrompt() {
        System.out.println(ADD_REPO_PROMPT);
    }

    public static void printAddFileRepoPrompt() {
        System.out.println(ADD_FILE_REPO_PROMPT);
    }

    public static void printAddFileTypePrompt() {
        System.out.println(ADD_FILE_TYPE_PROMPT);
    }

    public static void printFileTypeOptions() {
        System.out.println(FILE_TYPE_OPTIONS);
    }

    public static void printAddFileNamePrompt() {
        System.out.println(ADD_FILE_NAME_PROMPT);
    }

    public static void printCommitRepoPrompt() {
        System.out.println(COMMIT_REPO_PROMPT);
    }

    public static void printCommitMessagePrompt() {
        System.out.println(COMMIT_MESSAGE_PROMPT);
    }

    public static void printInvalidCommandMessage() {
        System.out.println(INVALID_COMMAND_MESSAGE);
    }

    public static void printCommandExamples() {
        System.out.println(COMMAND_EXAMPLES);
    }

    public static void printInvalidInputMessage() {
        System.out.println(INVALID_INPUT_MESSAGE);
    }

    public static void printInvalidFileTypeMessage() {
        System.out.println(INVALID_FILE_TYPE_MESSAGE);
    }
}
