package com.example.queries.results;

import com.example.queries.search.Funcs;

public class FunctionResult {
    private Funcs function;
    private String fieldName;
    private double value;

    public FunctionResult(Funcs function, String fieldName, double value) {
        this.function = function;
        this.fieldName = fieldName;
        this.value = value;
    }

    public FunctionResult() {
    }

    public Funcs getFunction() {
        return function;
    }

    public void setFunction(Funcs function) {
        this.function = function;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
