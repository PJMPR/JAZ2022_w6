package com.example.queries.search;

import java.util.DoubleSummaryStatistics;
import java.util.function.Function;

public enum Funcs {
    AVERAGE(stats -> stats.getAverage()),
    SUM(stats->stats.getSum()),
    MAX(stats->stats.getMax()),
    MIN(stats->stats.getMin());

   private final Function<DoubleSummaryStatistics, Double> calcFunction;

    Funcs(Function<DoubleSummaryStatistics, Double> calcFunction) {
        this.calcFunction = calcFunction;
    }

    public double calculate(DoubleSummaryStatistics stats){
       return calcFunction.apply(stats);
   }
}
