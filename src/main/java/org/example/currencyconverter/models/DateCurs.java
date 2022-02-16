package org.example.currencyconverter.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DateCurs {
    private String date;

    @JsonProperty("Date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) throws ParseException {
//        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
//        Date date = formatter.parse(dateStr);
        this.date = date;
    }
}
