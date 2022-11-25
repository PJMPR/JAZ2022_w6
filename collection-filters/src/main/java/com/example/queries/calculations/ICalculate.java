package com.example.queries.calculations;

import com.example.model.Person;
import com.example.queries.search.FunctionsParameters;

import java.util.List;

public interface ICalculate {
    double calculate(FunctionsParameters functionsParameters, List<Person> list);

    String getFieldName();
}
