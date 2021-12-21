package edu.sp5.javacafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.sp5.javacafe.dao.derby.MenuDaoDerby;
import edu.sp5.javacafe.domain.Menu;
import edu.sp5.javacafe.util.ItemNumberGenerator;

@Service("menuService")
public class MenuService {
	
	@Autowired
	private MenuDaoDerby menuDao;

	/**
	 * Menu(String itemName, String itemCategory, double itemPrice, String itemImage, String salesSeason)
	 */
	@Transactional
	public Menu addMenu(Menu menu) {
		long itemNumber = ItemNumberGenerator.getItemNumber();
		while(findMenuByItemNumber(itemNumber) != null) {
			itemNumber = ItemNumberGenerator.getItemNumber();
		}
		menu.setItemNumber(itemNumber);
		menuDao.addMenu(menu);
		menuDao.addStock(itemNumber, 0);
		
		return menu;
	}
	
	public void setStock(long itemNumber, long stock) {
		menuDao.setStock(itemNumber, stock);
	}

	@Transactional
	public void deleteMenu(long itemNumber) {
		menuDao.deleteStock(itemNumber);
		menuDao.deleteMenu(itemNumber);
	}

	public void updateMenu(Menu menu) {
		menuDao.updateMenu(menu);
	}
	
	public Menu findMenuByItemName(String itemName) {
		return menuDao.findMenuByItemName(itemName);
	}
	
	public Menu findMenuByItemNumber(long itemNumber) {
		return menuDao.findMenuByItemNumber(itemNumber);
	}
	
	public Menu findMenusAndStockByItemNumber(long itemNumber) {
		return menuDao.findMenusAndStockByItemNumber(itemNumber);
	}
	
	public List<Menu> findAllMenusAndStock() {
		return menuDao.findAllMenusAndStock();
	}

	public List<Menu> findAllMenus() {
		return menuDao.findAllMenus();
	}
	
}
