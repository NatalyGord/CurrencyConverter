package org.example.currencyconverter.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "conversions")
public class Conversion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "convId")
    private Long convId;
    @Column(name = "convDate", nullable = false)
    private Date date;
    @Column(name = "nameVal1", nullable = false)
    private String name1;
    @Column(name = "nameVal2", nullable = false)
    private String name2;
    @Column(name = "curs", nullable = false)
    private double curs;
    @Column(name = "sumVal", nullable = false)
    private double sumVal;
}
