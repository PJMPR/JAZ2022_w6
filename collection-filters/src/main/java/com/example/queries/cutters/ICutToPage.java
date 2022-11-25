package com.example.queries.cutters;

import com.example.model.Person;
import com.example.queries.search.Page;

import java.util.List;

public interface ICutToPage {
    List<Person> cut(Page page, List<Person> list);
}
