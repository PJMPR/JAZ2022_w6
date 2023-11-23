package com.example.queries.calculations;

import com.example.model.Person;
import com.example.queries.search.FunctionsParameters;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

//@Component
public class GeneralCalculator implements ICalculate {
    private String fieldName;
    private Function<Person, Number> getNumber;

    public GeneralCalculator(String fieldName, Function<Person, Number> getNumber) {
        this.fieldName = fieldName;
        this.getNumber = getNumber;
    }

    @Override
    public double calculate(FunctionsParameters functionsParameters, List<Person> list) {

        var stats = list.stream().map(getNumber).collect(Collectors.summarizingDouble(n->n.doubleValue()));
        switch (functionsParameters.getFunction()) {
            case AVERAGE: return stats.getAverage();
            case SUM: return stats.getSum();
            case MAX: return stats.getMax();
            case MIN: return stats.getMin();
        }
        return 0;

        /**
         * Pokazać jako dodatek
         */
//        return functionsParameters.getFunction().calculate(stats);
    }

    @Override
    public String getFieldName() {
        return fieldName;
    }
}
