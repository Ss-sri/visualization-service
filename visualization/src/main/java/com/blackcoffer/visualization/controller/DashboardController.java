package com.blackcoffer.visualization.controller;

import com.blackcoffer.visualization.dto.DashboardDataRequestDTO;
import com.blackcoffer.visualization.model.Data;
import com.blackcoffer.visualization.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class DashboardController {
    @Autowired()
    private DashboardService dashboardService;

    @GetMapping("/dashboard")
    List<Data> getDashboardData(DashboardDataRequestDTO dataRequestDTO) {
        return dashboardService.getDashboardData(dataRequestDTO);
    }
}
