package com.groupb.cuiz.item;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.groupb.cuiz.MyTest;
import com.groupb.cuiz.web.item.ItemDAO;
import com.groupb.cuiz.web.item.ItemDTO;

public class ItemTest extends MyTest {

	@Autowired
	private ItemDAO itemDAO;
//	@Test
	public void testList() {
		
		//itemDAO.getList();
		
	}

	@Test
	public void testinsert() {

		int result = 0;

		for (int i = 20; i < 40; i++) {

			ItemDTO itemDTO = new ItemDTO();

			itemDTO.setItem_Num(i);
			itemDTO.setItem_Price(100 + i);
			itemDTO.setItem_Contents("a" + i * i * i * i * i * i * i * i * i);
			itemDTO.setItem_Name("DDONG" + i);
			

			System.out.println(itemDTO.getItem_Name());

			//int temp = itemDAO.setItem(itemDTO);

			//result = temp + result;
		}

		assertEquals(result, 20);

	}

}
