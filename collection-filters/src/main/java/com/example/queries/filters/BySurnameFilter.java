package com.example.queries.filters;

import com.example.model.Person;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;
@Component
public class BySurnameFilter extends FilterBase{
    @Override
    public boolean canFilter() {
        return searchParameters.getSurname()!=null&&!searchParameters.getSurname().isEmpty();
    }

    @Override
    protected Predicate<Person> getPersonPredicate() {
        return person->person.getSurname().equalsIgnoreCase(searchParameters.getSurname());
    }
}
