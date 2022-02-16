package org.example.currencyconverter.models;

import javax.persistence.*;

@Entity
@Table(name = "exchangerates")
public class ExchangeRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exch_id")
    private Long exchId;
    @Column(name="date", nullable = false)
    private String date;
    @Column(name="num_code", nullable = false)
    private String numCode;
    @Column(name="char_code", nullable = false)
    private String charCode;
    @Column(name="nominal", nullable = false)
    private int nominal;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="value", nullable = false)
    private double value;

    public ExchangeRate() {

    }
    public ExchangeRate(String date, String numCode, String charCode, int nominal, String name, double value) {
        this.date = date;
        this.numCode = numCode;
        this.charCode = charCode;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
    }

    public Long getId() {
        return exchId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
