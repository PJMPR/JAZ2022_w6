package com.example.queries.filters;

import com.example.model.Person;
import com.example.queries.search.SearchParameters;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ByAgeFromFilter implements IFilterPeople {
    SearchParameters searchParameters;

    @Override
    public void setSearchParameters(SearchParameters searchParameters) {
        this.searchParameters = searchParameters;
    }

    @Override
    public boolean canFilter() {
        return searchParameters.getAgeFrom()!=0;
    }

    @Override
    public List<Person> filter(List<Person> list) {
        return list.stream()
                .filter(person->person.getAge()>=searchParameters.getAgeFrom())
                .toList();
    }
}
