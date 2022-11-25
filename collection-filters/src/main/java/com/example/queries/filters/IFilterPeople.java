package com.example.queries.filters;

import com.example.model.Person;
import com.example.queries.search.SearchParameters;

import java.util.List;

public interface IFilterPeople {
    void setSearchParameters(SearchParameters searchParameters);

    boolean canFilter();

    List<Person> filter(List<Person> list);
}
