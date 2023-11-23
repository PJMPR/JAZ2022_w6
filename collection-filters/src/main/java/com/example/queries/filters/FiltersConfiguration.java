package com.example.queries.filters;

import org.springframework.boot.context.properties.bind.Name;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
/**
 * Klasa FiltersConfiguration jest oznaczona adnotacją @Configuration, co oznacza, że jest ona klasą konfiguracyjną w Spring.
 * Klasy konfiguracyjne służą do definiowania beanów i innych ustawień konfiguracyjnych aplikacji.
 *
 * Użycie adnotacji @Bean pozwala na:
 * - Definiowanie metod w klasie konfiguracyjnej, które produkują beany zarządzane przez kontener Springa.
 * - Kontrolę nad tworzeniem i konfiguracją obiektów, które mają być używane w aplikacji jako beany.
 * - Możliwość dokładnego określenia, jak obiekt ma być utworzony i skonfigurowany.
 *
 * Metoda oznaczona adnotacją @Bean tworzy i zwraca obiekt, który Spring rejestruje jako bean w swoim kontenerze.
 * Dzięki temu bean może być później wstrzykiwany do innych części aplikacji.
 *
 * @Bean jest szczególnie przydatna, gdy tworzymy beany dla klas zewnętrznych bibliotek,
 * nad którymi nie mamy kontroli, lub gdy potrzebujemy specjalnej konfiguracji obiektów.
 */

@Configuration
public class FiltersConfiguration {

    /**
     * Metoda myBean() jest oznaczona adnotacją @Bean, co oznacza, że zwrócony przez nią obiekt
     * będzie zarządzany jako bean przez Spring.
     *
     * Dzięki temu bean może być później wstrzykiwany do innych komponentów.
     * Można tutaj dostosować tworzenie i konfigurację beana, np. ustawiając różne właściwości.
     */

//    @Bean
//    public IFilterPeople incomeToFilter(){
//        return new GeneralFilter(x->x.getIncomeTo()!=0, (x,p)->x.getIncomeTo()>=p.getIncome());
//    }
//
//    @Bean
//    public IFilterPeople incomeFromFilter(){
//        return new GeneralFilter(x->x.getIncomeFrom()!=0, (x,p)->x.getIncomeFrom()<=p.getIncome());
//    }

//    @Bean("generalFilters")
//    public List<IFilterPeople> generalFilters(){
//
//        var byIncomeToGenericFilter = new GeneralFilter(x->x.getIncomeTo()!=0, (x,p)->x.getIncomeTo()>=p.getIncome());
//        var byIncomeFromGenericFilter = new GeneralFilter(x->x.getIncomeFrom()!=0, (x,p)->x.getIncomeFrom()<=p.getIncome());
//        var list = new ArrayList<IFilterPeople>();
//        list.add(byIncomeFromGenericFilter);
//        list.add(byIncomeToGenericFilter);
//        return list;
//    }
}
