package com.example.queries.filters;

import org.springframework.boot.context.properties.bind.Name;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class FiltersConfiguration {

    @Bean
    public IFilterPeople incomeToFilter(){
        return new GeneralFilter(x->x.getIncomeTo()!=0, (x,p)->x.getIncomeTo()>=p.getIncome());
    }

    @Bean
    public IFilterPeople incomeFromFilter(){
        return new GeneralFilter(x->x.getIncomeFrom()!=0, (x,p)->x.getIncomeFrom()<=p.getIncome());
    }

    @Bean("general")
    public List<IFilterPeople> generalFilters(){

        var byIncomeToGenericFilter = new GeneralFilter(x->x.getIncomeTo()!=0, (x,p)->x.getIncomeTo()>=p.getIncome());
        var byIncomeFromGenericFilter = new GeneralFilter(x->x.getIncomeFrom()!=0, (x,p)->x.getIncomeFrom()<=p.getIncome());
        var list = new ArrayList<IFilterPeople>();
        list.add(byIncomeFromGenericFilter);
        list.add(byIncomeToGenericFilter);
        return list;
    }
}
