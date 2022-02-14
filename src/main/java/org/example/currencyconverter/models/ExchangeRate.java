package org.example.currencyconverter.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "exchangeRates")
public class ExchangeRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name="date", nullable = false)
    private Date date;
    @Column(name="numCode", nullable = false)
    private String numCode;
    @Column(name="charCode", nullable = false)
    private String charCode;
    @Column(name="nominal", nullable = false)
    private int nominal;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="value", nullable = false)
    private double value;

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
