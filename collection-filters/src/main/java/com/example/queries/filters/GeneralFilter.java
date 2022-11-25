package com.example.queries.filters;

import com.example.model.Person;
import com.example.queries.search.SearchParameters;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;


public class GeneralFilter extends FilterBase {
    private Predicate<SearchParameters> canFilterPredicate;
    private DualPredicate filterPredicate;

    public GeneralFilter(Predicate<SearchParameters> canFilterPredicate, DualPredicate filterPredicate) {
        this.canFilterPredicate = canFilterPredicate;
        this.filterPredicate = filterPredicate;
    }

    @Override
    public boolean canFilter() {
        return canFilterPredicate.test(searchParameters);
    }

    @Override
    protected Predicate<Person> getPersonPredicate() {
        return p -> filterPredicate.check(searchParameters, p);
    }
}
