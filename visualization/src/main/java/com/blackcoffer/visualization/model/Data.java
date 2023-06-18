package com.blackcoffer.visualization.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("analytics")
@lombok.Data
@Getter
public class Data {
    @Id
    private String _id;
    private int end_year;
    private String intensity;
    private String sector;
    private String topic;
    private String insight;
    private String url;
    private int start_year;
    private String swat;
    private String added;
    private String published;
    private String city;
    private String country;
    private String relevance;
    private String pestle;
    private String source;
    private String title;
    private int likelihood;
}
