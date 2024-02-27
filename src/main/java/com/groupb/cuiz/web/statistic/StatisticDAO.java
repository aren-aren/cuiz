package com.groupb.cuiz.web.statistic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StatisticDAO {
    @Autowired
    SqlSession sqlSession;
    private final String NAMESPACE = "com.groupb.cuiz.web.statistic.StatisticDAO.";

    public StatisticDTO getMainStatistic() {
        return sqlSession.selectOne(NAMESPACE + "getMainStatistic");
    }
}
