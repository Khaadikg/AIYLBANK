package com.aiylbank.demo.model.task.entity;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

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

    @JsonValue
    public Map<String, String> toValue() {
        Map<String, String> result = new HashMap<>();
        result.put("status", getDescription());
        return result;
    }
}
