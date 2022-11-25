package com.example.queries.filters;

import com.example.model.Person;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
public class ByNameFilter extends FilterBase {
    @Override
    public boolean canFilter() {
        return searchParameters.getName()!=null && !searchParameters.getName().isEmpty();
    }

    @Override
    protected Predicate<Person> getPersonPredicate() {
        return person->searchParameters.getName().equalsIgnoreCase(person.getName());
    }
}
