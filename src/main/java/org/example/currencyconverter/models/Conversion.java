package org.example.currencyconverter.models;

import liquibase.pro.packaged.S;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "conversions")
public class Conversion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conv_id")
    private Long convId;
    @Column(name = "conv_date", nullable = false)
    private String convDate;
    @Column(name = "name_val1", nullable = false)
    private String nameVal1;
    @Column(name = "name_val2", nullable = false)
    private String nameVal2;
    @Column(name = "curs", nullable = false)
    private double curs;
    @Column(name = "sum_val", nullable = false)
    private double sumVal;

    public Conversion(String convDate, String nameVal1, String nameVal2, double curs, double sumVal) {
        this.convDate = convDate;
        this.nameVal1 = nameVal1;
        this.nameVal2 = nameVal2;
        this.curs = curs;
        this.sumVal = sumVal;
    }

    public Conversion() {

    }

    public Long getConvId() {
        return convId;
    }

    public String getConvDate() {
        return convDate;
    }

    public void setConvDate(String convDate) {
        this.convDate = convDate;
    }

    public String getNameVal1() {
        return nameVal1;
    }

    public void setNameVal1(String nameVal1) {
        this.nameVal1 = nameVal1;
    }

    public String getNameVal2() {
        return nameVal2;
    }

    public void setNameVal2(String nameVal2) {
        this.nameVal2 = nameVal2;
    }

    public double getCurs() {
        return curs;
    }

    public void setCurs(double curs) {
        this.curs = curs;
    }

    public double getSumVal() {
        return sumVal;
    }

    public void setSumVal(double sumVal) {
        this.sumVal = sumVal;
    }
}
