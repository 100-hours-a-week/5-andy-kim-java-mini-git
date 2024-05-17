package com.cli;

public class Software {
    private final String name;

    public Software() {
        this.name = "SoftwareDefaultName";
    }

    public Software(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
