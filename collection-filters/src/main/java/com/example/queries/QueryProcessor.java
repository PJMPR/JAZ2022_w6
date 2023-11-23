package com.example.queries;

import com.example.queries.cutters.ICutToPage;
import com.example.queries.search.FunctionsParameters;
import com.example.queries.search.SearchParameters;
import com.example.model.Person;
import com.example.queries.calculations.ICalculate;
import com.example.queries.filters.IFilterPeople;
import com.example.queries.results.FunctionResult;
import com.example.queries.results.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class QueryProcessor {

    List<ICalculate> calculates = new ArrayList<>();
    List<IFilterPeople> filters = new ArrayList<>();
    ICutToPage pageCutter;

    public QueryProcessor() {
        System.out.println("nic tu nie ma");
    }

    /**
     * Wymaganany @Autowired gdy jest kilka konsttruktorów
     */
    //@Autowired
    public QueryProcessor(List<ICalculate> calculates, List<IFilterPeople> filters, ICutToPage pageCutter) {
        this.calculates = calculates;
        this.filters = filters;
        this.pageCutter = pageCutter;
    }

    public Results GetResults(SearchParameters parameters, List<Person> data){
        Results results = new Results();
        results.setItems(data);
        filterResults(parameters, results);
        calculateResults(parameters, results);
        cutResults(parameters, results);
        return results;
    }


    public QueryProcessor addFilter(IFilterPeople filter) {
        this.filters.add(filter);
        return this;
    }

    public QueryProcessor addCalculation(ICalculate calculator) {
        this.calculates.add(calculator);
        return this;
    }

    public void addPageCutter(ICutToPage pageCutter) {
        this.pageCutter=pageCutter;
    }

    private void cutResults(SearchParameters parameters, Results results) {
        results.setPages(results.getItems().size()% parameters.getPage().getSize());
        results.setCurrentPage(parameters.getPage().getPageNumber());
        results.setItems(pageCutter.cut(parameters.getPage(), results.getItems()));
    }

    private void calculateResults(SearchParameters parameters, Results results) {
        parameters.getFunctions().forEach(funcParams->
                makeCalculations(results, funcParams)
        );
    }

    private void makeCalculations(Results results, FunctionsParameters funcParams) {
        calculates.stream()
                .filter(c->c.getFieldName().equalsIgnoreCase(funcParams.getFieldName()))
                .map(c->
                        new FunctionResult(
                                funcParams.getFunction(),
                                funcParams.getFieldName(),
                                c.calculate(funcParams, results.getItems())))
                .forEach(fresult-> results.getFunctionResults().add(fresult));
    }

    private void filterResults(SearchParameters parameters, Results results) {
        filters.forEach(f->f.setSearchParameters(parameters));
        filters.stream()
                .filter(f->f.canFilter())
                .forEach(f-> results.setItems(f.filter(results.getItems())));
    }

}
