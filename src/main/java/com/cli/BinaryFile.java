package com.cli;

public class BinaryFile extends File{
    public String type;

    public BinaryFile(String fileName) {
        super(fileName);
        this.type = "binary";
    }

    public String getType() {
        return type;
    }
}
