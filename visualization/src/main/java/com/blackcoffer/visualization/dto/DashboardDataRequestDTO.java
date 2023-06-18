package com.blackcoffer.visualization.dto;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@Getter
@ToString
public class DashboardDataRequestDTO {
    private Integer endYear;
    private String topic;
    private String sector;
    private String region;
    private String pestle;
    private String swat;
    private String source;
    private String country;
    private String city;
}
