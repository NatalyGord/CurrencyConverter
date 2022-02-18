package org.example.currencyconverter.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.currencyconverter.models.Conversion;
import org.example.currencyconverter.models.DateCurs;
import org.example.currencyconverter.models.ExchangeRate;
import org.example.currencyconverter.models.Valute;
import org.example.currencyconverter.repositories.ConversionRepository;
import org.example.currencyconverter.repositories.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.Column;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public ExchangeRate createExchangeRate(String date, String numCode, String charCode, Integer nominal, String name, Double value) {
        ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.setDate(date);
        exchangeRate.setNumCode(numCode);
        exchangeRate.setCharCode(charCode);
        exchangeRate.setNominal(nominal);
        exchangeRate.setName(name);
        exchangeRate.setValue(value);
        return exchangeRateRepository.save(exchangeRate);
    }

    //парсинг данных с сайта http://www.cbr.ru/scripts/XML_daily.asp и запись курсов валют в БД
    public List<ExchangeRate> createExchangeRates() {
        //Получение данных с сайта
        URL url = null;
        String inputLine = null;
        XmlMapper xmlMapper = new XmlMapper();
        ArrayList<Valute> valutes = new ArrayList<>();
        DateCurs dateStr = new DateCurs();
        BufferedReader in = null;
        try {
            url = new URL("http://www.cbr.ru/scripts/XML_daily.asp");
            in = new BufferedReader(new InputStreamReader(url.openStream(), "windows-1251"));
            inputLine = in.readLine();
            in.close();
            valutes = xmlMapper.readValue(inputLine, Valute.class);
            dateStr = xmlMapper.readValue(inputLine, DateCurs.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String date = dateStr.getDate();
        //__________________________________
        //Запись всех курсов валют в БД
        if (exchangeRateRepository.findRateByDate(date).isEmpty()) {
            for (int i = 1; i < valutes.size(); i++) {
                Valute val = valutes.get(i);
                ExchangeRate exchangeRate = new ExchangeRate();

                exchangeRate.setDate(date);
                exchangeRate.setNumCode(val.getNumCode());
                exchangeRate.setCharCode(val.getCharCode());
                exchangeRate.setNominal(val.getNominal());
                exchangeRate.setName(val.getName());
                exchangeRate.setValue(val.getValue());
                exchangeRateRepository.save(exchangeRate);
            }
        }
        return exchangeRateRepository.findRateByDate(date);
    }

    //Расчет конвертаций и их запись в БД
    public Double createConversion(String nameVal1, String nameVal2,
                                   Double sumVal1) {
        Double cursVal1;
        Double cursVal2;
        Integer nominalVal1;
        Integer nominalVal2;
        String convDate;
        List <ExchangeRate> exchangeRates = createExchangeRates();
        convDate = exchangeRates.get(1).getDate();

        if(nameVal1.equals("Российский рубль")){
            cursVal1 =1.0;
            nominalVal1 = 1;
        }
        else {
            ExchangeRate exchangeRate1 = exchangeRates.stream().filter(i -> i.getName().equals(nameVal1)).collect(Collectors.toList()).get(0);
            cursVal1 = exchangeRate1.getValue();
            nominalVal1 = exchangeRate1.getNominal();
        }
        if(nameVal2.equals("Российский рубль")){
            cursVal2 =1.0;
            nominalVal2 = 1;
        }
        else {
            ExchangeRate exchangeRate2 = exchangeRates.stream().filter(i -> i.getName().equals(nameVal2)).collect(Collectors.toList()).get(0);
            cursVal2 = exchangeRate2.getValue();
            nominalVal2 = exchangeRate2.getNominal();
        }

        Conversion conversion = new Conversion();
        conversion.setConvDate(convDate);
        conversion.setNameVal1(nameVal1);
        conversion.setNameVal2(nameVal2);
        conversion.setSumVal1(sumVal1);
        double curs = (cursVal1 / nominalVal1) / (cursVal2 / nominalVal2);
        conversion.setCurs(curs);
        double sumVal2 = sumVal1 * curs;
        conversion.setSumVal2(sumVal2);

        conversionRepository.save(conversion);
        return conversion.getSumVal2();
    }
}
