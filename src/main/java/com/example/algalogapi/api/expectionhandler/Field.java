package com.example.algalogapi.api.expectionhandler;

public class Field {
    private String Field;
    private String message;

    public Field(String field, String message) {
        Field = field;
        this.message = message;
    }

    public String getField() {
        return Field;
    }

    public void setField(String field) {
        Field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
