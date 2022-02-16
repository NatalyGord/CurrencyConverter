package org.example.currencyconverter.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.example.currencyconverter.models.ExchangeRate;
import org.example.currencyconverter.repositories.ConversionRepository;
import org.example.currencyconverter.repositories.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class QueryResolver implements GraphQLQueryResolver {
    @Autowired
    private ConversionRepository conversionRepository;

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    public QueryResolver(ConversionRepository conversionRepository, ExchangeRateRepository exchangeRateRepository) {
        this.conversionRepository = conversionRepository;
        this.exchangeRateRepository = exchangeRateRepository;
    }

    //Вывод всех элементов из таблицы курсов валют
    public List<ExchangeRate> allExchangeRate() {
        return exchangeRateRepository.findAll();
    }
    //поиск курса валют по Id
    public ExchangeRate findRateById(Long Id){
        return exchangeRateRepository.findRateById(Id);
    }
    //поиск курса по дате
    public List <ExchangeRate> findRateByDate(String date){
        return exchangeRateRepository.findRateByDate(date);
    }

}
