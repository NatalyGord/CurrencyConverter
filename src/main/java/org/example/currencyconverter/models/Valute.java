package org.example.currencyconverter.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Valute extends ArrayList<Valute> {

    private String numCode;
    private String charCode;
    private int nominal;
    private String name;
    private double value;

    public Valute(String numCode, String charCode, int nominal, String name, double value) {
        this.numCode = numCode;
        this.charCode = charCode;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
    }
    public Valute(){}

    @JsonProperty("NumCode")
    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    @JsonProperty("CharCode")
    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    @JsonProperty("Nominal")
    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("Value")
    public double getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = Double.parseDouble(value.replace(",", "."));
    }
}
