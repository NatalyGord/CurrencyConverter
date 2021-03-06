package org.example.currencyconverter.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.example.currencyconverter.models.Conversion;
import org.example.currencyconverter.models.ExchangeRate;
import org.example.currencyconverter.repositories.ConversionRepository;
import org.example.currencyconverter.repositories.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
    public ExchangeRate findRateById(Long Id) {
        return exchangeRateRepository.findRateById(Id);
    }

    //поиск курса по дате
    public List<ExchangeRate> findRateByDate(String date) {
        return exchangeRateRepository.findRateByDate(date);
    }

    //Вывод всех элементов из таблицы conversions
    public List<Conversion> allConversion() {
        return conversionRepository.findAll();
    }

    //Вывод всех элементов из таблицы conversions лимит 10
    public List<Conversion> allConversionLimit10() {
        return conversionRepository.findAll().stream().limit(10).collect(Collectors.toList());
    }

    //Расчет среднего курса обмена валют
    public double middleRate(String nameVal1, String nameVal2) {
        double sumRate = 0.0;
        List<Conversion> conversions = allConversion().stream()
                .filter(i -> i.getNameVal1().equals(nameVal1)).filter(k -> k.getNameVal2().equals(nameVal2)).collect(Collectors.toList());

        for (Conversion conversion : conversions) {
            sumRate += conversion.getCurs();
        }
        return sumRate / conversions.size();
    }
}
