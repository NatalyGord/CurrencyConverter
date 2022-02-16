package org.example.currencyconverter.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.example.currencyconverter.models.ExchangeRate;
import org.example.currencyconverter.repositories.ConversionRepository;
import org.example.currencyconverter.repositories.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MutationResolver implements GraphQLMutationResolver {
    @Autowired
    private ConversionRepository conversionRepository;

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    public MutationResolver(ConversionRepository conversionRepository, ExchangeRateRepository exchangeRateRepository) {
        this.conversionRepository = conversionRepository;
        this.exchangeRateRepository = exchangeRateRepository;
    }

    //запись курса валют в БД
    public ExchangeRate createExchangeRate(String date, String numCode, String charCode, Integer nominal, String name, Double value){
        ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.setDate(date);
        exchangeRate.setNumCode(numCode);
        exchangeRate.setCharCode(charCode);
        exchangeRate.setNominal(nominal);
        exchangeRate.setName(name);
        exchangeRate.setValue(value);
        return exchangeRateRepository.save(exchangeRate);
    }
}
