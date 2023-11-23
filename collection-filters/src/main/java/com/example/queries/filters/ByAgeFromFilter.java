package com.example.queries.filters;

import com.example.model.Person;
import com.example.queries.search.SearchParameters;
import org.springframework.stereotype.Component;

import java.util.List;
import org.springframework.stereotype.Component;

/**
 * Klasa ByAgeFromFilter jest oznaczona adnotacją @Component, co oznacza, że jest ona komponentem zarządzanym przez Spring.
 * Spring automatycznie wykryje tę klasę podczas skanowania pakietów i zarejestruje ją w swoim kontenerze jako bean.
 *
 * Użycie adnotacji @Component pozwala na:
 * - Automatyczne zarządzanie tworzeniem i życiem obiektów tej klasy przez Spring.
 * - Wykorzystanie mechanizmu wstrzykiwania zależności (Dependency Injection) przez Spring.
 * - Lepszą organizację kodu poprzez wyraźne wskazanie komponentów aplikacji.
 *
 * Istnieją również specjalizacje adnotacji @Component, takie jak @Repository, @Service, i @Controller,
 * które służą do dalszego określania roli komponentu w aplikacji (np. warstwa danych, warstwa serwisowa, kontrolery).
 *
 * Ta klasa może być używana jako zwykły komponent Springa, z możliwością wstrzykiwania zależności itp.
 */

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
