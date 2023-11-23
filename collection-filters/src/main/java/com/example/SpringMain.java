package com.example;

import com.example.model.Gender;
import com.example.model.PeopleSample;
import com.example.model.Person;
import com.example.queries.QueryProcessor;
import com.example.queries.filters.ByNameFilter;
import com.example.queries.filters.IFilterPeople;
import com.example.queries.search.Funcs;
import com.example.queries.search.FunctionsParameters;
import com.example.queries.search.Page;
import com.example.queries.search.SearchParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
/**
 * W tej klasie używamy adnotacji @Autowired do wstrzyknięcia zależności.
 *
 * Użycie adnotacji @Autowired pozwala na:
 * - Automatyczne wstrzyknięcie zależności przez Spring. Kontener Springa automatycznie dostarczy
 *   odpowiednią instancję beana, który jest potrzebny dla danej zależności.
 * - Zmniejszenie potrzeby manualnego tworzenia obiektów i ich zależności, co zwiększa czytelność
 *   i redukuje ilość boilerplate code (powtarzającego się kodu).
 * - Elastyczność w zarządzaniu zależnościami, ponieważ Spring zajmuje się ich rozwiązywaniem
 *   i wstrzykiwaniem.
 *
 * @Autowired może być używana nad polami, setterami, konstruktorami lub dowolnymi metodami.
 * Jest to wygodny sposób na deklarowanie zależności komponentów.
 *
 *  * Użycie adnotacji @Qualifier wraz z @Autowired pozwala na:
 *  * - Rozróżnienie między wieloma beanami tego samego typu. Kiedy w kontenerze Springa istnieje więcej niż
 *  *   jeden bean danego typu, @Qualifier pozwala określić, który dokładnie bean ma zostać wstrzyknięty.
 *  * - Zapobieganie niejednoznaczności w wstrzykiwaniu zależności, poprzez wskazanie konkretnego beana
 *  *   po jego nazwie.
 *  * - Większą kontrolę nad wstrzykiwaniem zależności, co jest szczególnie przydatne w bardziej złożonych
 *  *   konfiguracjach aplikacji.
 *  *
 *  * @Autowired w połączeniu z @Qualifier jest często stosowany nad polami, konstruktorami lub metodami setterowymi,
 *  * aby wskazać dokładnie, który bean ma być użyty.
 */

@SpringBootApplication
public class SpringMain implements CommandLineRunner {

	/**
	 * Adnotacja @Autowired na polu byNameFilter informuje Spring, że potrzebujemy beana typu ByNameFilter.
	 * Spring automatycznie wstrzyknie odpowiednią instancję beana podczas tworzenia obiektu MyComponent.
	 */
	//@Autowired
	//ByNameFilter byNameFilter;

	/**
	 * Można stosować konwencje nazewnicze :)
	 * */

//	@Autowired
//	IFilterPeople byAgeToFilter;
//	@Autowired
//	IFilterPeople byAgeFromFilter;
//	@Autowired
//	IFilterPeople bySurnameFilter;
	/**
	 * Możemy pobrać wszystkie implementacje danego interfejsu
	 * */
//	@Autowired
//	List<IFilterPeople> filters;

	/**
	 * Ale trzeba uważać czy przypadkiem nie są deklarowane w innych miejscach
	 * --> najlepiej się zdecydować jak chcemy rejestrować beany i się tego trzymać
	 */

//	@Autowired()
//	List<IFilterPeople> generalFilters;

	/**
	 * Ale trzeba uważać czy przypadkiem nie są deklarowane w innych miejscach
	 * --> najlepiej się zdecydować jak chcemy rejestrować beany i się tego trzymać
	 */
//	@Autowired()

	/**
	 * Adnotacja @Autowired wraz z @Qualifier("general") informuje Spring,
	 * że w to miejsce należy wstrzyknąć beana o nazwie "general".
	 * Jest to przydatne, gdy istnieje kilka beanów tego samego typu, a konieczne jest
	 * wskazanie konkretnego egzemplarza.
	 */

//	@Qualifier("general")
//	List<IFilterPeople> generalFilters;

//			@Autowired
//	QueryProcessor processor;

	/**
	 * Zamiast Autowired może lepiej konstruktor?
	 */
//	public SpringMain(
///***/ //			ByNameFilter byNameFilter
///***/ //			, @Qualifier("general")List<IFilterPeople> filters
//	) {
//		//this.filters = filters;
//	}

	public static void main(String[] args) {
		SpringApplication.run(SpringMain.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("");
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
