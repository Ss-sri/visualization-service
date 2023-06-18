package com.blackcoffer.visualization.service;

import com.blackcoffer.visualization.dto.DashboardDataRequestDTO;
import com.blackcoffer.visualization.model.Data;
import com.blackcoffer.visualization.repository.DashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class DashboardService {
    @Autowired()
    private DashboardRepository dashboardRepository;

    @Autowired()
    MongoTemplate mongoTemplate;

    public List<Data> getDashboardData(DashboardDataRequestDTO dataRequestDTO) {
        Query query = new Query();
        Criteria criteria = Criteria.where("_id").exists(true);
        if(dataRequestDTO.getTopic() != null)
            criteria.and("topic").is(dataRequestDTO.getTopic());

        if(dataRequestDTO.getEndYear() != null)
            criteria.and("end_year").is(dataRequestDTO.getEndYear()  );

        if(dataRequestDTO.getSector() != null)
            criteria.and("sector").is(dataRequestDTO.getSector());

        if(dataRequestDTO.getRegion() != null)
            criteria.and("region").is(dataRequestDTO.getRegion());

        if(dataRequestDTO.getSector() != null)
            criteria.and("source").is(dataRequestDTO.getSource());

        if(dataRequestDTO.getSwat() != null)
            criteria.and("swat").is(dataRequestDTO.getSwat());

        if(dataRequestDTO.getCountry() != null)
            criteria.and("country").is(dataRequestDTO.getCountry());

        if(dataRequestDTO.getCity() != null)
            criteria.and("city").is(dataRequestDTO.getCity());

        return mongoTemplate.find(query.addCriteria(criteria), Data.class);
    }
}
