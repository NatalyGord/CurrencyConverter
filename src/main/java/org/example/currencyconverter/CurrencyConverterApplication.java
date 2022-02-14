package org.example.currencyconverter;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.currencyconverter.models.DateCurs;
import org.example.currencyconverter.models.Valute;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


@SpringBootApplication
public class CurrencyConverterApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(CurrencyConverterApplication.class, args);


//        URL url = new URL("http://www.cbr.ru/scripts/XML_daily.asp");
//        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), "windows-1251"));
//        String inputLine = in.readLine();
//        in.close();
//        System.out.println(inputLine);
//
//        XmlMapper xmlMapper = new XmlMapper();
//        ArrayList <Valute> valutes = xmlMapper.readValue(inputLine, Valute.class);
//
//        DateCurs dateStr = xmlMapper.readValue(inputLine, DateCurs.class);
//
//        System.out.println(dateStr.getDate());
//        for (int i = 1; i < valutes.size() ; i++) {
//            System.out.println(valutes.get(i).getNumCode());
//            System.out.println(valutes.get(i).getCharCode());
//            System.out.println(valutes.get(i).getNominal());
//            System.out.println(valutes.get(i).getName());
//            System.out.println(valutes.get(i).getValue());
//            System.out.println();
//        }
    }
}
