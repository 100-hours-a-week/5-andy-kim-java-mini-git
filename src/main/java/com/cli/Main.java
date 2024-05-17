package com.cli;

public class Main {
    public static void main(String[] args) {
        MiniGit myGit = new MiniGit("myGit");
        InputHandler inputHandler = new InputHandler(myGit);

        inputHandler.handleInput();
    }
}
