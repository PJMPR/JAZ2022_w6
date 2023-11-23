package com.example.queries.cutters;

import com.example.model.Person;
import com.example.queries.search.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PageCutter implements ICutToPage {
    @Override
    public List<Person> cut(Page page, List<Person> list) {
        return list.stream()
                .skip((page.getPageNumber()-1)* page.getSize())
                .limit(page.getSize())
                .toList();
    }
}
