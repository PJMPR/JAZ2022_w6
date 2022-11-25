package com.example.queries.filters;

import com.example.model.Person;
import com.example.queries.search.SearchParameters;

import java.util.List;
import java.util.function.Predicate;

public abstract class FilterBase implements IFilterPeople{
    protected SearchParameters searchParameters;

    @Override
    public void setSearchParameters(SearchParameters searchParameters) {
        this.searchParameters = searchParameters;
    }

    @Override
    public List<Person> filter(List<Person> list) {
        return list.stream()
                .filter(getPersonPredicate())
                .toList();
    }

    @Override
    public abstract boolean canFilter();
    protected abstract Predicate<Person> getPersonPredicate();
}
