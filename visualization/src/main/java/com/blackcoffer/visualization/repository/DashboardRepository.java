package com.blackcoffer.visualization.repository;

import com.blackcoffer.visualization.model.Data;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DashboardRepository extends MongoRepository<Data, String> {
}
