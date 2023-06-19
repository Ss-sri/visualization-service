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
            criteria.and("topic").in(dataRequestDTO.getTopic());

        if(dataRequestDTO.getEndYear() != null)
            criteria.and("end_year").in(dataRequestDTO.getEndYear()  );

        if(dataRequestDTO.getSector() != null)
            criteria.and("sector").in(dataRequestDTO.getSector());

        if(dataRequestDTO.getRegion() != null)
            criteria.and("region").in(dataRequestDTO.getRegion());

        if(dataRequestDTO.getSector() != null)
            criteria.and("source").in(dataRequestDTO.getSource());

        if(dataRequestDTO.getSwat() != null)
            criteria.and("swat").in(dataRequestDTO.getSwat());

        if(dataRequestDTO.getCountry() != null)
            criteria.and("country").in(dataRequestDTO.getCountry());

        if(dataRequestDTO.getCity() != null)
            criteria.and("city").in(dataRequestDTO.getCity());

        return mongoTemplate.find(query.addCriteria(criteria), Data.class);
    }
}
