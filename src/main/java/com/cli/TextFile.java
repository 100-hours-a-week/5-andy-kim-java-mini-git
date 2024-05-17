package com.cli;

public class TextFile extends File{
    public String type;

    public TextFile(String fileName) {
        super(fileName);
        this.type = "text";
    }

    public String getType() {
        return type;
    }
}
