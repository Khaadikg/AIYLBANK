package com.aiylbank.demo.model.task.entity;

public enum Status {

    OPEN("Открыт"),
    DONE("Сделан");

    private String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
