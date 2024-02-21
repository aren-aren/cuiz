package com.groupb.cuiz.web.schedule;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
public class TestSchedule {

	
	public void testPrint() {
		//System.out.println("2초마다 실행");
	}
}
