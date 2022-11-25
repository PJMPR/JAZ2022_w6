package com.example;

import com.example.model.Gender;
import com.example.model.PeopleSample;
import com.example.model.Person;
import com.example.queries.filters.ByNameFilter;
import com.example.queries.filters.IFilterPeople;
import com.example.queries.search.Funcs;
import com.example.queries.search.FunctionsParameters;
import com.example.queries.search.Page;
import com.example.queries.search.SearchParameters;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringMain implements CommandLineRunner {


	List<IFilterPeople> filters;
	ByNameFilter byNameFilter;

	public SpringMain(ByNameFilter byNameFilter, @Qualifier("general")List<IFilterPeople> filters) {
		this.filters = filters;
		this.byNameFilter = byNameFilter;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringMain.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		byNameFilter.setSearchParameters(sampleSearchParams());
		List<Person> ppl = byNameFilter.filter(PeopleSample.Data);
		System.out.println("dzialam");
	}


	private static SearchParameters sampleSearchParams(){
		SearchParameters params =new SearchParameters();
		params.setName("jan");
		params.setAgeFrom(20);
		params.setAgeTo(40);
		params.setIncomeFrom(2000);
		params.setPage(new Page(9,1));
		params.getSelectedGenders().add(Gender.FEMALE);
		params.getSelectedGenders().add(Gender.OTHER);
		params.getFunctions().add(new FunctionsParameters("age", Funcs.AVERAGE));
		params.getFunctions().add(new FunctionsParameters("income", Funcs.SUM));
		params.getFunctions().add(new FunctionsParameters("income", Funcs.AVERAGE));
		return params;
	}
}
