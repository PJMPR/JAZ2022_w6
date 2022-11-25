package com.example.queries.filters;

import com.example.model.Person;
import com.example.queries.search.SearchParameters;

@FunctionalInterface
public interface DualPredicate {

    boolean check(SearchParameters params, Person person);
}
