package com.groupb.cuiz.web.statistic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticService {

    @Autowired
    StatisticDAO statisticDAO;
    public StatisticDTO getMainStatistic(){
        var statistic = statisticDAO.getMainStatistic();
        System.out.println("statistic = " + statistic);

        return statistic;
    }
}
