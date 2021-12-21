package edu.sp5.javacafe.dao.derby;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import edu.sp5.javacafe.domain.Menu;

@SpringJUnitConfig(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class MenuDaoDerbyTest {
	
	@Autowired
	private MenuDaoDerby daoDerby;
	
	@Test
	public void findMenuByItemName() {
		String itemName = "아메리카노";
		assertTrue(daoDerby.findMenuByItemName(itemName).getItemName().equals("아메리카노"));
	}
	
	@Test
	@Transactional
	//@Commit
	public void addMenu() {
		Menu m = new Menu();
		m.setItemNumber(156917);
		m.setItemName("콜드브루");
		m.setItemCategory("Drink");
		m.setItemPrice(2500.0);
		m.setItemImage("");
		m.setSalesSeason("");
		daoDerby.addMenu(m);
	}
}
